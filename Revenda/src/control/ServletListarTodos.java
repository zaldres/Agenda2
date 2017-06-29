package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ListarTodosDAO;
import model.Carro;

/**
 * Servlet implementation class ServletListarTodos
 */
@WebServlet("/listarTodos")
public class ServletListarTodos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarTodos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();
		ListarTodosDAO ltd = new ListarTodosDAO(conexao);
		ArrayList<Carro> listarTodos = ltd.getListarTodosDAO();
	
		//Inserir Parametros no request
				request.setAttribute("carro", listarTodos);
				
				//Criar um request Request Dispatcher
				RequestDispatcher rd = request.getRequestDispatcher("/respostaListarTodos.jsp");
				rd.forward(request,  response);
	
	}

}
