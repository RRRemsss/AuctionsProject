package fr.eni.auctionsProject.ihm;

import java.io.IOException;
import java.time.LocalDate;

import fr.eni.auctionsProject.bll.ArticleManager;
import fr.eni.auctionsProject.bll.ManagerFactory;
import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Retrait;
import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.exceptions.BusinessException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



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
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     try {
	    	//Image récup url
	 		//Récupération des données
	 		HttpSession session =  request.getSession(false);
	 		Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
	 		String nomArticle = request.getParameter("nomArticle");
	 		String description = request.getParameter("description");
	 		int noCategorie = Integer.parseInt(request.getParameter("categorie"));
	 		//InputStream inputStream = request.getPart("photo").getInputStream();
	 		int prixInitial = Integer.parseInt(request.getParameter("prixInitial"));
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
	 		
	 		String rue = request.getParameter("rue");
	 		String cp = request.getParameter("cp");
	 		String ville = request.getParameter("ville");
	 		
	 		
	 		
	 		//création du nouvel objet
	 		
	 		
	 	     Article article = new Article( nomArticle,  description,localDateDebut,localDateFin,prixInitial, prixInitial, utilisateur.getNoUtilisateur(), noCategorie);
	 	     System.out.println(article);
	 	     Retrait retrait = new Retrait();
	 	     
	 	     retrait.setRue(rue);
	 	     retrait.setCodePostal(cp);
	 	     retrait.setVille(ville);
	 	
	 	   //Persist
	 	     
	 	     ArticleManager articleManager = ManagerFactory.getArticleManager();
	 	 
	 	     
	    	 
			articleManager.createArticle(article,retrait);
			
			
	      response.sendRedirect(request.getContextPath()+"/AccueilServlet");
	      
		}  catch (BusinessException e) {
		    e.printStackTrace();
		    request.setAttribute("listeErreurs", e.getListeCodesErreur());
		    request.getRequestDispatcher("/WEB-INF/pages/NewVente.jsp").forward(request, response);
		}
	    
	     
	  
	}
}
