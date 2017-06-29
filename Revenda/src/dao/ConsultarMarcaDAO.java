package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Carro;

public class ConsultarMarcaDAO {
	Connection conexao;
	
	public ConsultarMarcaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//Metodo que retorna um modelo de acordo com a marca
public Carro consultarModel(String marca){
	//Criar Objeto de retorno
	Carro c = new Carro();
	//Criar objeto de acesso a BD
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try {
		
		ps = conexao.prepareStatement("SELECT idcarros, modelo, anofab, marca FROM revenda.carros WHERE marca=?");
		ps.setString(1,marca);
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
