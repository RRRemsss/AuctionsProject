package fr.eni.auctionsProject.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Retrait;
import fr.eni.auctionsProject.dal.DAOFactory;
import fr.eni.auctionsProject.dal.articleDAO;
import fr.eni.auctionsProject.dal.retraitDAO;
import fr.eni.auctionsProject.dal.utilisateurDAO;

public class ArticleManager {

	public void createArticle(Article article, Retrait retrait) {
		articleDAO daoArticle = DAOFactory.getDaoArticle();
		article = daoArticle.insert(article);
	
		retraitDAO daoRetrait = DAOFactory.getDaoRetrait();
		retrait.setNoArticle(article.getNoArticle());
		daoRetrait.insert(retrait);

	}
	
	public List<Article> getArticleListe(){
		List<Article> articles = new ArrayList<Article>();
		articles = DAOFactory.getDaoArticle().selectAll();
		utilisateurDAO userDao = DAOFactory.getDaoUtilisateur();
		for(Article article : articles) {
			article.setUtilisateur(userDao.selectById(article.getNoUtilisateur()));
		}
		return articles;
		
		
	}
	

	
}	
	