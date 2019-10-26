<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script src="ressources/register.js"></script>
<link rel="stylesheet" type="text/css" href="ressources/style.css">
<title>Théâtre SAW - Inscription</title>
</head>
<body onLoad="loadData()">
	<div class="header">
		<h1>Théâtre SAW</h1>
	</div>
	<h2>Inscription</h2>

	<div class="form">
		<form action="register" method="post" id="registerForm">
			<input type="hidden" id="clientsList" name="clientsList" value="non" />
			<input type="hidden" id="addingClient" value="${addingClientMessage}" />
			<div class="container">
				<label><b>Nom</b></label> <input type="text" id="nom" name="nom"
					required> <label><b>Prénom</b></label> <input type="text"
					id="prénom" name="prénom" required> <label><b>Nom
						d'utilisateur</b></label> <input type="text" id="login" name="login" required>
				<label><b>Mot de passe</b></label> <input type="password" id="mdp"
					name="mdp" required> <label><b>Adresse mail</b></label> <input
					type="text" id="mail" name="mail" required> <label><b>Téléphone</b></label>
				<input type="text" id="tel" name="tel" required>

				<button onClick="signUp()">S'inscrire</button>
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button" class="cancelbtn" onClick="Connexion()">Connexion</button>
			</div>

		</form>
	</div>
</body>
</html>