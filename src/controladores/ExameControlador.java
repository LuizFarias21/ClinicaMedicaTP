package controladores;

import entidades.Exame;
import servicos.ExameServico;
import visoes.ExameVisao;

public final class ExameControlador extends TratamentoControlador<Exame> {
    private ExameServico exameServico;
    private ExameVisao exameVisao;

    public ExameControlador(ExameServico exameServico) {
        super(exameServico);
        this.exameServico = exameServico;
    }

    public void setExameVisao(ExameVisao exameVisao) {
        this.exameVisao = exameVisao;
    }

//    @Override
//    public String listar() {
//        return null;
//    }

    @Override
    public void cadastrar() {

    }

    @Override
    public Exame buscar() {
        return null;
    }

    @Override
    public void atualizar() {

    }
}
