package visoes;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class GenericoVisao<TipoEntidade> {

    public static void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void exibirMensagemInfo(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String solicitarEntrada(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static LocalDate solicitarEntradaData(String mensagem) {
        return LocalDate.parse(solicitarEntrada(mensagem));
    }

    public static LocalTime solicitarEntradaHorario(String mensagem) {
        return LocalTime.parse(solicitarEntrada(mensagem));
    }

    public abstract void exibir();

    public abstract void cadastrar();

    public abstract void buscar();

    public abstract void atualizar();

    public abstract void remover();
}
