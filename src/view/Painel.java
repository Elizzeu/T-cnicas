package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import control.Sistem;

public class Painel extends JFrame implements ActionListener {

	private static final Sistem Jogo = null;
	private Sistem cont;
	private JPanel Painel1;
	private JPanel Painel2;
	private JPanel PainelJogo;
	private Relatorio PainelRelatorio;
	private Saida PainelSaida;
	private JTextField NomeText;
	private JButton BotaoIniciar;
	private JButton BotaoRelatorio;
	private JButton BotaoSair;
	private boolean Iniciar;

	public void iniciar() {
		this.setTitle("Shows do Aniversario de Sobral");
		this.setSize(600,500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		NomeText = new JTextField();
		Painel1 = painel1();
		PainelRelatorio = new Relatorio(null);
		PainelJogo = new PainelControle(Jogo, this, PainelRelatorio);
		PainelSaida = new Saida(cont);

		PainelRelatorio.setVisible(false);
		PainelJogo.setVisible(false);
		PainelSaida.setVisible(false);

		Painel2 = new JPanel();
		Painel2.setLayout(new FlowLayout());
		Painel2.setBackground(Color.WHITE);
		Painel2.add(PainelJogo);
		Painel2.add(PainelRelatorio);
		Painel2.add(PainelSaida);

		this.add(Painel1, BorderLayout.NORTH);
		this.add(Painel2, BorderLayout.CENTER);

		this.setVisible(true);
	}

	private JPanel painel1() {

		JPanel Painel = new JPanel();
	
		BotaoRelatorio = new JButton("Relatorio");
		BotaoRelatorio.setBackground(Color.white);
		BotaoRelatorio.addActionListener(new acaoRelatorio());
		
		BotaoIniciar = new JButton("Iniciar");
		BotaoIniciar.setBackground(Color.white);
		BotaoIniciar.addActionListener(new acaoIniciar());
	
		BotaoSair = new JButton("Sair");
		BotaoSair.setBackground(Color.RED);
		BotaoSair.addActionListener(new acaoExit());
		NomeText.setPreferredSize(new Dimension(130, 25));

		Painel.setBackground(Color.GRAY);
		Painel.setPreferredSize(new Dimension(600, 40));
		Painel.add(new JLabel("Tecnico de Palco"));
		Painel.add(NomeText);
		Painel.add(BotaoIniciar);
		Painel.add(BotaoRelatorio);
		Painel.add(BotaoSair);
		return Painel;
	}

	private JPanel painelSair() {
		JPanel painel = new JPanel();
		painel.setBackground(Color.BLACK);
		painel.setPreferredSize(new Dimension(575, 500));
		return painel;
	}

	public void atualizarPainelRelatorio() {
		PainelRelatorio.removeAll();
		PainelRelatorio.setBackground(Color.BLACK);
		PainelRelatorio.setPreferredSize(new Dimension(575, 500));
	}
	private class acaoIniciar implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			PainelJogo.setVisible(true);
			BotaoIniciar.setEnabled(false);
			NomeText.setEnabled(false);
			Iniciar = true;

			String nomeJogador = NomeText.getText();
			if (!nomeJogador.isEmpty()) {
			} else {
				PainelJogo.setVisible(false);
				JOptionPane.showMessageDialog(null, "Insira o nome do Tecnico", "Mensagem",
						JOptionPane.INFORMATION_MESSAGE);
				NomeText.setEnabled(true);
				BotaoIniciar.setEnabled(true);
			}
		}
	}

	private class acaoRelatorio implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (PainelRelatorio.isVisible() && Iniciar == false) {
				PainelJogo.setVisible(false);
				PainelRelatorio.setVisible(false);

			} else if (PainelRelatorio.isVisible() && Iniciar) {
				PainelJogo.setVisible(true);
				PainelRelatorio.setVisible(false);

			} else {
				PainelJogo.setVisible(false);
				PainelRelatorio.setVisible(true);
			}
		}
	}

	private class acaoExit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public void actionPerformed(ActionEvent e) {
		JPanel Aux = painelSair();
		Painel2.add(Aux);
		PainelJogo.setVisible(false);
		PainelRelatorio.setVisible(false);
		Aux.setVisible(true);

		NomeText.setEnabled(false);
		BotaoIniciar.setEnabled(false);
		BotaoRelatorio.setEnabled(false);

	}

	public void setPainelSair(boolean b) {
		PainelSaida.atualizarPainelSair();
		PainelSaida.setVisible(b);
	}

	public JButton getBoButton() {
		return BotaoIniciar;
	}

}
