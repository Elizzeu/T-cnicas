package view;

import java.awt.Color;

import javax.swing.JButton;

public class Botao extends JButton{
	
	private String texto;
	public Botao(String texto, Color cor) {
		this.texto = texto;
		this.setText(texto);
		
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
