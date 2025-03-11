package controladores;

import entidades.Medicamento;
import servicos.MedicamentoServico;
import visoes.MedicamentoVisao;

public final class MedicamentoControlador extends TratamentoControlador<Medicamento> {
    private MedicamentoServico medicamentoServico;
    private MedicamentoVisao medicamentoVisao;

    public MedicamentoControlador(MedicamentoServico medicamentoServico) {
        super(medicamentoServico);
        this.medicamentoServico = medicamentoServico;
    }

    public void setMedicamentoVisao(MedicamentoVisao medicamentoVisao) {
        this.medicamentoVisao = medicamentoVisao;
    }

//    @Override
//    public String listar() {
//        return null;
//    }

    @Override
    public void cadastrar() {

    }

    @Override
    public Medicamento buscar() {
        return null;
    }

    @Override
    public void atualizar() {

    }
}
