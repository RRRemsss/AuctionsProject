package fr.eni.auctionsProject.dal.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Enchere;
import fr.eni.auctionsProject.bo.Retrait;

public class sqlMapperHelper {

	public static Article mapOutArticle(ResultSet result) {
		Article article = new Article();
		// Mapper en objet
		
		try {
			int no_Article = result.getInt("no_Article");
			String nom_article = result.getString("nom_article");
			String description = result.getString("description");
			Date date_debut_encheres = result.getDate("date_debut_encheres");
			Date date_fin_encheres = result.getDate("date_fin_encheres");
			int prix_initial = result.getInt("prix_initial");
			int prix_vente = result.getInt("prix_vente");
			int no_utilisateur = result.getInt("no_utilisateur");
			int no_categorie = result.getInt("no_categorie");
			
			article.setNomArticle(nom_article);
			article.setDescription(description);
			article.setDateDebut(date_debut_encheres.toLocalDate());
			article.setDateFin(date_fin_encheres.toLocalDate());
			article.setPrixInitial(prix_initial);
			article.setPrixVente(prix_vente);
			article.setNoUtilisateur(no_utilisateur);
			article.setNoCategorie(no_categorie);
			article.setNoArticle(no_Article);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	
	public static void mapInArticle(PreparedStatement pstmt, Article article) {
		// Remplir chaque ?
		try {
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getDateDebut()));
			pstmt.setDate(4, Date.valueOf(article.getDateFin()));
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setInt(7, article.getNoUtilisateur());
			pstmt.setInt(8,1/* article.getNoCategorie()*/);
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void mapInRetrait(PreparedStatement pstmt, Retrait retrait) {
		// Remplir chaque ?
		try {
			pstmt.setInt(1, retrait.getNoArticle());
			pstmt.setString(2, retrait.getRue());
			pstmt.setString(3, retrait.getCodePostal());
			pstmt.setString(4, retrait.getVille());
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		}


	public static Retrait mapOutRetrait(ResultSet result) throws SQLException {
		Retrait retrait = new Retrait();
		retrait.setNoArticle(result.getInt(1));
		retrait.setRue(result.getString(2));
		retrait.setCodePostal(result.getString(3));
		retrait.setVille(result.getString(4));
		
		return retrait;
	}

	public static void mapInEnchere(PreparedStatement pstmt, Enchere enchere) {
		// Remplir chaque ?
		try {
			pstmt.setDate(1, Date.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, enchere.getArticle().getNoArticle());
			pstmt.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
			
		
		}catch (SQLException e){
			e.printStackTrace();
		}
		}

	public static Enchere mapOutEnchere(ResultSet result) throws SQLException {
		Enchere enchere = new Enchere();
		try {
			Date dateEnchere = result.getDate("date_fin_encheres");
			int montantEnchere = result.getInt("prix_initial");
			
			enchere.setDateEnchere(dateEnchere.toLocalDate());
			enchere.setMontantEnchere(montantEnchere);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return enchere;
	}
	
}

