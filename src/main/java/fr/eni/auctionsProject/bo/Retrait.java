package fr.eni.auctionsProject.bo;

public class Retrait {

	private int noArticle;
	private String rue;
	private String codePostal;
	private String ville;
	private int idRetrait;
	/**
	 * @param noArticle
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param idRetrait
	 */
	public Retrait(int noArticle, String rue, String codePostal, String ville, int idRetrait) {
		this.noArticle = noArticle;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idRetrait = idRetrait;
	}
	/**
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param idRetrait
	 */
	public Retrait(String rue, String codePostal, String ville, int idRetrait) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idRetrait = idRetrait;
	}
	/**
	 * 
	 */
	public Retrait() {
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
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the idRetrait
	 */
	public int getIdRetrait() {
		return idRetrait;
	}
	/**
	 * @param idRetrait the idRetrait to set
	 */
	public void setIdRetrait(int idRetrait) {
		this.idRetrait = idRetrait;
	}
	
	
	@Override
	public String toString() {
		return "Retrait [noArticle=" + noArticle + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", idRetrait=" + idRetrait + "]";
	}
	

}
