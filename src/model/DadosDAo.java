package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import control.Dados;
import view.*;

public class DadosDAo {
	

	public ArrayList<String> selecionar() {
		ArrayList<String> relatorio = new ArrayList<String>();

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement r = 
		    conexao.prepareStatement("select * from dados order by relatorio");

			ResultSet resultado = r.executeQuery();

			while (resultado.next()) {
				Dados dados = new Dados();
				
				dados.setRelatorio(resultado.getString("relatorio"));
				relatorio.add(dados.getRelatorio());
				
			}

			conexao.close();
		} catch (Exception e) {
		}
		return relatorio;
	}

	
	public int inserir(Dados d) {
		int resp =0;
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = 
			conexao.prepareStatement("insert into dados "
					+ "relatorio"
					+ "values (?)");
			
			inserir.setString(1, d.getRelatorio());
				
		resp = inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resp;
	}

}
