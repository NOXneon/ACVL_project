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
import Exceptions.ExceptionChevauchement;
import Exceptions.ExceptionSpectacleExistant;
import Modele.Theatre.Representation;
import Modele.Theatre.Spectacle;
import Modele.Theatre.Theatre;

public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Theatre theatre = Theatre.getTHEATRE();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("userType");
		String toDo = request.getParameter("toDo");
		String shows = request.getParameter("showsList");
		List<Spectacle> listeShows = JSONArray.parseArray(shows, Spectacle.class);
		theatre.getSpectacles().clear();
		for (Spectacle s : listeShows) {
			try {
				theatre.ajouterSpectacle(s);
			} catch (ExceptionChevauchement e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionSpectacleExistant e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (toDo.equals("addShow")) {

			String showToAdd = request.getParameter("showsToAdd");
			Spectacle newShow = JSON.parseObject(showToAdd, Spectacle.class);
			try {
				theatre.ajouterSpectacle(newShow);
				request.setAttribute("addingShowMessage", "The show can be added");
				request.setAttribute("showToAddPostMessage", showToAdd);
				request.setAttribute("user", request.getParameter("userTypeShow"));
			} catch (ExceptionChevauchement e) {
				e.printStackTrace();
			} catch (ExceptionSpectacleExistant e) {
				request.setAttribute("addingShowMessage", "The show already exists");
			}

		} else if (toDo.equals("addRep")) {
			String repToAdd = request.getParameter("repToAdd");
			String repShow = request.getParameter("repShow");
			Representation newRep = JSON.parseObject(repToAdd, Representation.class);
			try {
				for (Spectacle s : theatre.getSpectacles()) {
					if (s.getNom().equals(repShow)) {
						theatre.getSpectacles().get(theatre.getSpectacles().indexOf(s)).ajouterRepresentation(newRep);
						request.setAttribute("repToAddPostMessage", repToAdd);
						request.setAttribute("repShow", repShow);
						request.setAttribute("addingRepMessage", "The rep can be added");
						System.out.println("NON" + theatre.getSpectacles());
					}
				}

			} catch (Exception f) {

				request.setAttribute("addingRepMessage", "The rep does not fit");
			}
		}

		request.setAttribute("user", user);
		this.doGet(request, response);
	}
}
