package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ConsultarMarcaDAO;
import model.Carro;

/**
 * Servlet implementation class ConsultarMarca
 */
@WebServlet("/consultarMarca")
public class ServletConsultarMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarMarca() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obter parametros da requisiçao
		String marca = request.getParameter("marca");
		Connection conexao = Conexao.getConexao();
		ConsultarMarcaDAO cmd = new ConsultarMarcaDAO(conexao);
		Carro c = cmd.consultarModel(marca);
		
		//Inserir Parametros no request
		request.setAttribute("carro", c);
		
		//Criar um request Request Dispatcher
		RequestDispatcher rd = request.getRequestDispatcher("/respostaConsultarMarca.jsp");
		rd.forward(request,  response);
		
	}

}
