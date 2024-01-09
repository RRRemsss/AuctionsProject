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

/**
 * Servlet implementation class SuppressionProfilServlet
 */
@WebServlet(
			urlPatterns = "/SuppressionProfilServlet"
		)
public class SuppressionProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noutilisateur = Integer.parseInt(request.getParameter("id"));
		
		UtilisateurManager utilisateurManager = ManagerFactory.getUtilisateurManager();
		utilisateurManager.deleteUser(noutilisateur);
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		
		response.sendRedirect(request.getContextPath() + "/AccueilServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
