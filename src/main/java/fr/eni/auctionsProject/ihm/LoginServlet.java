package fr.eni.auctionsProject.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.auctionsProject.bll.ManagerFactory;
import fr.eni.auctionsProject.bll.UtilisateurManager;
import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.exceptions.BusinessException;

@WebServlet(
		urlPatterns = "/LoginServlet"
	)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/Login.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Récupérer les infos pour le test des mots de passes
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			
			
			UtilisateurManager utilisateurManager = ManagerFactory.getUtilisateurManager();
			Utilisateur user = utilisateurManager.connectUser(username, password);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect(request.getContextPath() + "/AccueilServlet");
		} catch (BusinessException e) {
			e.printStackTrace();
		    request.setAttribute("listeErreurs", e.getListeCodesErreur());
		    request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
		}
		
		
	}

}
