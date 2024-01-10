package fr.eni.auctionsProject.bo;

import java.time.LocalDate;

public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private Utilisateur utilisateur;
	private Retrait retrait;
	
	

	
	/**
	 * @param noArticle
	 * @param utilisateur
	 */
	public Article(int noArticle, Utilisateur utilisateur) {
		this.noArticle = noArticle;
		this.utilisateur = utilisateur;
	}



	
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebut
	 * @param dateFin
	 * @param prixInitial
	 * @param prixVente
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	public Article(int noArticle, String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin,
			int prixInitial, int prixVente, int noUtilisateur, int noCategorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		
	}
	
	
	/**
	 * @param nomArticle
	 * @param description
	 * @param dateDebut
	 * @param dateFin
	 * @param prixInitial
	 * @param prixVente
	 * @param noUtilisateur
	 * @param noCategorie
	 
	 */
	
	public Article(String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin, int prixInitial,
			int prixVente, int noUtilisateur, int noCategorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	
	}
	 
	public Article(String nomArticle, String description, LocalDate dateDebut, LocalDate dateFin, int prixInitial,
			int noCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.noCategorie = noCategorie;
	}



	/**
	 * 
	 */
	public Article() {
	}
	
	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}
	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}
	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * @return the prixInitial
	 */
	public int getPrixInitial() {
		return prixInitial;
	}
	/**
	 * @param prixInitial the prixInitial to set
	 */
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}
	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}
	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	/**
	 * @return the noUtilisateur
	 */
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	/**
	 * @return the noCategorie
	 */
	public int getNoCategorie() {
		return noCategorie;
	}
	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	/**
	 * @return the retrait
	 */
	public Retrait getRetrait() {
		return retrait;
	}




	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prixInitial=" + prixInitial + ", prixVente="
				+ prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie=" + noCategorie + "]";
	}
	
	
}
