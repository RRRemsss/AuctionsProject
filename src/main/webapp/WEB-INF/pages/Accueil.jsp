<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test</h1>
	<div>
        <c:choose>
            <c:when test="${!empty user}">
                <p>${user}</p>
                <a href="<c:url value="/ConsultationProfilServlet?pseudo=${user.getPseudo() }" />">Mon profil</a>
               	<a href="<c:url value="/VenteServlet" />">Vendre un article</a>
                <a href="<c:url value="/DeconnexionServlet" />">Déconnexion</a>
            </c:when>
            <c:otherwise>
                <p>Connectez-vous pour accéder à cette fonctionnalité.</p>
                <a href="<c:url value="/LoginServlet" />">Login</a>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html> 