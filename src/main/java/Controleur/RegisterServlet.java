package Controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Modele.Utilisateur.Client;

public class RegisterServlet extends HttpServlet {

	public List<Client> listeClients;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String users = request.getParameter("clientsList");
		if (users != "") {
			ObjectMapper mapper = new ObjectMapper();
			listeClients = new ArrayList<Client>();
			listeClients = mapper.readValue(users, new TypeReference<List<Client>>() {});

			String name = request.getParameter("nom");
			String surname = request.getParameter("prénom");
			String username = request.getParameter("login");
			String password = request.getParameter("mdp");
			String mail = request.getParameter("mail");
			String number = request.getParameter("tel");

			Client client = new Client(name, surname, username, password, mail, number);
			boolean same = false;
			for (Client c: listeClients) {
				if (c.getLogin() == client.getLogin()) {
					same = true;
				}
			}
			if (same) {
				request.setAttribute("addingClientMessage", "The client already exists");
			} else {
				request.setAttribute("addingClientMessage", "The client can be added");
			}
		} else {
			request.setAttribute("addingClientMessage", "The client can be added");
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}
}