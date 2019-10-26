<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script src="ressources/home.js"></script>
<link rel="stylesheet" type="text/css" href="ressources/style.css">
<title>Théâtre SAW - Accueil</title>
</head>
<body onLoad = "loadData()">
	<div class="header">
		<h1>Théâtre SAW</h1>
	</div>
<ul id = "menuAdmin">
  <li><a href="#home_admin">Spectacles</a></li>
  <li><a href="#clients_admin">Liste clients</a></li>
  <li><a href="#reps_admin">Représentations</a></li>
</ul>
<ul id = "menuRespo">
  <li><a href="#home_admin">Spectacles</a></li>
  <li><a  href="#clients_respo">Liste clients</a></li>
  <li><a href="#reps_admin">Représentations</a></li>
  <li><a href="#stats">Statistiques</a></li>
</ul>
<ul id = "menuClient">
  <li><a href="#home_client">Spectacles</a></li>
  <li><a href="#reps_client">Représentations</a></li>
</ul>
<h2>Liste des spectacles</h2>
<div class="container" style="background-color: #f1f1f1" id="showsAdmin">
	<button type="button" class="cancelbtn" onClick="addShow()">Ajouter spectacle</button>
	<button type="button" class="cancelbtn" onClick="delShow()">Supprimer spectacle</button>
	<button type="button" class="cancelbtn" onClick="saveShow()">Sauvegarder spectacle</button>
	<table id = "spectaclesTable">
		<th>
			
		</th>
		<th>
			Nom du spectacle
		</th>
		<th>
			Nom du spectacle
		</th>
	</table>
</div>
<h2>Liste des clients</h2>
<div class="container" style="background-color: #f1f1f1" id="clientsAdmin">
	<table id = "clientsTable">
		<th>
			
		</th>
		<th>
			Nom client
		</th>
		<th>
			Prénom client
		</th>
		<th>
			Nom d'utilisateur client
		</th>
		<th>
			Adresse mail client
		</th>
		<th>
			Téléphone client
		</th>
	</table>
</div>
<h2>Liste des Représentations</h2>
<div class="container" style="background-color: #f1f1f1" id="repsAdmin">
	<table id = "repsTable">
		<th>
			
		</th>
		<th>
			Nom représentation
		</th>
		<th>
			Date représentation
		</th>
		<th>
			Durée représentation
		</th>
	</table>
</div>
</body>
</html>