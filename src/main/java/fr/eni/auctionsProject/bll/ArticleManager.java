package fr.eni.auctionsProject.bll;

import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Retrait;
import fr.eni.auctionsProject.dal.DAOFactory;
import fr.eni.auctionsProject.dal.articleDAO;
import fr.eni.auctionsProject.dal.retraitDAO;

public class ArticleManager {

	public void createArticle(Article article, Retrait retrait) {
		articleDAO daoArticle = DAOFactory.getDaoArticle();
		article = daoArticle.insert(article);
	
		retraitDAO daoRetrait = DAOFactory.getDaoRetrait();
		retrait.setNoArticle(article.getNoArticle());
		daoRetrait.insert(retrait);
	}
	
}
