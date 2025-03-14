package controladores;

import entidades.Consulta;
import entidades.Medico;
import entidades.Paciente;
import excecoes.DadoInvalidoException;
import servicos.MedicoServico;
import visoes.GenericoVisao;
import visoes.MedicoVisao;
import visoes.PessoaVisao;

import java.time.LocalDate;
import java.util.ArrayList;

public final class MedicoControlador extends PessoaControlador<Medico> {
    private final MedicoServico medicoServico;
    private MedicoVisao medicoVisao;

    public MedicoControlador(MedicoServico medicoServico) {
        super(medicoServico);
        this.medicoServico = medicoServico;
    }

    public void setMedicoVisao(MedicoVisao medicoVisao) {
        this.medicoVisao = medicoVisao;
    }

    @Override
    public void cadastrar() {
        try {
            Medico medico = criarMedico();
            medicoServico.cadastrar(medico); // Cadastrar o médico no serviço
            GenericoVisao.exibirMensagemInfo("Cadastro concluído com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage()); // Exibe erro se CPF for inválido
        }
    }

    // E preciso depois procurar uma maneira de atualizar o historicoMedico tambem!
    @Override
    public void atualizar() {

        try {
            ArrayList<String[]> dados = new ArrayList<>();
            ArrayList<Medico> listaMedicos = medicoServico.listar();
            for (Medico medico : listaMedicos) {
                dados.add(new String[]{medico.getCpf(), medico.getNome(), medico.getDataNascimento().toString()});
            }
            String cpf = PessoaVisao.solicitarEntradaBuscar(dados);
            if (cpf == null) return;
            Medico medico = medicoServico.buscar(cpf);

            Medico novoMedico = criarMedico();
            novoMedico.setHistoricoMedico(medico.getHistoricoMedico());

            medicoServico.atualizar(medico, novoMedico);
            GenericoVisao.exibirMensagemInfo("Medico atualizado com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }

    private Medico criarMedico() {
        String nome = GenericoVisao.solicitarEntrada("Digite o nome do médico:");
        String cpf = GenericoVisao.solicitarEntrada("Digite o CPF do médico:");
        LocalDate dataNascimento = GenericoVisao.solicitarEntradaData("Digite da data de nascimento do médico (YYYY-MM-DD):");
        String crm = GenericoVisao.solicitarEntrada("Digite o crm do Médico:");
        String especialidade = GenericoVisao.solicitarEntrada("Digite a especialidade do médico:");

        ArrayList<Consulta> historicoMedico = new ArrayList<>();
        return new Medico(nome, cpf, dataNascimento, crm, especialidade, historicoMedico);
    }
}
