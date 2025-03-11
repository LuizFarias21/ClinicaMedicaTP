package servicos;

import entidades.Consulta;
import entidades.Paciente;
import repositorios.PacienteRepositorio;


public final class PacienteServico extends PessoaServico<Paciente> {

    public PacienteServico(PacienteRepositorio pacienteRepositorio) {
        super(pacienteRepositorio);
    }

    public static void registrarHistorico(Consulta consulta) {
        consulta.getPacienteAssociado().getHistoricoMedico().add(consulta);
    }
}
