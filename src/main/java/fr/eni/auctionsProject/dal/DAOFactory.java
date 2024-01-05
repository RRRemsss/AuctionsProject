package fr.eni.auctionsProject.dal;

import fr.eni.auctionsProject.dal.jdbc.articleDaoImpl;
import fr.eni.auctionsProject.dal.jdbc.utilisateurDaoImpl;

public class DAOFactory {
	private static utilisateurDAO daoUtilisateur;
	public static utilisateurDAO getDaoUtilisateur() {
		if(daoUtilisateur == null) {
			daoUtilisateur = new utilisateurDaoImpl();
		}
		return daoUtilisateur;
	}

	private static articleDAO daoArticle;
	public static articleDAO getDaoArticle() {
		if(daoArticle == null) {
			daoArticle = new articleDaoImpl();
		}
		return daoArticle;
	}
}
