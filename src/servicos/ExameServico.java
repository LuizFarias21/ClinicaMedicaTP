package servicos;

import entidades.Exame;
import repositorios.ExameRepositorio;

public final class ExameServico extends TratamentoServico<Exame> {

    private ExameRepositorio exameRepositorio;

    public ExameServico(ExameRepositorio exameRepositorio) {
        super(exameRepositorio);
        this.exameRepositorio = exameRepositorio;
    }
}
