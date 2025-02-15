package repositorios;

import entidades.Pessoa;
import visoes.GenericoVisao;

import java.util.ArrayList;

public abstract class PessoaRepositorio<TipoPessoa extends Pessoa> extends GenericoRepositorio<TipoPessoa> {

    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    @Override
    public void cadastrar(TipoPessoa tipoPessoa) {
        // Cadastra um tipo específico de pessoa em sua respectiva lista
        super.cadastrar(tipoPessoa);
        // Cadastra qualquer tipo de pessoa, paciente e medico na lista de pessoas
        listaPessoas.add(tipoPessoa);
    }

    @Override
    public TipoPessoa buscar(String cpf) {
        for (TipoPessoa pessoa : listar()){
            if(pessoa.getCpf().equals(cpf)) return pessoa;
        }
        return null;
    }

    public ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void atualizar(TipoPessoa entidade, TipoPessoa novaEntidade) {
        // Atualiza qualquer tipo de pessoa, paciente e medico na lista de pessoas
        listaPessoas.set(listaPessoas.indexOf(entidade), novaEntidade);
    }
}