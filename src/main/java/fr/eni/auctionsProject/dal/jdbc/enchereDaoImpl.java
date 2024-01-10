package fr.eni.auctionsProject.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Enchere;
import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.config.ConnectionProvider;
import fr.eni.auctionsProject.dal.enchereDAO;

public class enchereDaoImpl implements enchereDAO {

	private final static String INSERT_ENCHERE = "INSERT INTO ENCHERES (date_enchere,montant_enchere,no_article, no_utilisateur) VALUES (?,?,?,?)";
	private final static String SELECT_ALL_ENCHERE_BY_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article=?";
	
	@Override
	public Enchere insertEnchere(Enchere enchere) {

		//connection à la base de donnée
	try (Connection connection = ConnectionProvider.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(INSERT_ENCHERE);){
		
		//récupere les valeurs et mise a jour de la base de donnée 
		sqlMapperHelper.mapInEnchere(pstmt, enchere);
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		//on retourne les valeurs 
		return enchere;
	}
	
	public List<Enchere> selectAllEnchereByArticle(int noArticle){
		List<Enchere> encheres = new ArrayList<Enchere>();
		try (Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_ENCHERE_BY_ARTICLE);){
				
				//récupere les valeurs et mise a jour de la base de donnée 
				pstmt.setInt(1, noArticle);
			
				ResultSet result = pstmt.executeQuery();
				
				while(result.next()){
					Enchere enchere = new Enchere();
					enchere.setNoEnchere(result.getInt(1));
					enchere.setDateEnchere(result.getDate(2).toLocalDate());
					enchere.setMontantEnchere(result.getInt(3));
					enchere.setArticle(new Article(result.getInt(4)));
					enchere.setUtilisateur(new Utilisateur(result.getInt(5)));
					encheres.add(enchere);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				//on retourne les valeurs 
				return encheres;
				
			}
	
}
