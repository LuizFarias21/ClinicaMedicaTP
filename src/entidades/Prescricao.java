package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public final class Prescricao {

    private Consulta consultaAssociada;
    private ArrayList<Exame> examesPrescritos;
    private ArrayList<Medicamento> medicamentos;
    private LocalDate dataValidade;

    public Prescricao(Consulta consultaAssociada, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {
        this.consultaAssociada = consultaAssociada;
        this.examesPrescritos = examesPrescritos;
        this.medicamentos = medicamentos;
        this.dataValidade = dataValidade;
    }

    public Consulta getConsultaAssociada() {
        return consultaAssociada;
    }

    public void setConsultaAssociada(Consulta consultaAssociada) {
        this.consultaAssociada = consultaAssociada;
    }

    public ArrayList<Exame> getExamesPrescritos() {
        return examesPrescritos;
    }

    public void setExamesPrescritos(ArrayList<Exame> examesPrescritos) {
        this.examesPrescritos = examesPrescritos;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
