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
	<div>
		<img alt="photo-article" src="#">
	</div>
	<h1>Détail Vente</h1>
	<div>
		<p>PC Gamer Pour Travailler</p>
	</div>
	<div>
		<h3>Description :</h3>
		<p>DRFGHJGHJKLFGVHJK</p>
	</div>
	<div>
		<h3>catégorie :</h3>
		<p>informatique</p>
	</div>
	<div>
		<h3>Meilleure offre :</h3>
		<p>210 pts par Bob</p>
	</div>
	<div>
		<h3>Mise à prix :</h3>
		<p>185 points</p>
	</div>
	<div>
		<h3>Fin de l'enchère :</h3>
		<p>date</p>
	</div>
	<div>
		<h3>Retrait :</h3>
		<p>10 allée des alouettes , 44800 Saint Herblain</p>
	</div>
	<div>
		<h3>Vendeur :</h3>
		<p>Jojo44</p>
	</div>
	<div>
		<h3>Ma proposition :</h3>
		<form action="POST">
			<label for="tentacles">mise à prix:</label> <input type="number"
				id="tentacles" name="mise a prix" min="0" max="100000" value="0" />
			<button type="submit">Enchérir</button>
		</form>
	</div>
</body>
</html>