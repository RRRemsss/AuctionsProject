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
			<h1>Consultation du profil</h1>
			<div>
				<div class="ligne">
					<p>Pseudo : </p>
					<p>TonyM</p>
				</div>
				<div class="ligne">
					<p>Nom : </p>
					<p>Mascate</p>
				</div>
				<div class="ligne">
					<p>Prénom : </p>
					<p>Tony</p>
				</div>
				<div class="ligne">
					<p>Email : </p>
					<p>tony.mascate2023@campus-eni.fr</p>
				</div>
				<div class="ligne">
					<p>Téléphone : </p>
					<p>0607048543</p>
				</div>
				<div class="ligne">
					<p>Rue : </p>
					<p>Chemin de l'ENI</p>
				</div>
				<div class="ligne">
					<p>Code postal : </p>
					<p>17000</p>
				</div>
				<div class="ligne">
					<p>Ville : </p>
					<p>Une ville</p>
				</div>
			</div>
			<a href='<c:url value="/ModificationProfilServlet"/>'>Modifier</a>
		</main>
	</section>
</body>
</html>