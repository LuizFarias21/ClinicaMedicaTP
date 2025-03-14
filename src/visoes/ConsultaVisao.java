package visoes;

import controladores.ConsultaControlador;
import entidades.Consulta;

import javax.swing.*;

public class ConsultaVisao extends TratamentoVisao<Consulta> {

    private ConsultaControlador consultaControlador;

    public ConsultaVisao(ConsultaControlador consultaControlador) {
        super(consultaControlador);
        this.consultaControlador = consultaControlador;
    }

    @Override
    public void exibir() {
        while (true) {

            String[] opcoesMenu = {"Agendar Consulta", "Cancelar Consulta", "Finalizar Consulta", "Buscar Consulta",
                    "Atualizar Consulta", "Remover Consulta", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int opcaoEscolhida = JOptionPane.showOptionDialog(null, "Menu Consulta", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

            // Verificar opcaoEscolhida do usuário
            switch (opcaoEscolhida) {
                case 0:
                    agendar();
                    break;
                case 1:
                    cancelar();
                    break;
                case 2:
                    finalizar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    remover();
                    break;
                case 6:
                    return;
            }
        }
    }

// Prescrever vai ocorrer dentro de agendar consulta

    public void agendar() {

    }

    public void cancelar() {

    }

    public void finalizar() {

    }
}
