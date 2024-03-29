package fr.eni.auctionsProject.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.auctionsProject.bll.ManagerFactory;
import fr.eni.auctionsProject.bll.UtilisateurManager;
import fr.eni.auctionsProject.bo.Utilisateur;

/**
 * Servlet implementation class ConsultationProfilservlet
 */
@WebServlet(
			urlPatterns = "/ConsultationProfilServlet"
		)
public class ConsultationProfilservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
	    if (pseudo != null) {
	        UtilisateurManager utilisateurManager = ManagerFactory.getUtilisateurManager();
	        Utilisateur user = utilisateurManager.getUserByPseudo(pseudo);
	        request.setAttribute("user_info", user);
	    }
		
		request.getRequestDispatcher("/WEB-INF/pages/ConsultationProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
