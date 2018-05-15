package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import pacote.Pais;
import service.vendedorService;

/**
 * Servlet implementation class ListarPaisController
 */
@WebServlet("/listarPaisController.do")
public class ListarPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request,
			
	HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		String acao = request.getParameter("acao");
		vendedorService vendedor = new vendedorService();
		ArrayList<Pais> lista = null;
		HttpSession session = request.getSession();
		
		if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				lista = vendedor.listarPais(chave);
			} else {
				lista = vendedor.listarPais();
			}
			session.setAttribute("lista", lista);
		} else if (acao.equals("reiniciar")) {
			session.setAttribute("lista", null);
		}

		RequestDispatcher dispatcher = (RequestDispatcher) request
				.getRequestDispatcher("ListarPais.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


	
		
}
