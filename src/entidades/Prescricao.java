package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prescricao {

    private Consulta consultaAssociada;
    private Exame examePrescritos;
    private ArrayList<Medicamento> medicamentos;
    private LocalDate dataValidade;

    Prescricao(Consulta consultaAssociada, Exame examePrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {
        this.consultaAssociada = consultaAssociada;
        this.examePrescritos = examePrescritos;
        this.medicamentos = medicamentos;
        this.dataValidade = dataValidade;
    }

}
