<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.auctionsProject.exceptions.LecteurMessage" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
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
			<h1>Connexion</h1>
			<c:if test="${!empty requestScope.listeErreurs}">
				<div class="erreurs">
					<ul>
						<c:forEach var="codeErreur" items="${requestScope.listeErreurs}">
							<li>${LecteurMessage.getMessageErreur(codeErreur)}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<form  method="POST">
				<div class="input">
					<label for="username">Identifiant :</label> <input type="text"
						name="username" id="username" >
				</div>
				<div class="input">
					<label for="password">Mot de passe :</label> <input
						type="password" name="password" id="password" >
				</div>
				<div class="input-checkbox">
					<input type="checkbox" name="rememberme" id="rememberme"> <label
						for="rememberme">Se souvenir de moi</label>
				</div>
				<div class="buttons">
					<button type="submit" class="connexion">Connexion</button>
					<a href="<c:url value="/CreationCompte" />" class="creation">Créer un compte</a>
				</div>
			</form>
			<a href="">Mot de passe oublié ?</a>
		</main>
	</section>
</body>
</html>