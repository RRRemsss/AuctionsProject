package fr.eni.auctionsProject.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
			// Gestion des erreurs en cas de champs vides
			BusinessException businessException = new BusinessException();
			if(request.getParameter("pseudo") == null || request.getParameter("pseudo").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.PSEUDO_USER_OBLIGATOIRE);
			}
			if(request.getParameter("nom") == null || request.getParameter("nom").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.NOM_USER_OBLIGATOIRE);
			}
			if(request.getParameter("prenom") == null || request.getParameter("prenom").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.PRENOM_USER_OBLIGATOIRE);
			}
			if(request.getParameter("email") == null || request.getParameter("email").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.EMAIL_USER_OBLIGATOIRE);
			}
			if(request.getParameter("rue") == null || request.getParameter("rue").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.RUE_USER_OBLIGATOIRE);
			}
			if(request.getParameter("cp") == null || request.getParameter("cp").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.CP_USER_OBLIGATOIRE);
			}
			if(request.getParameter("ville") == null || request.getParameter("ville").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.VILLE_USER_OBLIGATOIRE);
			}
			if(request.getParameter("password") == null || request.getParameter("password").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.PASSWORD_USER_OBLIGATOIRE);
			}
			if(request.getParameter("confirm") == null || request.getParameter("confirm").isEmpty()) {
				businessException.ajouterErreur(CodesResultatIHM.CONFIRMPASSWORD_USER_OBLIGATOIRE);
			}
			
			// Throw erreur si la liste des erreurs n'est pas vide
			if(businessException.hasErreurs()) {
				throw businessException;
			}
			
			// Générer un sel (salt) avec un facteur de coût par défaut de 12
	        BCrypt.Hasher hasher = BCrypt.withDefaults();
	        // Hacher le mot de passe avec le sel généré
	        String hashedPassword = hasher.hashToString(12, request.getParameter("password").toCharArray());
			
			Utilisateur user = new Utilisateur(
						request.getParameter("pseudo"),
						request.getParameter("nom"),
						request.getParameter("prenom"),
						request.getParameter("email"),
						request.getParameter("tel"),
						request.getParameter("rue"),
						request.getParameter("cp"),
						request.getParameter("ville"),
						hashedPassword,
						0,
						false
					);
			
			UtilisateurManager utilisateurManager = ManagerFactory.getUtilisateurManager();
			
			utilisateurManager.createUser(user);
			
			request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
		} catch (BusinessException e) {
		    e.printStackTrace();
		    request.setAttribute("listeErreurs", e.getListeCodesErreur());
		    request.getRequestDispatcher("/WEB-INF/pages/CreationCompte.jsp").forward(request, response);
		}
	}

}
