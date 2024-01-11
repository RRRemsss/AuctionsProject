<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/consultationProfil.css">
</head>
<body>
	<section>
		<main>
			<h1>Profil</h1>
			<div class="infos">
                <div class="ligne">
                    <p>Pseudo : </p>
                    <p>${user_info.pseudo}</p>
                </div>
                <div class="ligne">
                    <p>Nom : </p>
                    <p>${user_info.nom}</p>
                </div>
                <div class="ligne">
                    <p>Prénom : </p>
                    <p>${user_info.prenom}</p>
                </div>
                <div class="ligne">
                    <p>Email : </p>
                    <p>${user_info.email}</p>
                </div>
                <div class="ligne">
                    <p>Téléphone : </p>
                    <p>${user_info.telephone}</p>
                </div>
                <div class="ligne">
                    <p>Rue : </p>
                    <p>${user_info.rue}</p>
                </div>
                <div class="ligne">
                    <p>Code postal : </p>
                    <p>${user_info.codePostal}</p>
                </div>
                <div class="ligne">
                    <p>Ville : </p>
                    <p>${user_info.ville}</p>
                </div>
            </div>
            <c:if test="${!empty user && sessionScope.user.getPseudo() == user_info.pseudo }">
				<a href='<c:url value="/ModificationProfilServlet"/>'>Modifier</a>  
            </c:if>
		</main>
	</section>
</body>
</html>