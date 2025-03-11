package repositorios;

import entidades.Pessoa;
import java.util.ArrayList;

public abstract class PessoaRepositorio<TipoPessoa extends Pessoa> extends GenericoRepositorio<TipoPessoa> {

    private static final ArrayList<Pessoa> LISTA_PESSOAS = new ArrayList<>();

    @Override
    public void cadastrar(TipoPessoa tipoPessoa) {
        super.cadastrar(tipoPessoa);
        LISTA_PESSOAS.add(tipoPessoa);
    }

    @Override
    public TipoPessoa buscar(String cpf) {
        for (TipoPessoa pessoa : getLista()){
            boolean cpfCorrespondente = pessoa.getCpf().equals(cpf);
            if(cpfCorrespondente) return pessoa;
        }
        return null;
    }

    @Override
    public void atualizar(TipoPessoa pessoa, TipoPessoa novaPessoa) {
        super.atualizar(pessoa, novaPessoa);
        LISTA_PESSOAS.set(LISTA_PESSOAS.indexOf(pessoa), novaPessoa);
    }

    @Override
    public void remover(TipoPessoa tipoPessoa) {
        super.remover(tipoPessoa);
        LISTA_PESSOAS.remove(tipoPessoa);
    }

    public ArrayList<Pessoa> getListaPessoas() {
        return LISTA_PESSOAS;
    }
}