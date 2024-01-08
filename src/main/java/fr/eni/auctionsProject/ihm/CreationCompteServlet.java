package fr.eni.auctionsProject.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import fr.eni.auctionsProject.bll.ManagerFactory;
import fr.eni.auctionsProject.bll.UtilisateurManager;
import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.exceptions.BusinessException;

/**
 * Servlet implementation class CreationCompteServlet
 */
@WebServlet(
			urlPatterns = "/CreationCompte"
		)
public class CreationCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/CreationCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {				
			Utilisateur user = new Utilisateur(
						request.getParameter("pseudo"),
						request.getParameter("nom"),
						request.getParameter("prenom"),
						request.getParameter("email"),
						request.getParameter("tel"),
						request.getParameter("rue"),
						request.getParameter("cp"),
						request.getParameter("ville"),
						request.getParameter("password"),
						100,
						false
					);
			
			UtilisateurManager utilisateurManager = ManagerFactory.getUtilisateurManager();
			Utilisateur createdUser = utilisateurManager.createUser(user);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", createdUser);
			
			response.sendRedirect(request.getContextPath() + "/AccueilServlet");
		} catch (BusinessException e) {
		    e.printStackTrace();
		    request.setAttribute("listeErreurs", e.getListeCodesErreur());
		    request.getRequestDispatcher("/WEB-INF/pages/CreationCompte.jsp").forward(request, response);
		}
	}

}
