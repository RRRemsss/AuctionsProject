<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/Accueil.css">
</head>
<script>
	// Fonction pour désactiver ou activer les cases à cocher en fonction du bouton radio sélectionné
	function gererCheckbox() {
		let btnAchat = document.getElementById("buy");
		let btnVente = document.getElementById("sell");
		
		let checkEnchereOuverte = document.getElementById("enchereOuverte");
		let checkMesEncheres = document.getElementById("mesEncheres");
		let checkEnchereGagnee = document.getElementById("enchereGagnee");
		
		let checkVenteCours = document.getElementById("venteCours");
		let checkVenteNonDebutee = document.getElementById("venteNonDebutee");
		let checkVenteTerminee = document.getElementById("venteTerminee");
		
		if(btnAchat.checked){
			checkVenteCours.disabled = true;
			checkVenteCours.checked = false;
			checkVenteNonDebutee.disabled = true;
			checkVenteNonDebutee.checked = false;
			checkVenteTerminee.disabled = true;
			checkVenteTerminee.checked = false;
			
			checkEnchereOuverte.disabled = false;
			checkMesEncheres.disabled = false;
			checkEnchereGagnee.disabled = false;
		}
		if(btnVente.checked){
			checkEnchereOuverte.disabled = true;
			checkEnchereOuverte.checked = false;
			checkMesEncheres.disabled = true;
			checkMesEncheres.checked = false;
			checkEnchereGagnee.disabled = true;
			checkEnchereGagnee.checked = false;
			
			checkVenteCours.disabled = false;
			checkVenteNonDebutee.disabled = false;
			checkVenteTerminee.disabled = false;
		}
	}
</script>
<body>
	<section>
		<header>
			<c:choose>
				<c:when test="${!empty user}">
					<a
						href="<c:url value="/ConsultationProfilServlet?pseudo=${user.getPseudo() }" />">Mon
						profil</a>
					<a href="<c:url value="/VenteServlet" />">Vendre un article</a>
					<a href="<c:url value="/DeconnexionServlet" />">Déconnexion</a>
				</c:when>
				<c:otherwise>
					<a href="<c:url value="/LoginServlet" />">S'incrire - se
						connecter</a>
				</c:otherwise>
			</c:choose>
		</header>
		<main>
			<h1>Liste des enchères</h1>

			<div class="Form">
				<h2>Filtres :</h2>
				<form method="POST">
					<input type="text" name="SearchFilter"
						placeholder="Le nom de l'article contient" />
					<c:if test="${!empty user}">
						<div class="buy-Sell">
							<fieldset>
								<legend>Achats</legend>
								<input type="radio" name="deal" id="buy"
									onChange=gererCheckbox()> <label for="buy">Achats</label>
								<input type="checkbox" name="enchereOuverte" id="enchereOuverte"
									disabled> <label for="enchereOuverte">Enchères
									ouvertes</label> <input type="checkbox" name="mesEncheres"
									id="mesEncheres" disabled> <label for="mesEncheres">Mes
									enchères</label> <input type="checkbox" name="enchereGagnee"
									id="enchereGagnee" disabled> <label for="enchereGagnee">Mes
									enchères remportées</label>
							</fieldset>

							<fieldset>
								<legend>Mes ventes</legend>
								<input type="radio" name="deal" id="sell"
									onChange=gererCheckbox() checked> <label for="sell">Mes
									ventes</label> <input type="checkbox" name="venteCours" id="venteCours">
								<label for="venteCours">Mes ventes en cours</label> <input
									type="checkbox" name="venteNonDebutee" id="venteNonDebutee">
								<label for="venteNonDebutee">Ventes non débutées</label> <input
									type="checkbox" name="venteTerminee" id="venteTerminee">
								<label for="venteTerminee">Ventes terminées</label>
							</fieldset>
						</div>
					</c:if>
					<button type="submit" class="rechercher">Rechercher</button>
				</form>
			</div>

			<div class="articles">

				<c:choose>
					<c:when test="${!empty ListeArticles}">
						<!-- Liste d'articles-->
						<c:forEach var="article" items="${ListeArticles}">
							<!-- Affichez les détails de chaque article -->
							<article>	
								<c:choose>
									<c:when test="${!empty user}">
										<a href="<c:url value="/EnchereServlet?id=${article.getNoArticle()}"/>">${article.getNomArticle()}</a>
									</c:when>
									<c:otherwise>
										<p>${article.getNomArticle()}</p>
									</c:otherwise>
								</c:choose>
								<p>Prix : ${article.getPrixInitial()}</p>
								<p>Fin de l'enchère : ${article.getDateFin()}</p>
								<p>Début de l'enchère : ${article.getDateDebut()}</p>
								<!-- À retirer -->
								<p>Vendeur : ${article.getUtilisateur().getPseudo()}</p>
							</article>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p>Aucun article disponible.</p>
					</c:otherwise>
				</c:choose>


			</div>
		</main>
	</section>
</body>
</html>
