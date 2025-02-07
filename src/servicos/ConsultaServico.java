package servicos;

import entidades.*;
import excecoes.EspecialidadeInvalidaException;
import excecoes.HorarioIndisponivelException;
import excecoes.LimiteConsultaAtingidoException;
import excecoes.PacienteIndisponivelException;
import repositorios.ConsultaRepositorio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaServico {

    private ConsultaRepositorio consultaRepositorio;
    private PacienteServico pacienteServico;
    private MedicoServico medicoServico;
    private Consulta consultaConflitante;

    public ConsultaServico(ConsultaRepositorio consultaRepositorio, PacienteServico pacienteServico, MedicoServico medicoServico) {
        this.consultaRepositorio = consultaRepositorio;
        this.pacienteServico = pacienteServico;
        this.medicoServico = medicoServico;
    }

    public void agendarConsulta(Consulta consulta) {

        try {

            if(validarLimiteConsultas(consulta.getMedicoResponsavel())) {

                throw new LimiteConsultaAtingidoException();
            }

            // Nao permitir realizar agenda se medico nao estiver disponivel
            if(validarDisponibilidadeMedico(consulta.getMedicoResponsavel(), consulta.getDataPrescricao(), consulta.getHorarioInicialConsulta(), consulta.getHorarioFinalConsulta())){
                throw new HorarioIndisponivelException(consultaConflitante);
            }

            // Nao permitir realizar agenda se medico nao tiver especialidade requerida
            if (!validarEspecialidadeMedico(consulta, consulta.getEspecialidadeRequerida())) {
                throw new EspecialidadeInvalidaException(consulta.getMedicoResponsavel());
            }

            // Nao permitir realizar agenda se paciente tiver outra consulta no mesmo dia
            if(validarDisponibilidadePaciente(consulta.getPacienteAssociado(), consulta.getDataPrescricao())){
                throw new PacienteIndisponivelException(consulta.getPacienteAssociado());
            }

        } catch (LimiteConsultaAtingidoException | HorarioIndisponivelException | PacienteIndisponivelException | EspecialidadeInvalidaException e) {
            System.out.println("Erro ao agendar consulta: " + e.getMessage());
            return;
        }


        System.out.println("Horario disponivel! Agendando consulta...");
        pacienteServico.registrarHistorico(consulta);
        medicoServico.registrarHistorico(consulta);
        consultaRepositorio.salvar(consulta);

    }

    public void cancelarConsulta(Consulta consulta) {
        consulta.setStatus(Consulta.Status.CANCELADA);
        System.out.println("Consulta cancelada!");
    }

    public void prescreverTratamento(Consulta consulta, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {

        //consulta.setPrescricao(new Prescricao(consulta, examesPrescritos, medicamentos, dataValidade));
    }

//    public void finalizarConsulta(String identificador, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {
//
//        for (Consulta consulta : ) {
//
//        }
//
//        if (consulta == null) {
//            System.out.println("Nao existe essa consulta, portanto nao pode ser finalizada!");
//            return;
//        }
//
//        if (consulta.getStatus() == Consulta.Status.AGENDADA) {
//            consulta.setStatus(Consulta.Status.REALIZADA);
//            prescreverTratamento(consulta, examesPrescritos, medicamentos, dataValidade);
//            System.out.println("Consulta " + consulta.getId() + " marcada como REALIZADA.");
//        } else {
//            System.out.println("Apenas consultas AGENDADAS podem ser finalizadas.");
//        }
//    }
    
    public boolean validarLimiteConsultas(Medico medicoResponsavel) {
        int limiteConsultasMedico = 6;
        int consultasAtivas = 0;

        for (Consulta consulta : medicoResponsavel.getHistoricoMedico()) {
            if (consulta.getStatus() != Consulta.Status.CANCELADA) {
                consultasAtivas++;
            }
        }
        return consultasAtivas >= limiteConsultasMedico;
    }

    public boolean validarDisponibilidadeMedico(Medico medicoResponsavel, LocalDate novaData, LocalTime novoInicio, LocalTime novoFim){

        for (Consulta consulta : medicoResponsavel.getHistoricoMedico()){

            if (consulta.getStatus() == Consulta.Status.CANCELADA) continue;

            LocalDate dataAgendada = consulta.getDataPrescricao();
            LocalTime inicioAgendado = consulta.getHorarioInicialConsulta();
            LocalTime fimAgendado = consulta.getHorarioFinalConsulta();

            boolean diasIguais = (dataAgendada.equals(novaData));
            boolean conflitoHorarios = (novoInicio.isBefore(fimAgendado) && novoFim.isAfter(inicioAgendado));
            boolean conflitoAgenda = diasIguais && conflitoHorarios;

            if (conflitoAgenda) {
                consultaConflitante = consulta;
                return true;
            }
        }
        return false;
    }

    private boolean validarDisponibilidadePaciente(Paciente pacienteAssociado, LocalDate dataConsulta){

        ArrayList<Consulta> historicoMedicoPaciente = pacienteAssociado.getHistoricoMedico();
        for (Consulta consulta : historicoMedicoPaciente){

            if (consulta.getStatus() == Consulta.Status.CANCELADA) continue;
            if (pacienteAssociado.getCpf().equals(consulta.getPacienteAssociado().getCpf()) && consulta.getDataPrescricao().equals(dataConsulta)) return true; // Paciente ja tem uma consulta esse dia
        }
        return false; // Paciente nao tem consulta esse dia
    }

    private boolean validarEspecialidadeMedico(Consulta consulta, String especialidadeRequerida){

        String especialidadeMedico = consulta.getMedicoResponsavel().getEspecialidade();
        boolean especialidadeCompativel = especialidadeMedico.equals(especialidadeRequerida);

        return especialidadeCompativel;
    }
}
