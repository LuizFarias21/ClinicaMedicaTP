package visoes;

import controladores.MedicamentoControlador;
import entidades.Medicamento;

import javax.swing.*;

public class MedicamentoVisao extends TratamentoVisao<Medicamento> {

    private MedicamentoControlador medicamentoControlador;

    public MedicamentoVisao(MedicamentoControlador medicamentoControlador) {
        super(medicamentoControlador);
        this.medicamentoControlador = medicamentoControlador;
    }


    @Override
    public void exibir() {
        while (true) {

            String[] menuOpcoes = {"Cadastrar Medicamento", "Buscar Medicamento", "Atualizar Medicamento", "Remover Medicamento", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int opcaoEscolhida = JOptionPane.showOptionDialog(null, "Menu Medicamento", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menuOpcoes, menuOpcoes[0]);

            // Verificar escolha do usuário
            switch (opcaoEscolhida) {
                case 0:
                    cadastrar();
                    break;
                case 1:
                    buscar();
                    break;
                case 2:
                    atualizar();
                    break;
                case 3:
                    remover();
                    break;
                case 4:
                    return;
            }
        }
    }
}
