package fr.eni.auctionsProject.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.auctionsProject.bo.Retrait;

import fr.eni.auctionsProject.config.ConnectionProvider;
import fr.eni.auctionsProject.dal.retraitDAO;

public class retraitDaoImpl implements retraitDAO {
	
	private static final String SQL_INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article,rue, code_postal, ville) values (?,?,?,?)";
	private static final String SELECT_BY_ID_RETRAIT= "SELECT * FROM RETRAITS WHERE no_article =?";
	
	@Override
	public Retrait selectByIdRetrait(int noArticle) {
		Retrait retrait = null;
		 try ( 	Connection connection = ConnectionProvider.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID_RETRAIT);){

				pstmt.setInt(1, noArticle);
				

				ResultSet result = pstmt.executeQuery();
				if (result.next()) {
					
					retrait = sqlMapperHelper.mapOutRetrait(result);
					
				};
							
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return retrait;	
	}

	

	@Override
	public void insert(Retrait retrait) {
				try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement stmt = cnx.prepareStatement(SQL_INSERT_RETRAIT, Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setInt(1, retrait.getNoArticle());			
			stmt.setString(2, retrait.getRue());	
			stmt.setString(3, retrait.getCodePostal());		
			stmt.setString(4, retrait.getVille());		
		
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
