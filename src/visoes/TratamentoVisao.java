package visoes;

import controladores.TratamentoControlador;
import entidades.Tratamento;

public abstract class TratamentoVisao<TipoTratamento extends Tratamento> extends GenericoVisao<TipoTratamento> {

    private TratamentoControlador<TipoTratamento> tratamentoControlador;

    public TratamentoVisao(TratamentoControlador<TipoTratamento> tratamentoControlador) {
        this.tratamentoControlador = tratamentoControlador;
    }

    @Override
    public void cadastrar() {
        tratamentoControlador.cadastrar();
    }

    @Override
    public void buscar() {
        tratamentoControlador.buscar();
    }

    @Override
    public void atualizar() {
        tratamentoControlador.atualizar();
    }

    @Override
    public void remover() {
        tratamentoControlador.remover();
    }
}
