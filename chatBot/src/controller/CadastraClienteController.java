package controller;

import java.io.IOException;

import pacote.ChatB;
import pacote.Cliente;
import service.ClienteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CadastraClienteController
 */
@WebServlet("/cadastraCliente.do")
public class CadastraClienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String pNome = request.getParameter("nome");
        String pEmail = request.getParameter("email");

        Cliente cli = new Cliente();
        cli.setNome(pNome);
        cli.setEmail(pEmail);
        
        ClienteService service = new ClienteService();        
        int id = service.criarCliente(cli);
        cli.setId(id);
 //       cli.setId(1);

        session.setAttribute("cliente", cli);
        session.setAttribute("chat", new ChatB());

        RequestDispatcher view = request.getRequestDispatcher("chat.jsp");
        view.forward(request, response);
    }
}