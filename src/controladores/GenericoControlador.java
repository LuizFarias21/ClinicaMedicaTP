package controladores;

public abstract class GenericoControlador<TipoEntidade> {

    public abstract void cadastrar();

    public abstract TipoEntidade buscar();

    public abstract void atualizar();

    public abstract void remover();
}