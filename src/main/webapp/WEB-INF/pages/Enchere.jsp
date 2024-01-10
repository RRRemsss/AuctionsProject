<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail vente</title>
</head>
<body>
	<section>
		<main>
			<div>
				<img alt="photo-article" src="#">
			</div>
			<h1>Détail Vente</h1>
			<div>
				<p>${article_info.getNomArticle()}</p>
			</div>
			<div>
				<h3>Description :</h3>
				<p>${article_info.getDescription()}</p>
			</div>
			<div>
				<h3>Meilleure offre :</h3>
				<p>${article_info.getPrixVente()}</p>
			</div>
			<div>
				<h3>Mise à prix :</h3>
				<p>${article_info.getPrixInitial()}</p>
			</div>
			<div>
				<h3>Fin de l'enchère :</h3>
				<p>${article_info.getDateFin()}</p>
			</div>
			<div>
				<h3>Retrait :</h3>
				<p>${article_info.getRetrait().getRue()}</p>
				<p>${article_info.getRetrait().getCodePostal()}</p>
				<p>${article_info.getRetrait().getVille()}</p>
				
			</div>
			<div>
				<h3>Vendeur :</h3>
				<p>${article_info.getUtilisateur().getPseudo()}</p>
			</div>
			<div>
				<h3>Ma proposition :</h3>
				<form method="POST">
					<label for="tentacles">mise à prix:</label> <input type="number"
						id="tentacles" name="MiseAPrix" min="${article_info.getPrixVente()}+1" max="100000" value="0" />
					<button type="submit">Enchérir</button>
				</form>
			</div>
		</main>
	</section>
</body>
</html>