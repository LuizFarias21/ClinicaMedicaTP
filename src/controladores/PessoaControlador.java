package controladores;

import entidades.Pessoa;
import excecoes.DadoInvalidoException;
import servicos.PessoaServico;
import visoes.GenericoVisao;
import visoes.PessoaVisao;

import java.util.ArrayList;

public abstract class PessoaControlador<TipoPessoa extends Pessoa> extends GenericoControlador<TipoPessoa> {

    private final PessoaServico<TipoPessoa> pessoaServico;

    public PessoaControlador(PessoaServico<TipoPessoa> pessoaServico) {
        this.pessoaServico = pessoaServico;
    }

    @Override
    public TipoPessoa buscar() {

        try {
            ArrayList<String[]> dados = new ArrayList<>();
            ArrayList<TipoPessoa> listaPessoas = pessoaServico.listar();
            for (TipoPessoa pessoa : listaPessoas) {
                dados.add(new String[]{pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento().toString()});
            }
            String cpf = PessoaVisao.solicitarEntradaBuscar(dados);
            if (cpf == null) return null;
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
            ArrayList<String[]> dados = new ArrayList<>();
            ArrayList<TipoPessoa> listaPessoas = pessoaServico.listar();
            for (TipoPessoa pessoa : listaPessoas) {
                dados.add(new String[]{pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento().toString()});
            }
            String cpf = PessoaVisao.solicitarEntradaBuscar(dados);
            if (cpf == null) return;

            pessoaServico.remover(cpf);
            GenericoVisao.exibirMensagemInfo("Registro da pessoa com o CPF: " + cpf + " foi excluído com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }
}
