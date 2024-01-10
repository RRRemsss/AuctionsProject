package fr.eni.auctionsProject.bo;

import java.time.LocalDate;

public class Enchere {

	private int noEnchere;
	private LocalDate dateEnchere;
	private int montantEnchere;
	
	private Article article ;
	private Utilisateur utilisateur;
	/**
	 * @param noEnchere
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param noArticle
	 * @param noUtilisateur
	 */
	public Enchere(int noEnchere, LocalDate dateEnchere, int montantEnchere) {
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		
	}
	/**
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param noArticle
	 * @param noUtilisateur
	 */
	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		
	}
	/**
	 * 
	 */
	public Enchere() {
	}
	/**
	 * @return the noEnchere
	 */
	public int getNoEnchere() {
		return noEnchere;
	}
	/**
	 * @param noEnchere the noEnchere to set
	 */
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	/**
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", article=" + article + ", utilisateur=" + utilisateur + "]";
	}
	
	
	
	
}
