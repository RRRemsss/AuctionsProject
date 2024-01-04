package fr.eni.auctionsProject.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.config.ConnectionProvider;
import fr.eni.auctionsProject.dal.utilisateurDAO;

public class utilisateurDaoImpl implements utilisateurDAO{
	
	private static final String SQL_INSERT_USER = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public Utilisateur selectById(int noUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Utilisateur utilisateur) {
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement stmt = cnx.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());			
			stmt.setString(6, utilisateur.getRue());			
			stmt.setString(7, utilisateur.getCodePostal());		
			stmt.setString(8, utilisateur.getVille());		
			stmt.setString(9, utilisateur.getMotDePasse());		
			stmt.setInt(10, utilisateur.getCredit());		
			stmt.setInt(11, utilisateur.isAdministrateur() ? 1 : 0);		
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int noUtilisateur) {
		// TODO Auto-generated method stub
		
	}

	
}
