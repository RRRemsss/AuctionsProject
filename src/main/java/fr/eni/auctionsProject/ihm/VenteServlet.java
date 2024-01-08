package fr.eni.auctionsProject.ihm;

import java.io.IOException;
import java.time.LocalDate;

import fr.eni.auctionsProject.bll.ArticleManager;
import fr.eni.auctionsProject.bll.ManagerFactory;
import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Retrait;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class VenteServlet
 */
@WebServlet (
		urlPatterns = "/VenteServlet"
	)
public class VenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/NewVente.jsp").forward(request, response);
		System.out.println("test do get");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Image récup url
		//Récupération des données
		System.out.println("test do post");
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		int noCategorie = 1;
		//InputStream inputStream = request.getPart("photo").getInputStream();
		int prixInitial = 100;
		System.out.println (prixInitial);
		String dateDebut = request.getParameter("dateDebut");
		String dateFin = request.getParameter("dateFin");
		LocalDate localDateDebut = null;
		LocalDate localDateFin = null;

		if (dateDebut != null && !dateDebut.isEmpty()) {
		    localDateDebut = LocalDate.parse(dateDebut);
		}

		if (dateFin != null && !dateFin.isEmpty()) {
		    localDateFin = LocalDate.parse(dateFin);
		}
		
		System.out.println (dateDebut);
		System.out.println (dateFin);
		
		
		
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		
		
		//céation du nouvel objet
		
		
	     Article article = new Article( nomArticle,  description,localDateDebut,localDateFin,prixInitial, noCategorie);
	     
	     Retrait retrait = new Retrait();
	     
	     retrait.setRue(rue);
	     retrait.setCodePostal(cp);
	     retrait.setVille(ville);
	     System.out.println(article);
	     System.out.println(retrait);
	   //Persist
	     
	     ArticleManager articleManager = ManagerFactory.getArticleManager();
	 
	     
	     articleManager.createArticle(article,retrait);
	    
	    
	     
	      
	      response.sendRedirect(request.getContextPath()+"/AccueilServlet");
	}
}
