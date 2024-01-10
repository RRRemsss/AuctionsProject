package fr.eni.auctionsProject.dal;


import java.util.List;

import fr.eni.auctionsProject.bo.Enchere;

public interface enchereDAO {

	
	public Enchere insertEnchere(Enchere enchere);
	
	public List<Enchere> selectAllEnchereByArticle(int noArticle);
}
