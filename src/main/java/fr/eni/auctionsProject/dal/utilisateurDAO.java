package fr.eni.auctionsProject.dal;

import fr.eni.auctionsProject.bo.Utilisateur;

public interface utilisateurDAO {
	
	//CRUD

	public Utilisateur selectById(int noUtilisateur);

	public void update(Utilisateur utilisateur);

	public Utilisateur insert(Utilisateur utilisateur);

	public void delete(int noUtilisateur);
	
	public Utilisateur selectByPseudo(String pseudo);
	
	public void updatePassword(Utilisateur utilisateur);
}
