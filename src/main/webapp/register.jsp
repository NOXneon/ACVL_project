<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="ressources/style.css">
<title>Théâtre SAW - Inscription</title>
</head>
<body>
<div class="header">
		<h1>Théâtre SAW</h1>
	</div>
	<h2>Inscription</h2>

	<form action="RegisterServlet" method="post">

		<div class="container">
			<label><b>Nom</b></label> 
			<input type="text" name="name" required> 
			<label ><b>Prénom</b></label> 
			<input	type="text" name="surname" required>
			<label ><b>Nom d'utilisateur</b></label>
			<input type="text" name="uname" required>
			<label ><b>Mot de passe</b></label>
			<input type="password" name="psw" required>
			<label ><b>Adresse mail</b></label>
			<input type="text" name="mail" required>
			<label ><b>Téléphone</b></label>
			<input type="text" name="number" required>

			<button type="submit">S'inscrire en tant que</button>
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
			<button type="button" class="cancelbtn">Connection</button>
		</div>
	</form>
</body>
</html>