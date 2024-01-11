<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.auctionsProject.exceptions.LecteurMessage" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="/WEB-INF/fragments/header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer son compte</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/creationCompte.css">
</head>
<body>
	<section>
		<main>
			<h1>Créer mon compte</h1>
			<c:if test="${!empty requestScope.listeErreurs}">
				<div class="erreurs">
					<ul>
						<c:forEach var="codeErreur" items="${requestScope.listeErreurs}">
							<li>${LecteurMessage.getMessageErreur(codeErreur)}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<form action="" method="POST">
				<div class="input">
					<label for="pseudo">Pseudo :</label> <input type="text" id="pseudo"
						name="pseudo" />
				</div>
				<div class="input">
					<label for="nom">Nom :</label> <input type="text" id="nom"
						name="nom"  />
				</div>
				<div class="input">
					<label for="prenom">Prénom :</label> <input type="text" id="prenom"
						name="prenom"  />
				</div>
				<div class="input">
					<label for="email">Email :</label> <input type="email" id="email"
						name="email"  />
				</div>
				<div class="input">
					<label for="tel">Téléphone :</label> <input type="tel" id="tel"
						name="tel" />
				</div>
				<div class="input">
					<label for="rue">Rue :</label> <input type="text" id="rue"
						name="rue"  />
				</div>
				<div class="input">
					<label for="cp">Code postal :</label> <input type="text" id="cp"
						name="cp"  />
				</div>
				<div class="input">
					<label for="ville">Ville :</label> <input type="text" id="ville"
						name="ville"  />
				</div>
				<div class="input">
					<label for="password">Mot de passe :</label> <input type="password"
						id="password" name="password"  />
				</div>
				<div class="input">
					<label for="confirm">Confirmation :</label> <input type="password"
						id="confirm" name="confirm"  />
				</div>
				<div class="buttons">
					<button type="submit">Créer</button>
					<a href="<c:url value="/AccueilServlet"/>">Annuler</a>
				</div>
			</form>
		</main>
	</section>
</body>
</html>