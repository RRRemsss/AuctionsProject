<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.auctionsProject.exceptions.LecteurMessage"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail vente</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/Enchere.css">
</head>
<body>
	<section>
		<main>
			<h1>Détail Vente</h1>
			<c:if test="${!empty requestScope.listeErreurs}">
				<div class="erreurs">
					<ul>
						<c:forEach var="codeErreur" items="${requestScope.listeErreurs}">
							<li>${LecteurMessage.getMessageErreur(codeErreur)}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<div class="info">
				<div class="ligne">
				<h3>Nom :</h3>
					<p>${article_info.getNomArticle()}</p>
				</div>
				<div class="ligne">
					<h3>Description :</h3>
					<p>${article_info.getDescription()}</p>
				</div>
				<div class="ligne">
					<h3>Meilleure offre :</h3>
					<p>${article_info.getPrixVente()}</p>
				</div>
				<div class="ligne">
					<h3>Mise à prix :</h3>
					<p>${article_info.getPrixInitial()}</p>
				</div>
				<div class="ligne">
					<h3>Fin de l'enchère :</h3>
					<p>${article_info.getDateFin()}</p>
				</div>
				<div class="retrait">
					<h3>Retrait :</h3>
					<p>${article_info.getRetrait().getRue()}</p>
					<p>${article_info.getRetrait().getCodePostal()}</p>
					<p>${article_info.getRetrait().getVille()}</p>

				</div>
				<div class="ligne">
					<h3>Vendeur :</h3>
					<p>${article_info.getUtilisateur().getPseudo()}</p>
				</div>
				<c:if
					test="${LocalDate.now().isBefore(article_info.getDateDebut()) || LocalDate.now().isEqual(article_info.getDateDebut())}">
					<div class="proposition">
						<h3>Ma proposition :</h3>
						<form method="POST">
							<input type="number"
								id="tentacles" name="MiseAPrix"
								min="${article_info.getPrixVente()}+1" max="100000" value="0" />
							<button type="submit">Enchérir</button>
						</form>
					</div>
				</c:if>
			</div>
		</main>
	</section>
</body>
</html>