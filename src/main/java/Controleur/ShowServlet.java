package Controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import Modele.ExceptionChevauchement;
import Modele.ExceptionSpectacleExistant;
import Modele.Theatre.Spectacle;
import Modele.Theatre.Theatre;

public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Theatre theatre;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		theatre = Theatre.getTHEATRE();
		String shows = request.getParameter("showsList");
		String showToAdd = request.getParameter("showsToAdd");
		List<Spectacle> listeShows = JSONArray.parseArray(shows, Spectacle.class);
		Spectacle newShow = JSON.parseObject(showToAdd, Spectacle.class);
		try {
			theatre.ajouterSpectacle(newShow);
		} catch (ExceptionChevauchement e) {
			e.printStackTrace();
		} catch (ExceptionSpectacleExistant e) {
			e.printStackTrace();
			System.out.println("ERREUR");
		}
		System.out.println(theatre.getSpectacles().toString());
		if (!listeShows.isEmpty()) {

				boolean same = false;
				for (Spectacle s: listeShows) {
					if (s.getNom() == newShow.getNom()) {
						same = true;
					}
				}
				if (same) {
					request.setAttribute("addingShowMessage", "The show already exists");
				} else {
					request.setAttribute("addingShowMessage", "The show can be added");
					request.setAttribute("showToAddPostMessage", showToAdd);
				}
		} else {
			request.setAttribute("addingShowMessage", "The show can be added");
			request.setAttribute("showToAddPostMessage", showToAdd);
		}
		request.setAttribute("user", request.getParameter("userTypeShow"));
		this.doGet(request, response);
	}
}
