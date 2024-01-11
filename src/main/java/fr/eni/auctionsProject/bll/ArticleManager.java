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

public class ArticleManager {

	public void createArticle(Article article, Retrait retrait) {
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

	public void insertEnchere(Enchere enchere, int noArticle) {

		// récupération de l'article
		articleDAO daoArticle = DAOFactory.getDaoArticle();
		Article article = daoArticle.selectById(noArticle);
		enchere.setArticle(article);

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
		if(enchereRecente.getUtilisateur() != null) {
			int noEncherisseurPerdant = enchereRecente.getUtilisateur().getNoUtilisateur();
			Utilisateur utilisateurPerdant = daoUtilisateur.selectById(noEncherisseurPerdant);
			utilisateurPerdant.setCredit(utilisateurPerdant.getCredit()+enchereRecente.getMontantEnchere());
			daoUtilisateur.updateCredit(utilisateurPerdant);
		}

		// récupération de l'encherisseur
		Utilisateur utilisateur = enchere.getUtilisateur();

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
