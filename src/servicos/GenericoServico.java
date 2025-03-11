package servicos;

import excecoes.DadoInvalidoException;
import repositorios.GenericoRepositorio;
import java.util.ArrayList;

public abstract class GenericoServico<TipoEntidade> {

    private final GenericoRepositorio<TipoEntidade> genericoRepositorio;

    public GenericoServico(GenericoRepositorio<TipoEntidade> genericoRepositorio) {
        this.genericoRepositorio = genericoRepositorio;
    }

    protected abstract void cadastrar(TipoEntidade entidade) throws DadoInvalidoException;
    protected abstract TipoEntidade buscar(String identificador) throws DadoInvalidoException;
    protected abstract void atualizar(TipoEntidade entidade, TipoEntidade novaEntidade) throws DadoInvalidoException;

    public final void remover(String identificador) throws DadoInvalidoException {
        TipoEntidade entidade = buscar(identificador);
        genericoRepositorio.remover(entidade);
    }

    public final ArrayList<TipoEntidade> listar() throws DadoInvalidoException {
        if (listaVazia()) throw new DadoInvalidoException("Nenhum registro encontrado!");
        return genericoRepositorio.getLista();
    }

    public final boolean listaVazia() {
        return genericoRepositorio.getLista().isEmpty();
    }
}
