package fr.eni.auctionsProject.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.config.ConnectionProvider;
import fr.eni.auctionsProject.dal.articleDAO;

public class articleDaoImpl implements articleDAO{

	private final static String SELECT_BY_ID = "SELECT * FROM ARTICLES WHERE no_article =?";
	private final static String SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES ";
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES (nom_article, description, date_debut_encheres, "
												+ "date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	private final static String DELETE_ARTICLE = "DELETE FROM ARTICLES WHERE no_article =?";
	
	
	@Override
	public Article selectById(int noArticle) {
		Article article = null;
		try (Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID);){
			
			
			pstmt.setInt(1, noArticle);
			

			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				System.out.println("Test");
				article = sqlMapperHelper.mapInArticle(result);
				
			};
						
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return article;	
	}

	@Override
	public List<Article> selectAll() {
		//Préparer une liste vide par défaut 
		List<Article> articles = new ArrayList<Article>();
		try (Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_ARTICLE);){
			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				Article article = sqlMapperHelper.mapInArticle(result);
				articles.add(article); }
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return articles;	
	}

	@Override
	public Article insert(Article article) {

	try (Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);){
		
		sqlMapperHelper.mapOutArticle(pstmt, article);
		int nbRows = pstmt.executeUpdate();
		if(nbRows > 0) {
			try (ResultSet rs = pstmt.getGeneratedKeys()){
				if(rs.next()) {
					article.setNoArticle(rs.getInt(1));
				}
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return article;
	}

	@Override
	public void delete(int noArticle) {
		try (Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(DELETE_ARTICLE);){
				pstmt.setInt(1, noArticle);
				pstmt.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
