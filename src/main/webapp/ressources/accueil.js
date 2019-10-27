// sets the username and password of the admin and resp prog
function loadData() {
	if (window.localStorage) {
		//add reps and clients
		var spectacles = localStorage.getItem('spectacles');
		var spectaclesTable = [];
		if (spectacles == null) {
			localStorage.setItem('spectacles', JSON.stringify(spectaclesTable));
		}
	} else {
		alert("db not working");
	}
	//passer liste des spectacles au controleur
	document.getElementById("showsList").value = localStorage.getItem('spectacles');
	var containers = document.querySelectorAll("div[class=container]");
	var uls = document.querySelectorAll("ul");
	for (var i = 0; i < uls.length; i++) {
		uls[i].style.display = "none";
	}
	for (var i = 0; i < containers.length; i++) {
		containers[i].style.display = "none";
	}
	loadDataUser();
}
function disconnect() {
	window.location="/Theater";
}
function loadDataUser() {
	document.getElementById("menuClient").style.display="block";
	document.getElementById("showsClient").style.display="block";
	document.getElementById("repsClient").style.display="block";
	displayShows("spectaclesTableClient");
	displayReps("repsTableClient");
}

function displayShows(idTable) {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById(idTable);
	table.style.display="block";
	if (table.rows.length == 0) {
		table.style.display = "none";
	}
	for (var i = 0; i < spectacles.length; i++) {
		var row = table.insertRow(-1);
		if (table.rows[0].cells.length == 2) {
			var del = row.insertCell(-1);
			del.innerHTML = '<input type = "checkbox">';
		}
		var name = row.insertCell(-1);
		name.innerHTML = spectacles[i].nom;
	}
}

function displayReps(idTable) {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById(idTable);
	table.style.display="block";
	if (table.rows.length == 0) {
		table.style.display = "none";
	}
	for (var i = 0; i < spectacles.length; i++) {
		var reps = spectacles[i].representations;
		for (var j = 0; j < reps.length; j++) {
			var row = table.insertRow(-1);
			if (table.rows[0].cells.length == 4) {
				var del = row.insertCell(-1);
				del.innerHTML = '<input type = "checkbox">';
			}
			var showName = row.insertCell(-1);
			showName.innerHTML = spectacles[i].nom;
			var repDate = row.insertCell(-1);
			repDate.innerHTML = reps.date;
			var repDuration = row.insertCell(-1);
			repDuration.innerHTML = reps.duree;
		}
	}
}
 