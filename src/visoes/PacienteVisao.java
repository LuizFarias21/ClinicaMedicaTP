package visoes;

import javax.swing.*;

import controladores.PacienteControlador;
import entidades.Paciente;

public class PacienteVisao extends PessoaVisao<Paciente> {

    public PacienteVisao(PacienteControlador pacienteControlador) {
        super(pacienteControlador);
    }

    @Override
    public void exibir() {
        while (true) {

            String[] opcoesMenu = {"Cadastrar Pacientes", "Buscar Pacientes",
                    "Atualizar Pacientes", "Remover Pacientes", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int opcaoEscolhida = JOptionPane.showOptionDialog(null, "Menu Paciente", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

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

