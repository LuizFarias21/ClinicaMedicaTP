package controladores;

import entidades.Consulta;
import entidades.Paciente;
import excecoes.DadoInvalidoException;
import servicos.PacienteServico;
import visoes.GenericoVisao;
import visoes.PacienteVisao;
import visoes.PessoaVisao;

import java.time.LocalDate;
import java.util.ArrayList;

public final class PacienteControlador extends PessoaControlador<Paciente> {

    private final PacienteServico pacienteServico;
    private PacienteVisao pacienteVisao;

    public PacienteControlador(PacienteServico pacienteServico) {
        super(pacienteServico);
        this.pacienteServico = pacienteServico;
    }

    public void setPacienteVisao(PacienteVisao pacienteVisao) {
        this.pacienteVisao = pacienteVisao;
    }

    @Override
    public void cadastrar() {
        try {
            Paciente paciente = criarPaciente();
            pacienteServico.cadastrar(paciente);
            GenericoVisao.exibirMensagemInfo("Cadastro concluído com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }

    // E preciso depois procurar uma maneira de atualizar o historicoMedico tambem!
    @Override
    public void atualizar() {
            
        try {
            ArrayList<String[]> dados = new ArrayList<>();
            ArrayList<Paciente> listaPacientes = pacienteServico.listar();
            for (Paciente paciente : listaPacientes) {
                dados.add(new String[]{paciente.getCpf(), paciente.getNome(), paciente.getDataNascimento().toString()});
            }
            String cpf = PessoaVisao.solicitarEntradaBuscar(dados);
            if (cpf == null) return;
            Paciente paciente = pacienteServico.buscar(cpf);
    
            Paciente novoPaciente = criarPaciente();
            novoPaciente.setHistoricoMedico(paciente.getHistoricoMedico());

            pacienteServico.atualizar(paciente, novoPaciente);
            GenericoVisao.exibirMensagemInfo("Paciente atualizado com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }

    private Paciente criarPaciente() {
        String nome = GenericoVisao.solicitarEntrada("Digite o nome do paciente:");
        String cpf = GenericoVisao.solicitarEntrada("Digite o CPF do paciente:");
        LocalDate dataNascimento = GenericoVisao.solicitarEntradaData("Digite a data de nascimento do paciente (YYYY-MM-DD):");
        ArrayList<Consulta> historicoMedico = new ArrayList<>();
        return new Paciente(nome, cpf, dataNascimento, historicoMedico);
    }
}