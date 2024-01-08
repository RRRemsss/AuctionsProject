package fr.eni.auctionsProject.dal;

import fr.eni.auctionsProject.bo.Retrait;


public interface retraitDAO {
	
	public Retrait selectByIdRetrait(int noArticle);
	
	public void insert(Retrait retrait);
}
