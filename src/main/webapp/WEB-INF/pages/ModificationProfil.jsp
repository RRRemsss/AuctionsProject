<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification du profil</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/modificationProfil.css">
</head>
<body>
	<section>
		<main>
			<h1>Mon Profil</h1>
			<form action="" method="POST">
			<div class="inputs">
				<div class="input">
					<label for="pseudo">Pseudo :</label>
					<input type="text" id="pseudo" name="pseudo"/>
				</div>
				<div class="input">
					<label for="nom">Nom :</label>
					<input type="text" id="nom" name="nom"/>
				</div>
				<div class="input">
					<label for="prenom">Prénom : :</label>
					<input type="text" id="prenom" name="prenom"/>
				</div>
				<div class="input">
					<label for="pseudo">Email :</label>
					<input type="email" id="email" name="email"/>
				</div>
				<div class="input">
					<label for="telephone">Téléphone :</label>
					<input type="tel" id="telephone" name="telephone"/>
				</div>
				<div class="input">
					<label for="rue">Rue :</label>
					<input type="text" id="rue" name="rue"/>
				</div>
				<div class="input">
					<label for="codepostal">Code Postal :</label>
					<input type="text" id="codepostal" name="codepostal"/>
				</div>
				<div class="input">
					<label for="ville">Ville :</label>
					<input type="text" id="ville" name="ville"/>
				</div>
				<div class="input">
					<label for="actualPassword">Mot de passe actuel :</label>
					<input type="password" id="actualPassword" name="actualPassword"/>
				</div>
				<div class="input">
					<label for="newPassword">Nouveau mot de passe :</label>
					<input type="password" id="newPassword" name="newPassword"/>
				</div>
				<div class="input">
					<label for="confirmPassword">Confirmer le mot de passe :</label>
					<input type="password" id="confirmPassword" name="confirmPassword"/>
				</div>
				<div class="input">
					<h3>Crédit(s) :</h3>
					<p>640</p>
				</div>
			</div>
			<div class="boutons">
				<button type="submit">Enregistrer</button>
				<a href="">Supprimer mon compte</a>
			</div>
			</form>
			
		</main>
	</section>
</body>
</html>