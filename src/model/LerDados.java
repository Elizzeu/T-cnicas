package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import view.*;

public class LerDados {
	private String arquivo;
	
	private ArrayList<String> luz1;
	private ArrayList<String> luz2;
	private ArrayList<String> luz3;
	private ArrayList<String> luz4;
	private ArrayList<String> luz5;
	private ArrayList<String> luz6;

	
	
	public void  separaArquivos(String arquivo) {
		String caminho = arquivo;

		luz1 = new ArrayList<>();
		luz2 = new ArrayList<>();
		luz3 = new ArrayList<>();
		luz4 = new ArrayList<>();
		luz5 = new ArrayList<>();
		luz6 = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] numbers = linha.split(";");
				
				luz1.add(numbers[0]);
				luz2.add(numbers[1]);
				luz3.add(numbers[2]);
				luz4.add(numbers[3]);
				luz5.add(numbers[4]);
				luz6.add(numbers[5]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
	 
