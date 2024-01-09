<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
				<form>
					<input type="text" name="SearchFilter"
						placeholder="Le nom de l'article contient" />
					<button type="submit">Rechercher</button>
				</form>
			</div>
			<div class="buy-Sell">
    <fieldset>
        <legend>Achats</legend>
        <input type="radio" name="deal" id="buy"> <label for="buy">Achats</label> 
        <input type="checkbox" name="enchereOuverte" id="enchereOuverte"> <label for="enchereOuverte">Enchères ouvertes</label> 
        <input type="checkbox" name="mesEncheres" id="mesEncheres"> <label for="mesEncheres">Mes enchères</label> 
        <input type="checkbox" name="enchereGagnee" id="enchereGagnee"> <label for="enchereGagnee">Mes enchères remportées</label>
    </fieldset>

    <fieldset>
        <legend>Mes ventes</legend>
        <input type="radio" name="deal" id="sell"> <label for="sell">Mes ventes</label>
        <input type="checkbox" name="venteCours" id="venteCours"> <label for="venteCours">Mes ventes en cours</label> 
        <input type="checkbox" name="venteNonDebutee" id="venteNonDebutee"> <label for="venteNonDebutee">Ventes non débutées</label> 
        <input type="checkbox" name="venteTerminee" id="venteTerminee"> <label for="venteTerminee">Ventes terminées</label>
    </fieldset>
</div>

			</div>
			<div>

				<c:choose>
					<c:when test="${!empty ListeArticles}">
						<!-- Liste d'articles-->
						<c:forEach var="article" items="${ListeArticles}">
							<!-- Affichez les détails de chaque article -->

							<p>${article.getNomArticle()}</p>
							<p>Prix : ${article.getPrixInitial()}</p>
							<p>Fin de l'enchère : ${article.getDateFin()}</p>
							<p>Vendeur : ${article.getUtilisateur().getPseudo()}</p>
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
