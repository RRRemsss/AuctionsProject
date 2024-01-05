<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<section>
		<main>

			<form action="" method="POST">
				<div class="input">
					<label for="username">Identifiant :</label> <input type="text"
						name="username" id="username">
				</div>
				<div class="input">
					<label for="password">Mot de passe :</label> <input
						type="password" name="password" id="password">
				</div>
				<div class="buttons">
					<button type="submit">Connexion</button>
					<input type="checkbox" name="rememberme" id="rememberme"> <label
						for="rememberme">Se souvenir de moi</label>
				</div>
				<div class="forgot">
					<a href="">Mot de passe oublié ?</a>
				</div>
				<div class="input">
					<a href="<%=request.getContextPath()%>">Créer un compte</a>
					<!-- Lien vers création compte -->
				</div>

			</form>
		</main>
	</section>
</body>
</html>