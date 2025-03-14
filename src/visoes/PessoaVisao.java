package visoes;

import controladores.PessoaControlador;
import entidades.Pessoa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public abstract class PessoaVisao<TipoPessoa extends Pessoa> extends GenericoVisao<TipoPessoa> {

    private PessoaControlador<TipoPessoa> pessoaControlador;

    public PessoaVisao(PessoaControlador<TipoPessoa> pessoaControlador) {
        this.pessoaControlador = pessoaControlador;
    }

    public static String solicitarEntradaBuscar(ArrayList<String[]> dados) {
        String[] colunas = {"CPF", "Nome", "Data de Nascimento"};

        Object[][] dadosArray = dados.toArray(new Object[0][]);
        DefaultTableModel modeloTabela = new DefaultTableModel(dadosArray, colunas);
        JTable tabela = new JTable(modeloTabela);

        // Wrap table inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(600, 150));

        return JOptionPane.showInputDialog(null, scrollPane, "Buscar pelo CPF", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void cadastrar() {
        pessoaControlador.cadastrar();
    }

    @Override
    public void buscar() {
        pessoaControlador.buscar();
    }

    @Override
    public void atualizar() {
        pessoaControlador.atualizar();
    }

    @Override
    public void remover() {
        pessoaControlador.remover();
    }
}
