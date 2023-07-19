package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import control.Sistem;

public class Saida extends JPanel {


	private Sistem cont;
	private JButton botao;

	// construtot
	public Saida(Sistem cont) {
		this.cont = cont;

		this.botao = new JButton("FECHAR JOGO");

		painelIniciar();
		addComponents();
		configBotao();
	}

	private void painelIniciar() {
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(575, 500));
		setLayout(new BorderLayout());
	}

	private void addComponents() {
		String[] colunas = { "Nome", "Botao"};
		String[][] dados = new String[0][2];


		JScrollPane painelRolagem = new JScrollPane();
		painelRolagem.setPreferredSize(new Dimension(550, 400));

		add(painelRolagem, BorderLayout.CENTER);
		add(botao, BorderLayout.SOUTH);
	}

	private void configBotao() {}

	public void atualizarPainelSair() {
		removeAll();
		painelIniciar();
		addComponents();
		System.exit(0);
	}

}
