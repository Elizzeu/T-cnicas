package control;

import java.util.ArrayList;

public class Dados  {
	
	private static ArrayList<String>dadosSistema;
	private String relatorio;
	
	
	public Dados() {
		dadosSistema = new ArrayList<String>();
		 
	}
	
	public void addDados(String dados) {
		dadosSistema.add(dados);
		
	}

	public ArrayList<String> getDadosSistema() {
		return dadosSistema;
	}

	public void setDadosSistema(ArrayList<String> dadosSistema) {
		this.dadosSistema = dadosSistema;
	}

	public String getRelatorio() {
		String delimiter = ";";
		String relatorio = String.join(delimiter,getDadosSistema());
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}


}
