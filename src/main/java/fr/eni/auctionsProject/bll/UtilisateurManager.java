package fr.eni.auctionsProject.bll;

import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.dal.DAOFactory;
import fr.eni.auctionsProject.dal.utilisateurDAO;

public class UtilisateurManager {
	
	public void createUser(Utilisateur utilisateur) {
		utilisateurDAO daoUtilisateur = DAOFactory.getDaoUtilisateur();
		daoUtilisateur.insert(utilisateur);
	}
	
}
