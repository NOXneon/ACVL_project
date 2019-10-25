<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="ressources/style.css">
<title>Théâtre SAW - Accueil</title>
</head>
<body>
	<div class="header">
		<h1>Théâtre SAW</h1>
	</div>
	<h2>Connection</h2>

	<form action="LoginServlet" method="post">

		<div class="container">
			<label><b>Nom d'utilisateur</b></label>
			<input type="text" name="uname" required>
			<label ><b>Mot de passe</b></label>
			<input type="password" name="psw" required>

			<button type="submit">Se connecter en tant que</button>
			<div>
				<label> <input type="radio" checked="checked"
					name="utilisateur"> Utilisateur
				</label> <label> <input type="radio" name="respProg"> Resp.
					Prog.
				</label> <label> <input type="radio" name="admin"> Admin
				</label>
			</div>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Inscription</button>
		</div>
	</form>
</body>
</html>