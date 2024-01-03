<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main>
		
		<form action="" method="POST">
			<div>
				<label for="username" >Identifiant :</label>
				<input type="text" name="username" id="username">
			</div>
			<div>
				<label for="password" >Mot de passe :</label>
				<input type="password" name="password" id="password">
			</div>
			<div>
				<button type="submit">Connexion</button>
				<input type="checkbox" name="rememberme" id="rememberme">
	            <label for="rememberme">Se souvenir de moi</label>
			</div>
			<div>
				<a href="">Mot de passe oublié</a>
			</div>
			<div>
				<a href="<%= request.getContextPath() %>">Créer un compte</a> <!-- Lien vers création compte -->
			</div>
			
		</form>
	</main>

</body>
</html>