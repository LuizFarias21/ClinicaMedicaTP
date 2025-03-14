package visoes;

import javax.swing.*;

public class SistemaVisao {

    private final PacienteVisao pacienteVisao;
    private final MedicoVisao medicoVisao;
    private final ConsultaVisao consultaVisao;
    private final ExameVisao exameVisao;
    private final MedicamentoVisao medicamentoVisao;

    public SistemaVisao(PacienteVisao pacienteVisao, MedicoVisao medicoVisao, ConsultaVisao consultaVisao, ExameVisao exameVisao, MedicamentoVisao medicamentoVisao) {
        this.pacienteVisao = pacienteVisao;
        this.medicoVisao = medicoVisao;
        this.consultaVisao = consultaVisao;
        this.exameVisao = exameVisao;
        this.medicamentoVisao = medicamentoVisao;
    }

    public void exibirVisao() {
        while(true) {

            String[] opcoesMenu = {"Gerenciar Pacientes", "Gerenciar Médicos", "Gerenciar Consultas", "Gerenciar Exames", "Gerenciar Medicamentos", "Sair"};

            int opcaoEscolhida = JOptionPane.showOptionDialog(null, "Gerenciador de clínica médica", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

            switch (opcaoEscolhida) {
                case 0:
                    pacienteVisao.exibir();
                    break;
                case 1:
                    medicoVisao.exibir();
                    break;
                case 2:
                    consultaVisao.exibir();
                    break;
                case 3:
                    exameVisao.exibir();
                    break;
                case 4:
                    medicamentoVisao.exibir();
                    break;
                case 5:
                    return;
            }
        }
    }
}
