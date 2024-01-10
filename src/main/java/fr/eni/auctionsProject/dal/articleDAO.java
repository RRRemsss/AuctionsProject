package fr.eni.auctionsProject.dal;

import java.util.List;

import fr.eni.auctionsProject.bo.Article;


public interface articleDAO {

	//CRUD

		public Article selectById(int noArticle);

		public List<Article> selectAll();

		public Article insert(Article article);

		public void delete(int noArticle);
		
		public void updatePrixVente (Article article);
}
