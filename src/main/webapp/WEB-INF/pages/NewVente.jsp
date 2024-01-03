<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
</head>
<body>

	<h1>ENI-Enchères</h1>

	<h2>Nouvelle Vente</h2>
	 
	<form action="POST">
		<div>
			<img alt="image-article" src="#">

		</div>
		<div>
		<h3>Article</h3>
			<textarea rows="2" cols="50" placeholder="Article"></textarea>
		</div>
		<div>
		<h3>Description </h3>
			<textarea rows="20" cols="50" placeholder="Description"></textarea>
		</div>

		<div>
		<h3>catégorie</h3>
			<select name="categorie" id="categorie-select">
				<option value="">Toutes</option>
				<option value="Informatique">Informatique</option>
				<option value="Ameublement">Ameublement</option>
				<option value="Vêtement">Vêtement</option>
				<option value="Sport&Loisirs">Sport&Loisirs</option>

			</select>
		</div>

		<div>

			<label for="avatar">Photo de l'article:</label> <input type="file"
				id="avatar" name="photo" accept="image/png, image/jpeg" />
		</div>

		<div>
			<label for="tentacles">mise à prix:</label> <input type="number"
				id="tentacles" name="mise a prix" min="0" max="100000" value="0" />
		</div>

		<div>
			<label for="start">Début de l'enchère:</label> <input type="date"
				id="start" name="trip-start" value="2024-01-12" min="2024-01-12"
				max="2024-12-31" /> <label for="finish">Fin de l'enchère:</label> <input
				type="date" id="finish" name="trip-finish" value="2024-01-12"
				min="2024-01-12" max="2024-12-31" />
		</div>

		<div>
			<p>information de retrait</p>
		</div>


		<button type="submit">Enregistrer</button>
		<button type="submit">Annuler</button>
	</form>
</body>
</html>