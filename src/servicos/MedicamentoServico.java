package servicos;

import entidades.Medicamento;
import excecoes.DadoInvalidoException;
import repositorios.MedicamentoRepositorio;

public final class MedicamentoServico extends TratamentoServico<Medicamento> {

    private MedicamentoRepositorio medicamentoRepositorio;

    public MedicamentoServico(MedicamentoRepositorio medicamentoRepositorio) {
        super(medicamentoRepositorio);
        this.medicamentoRepositorio = medicamentoRepositorio;
    }
}
