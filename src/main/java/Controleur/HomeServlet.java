package Controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import Modele.Theatre.Spectacle;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String shows = request.getParameter("showsList");
		String showToAdd = request.getParameter("showToAdd");
		List<Spectacle> listeShows = JSONArray.parseArray(shows, Spectacle.class);
	
		System.out.println(showToAdd);
		Spectacle newShowToAdd = JSON.parseObject(showToAdd, Spectacle.class);
		if (!listeShows.isEmpty()) {

				boolean same = false;
				if (listeShows.contains(newShowToAdd)) {
					same = true;
				}
				if (same) {
					request.setAttribute("addingShowMessage", "The show already exists");
				} else {
					request.setAttribute("addingShowMessage", "The show can be added");
					request.setAttribute("showsToAdd", newShowToAdd.toString());
				}
		} else {
			request.setAttribute("addingShowMessage", "The show can be added");
			request.setAttribute("showsToAdd", newShowToAdd.toString());
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}
}
