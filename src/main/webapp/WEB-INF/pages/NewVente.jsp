<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/NewVente.css">

</head>
<body>
	<nav><h1>ENI-Enchères</h1></nav>
	<section>
		<main>
			<h2>Nouvelle Vente</h2>
			 
			<form  method="POST">
				<div>
					<img alt="image-article" src="#">

				</div>
				<div>
					<label for="nomArticle">Article</label>
					<input type="text" id="name" name="nomArticle" required minlength="2" maxlength="20" size="10" placeholder="Article">
					
				</div>
				<div>
					<label for="description">description</label>
					<textarea id="description" name="description"  rows="20" cols="50" placeholder="Description"></textarea>
				</div>

				<div>
				<label for="categorie">catégorie</label>
					<select name="categorie" id="categorie-select">
						<option value="">Toutes</option>
						<option value="Informatique">Informatique</option>
						<option value="Ameublement">Ameublement</option>
						<option value="Vêtement">Vêtement</option>
						<option value="Sport&Loisirs">Sport&Loisirs</option>
					</select>
					
				</div>

				<div>

					<label for="photo">Photo de l'article:</label> 
					<input type="file"
						id="avatar" name="photo" accept="image/png, image/jpeg" />
				</div>

				<div>
					<label for="prixInitial">mise à prix:</label> <input type="number"
						id="tentacles" name="prixInitial" min="0" max="100000" value="1" />
				</div>

				<div>
					<label for="dateDebut">Début de l'enchère:</label> 
						<input	type="date" id="dateDebut" name="dateDebut" value=""	min="" max="" /> 
						
					<label for="dateFin">Fin de l'enchère:</label>
						<input type="date" id="dateFin" name="dateFin" value="" min="" max="" />
				</div>

				<div>
					<fieldset>
						<label for="retrait"> Retrait</label>
							<legend>Retrait</legend> 
								
									<label for="street">Rue : </label> 
										<input type="text" id="name" name="rue" required minlength="2" maxlength="20" size="10"  value ="rue des mouettes">
										 <br>
									<label for="postCode">Codepostal : </label>
										 <input type="text" id="name" name="cp" required	minlength="2" maxlength="20" size="10" value ="44800">
										  <br>
									<label for="city">Ville : </label> 
										<input type="text" id="name"name="ville" required minlength="2" maxlength="20" size="10" value ="Saint Herblain">	
							
							
						</fieldset>
				</div>
				<div class="boutons">
				<button type="submit">Enregistrer</button>
				<a href="<%=request.getContextPath()%>/AccueilServlet ">Annuler</a>
				</div>
			</form>
		</main>
	</section>
</body>
</html>