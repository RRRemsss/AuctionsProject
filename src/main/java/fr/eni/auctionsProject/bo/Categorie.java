package fr.eni.auctionsProject.bo;

public class Categorie {

	private int noCategorie;
	private String libelle;
	/**
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	/**
	 * 
	 */
	public Categorie() {
	}

	/**
	 * @param libelle
	 */
	public Categorie(String libelle) {
		this.libelle = libelle;
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}
	
	
}
