package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		   
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		   String name = request.getParameter("name");
		   String surname = request.getParameter("surname");
		   String username = request.getParameter("uname");
		   String password = request.getParameter("psw");
		   String mail = request.getParameter("mail");
		   String number = request.getParameter("number");
		   
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	    }
}
