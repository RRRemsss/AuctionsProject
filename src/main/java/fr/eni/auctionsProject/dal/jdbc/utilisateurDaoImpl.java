package fr.eni.auctionsProject.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.config.ConnectionProvider;
import fr.eni.auctionsProject.dal.utilisateurDAO;

public class utilisateurDaoImpl implements utilisateurDAO {

	private static final String SQL_INSERT_USER = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_BY_PSEUDO = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe FROM utilisateurs WHERE pseudo=?";
	private static final String SQL_SELECT_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe FROM utilisateurs WHERE no_utilisateur=?";
	private static final String SQL_UPDATE_USER = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=? WHERE no_utilisateur=?";
	private static final String SQL_UPDATE_PASSWORD = "UPDATE utilisateurs SET mot_de_passe=? WHERE no_utilisateur=?";
	private static final String SQL_DELETE_USER = "DELETE FROM utilisateurs WHERE no_utilisateur=?";

	@Override
	public Utilisateur selectById(int noUtilisateur) {
		Utilisateur user = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SQL_SELECT_BY_ID)) {
			stmt.setInt(1, noUtilisateur);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				user.setNoUtilisateur(rs.getShort(1));
				user.setPseudo(rs.getString(2));
				user.setNom(rs.getString(3));
				user.setPrenom(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setRue(rs.getString(7));
				user.setCodePostal(rs.getString(8));
				user.setVille(rs.getString(9));
				user.setMotDePasse(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void update(Utilisateur utilisateur) {
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement stmt = cnx.prepareStatement(SQL_UPDATE_USER)) {
			stmt.setString(1, utilisateur.getPseudo());
		    stmt.setString(2, utilisateur.getNom());
		    stmt.setString(3, utilisateur.getPrenom());
		    stmt.setString(4, utilisateur.getEmail());
		    stmt.setString(5, utilisateur.getTelephone());
		    stmt.setString(6, utilisateur.getRue());
		    stmt.setString(7, utilisateur.getCodePostal());
		    stmt.setString(8, utilisateur.getVille());
		    stmt.setInt(9, utilisateur.getNoUtilisateur());
		    
		    stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur insert(Utilisateur utilisateur) {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
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

			int affectedRows = stmt.executeUpdate();

	        if (affectedRows > 0) {
	            try (ResultSet rs = stmt.getGeneratedKeys()) {
	                if (rs.next()) {
	                    utilisateur.setNoUtilisateur(rs.getInt(1));
	                } else {
	                    throw new SQLException("La récupération de l'ID généré a échoué.");
	                }
	            }
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public void delete(int noUtilisateur) {
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement stmt = cnx.prepareStatement(SQL_DELETE_USER)) {
			stmt.setInt(1, noUtilisateur);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) {
		Utilisateur user = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SQL_SELECT_BY_PSEUDO)) {
			stmt.setString(1, pseudo);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				user.setNoUtilisateur(rs.getShort(1));
				user.setPseudo(rs.getString(2));
				user.setNom(rs.getString(3));
				user.setPrenom(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setRue(rs.getString(7));
				user.setCodePostal(rs.getString(8));
				user.setVille(rs.getString(9));
				user.setMotDePasse(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updatePassword(Utilisateur utilisateur) {
		try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement stmt = cnx.prepareStatement(SQL_UPDATE_PASSWORD)) {
			stmt.setString(1, utilisateur.getMotDePasse());
			stmt.setInt(2, utilisateur.getNoUtilisateur());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
