package controladores;

import entidades.Consulta;
import excecoes.*;
import servicos.ConsultaServico;
import visoes.ConsultaVisao;
import visoes.GenericoVisao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public final class ConsultaControlador extends TratamentoControlador<Consulta> {

    private ConsultaServico consultaServico;
    private ConsultaVisao consultaVisao;
    private PacienteControlador pacienteControlador;

    public ConsultaControlador(ConsultaServico consultaServico) {
        super(consultaServico);
        this.consultaServico = consultaServico;
    }

    public void setConsultaVisao(ConsultaVisao consultaVisao) {
        this.consultaVisao = consultaVisao;
    }

//    LocalDate dataAgendada,
//    LocalTime horario,
//    LocalTime duracao,
//    Paciente pacienteAssociado,
//    Medico medicoResponsavel,
//    String especialidadeRequerida,
//    double custo

    public void agendar() {

        LocalDate dataAgendada = GenericoVisao.solicitarEntradaData("Digite a data que deseja agendar (YYYY-MM-DD):");
        LocalTime horario = GenericoVisao.solicitarEntradaHorario("Digita o horário da consulta (HH-MM-SS):");
        LocalTime duracao = GenericoVisao.solicitarEntradaHorario("Digite a duração estimada da consulta:");
        //String idPaciente =


//        try {
//
//            consultaServico.agendar();
//
//        } catch (LimiteConsultaAtingidoException | HorarioIndisponivelException | PacienteIndisponivelException | EspecialidadeInvalidaException e) {
//            GenericoVisao.exibirMensagemErro(e.getMessage());
//        }
    }

//    @Override
//    public String listar() {
//
//        String mensagem = "";
//
//        try {
//
//            ArrayList<Consulta> listaConsultas = consultaServico.listar();
//
//            for (Consulta consulta : listaConsultas) {
//                mensagem +=  consulta.getId() + " - " + "Consulta - " + "Data agendada: " + consulta.getDataAgendada() + "\n";
//                mensagem += "---------------------------------\n";
//            }
//
//            GenericoVisao.exibirMensagemInfo(mensagem);
//            return mensagem;
//        } catch (DadoInvalidoException e ) {
//            GenericoVisao.exibirMensagemErro(e.getMessage());
//        }
//        return null;
//    }

//    public String imprimirLista() {
//        String mensagem = "";
//
//        if (listaPessoas.isEmpty()) {
//            mensagem = "Lista vazia!";
//        }
//
//        for (TipoPessoa pessoa : listaPessoas) {
//            mensagem +=  pessoa.getCpf() + " - " + pessoa.getNome() + "\n";
//            mensagem += "---------------------------------\n";
//        }
//        return mensagem;
//    }

    @Override
    public void cadastrar() {

    }

    @Override
    public Consulta buscar() {
//        String id = GenericoVisao.solicitarEntrada(imprimirLista() + "\nDigite o ID da consulta:");
//        try {
//            Consulta consulta = consultaServico.buscar(id);
//            GenericoVisao.exibirMensagemInfo("Consulta do ID: " + id + " foi encontrada!\n" + "Status: " + consulta.getStatus().toString());
//            return consulta;
//        } catch (DadoInvalidoException e) {
//            GenericoVisao.exibirMensagemErro(e.getMessage());
//        }
//        return null;
        return null;
    }

    @Override
    public void atualizar() {

    }
}
