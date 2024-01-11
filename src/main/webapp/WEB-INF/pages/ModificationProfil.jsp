<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.auctionsProject.exceptions.LecteurMessage"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="/WEB-INF/fragments/header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification du profil</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/modificationProfil.css">
</head>
<body>
	<section>
		<main>
			<h1>Mon Profil</h1>
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
				<div class="inputs">
					<div class="input">
						<label for="pseudo">Pseudo :</label> <input type="text"
							id="pseudo" name="pseudo" value="${sessionScope.user.getPseudo() }"/>
					</div>
					<div class="input">
						<label for="nom">Nom :</label> <input type="text" id="nom"
							name="nom" value="${sessionScope.user.getNom() }" />
					</div>
					<div class="input">
						<label for="prenom">Prénom : :</label> <input type="text"
							id="prenom" name="prenom" value="${sessionScope.user.getPrenom() }" />
					</div>
					<div class="input">
						<label for="pseudo">Email :</label> <input type="email" id="email"
							name="email" value="${sessionScope.user.getEmail() }" />
					</div>
					<div class="input">
						<label for="telephone">Téléphone :</label> <input type="tel"
							id="telephone" name="telephone" value="${sessionScope.user.getTelephone() }" />
					</div>
					<div class="input">
						<label for="rue">Rue :</label> <input type="text" id="rue"
							name="rue" value="${sessionScope.user.getRue() }" />
					</div>
					<div class="input">
						<label for="codepostal">Code Postal :</label> <input type="text"
							id="codepostal" name="codepostal" value="${sessionScope.user.getCodePostal() }" />
					</div>
					<div class="input">
						<label for="ville">Ville :</label> <input type="text" id="ville"
							name="ville" value="${sessionScope.user.getVille() }" />
					</div>
					<div class="input">
						<label for="actualPassword">Mot de passe actuel :</label> <input
							type="password" id="actualPassword" name="password" />
					</div>
					<div class="input">
						<label for="newPassword">Nouveau mot de passe :</label> <input
							type="password" id="newPassword" name="newPassword" />
					</div>
					<div class="input">
						<label for="confirmPassword">Confirmer le mot de passe :</label> <input
							type="password" id="confirmPassword" name="confirmNewPassword" />
					</div>
					<div class="input">
						<h3>Crédit(s) :</h3>
						<p>${user.getCredit() }</p>
					</div>
				</div>
				<input type="hidden" name="action" value=""/>
				<div class="boutons">
					<button type="submit">Enregistrer</button>
					<a href="<c:url value="/SuppressionProfilServlet?id=${user.getNoUtilisateur() }" />">Supprimer mon compte</a>
				</div>
			</form>

		</main>
	</section>
</body>
</html>