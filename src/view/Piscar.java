package view;

import java.awt.Color;

import javax.swing.JPanel;

public class Piscar {
	
	   

		public Piscar(JPanel painel, Color corOriginal, int velocidade) {
	        Thread thread = new Thread(() -> {
	            try {
	                boolean piscando = true;
	                while (piscando) {
	                    painel.setBackground(Color.WHITE);
	                    Thread.sleep(velocidade); // Tempo de espera em milissegundos (mais rápido)
	                    painel.setBackground(corOriginal);
	                    Thread.sleep(velocidade); // Tempo de espera em milissegundos (mais rápido)
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        thread.start();
	    }

}
