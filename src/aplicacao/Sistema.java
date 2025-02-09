package aplicacao;

import controladores.ConsultaControlador;
import controladores.MedicoControlador;
import controladores.PacienteControlador;
import interfaces.*;
import repositorios.ConsultaRepositorio;
import repositorios.MedicoRepositorio;
import repositorios.PacienteRepositorio;
import servicos.ConsultaServico;
import servicos.MedicoServico;
import servicos.PacienteServico;

public class Sistema {
    private SistemaInterface sistemaInterface;

    public Sistema() {
        gerenciarDependencias();
    }

    public void iniciar() {
        sistemaInterface.exibirInterface();
    }

    public void gerenciarDependencias() {

        ClinicaInterface clinicaInterface = new ClinicaInterface();
        PacienteRepositorio pacienteRepositorio = new PacienteRepositorio();
        PacienteServico pacienteServico = new PacienteServico(pacienteRepositorio);
        PacienteControlador pacienteControlador = new PacienteControlador(pacienteServico);
        PacienteInterface pacienteInterface = new PacienteInterface(pacienteControlador);
        ExameInterface exameInterface = new ExameInterface();
        MedicamentoInterface medicamentoInterface = new MedicamentoInterface();
        pacienteControlador.setPacienteInterface(pacienteInterface);

        MedicoRepositorio medicoRepositorio = new MedicoRepositorio();
        MedicoServico medicoServico = new MedicoServico(medicoRepositorio);
        MedicoControlador medicoControlador = new MedicoControlador(medicoServico);
        MedicoInterface medicoInterface = new MedicoInterface(medicoControlador);
        medicoControlador.setMedicoInterface(medicoInterface);

        ConsultaInterface consultaInterface = new ConsultaInterface();
//        ConsultaRepositorio consultaRepositorio = new ConsultaRepositorio();
//        ConsultaServico consultaServico = new ConsultaServico(consultaRepositorio);
//        ConsultaControlador consultaControlador = new ConsultaControlador(consultaServico);
//        consultaControlador.serConsultaInterface = new ConsultaInterface(consultaControlador);



        sistemaInterface = new SistemaInterface(clinicaInterface, pacienteInterface, medicoInterface, consultaInterface, exameInterface, medicamentoInterface);
    }
}
