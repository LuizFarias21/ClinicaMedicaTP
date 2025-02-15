package controladores;

import entidades.Pessoa;
import excecoes.DadoInvalidoException;
import servicos.PessoaServico;
import visoes.GenericoVisao;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class PessoaControlador<TipoPessoa extends Pessoa> extends GenericoControlador<TipoPessoa> {

    private PessoaServico<TipoPessoa> pessoaServico;

    public PessoaControlador(PessoaServico<TipoPessoa> pessoaServico) {
        this.pessoaServico = pessoaServico;
    }

    @Override
    public String listar() {
        String mensagem = "";

        try {

            ArrayList<TipoPessoa> listaPessoas = pessoaServico.listar();

            for (TipoPessoa pessoa : listaPessoas) {
                mensagem +=  pessoa.getCpf() + " - " + pessoa.getNome() + "\n";
                mensagem += "---------------------------------\n";
            }
            return mensagem;

        } catch (DadoInvalidoException e ) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
        return "";
    }

    @Override
    public TipoPessoa buscar() {
        String cpf = GenericoVisao.solicitarEntrada(listar() + "\nDigite o CPF da pessoa:");

        try {

            TipoPessoa pessoa = pessoaServico.buscar(cpf);
            GenericoVisao.exibirMensagemInfo("Pessoa encontrada: " + pessoa.getNome());
            return pessoa;
            } catch (DadoInvalidoException e ) {
                GenericoVisao.exibirMensagemErro(e.getMessage());
            }
            return null;

    }

    @Override
    public void remover() {

        String cpf = GenericoVisao.solicitarEntrada("Digite o CPF da pessoa:");

        try {
            pessoaServico.remover(cpf);
            GenericoVisao.exibirMensagemInfo("Registro da pessoa com o " + cpf + " foi excluído com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }
}
