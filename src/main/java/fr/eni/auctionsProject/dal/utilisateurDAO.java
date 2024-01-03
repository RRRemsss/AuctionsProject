package fr.eni.auctionsProject.dal;

import java.util.List;

import fr.eni.auctionsProject.bo.Utilisateur;

public interface utilisateurDAO {
	
	//CRUD

	public Utilisateur selectById(int noUtilisateur);

	public List<Utilisateur> selectAll();

	public void update(Utilisateur utilisateur);

	public void insert(Utilisateur utilisateur);

	public void delete(int noUtilisateur);
}
