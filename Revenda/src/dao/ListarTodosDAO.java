package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import model.Carro;

public class ListarTodosDAO {
		Connection conexao;
		
	public ListarTodosDAO(Connection conexao){
		this.conexao = conexao;
		}
	public ArrayList<Carro> getListarTodosDAO(){
		//Criar Objeto de retorno 
		ArrayList<Carro> listarTodos = new ArrayList<Carro>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			ps = conexao.prepareStatement("SELECT idcarros, modelo, anofab, marca FROM revenda.carros");
			rs=ps.executeQuery();
			
			while(rs.next()){
				Carro c = new Carro();
				c.setIdcarro(rs.getInt("idcarros"));
				c.setAnofab(rs.getString("anofab"));
				c.setModelo(rs.getString("modelo"));
				c.setMarca(rs.getString("marca"));
				
				listarTodos.add(c);
			}
			rs.close();
			ps.close();
		}
		catch (Exception e) {
			e.printStackTrace();
	}
		return listarTodos ;
	}
	

}

