package fr.eni.auctionsProject.bll;

import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.dal.DAOFactory;
import fr.eni.auctionsProject.dal.articleDAO;

public class ArticleManager {

	public void createArticle(Article article) {
		articleDAO daoArticle = DAOFactory.getDaoArticle();
		daoArticle.insert(article);
	}
}
