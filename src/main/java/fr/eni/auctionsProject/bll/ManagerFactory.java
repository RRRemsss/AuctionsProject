package fr.eni.auctionsProject.bll;

public class ManagerFactory {
	
	public static UtilisateurManager getUtilisateurManager() {
		return new UtilisateurManager();
	}
	
	public static ArticleManager getArticleManager() {
		return new ArticleManager();
	
	}
}
