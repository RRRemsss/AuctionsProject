package fr.eni.auctionsProject.bll;

public abstract class CodesResultatBLL {

	// Les codes d'erreurs IHM se situent entre 1 et 9999.

	// Création du compte Article
	public static final int ARTICLE_NOM_OBLIGATOIRE = 2001;
	public static final int ARTICLE_DESCRIPTION_OBLIGATOIRE = 2002;
	public static final int ARTICLE_CATEGORIE_OBLIGATOIRE = 2003;
	public static final int ARTICLE_PRIX_INITIAL_OBLIGATOIRE = 2004;
	public static final int RETRAIT_RUE_OBLIGATOIRE = 2005;
	public static final int RETRAIT_CP_OBLIGATOIRE = 2006;
	public static final int RETRAIT_VILLE_OBLIGATOIRE = 2007;
	public static final int  ARTICLE_DATE_DEBUT_OBLIGATOIRE = 2008;
	public static final int  ARTICLE_DATE_FIN_OBLIGATOIRE = 2009;
	public static final int  ARTICLE_DATE_FIN_AVANT_DEBUT = 2010;
	public static final int  ARTICLE_DATE_FIN_AVANT_AJD = 2011;
	public static final int  ARTICLE_DATE_DEBUT_AVANT_AJD = 2012;
	public static final int  ARTICLE_DATE_DEBUT_APRES_DATE_FIN = 2013;
	public static final int  ARTICLE_DATE_EGALS = 2014;
	
	
	// Création du compte Enchere
	public static final int  ENCHERE_INF_PRIX_VENTE = 3001;
	public static final int  ENCHERE_CREDIT_INSUFFISANT = 3002;
	public static final int  MEME_ENCHERISSEUR = 3003;
	
}
