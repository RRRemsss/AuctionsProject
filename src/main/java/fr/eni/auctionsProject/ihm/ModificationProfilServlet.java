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

/**
 * Servlet implementation class ModificationProfilServlet
 */
@WebServlet(
			urlPatterns = "/ModificationProfilServlet"
		)
public class ModificationProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/ModificationProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Utilisateur connectedUser = (Utilisateur) session.getAttribute("user");
		try {
			// Récupération des nouvelles infos du user
			Utilisateur modifiedUser = new Utilisateur(
					connectedUser.getNoUtilisateur(),
					request.getParameter("pseudo"),
					request.getParameter("nom"),
					request.getParameter("prenom"),
					request.getParameter("email"),
					request.getParameter("telephone"),
					request.getParameter("rue"),
					request.getParameter("codepostal"),
					request.getParameter("ville"),
					request.getParameter("password")
				);
			
			// Récupération du nouveau mot de passe pour le changer
			String newPassword= request.getParameter("newPassword");
			String confirmNewPassword= request.getParameter("confirmNewPassword");
			
			// Update du user
			UtilisateurManager utilisateurManager = ManagerFactory.getUtilisateurManager();
			utilisateurManager.updateUser((Utilisateur) session.getAttribute("user"), modifiedUser, newPassword, confirmNewPassword);
			
			// Modification de la session avec les changements
			session.setAttribute("user", modifiedUser);
			
			response.sendRedirect(request.getContextPath() + "/AccueilServlet");
		} catch (BusinessException e) {
			e.printStackTrace();
		    request.setAttribute("listeErreurs", e.getListeCodesErreur());
		    request.getRequestDispatcher("/WEB-INF/pages/ModificationProfil.jsp").forward(request, response);
		}
		
		
		
	}

}
