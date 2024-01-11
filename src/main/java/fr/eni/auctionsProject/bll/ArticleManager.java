package fr.eni.auctionsProject.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.auctionsProject.bo.Article;
import fr.eni.auctionsProject.bo.Enchere;
import fr.eni.auctionsProject.bo.Retrait;
import fr.eni.auctionsProject.bo.Utilisateur;
import fr.eni.auctionsProject.dal.DAOFactory;
import fr.eni.auctionsProject.dal.articleDAO;
import fr.eni.auctionsProject.dal.enchereDAO;
import fr.eni.auctionsProject.dal.retraitDAO;
import fr.eni.auctionsProject.dal.utilisateurDAO;
import fr.eni.auctionsProject.exceptions.BusinessException;


public class ArticleManager {

	public void createArticle(Article article, Retrait retrait) throws BusinessException {
		
		//gestion des erreurs
		
		BusinessException businessException = new BusinessException();
		if (article.getNomArticle() == null || article.getNomArticle().isEmpty()) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_NOM_OBLIGATOIRE);
		}
		if (article.getDescription() == null || article.getDescription().isEmpty()) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_DESCRIPTION_OBLIGATOIRE);
		}
		if (article.getNoCategorie() == 0 ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_CATEGORIE_OBLIGATOIRE);
		}
		if (article.getPrixInitial() == 0 ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_PRIX_INITIAL_OBLIGATOIRE);	
		}
		//Gestion des erreurs de Date Debut
		if (article.getDateDebut() == null ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_DATE_DEBUT_OBLIGATOIRE);		
		}
		else if (article.getDateDebut().isBefore(LocalDate.now()) ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_DATE_DEBUT_AVANT_AJD);		
		}
		else if (article.getDateDebut().isAfter(article.getDateFin()) ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_DATE_DEBUT_APRES_DATE_FIN);		
		}
		
		//Gestion des erreurs de Date Fin 
		if (article.getDateFin() == null ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_DATE_FIN_OBLIGATOIRE);
		}
		else if (article.getDateFin().isBefore(article.getDateDebut())  ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_DATE_FIN_AVANT_DEBUT);
		}
		else if (article.getDateFin().isBefore(LocalDate.now())  ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_DATE_FIN_AVANT_AJD);
		}
		else if (article.getDateFin().isEqual(article.getDateDebut())  ) {
			businessException.ajouterErreur(CodesResultatBLL.ARTICLE_DATE_EGALS);
		}
		
		if (retrait.getRue() == null || retrait.getRue().isEmpty()) {
			businessException.ajouterErreur(CodesResultatBLL.RETRAIT_RUE_OBLIGATOIRE);
		}
		if (retrait.getCodePostal() == null || retrait.getCodePostal().isEmpty()) {
			businessException.ajouterErreur(CodesResultatBLL.RETRAIT_CP_OBLIGATOIRE);
		}
		if (retrait.getVille() == null || retrait.getVille().isEmpty()) {
			businessException.ajouterErreur(CodesResultatBLL.RETRAIT_VILLE_OBLIGATOIRE);

		}
		
		
		
		// Throw erreur si la liste des erreurs n'est pas vide
				if (businessException.hasErreurs()) {
					throw businessException;
				} 
		articleDAO daoArticle = DAOFactory.getDaoArticle();
		article = daoArticle.insert(article);

		retraitDAO daoRetrait = DAOFactory.getDaoRetrait();
		retrait.setNoArticle(article.getNoArticle());
		daoRetrait.insert(retrait);

		
	}

	public Article selectByArticle(int noArticle) {
		articleDAO daoArticle = DAOFactory.getDaoArticle();
		Article article = daoArticle.selectById(noArticle);

		retraitDAO daoRetrait = DAOFactory.getDaoRetrait();
		Retrait retrait = daoRetrait.selectByIdRetrait(noArticle);

		article.setRetrait(retrait);

		utilisateurDAO daoUtilisateur = DAOFactory.getDaoUtilisateur();
		Utilisateur utilisateur = daoUtilisateur.selectById(article.getNoUtilisateur());

		article.setUtilisateur(utilisateur);

		return article;
	}

	public void insertEnchere(Enchere enchere, int noArticle) throws BusinessException {
		
		// récupération de l'article
		articleDAO daoArticle = DAOFactory.getDaoArticle();
		Article article = daoArticle.selectById(noArticle);
		enchere.setArticle(article);

		//Gestion des Erreurs Enchere
				BusinessException businessException = new BusinessException();
				if (enchere.getMontantEnchere() <= article.getPrixVente() ) {
					businessException.ajouterErreur(CodesResultatBLL.ENCHERE_INF_PRIX_VENTE);
				}
				
				
				// Throw erreur si la liste des erreurs n'est pas vide
				if (businessException.hasErreurs()) {
					throw businessException;
				} 
		
		// récupération de la meilleure enchère
		enchereDAO daoEnchere = DAOFactory.getDaoEnchere();
		List<Enchere> encheres = daoEnchere.selectAllEnchereByArticle(noArticle);
		Enchere enchereRecente = new Enchere();
		if(encheres.size()>0) {
			for (Enchere enc : encheres) {
				if (enc.getMontantEnchere() > enchereRecente.getMontantEnchere()) {
					enchereRecente = enc;
				}
			}
		}
		
		//Recréditer l'ancien enchérisseur
		utilisateurDAO daoUtilisateur = DAOFactory.getDaoUtilisateur();
		int noEncherisseurPerdant = 0;
		if(enchereRecente.getUtilisateur() != null) {
			noEncherisseurPerdant = enchereRecente.getUtilisateur().getNoUtilisateur();
			Utilisateur utilisateurPerdant = daoUtilisateur.selectById(noEncherisseurPerdant);
			utilisateurPerdant.setCredit(utilisateurPerdant.getCredit()+enchereRecente.getMontantEnchere());
			daoUtilisateur.updateCredit(utilisateurPerdant);
		}

		// récupération de l'encherisseur
		Utilisateur utilisateur = enchere.getUtilisateur();
		
		// Gestion des Erreurs de Crédits
		if (utilisateur.getCredit() - enchere.getMontantEnchere() < 0 ) {
			businessException.ajouterErreur(CodesResultatBLL.ENCHERE_CREDIT_INSUFFISANT);
		}
		if (noEncherisseurPerdant == utilisateur.getNoUtilisateur() ) {
			businessException.ajouterErreur(CodesResultatBLL.MEME_ENCHERISSEUR);
		}
		
		
		// Throw erreur si la liste des erreurs n'est pas vide
		if (businessException.hasErreurs()) {
			throw businessException;
		} 

		// Mise à jour des crédits
		utilisateur.setCredit(utilisateur.getCredit() - enchere.getMontantEnchere());
		daoUtilisateur.updateCredit(enchere.getUtilisateur());

		// Ajout de l'enchere
		daoEnchere.insertEnchere(enchere);

		// mise à jour du prix de l'article
		article.setPrixVente(enchere.getMontantEnchere());
		daoArticle.updatePrixVente(article);

	}

	public List<Article> getArticleListe() {
		List<Article> articles = new ArrayList<Article>();
		articles = DAOFactory.getDaoArticle().selectAll();
		utilisateurDAO userDao = DAOFactory.getDaoUtilisateur();
		for (Article article : articles) {
			article.setUtilisateur(userDao.selectById(article.getNoUtilisateur()));
		}
		return articles;

	}

	public List<Article> FiltrerVente(Utilisateur utilisateur, boolean venteCours, boolean venteNonDebutee,
			boolean venteTerminee) {
		articleDAO DaoArticles = DAOFactory.getDaoArticle();
		List<Article> articles = getArticleListe();
		List<Article> articlesFiltres = new ArrayList<Article>();

		if (venteCours) {
			for (Article article : articles) {
				if (article.getDateDebut().isBefore(LocalDate.now()) && LocalDate.now().isBefore(article.getDateFin())
						&& article.getNoUtilisateur() == utilisateur.getNoUtilisateur()) {
					articlesFiltres.add(article);
				}
			}
		}

		if (venteNonDebutee) {
			for (Article article : articles) {
				if (LocalDate.now().isBefore(article.getDateDebut())
						&& article.getNoUtilisateur() == utilisateur.getNoUtilisateur()) {
					articlesFiltres.add(article);
				}
			}
		}

		if (venteTerminee) {
			for (Article article : articles) {
				if ((LocalDate.now().isEqual(article.getDateFin()) || LocalDate.now().isAfter(article.getDateFin()))
						&& article.getNoUtilisateur() == utilisateur.getNoUtilisateur()) {
					articlesFiltres.add(article);
				}
			}
		}

		return articlesFiltres;
	}

}
