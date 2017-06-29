package dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Carro;

public class ConsultarModeloDAO {
	Connection conexao;
	
	public ConsultarModeloDAO(Connection conexao){
		this.conexao = conexao;
	}
	public Carro consultarModel(String modelo){
		//Criar Objeto de retorno
		Carro c = new Carro();
		//Criar objeto de acesso a BD
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT idcarros, modelo, anofab, marca FROM revenda.carros WHERE modelo like ?");
			ps.setString(1,"%" + modelo + "%");
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				c.setIdcarro(rs.getInt("idcarros"));
				c.setAnofab(rs.getString("anofab"));
				c.setModelo(rs.getString("modelo"));
				c.setMarca(rs.getString("marca"));
			}
			rs.close();
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
	}
		return c;
	}
	}