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
<ul id = "menuRespoAdmin">
  <li><a class="active" href="#home">Spectacles</a></li>
  <li><a href="#news">Liste clients</a></li>
  <li><a href="#contact">Représentations</a></li>
  <li><a href="#about">Statistiques</a></li>
</ul>
<ul id = "menuClient">
  <li><a class="active" href="#home">Spectacles</a></li>
  <li><a href="#contact">Représentations</a></li>
</ul>

<div class="container" style="background-color: #f1f1f1">
	<button type="button" class="cancelbtn" onClick="addShow()">Ajouter spectacle</button>
	<button type="button" class="cancelbtn" onClick="delShow()">Supprimer spectacle</button>
	<button type="button" class="cancelbtn" onClick="saveShow()">Sauvegarder spectacle</button>
	<table id = "spectaclesTable">
		<th>
			
		</th>
		<th>
			Nom du spectacle
		</th>
	</table>
</div>
</body>
</html>