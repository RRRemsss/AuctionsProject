package fr.eni.auctionsProject.dal;

import java.util.List;

import fr.eni.auctionsProject.bo.Article;


public interface articleDAO {

	//CRUD

		public Article selectById(int noArticle);

		public List<Article> selectAll();

		public void insert(Article article);

		public void delete(int noArticle);
}
