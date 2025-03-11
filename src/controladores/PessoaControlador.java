package controladores;

import entidades.Pessoa;
import excecoes.DadoInvalidoException;
import servicos.PessoaServico;
import visoes.GenericoVisao;
import java.util.ArrayList;

public abstract class PessoaControlador<TipoPessoa extends Pessoa> extends GenericoControlador<TipoPessoa> {

    private final PessoaServico<TipoPessoa> pessoaServico;

    public PessoaControlador(PessoaServico<TipoPessoa> pessoaServico) {
        this.pessoaServico = pessoaServico;
    }

    public String imprimirLista(ArrayList<TipoPessoa> listaPessoas) {
        String mensagem = "---------------------------------\n";

        for (TipoPessoa pessoa : listaPessoas) {
            mensagem +=  pessoa.getCpf() + " - " + pessoa.getNome() + "\n";
            mensagem += "---------------------------------\n";
        }
        return mensagem;
    }

    @Override
    public TipoPessoa buscar() {

        try {

            ArrayList<TipoPessoa> listaPessoas = pessoaServico.listar();

            String cpf = GenericoVisao.solicitarEntrada(imprimirLista(listaPessoas) + "\nDigite o CPF da pessoa:");
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

        try {
            ArrayList<TipoPessoa> listaPessoas = pessoaServico.listar();
            String cpf = GenericoVisao.solicitarEntrada(imprimirLista(listaPessoas) + "Digite o CPF da pessoa que deseja remover:");

            pessoaServico.remover(cpf);
            GenericoVisao.exibirMensagemInfo("Registro da pessoa com o CPF: " + cpf + " foi excluído com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }
}
