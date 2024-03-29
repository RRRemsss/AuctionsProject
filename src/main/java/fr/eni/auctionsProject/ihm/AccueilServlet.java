package fr.eni.auctionsProject.ihm;

import java.io.IOException;
import java.util.List;

import fr.eni.auctionsProject.bll.ArticleManager;
import fr.eni.auctionsProject.bll.ManagerFactory;
import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet(
			urlPatterns = "/AccueilServlet"
		)
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleManager articleManager = ManagerFactory.getArticleManager();
		List<Article> articleListe = articleManager.getArticleListe();
		request.setAttribute("ListeArticles", articleListe);
		request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		
		ArticleManager articleManager = ManagerFactory.getArticleManager();
		
		Boolean venteCours = "on".equals(request.getParameter("venteCours"));
		Boolean venteNonDebutee = "on".equals(request.getParameter("venteNonDebutee"));
		Boolean venteTerminee = "on".equals(request.getParameter("venteTerminee"));
		

	    List<Article> articlesFiltres = articleManager.FiltrerVente( utilisateur ,venteCours,	venteNonDebutee, venteTerminee);
	    
	    request.setAttribute("ListeArticles", articlesFiltres);
	    
	    request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
	}

}
