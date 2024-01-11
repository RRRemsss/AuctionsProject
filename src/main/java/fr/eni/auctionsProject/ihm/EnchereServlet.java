package fr.eni.auctionsProject.ihm;

import java.io.IOException;
import java.time.LocalDate;

import fr.eni.auctionsProject.bll.ArticleManager;
import fr.eni.auctionsProject.bll.ManagerFactory;
import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Enchere;
import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.exceptions.BusinessException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet(
		urlPatterns = "/EnchereServlet"
	)
public class EnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noArticle = Integer.parseInt (request.getParameter("id"));
	    if (noArticle!= 0) {
	        ArticleManager articleManager = ManagerFactory.getArticleManager();
	        Article article= articleManager.selectByArticle(noArticle);
	        
	        System.out.println(article);
	        
	        
	        request.setAttribute("article_info", article);
	    }
		
		
		request.getRequestDispatcher("/WEB-INF/pages/Enchere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Enchere enchere = new Enchere();
			
			enchere.setDateEnchere(LocalDate.now());
			enchere.setMontantEnchere(Integer.parseInt(request.getParameter("MiseAPrix")));
			
			HttpSession session =  request.getSession(false);
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
			
			enchere.setUtilisateur(utilisateur);
			
			int noArticle = Integer.parseInt (request.getParameter("id"));
			
			ArticleManager articleManager = ManagerFactory.getArticleManager();
			
			articleManager.insertEnchere(enchere, noArticle);
			
			response.sendRedirect(request.getContextPath() + "/EnchereServlet?id="+noArticle);
		}  catch (BusinessException e) {
		    e.printStackTrace();
		    request.setAttribute("listeErreurs", e.getListeCodesErreur());
		    doGet(request, response);
		}
		
		
	}

}
