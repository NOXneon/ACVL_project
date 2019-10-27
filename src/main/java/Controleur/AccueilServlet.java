package Controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import Exceptions.ExceptionSpectacleExistant;
import Exceptions.ExceptionChevauchement;
import Modele.Theatre.Spectacle;
import Modele.Theatre.Theatre;

public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Theatre theatre;
//	private String user;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		theatre = Theatre.getTHEATRE();
		String shows = request.getParameter("showsList");
		String showToAdd = request.getParameter("showsToAdd");
		//List<Spectacle> listeShows = JSONArray.parseArray(shows, Spectacle.class);

		this.doGet(request, response);
	}
}
