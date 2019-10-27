package Controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import Modele.ExceptionChevauchement;
import Modele.Theatre.Representation;
import Modele.Theatre.Spectacle;
import Modele.Theatre.Theatre;

public class RepresentationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Theatre theatre = Theatre.getTHEATRE();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String repToAdd = request.getParameter("repToAdd");
		String repShow = request.getParameter("repShow");
		Spectacle show = JSON.parseObject(repShow, Spectacle.class);
		Representation newRep = JSON.parseObject(repToAdd, Representation.class);
		try {
			theatre.getSpectacles().get(theatre.getSpectacles().indexOf(show)).ajouterRepresentation(newRep);
			request.setAttribute("repToAddPostMessage", repShow);
		} catch (ExceptionChevauchement f) {
			request.setAttribute("addingShowMessage", f.getMessage());
		}
		request.setAttribute("user", request.getParameter("userTypeShow"));
		this.doGet(request, response);
	}
}
