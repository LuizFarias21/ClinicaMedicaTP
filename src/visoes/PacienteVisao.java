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

            String[] opcoes = {"Cadastrar Pacientes", "Buscar Pacientes",
                    "Atualizar Pacientes", "Remover Pacientes", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Paciente", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
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

    @Override
    public void listar() {

    }
}

