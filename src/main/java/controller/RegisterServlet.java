package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

		this.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String users = request.getParameter("clientsList");
		ObjectMapper mapper = new ObjectMapper();
		listeClients = mapper.readValue(users, listeClients.getClass());

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		String mail = request.getParameter("mail");
		String number = request.getParameter("number");

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
		this.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}
}
