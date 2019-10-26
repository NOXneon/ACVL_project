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
	var containers = document.querySelectorAll("div[class=container]");
	var uls = document.querySelectorAll("ul");
	for (var i = 0; i < uls.length; i++) {
		uls[i].style.display = "none";
	}
	for (var i = 0; i < containers.length; i++) {
		containers[i].style.display = "none";
	}
	var params = new URLSearchParams(location.search);
	if (params.get('user') == "admin") {
		loadDataAdmin();
	} else if (params.get('user') == 'utilisateur') {
		loadDataUser();
	} else {
		loadDataRespo();
	}
}

function loadDataAdmin() {
	document.getElementById("menuAdmin").style.display="block";
	document.getElementById("showsAdmin").style.display="block";
	document.getElementById("clientsAdmin").style.display="block";
	document.getElementById("repsAdmin").style.display="block";
	displayShows();
	displayClients();
	displayReps();
}
// function to add a show
function addShow() {
	var table = document.getElementById("spectaclesTable");
	table.style.display = "block";
	var row = table.insertRow(-1);
	var del = row.insertCell(-1);
	del.innerHTML = '<input type = "checkbox">';
	var name = row.insertCell(-1);
	name.innerHTML = '<input type = "text" id = "showName'+row.indexRow+'">';
	
}

//function to save a show
function saveShow() {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById("spectaclesTable");
	for (var i = 1; i < table.rows.length; i++) {
		if (table.rows[i].cells[1].firstChild.value != undefined) {
			spectacles.push(table.rows[i].cells[1].firstChild.value);
		}
	}
	localStorage.setItem('spectacles', JSON.stringify(spectacles));
}

function displayShows() {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById("spectaclesTable");
	if (table.rows.length <= 1) {
		table.style.display = "none";
	}
	for (var i = 0; i < spectacles.length; i++) {
		var row = table.insertRow(-1);
		var del = row.insertCell(-1);
		del.innerHTML = '<input type = "checkbox">';
		var name = row.insertCell(-1);
		name.innerHTML = spectacles[i];
	}
}

function displayClients() {
	var users = JSON.parse(localStorage.getItem('users'));
	var table = document.getElementById("clientsTable");
	if (table.rows.length <= 1) {
		table.style.display = "none";
	}
	for (var i = 0; i < users.length; i++) {
		var user = users[i];
		var row = table.insertRow(-1);
		var del = row.insertCell(-1);
		del.innerHTML = '<input type = "checkbox">';
		var name = row.insertCell(-1);
//		name.innerHTML = spectacles[i];
		//finish this
	}
}

function delShow() {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById("spectaclesTable");
	for (var i = table.rows.length-1; i > 0; i--) {
		console.log(table.rows.length);
		if (table.rows[i].cells[0].firstChild.checked) {
			delete spectacles[i-1];
		}
	}
	spectacles = spectacles.filter(el => el != null);
	localStorage.setItem('spectacles', JSON.stringify(spectacles));
	location.reload();
}
 