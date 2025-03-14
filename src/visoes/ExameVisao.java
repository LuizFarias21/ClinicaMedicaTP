package visoes;

import controladores.ExameControlador;
import entidades.Exame;

import javax.swing.*;

public class ExameVisao extends TratamentoVisao<Exame> {

    private ExameControlador exameControlador;

    public ExameVisao(ExameControlador exameControlador) {
        super(exameControlador);
        this.exameControlador = exameControlador;
    }

    @Override
    public void exibir() {
        while (true) {

            String[] opcoesMenu = {"Cadastrar Exame", "Buscar Exame", "Atualizar Exame", "Remover Exame", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int opcaoEscolhida = JOptionPane.showOptionDialog(null, "Menu Exame", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

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
