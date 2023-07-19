package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import control.Sistem;

public class Relatorio extends JPanel {

	private static final long serialVersionUID = 1L;

	private Border borda = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
	private JTable tabela;
	private StringBuilder botoesClicados;
	
	
	public Relatorio(StringBuilder botoesClicados) {

		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(575, 500));
		this.setBorder(borda);

     String[][] dados = obterDados1();

		String[] colunas = { "Botões clicados: " + botoesClicados};

		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

		tabela = new JTable(modelo);


		JScrollPane painelRolagem = new JScrollPane(tabela);
		painelRolagem.setPreferredSize(new Dimension(550, 480));

		this.add(painelRolagem);
	
	}
	  
	    private String[][] obterDados1() {
		return null;
	}
		
	private void configurarTabela() {
		tabela.setCellSelectionEnabled(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.setRowHeight(30);
	}
	

	
}