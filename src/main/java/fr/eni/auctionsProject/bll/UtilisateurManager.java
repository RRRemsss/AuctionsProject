package fr.eni.auctionsProject.bll;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Verifyer;
import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.dal.DAOFactory;
import fr.eni.auctionsProject.dal.utilisateurDAO;
import fr.eni.auctionsProject.exceptions.BusinessException;
import fr.eni.auctionsProject.ihm.CodesResultatIHM;

public class UtilisateurManager {

	public Utilisateur createUser(Utilisateur utilisateur) throws BusinessException {
		// Gestion des erreurs en cas de champs vides
		BusinessException businessException = new BusinessException();
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.PSEUDO_USER_OBLIGATOIRE);
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.NOM_USER_OBLIGATOIRE);
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.PRENOM_USER_OBLIGATOIRE);
		}
		if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.EMAIL_USER_OBLIGATOIRE);
		}
		if (utilisateur.getRue() == null || utilisateur.getRue().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.RUE_USER_OBLIGATOIRE);
		}
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.CP_USER_OBLIGATOIRE);
		}
		if (utilisateur.getVille() == null || utilisateur.getVille().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.VILLE_USER_OBLIGATOIRE);
		}
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.PASSWORD_USER_OBLIGATOIRE);
		}

		// Throw erreur si la liste des erreurs n'est pas vide
		if (businessException.hasErreurs()) {
			throw businessException;
		}
		// CRypter le mot de passe
		// Générer un sel (salt) avec un facteur de coût par défaut de 12
		BCrypt.Hasher hasher = BCrypt.withDefaults();
		// Hacher le mot de passe avec le sel généré
		String hashedPassword = hasher.hashToString(12, utilisateur.getMotDePasse().toCharArray());
		utilisateur.setMotDePasse(hashedPassword);

		utilisateurDAO daoUtilisateur = DAOFactory.getDaoUtilisateur();
		return daoUtilisateur.insert(utilisateur);
	}

	public Utilisateur connectUser(String username, String password) throws BusinessException {
		utilisateurDAO daouUtilisateur = DAOFactory.getDaoUtilisateur();
		Utilisateur user = daouUtilisateur.selectByPseudo(username);

		verifyPassword(user, password, username);

		return user;
	}

	public void verifyPassword(Utilisateur user, String password, String username) throws BusinessException {
		BusinessException businessException = new BusinessException();

		if (username == null || username.isEmpty()) {
			businessException.ajouterErreur(1);
		}
		if (password == null || password.isEmpty()) {
			businessException.ajouterErreur(8);
		}
		else if (user == null || user.getMotDePasse() == null || user.getMotDePasse().isEmpty()) {
	        businessException.ajouterErreur(10);
	    }
		if (businessException.hasErreurs()) {
			throw businessException;
		}

		Verifyer verifyer = BCrypt.verifyer();
		BCrypt.Result result = verifyer.verify(password.toCharArray(), user.getMotDePasse());

		if (!result.verified) {
			businessException.ajouterErreur(10);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
	}

	public Utilisateur getUserByPseudo(String pseudo) {
		utilisateurDAO daouUtilisateur = DAOFactory.getDaoUtilisateur();
		return daouUtilisateur.selectByPseudo(pseudo);
	}
	
	public void updateUser(Utilisateur InitialUtilisateur, Utilisateur utilisateur, String newPassword, String confirmNewPassword) throws BusinessException {
		
		BusinessException businessException = new BusinessException();
		
		// Verification des champs afin qu'ils ne soient pas vides
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.PSEUDO_USER_OBLIGATOIRE);
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.NOM_USER_OBLIGATOIRE);
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.PRENOM_USER_OBLIGATOIRE);
		}
		if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.EMAIL_USER_OBLIGATOIRE);
		}
		if (utilisateur.getRue() == null || utilisateur.getRue().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.RUE_USER_OBLIGATOIRE);
		}
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.CP_USER_OBLIGATOIRE);
		}
		if (utilisateur.getVille() == null || utilisateur.getVille().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.VILLE_USER_OBLIGATOIRE);
		}
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().isEmpty()) {
			businessException.ajouterErreur(CodesResultatIHM.PASSWORD_USER_OBLIGATOIRE);
		}
		
		// Vérifier le mot de passe entre celui en session et celui entré dans le formulaire de modification
		Verifyer verifyer = BCrypt.verifyer();
		BCrypt.Result result = verifyer.verify(utilisateur.getMotDePasse().toCharArray(), InitialUtilisateur.getMotDePasse());

		if (!result.verified) {
			businessException.ajouterErreur(10);
		}
		// Jeter une erreur si seul un des deux champs est rempli pour le changement de mot de passe
		if ((newPassword != null && !newPassword.isEmpty() && (confirmNewPassword == null || confirmNewPassword.isEmpty())) ||
			    (confirmNewPassword != null && !confirmNewPassword.isEmpty() && (newPassword == null || newPassword.isEmpty()))) {
			    businessException.ajouterErreur(11);
			}
		



		// Throw erreur si la liste des erreurs n'est pas vide
		if (businessException.hasErreurs()) {
			throw businessException;
		}
		
		utilisateurDAO daouUtilisateur = DAOFactory.getDaoUtilisateur();
		daouUtilisateur.update(utilisateur);
		// Vérifier si l'utilisateur veut changer de mot de passe, et si oui le changer
		if(newPassword != null && !newPassword.isEmpty() && confirmNewPassword != null && !confirmNewPassword.isEmpty() && newPassword.equals(confirmNewPassword)) {
			// Générer un sel (salt) avec un facteur de coût par défaut de 12
			BCrypt.Hasher hasher = BCrypt.withDefaults();
			// Hacher le mot de passe avec le sel généré
			String hashedPassword = hasher.hashToString(12, newPassword.toCharArray());
			utilisateur.setMotDePasse(hashedPassword);
			daouUtilisateur.updatePassword(utilisateur);
		}
	}

	public void deleteUser(int noUtilisateur) {
		utilisateurDAO daouUtilisateur = DAOFactory.getDaoUtilisateur();
		daouUtilisateur.delete(noUtilisateur);
	}
}






















