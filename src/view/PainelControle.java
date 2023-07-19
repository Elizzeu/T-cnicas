package view;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import control.*;

public class PainelControle extends Luz {

	private static final long serialVersionUID = 1L;
	private Sistem Show;
	private Painel Janela;
	private Relatorio PainelRel;
	private JButton CorForte;
	private JButton CorFraca;
	private JButton Rapido;
	private JButton Lento;
	private JPanel LuzAzul;
	private JPanel LuzVermelha;
	private JPanel LuzVerde;
	private JPanel LuzRoza;
	private JPanel LuzLilas;
	private JPanel LuzRocho;
	private JPanel LuzAmarelo;
	private Dados dados;

	public PainelControle(Sistem cont, Painel janela, Relatorio rel) {
		Show = cont;
		this.Janela = janela;
		PainelRel = rel;

		this.setLayout(new BorderLayout());
		JPanel PainelPlano = painelLuz();
		JPanel PainelRodada = painelMenu();

		this.add(PainelPlano, BorderLayout.CENTER);
		this.add(PainelRodada, BorderLayout.EAST);
	}

	private JPanel painelLuz() {
		JPanel Painel = new JPanel();
		Painel.setBackground(Color.WHITE);
		Painel.setPreferredSize(new Dimension(400, 520));

		JPanel PainelCores = new JPanel();
		PainelCores.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		PainelCores.setPreferredSize(new Dimension(400, 50));
		PainelCores.setBackground(Color.WHITE);

		LuzAzul = new JPanel();
		LuzAzul.setBackground(Color.BLUE);
		LuzAzul.setPreferredSize(new Dimension(50, 50));

		LuzVermelha = new JPanel();
		LuzVermelha.setBackground(Color.RED);
		LuzVermelha.setPreferredSize(new Dimension(50, 50));

		LuzVerde = new JPanel();
		LuzVerde.setBackground(new Color(0, 128, 0));
		LuzVerde.setPreferredSize(new Dimension(50, 50));

		LuzRoza = new JPanel();
		LuzRoza.setBackground(new Color(255, 20, 147));
		LuzRoza.setPreferredSize(new Dimension(50, 50));

		LuzLilas = new JPanel();
		LuzLilas.setBackground(new Color(200, 162, 200));
		LuzLilas.setPreferredSize(new Dimension(50, 50));

		LuzRocho = new JPanel();
		LuzRocho.setBackground(new Color(128, 0, 128));
		LuzRocho.setPreferredSize(new Dimension(50, 50));

		LuzAmarelo = new JPanel();
		LuzAmarelo.setBackground(new Color(255, 255, 0));
		LuzAmarelo.setPreferredSize(new Dimension(50, 50));

		PainelCores.add(LuzAzul);
		PainelCores.add(LuzVermelha);
		PainelCores.add(LuzVerde);
		PainelCores.add(LuzRoza);
		PainelCores.add(LuzRocho);
		PainelCores.add(LuzAmarelo);
		Painel.add(PainelCores);
		return Painel;
	}
	JPanel painelMenu() {
		JPanel painel = new JPanel();
		painel.setBackground(Color.GRAY);
		painel.setPreferredSize(new Dimension(180, 520));

		CorForte = new JButton("Cor Forte");
		CorFraca = new JButton("Cor Fraca");
		Rapido = new JButton("Rapido");
		Lento = new JButton("Lento");

		JButton rock = new JButton("Rock");

		JButton reggae = new JButton("Reggae");
		JButton eletronico = new JButton("Eletronico");
		JButton proximaRodada = new JButton("ProximaRodada");
		JButton sair = new JButton("Sair");

		CorForte.setBackground(Color.white);
		CorForte.setPreferredSize(new Dimension(150, 40));
		CorForte.addActionListener(new acaoCorForte());

		CorFraca.setBackground(Color.WHITE);
		CorFraca.setPreferredSize(new Dimension(150, 40));
		CorFraca.addActionListener(new acaoCorFraca());

		Rapido.setBackground(Color.WHITE);
		Rapido.setPreferredSize(new Dimension(150, 40));
		Rapido.addActionListener(new acaoRapido());

		Lento.setBackground(Color.WHITE);
		Lento.setPreferredSize(new Dimension(150, 40));
		Lento.addActionListener(new acaoLento());

		rock.setBackground(Color.WHITE);
		rock.setPreferredSize(new Dimension(150, 40));
		rock.addActionListener(new acaoRock());

		reggae.setBackground(Color.WHITE);
		reggae.setPreferredSize(new Dimension(150, 40));
		reggae.addActionListener(new acaoReggae());

		eletronico.setBackground(Color.WHITE);
		eletronico.setPreferredSize(new Dimension(150, 40));
		eletronico.addActionListener(new acaoEletronico());

		proximaRodada.setBackground(Color.WHITE);
		proximaRodada.setPreferredSize(new Dimension(150, 40));
		proximaRodada.addActionListener(new acaoNextRound());

		sair.setBackground(Color.WHITE);
		sair.setPreferredSize(new Dimension(150, 50));

		painel.add(new JLabel("Ritmos"));
		painel.add(rock);
		painel.add(reggae);
		painel.add(eletronico);

		painel.add(new JLabel("Intencidade da cor"));
		painel.add(CorForte);
		painel.add(CorFraca);

		painel.add(new JLabel("Velocidade"));
		painel.add(Rapido);
		painel.add(Lento);
		return painel;
	}
	public class acaoLento implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomeBotao = e.getActionCommand();
			dados.addDados(nomeBotao);			
			Piscar piscarAzul = new Piscar(LuzAzul,  Color.blue, 800);
			Piscar piscarRed = new Piscar(LuzVermelha,  Color.RED, 800);
			Piscar piscarAmarelo = new Piscar(LuzAmarelo, new Color(255, 255, 0), 800);
			Piscar piscarRoxo = new Piscar(LuzRocho, new Color(128, 0, 128), 800);
			Piscar piscarRoza = new Piscar(LuzRoza, new Color(255, 20, 147), 800);
			Piscar piscarVerde = new Piscar(LuzVerde, new Color(0, 128, 0), 800);

		}
	}

	public class acaoReggae implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomeBotao = e.getActionCommand();
			dados.addDados(nomeBotao);
			Piscar piscarAzul = new Piscar(LuzAzul,  Color.blue, 500);
			Piscar piscarRed = new Piscar(LuzVermelha,  Color.RED, 500);
			Piscar piscarAmarelo = new Piscar(LuzAmarelo, new Color(255, 255, 0), 500);
			Piscar piscarRoxo = new Piscar(LuzRocho, new Color(128, 0, 128), 500);
			Piscar piscarRoza = new Piscar(LuzRoza, new Color(255, 20, 147), 500);
			Piscar piscarVerde = new Piscar(LuzVerde, new Color(0, 128, 0), 500);

		}
	}

	public class acaoEletronico implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    String nomeBotao = e.getActionCommand();
	    	dados.addDados(nomeBotao);
			Piscar piscarAzul = new Piscar(LuzAzul,  Color.blue, 500);
			Piscar piscarRed = new Piscar(LuzVermelha,  Color.RED, 500);
			Piscar piscarAmarelo = new Piscar(LuzAmarelo, new Color(255, 255, 0), 500);
			Piscar piscarRoxo = new Piscar(LuzRocho, new Color(128, 0, 128), 500);
			Piscar piscarRoza = new Piscar(LuzRoza, new Color(255, 20, 147), 500);
			Piscar piscarVerde = new Piscar(LuzVerde, new Color(0, 128, 0), 500);

		}
	}

	public class acaoRock implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomeBotao = e.getActionCommand();
			dados.addDados(nomeBotao);
			Piscar piscarAzul = new Piscar(LuzAzul,  Color.blue, 500);
			Piscar piscarRed = new Piscar(LuzVermelha,  Color.RED, 500);
			Piscar piscarAmarelo = new Piscar(LuzAmarelo, new Color(255, 255, 0), 500);
			Piscar piscarRoxo = new Piscar(LuzRocho, new Color(128, 0, 128), 500);
			Piscar piscarRoza = new Piscar(LuzRoza, new Color(255, 20, 147), 500);
			Piscar piscarVerde = new Piscar(LuzVerde, new Color(0, 128, 0), 500);

		}
	}

	public class acaoCorForte implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomeBotao = e.getActionCommand();
			dados.addDados(nomeBotao);
			Piscar piscarAzul = new Piscar(LuzAzul, new  Color(0, 0, 139), 500);
			Piscar piscarRed = new Piscar(LuzVermelha, new  Color(128, 0, 0), 500);
			Piscar piscarAmarelo = new Piscar(LuzAmarelo, new Color(255, 165, 0), 500);
			Piscar piscarRoxo = new Piscar(LuzRocho, new Color(75, 0, 130), 500);
			Piscar piscarRoza = new Piscar(LuzRoza, new Color(199, 21, 133), 500);
			Piscar piscarVerde = new Piscar(LuzVerde, new Color(0, 100, 0), 500);

		}
	}

	public class acaoCorFraca implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomeBotao = e.getActionCommand();
			dados.addDados(nomeBotao);
			Piscar piscarAzul = new Piscar(LuzAzul, new  Color(0, 191, 255), 500);
			Piscar piscarRed = new Piscar(LuzVermelha, new  Color(255, 99, 17), 500);
			Piscar piscarAmarelo = new Piscar(LuzAmarelo, new Color(240, 230, 147), 500);
			Piscar piscarRoxo = new Piscar(LuzRocho, new Color(216, 191, 216), 500);
			Piscar piscarRoza = new Piscar(LuzRoza, new Color(255, 105, 180), 500);
			Piscar piscarVerde = new Piscar(LuzVerde, new Color(0, 250, 154), 500);

		}
	}

	public class acaoRapido implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	    	String nomeBotao = e.getActionCommand();
			dados.addDados(nomeBotao);
			Piscar piscarAzul = new Piscar(LuzAzul,  Color.blue, 200);
			Piscar piscarRed = new Piscar(LuzVermelha,  Color.RED, 200);
			Piscar piscarAmarelo = new Piscar(LuzAmarelo, new Color(255, 255, 0), 200);
			Piscar piscarRoxo = new Piscar(LuzRocho, new Color(128, 0, 128), 200);
			Piscar piscarRoza = new Piscar(LuzRoza, new Color(255, 20, 147), 200);
			Piscar piscarVerde = new Piscar(LuzVerde, new Color(0, 128, 0), 200);
		
	}

	}

	public class acaoNextRound implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nomeBotao = e.getActionCommand();
			dados.addDados(nomeBotao);

		}
	}
}
