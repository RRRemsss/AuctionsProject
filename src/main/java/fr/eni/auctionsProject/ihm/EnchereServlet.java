package fr.eni.auctionsProject.ihm;

import java.io.IOException;

import fr.eni.auctionsProject.bll.ArticleManager;
import fr.eni.auctionsProject.bll.ManagerFactory;
import fr.eni.auctionsProject.bo.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	        System.out.println(article.getRetrait());
	        request.setAttribute("article_info", article);
	    }
		
		request.getRequestDispatcher("/WEB-INF/pages/Enchere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
