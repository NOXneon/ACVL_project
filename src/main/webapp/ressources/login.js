// sets the username and password of the admin and resp prog
function loadData() {
	if (window.localStorage) {
		var adminLogin = localStorage.getItem('adminLogin');
		var respLogin = localStorage.getItem('respLogin');
		var users = localStorage.getItem('users');
		var adminTable = {'username' : 'admin', 'password' : 'root'};
		var respTable = {'username' : 'respo', 'password' : 'THEresponsable'}
		if (adminLogin == null) {
			localStorage.setItem('adminLogin', JSON.stringify(adminTable));
		}
		if (respLogin == null) {
			localStorage.setItem('respLogin', JSON.stringify(respTable));
		}
		if (users == null) {
			var usersTable = [];
			localStorage.setItem('users', JSON.stringify(usersTable));
		}
	} else {
		alert("db not working");
	}
	
}

// function that checks if user exists in db

function login() {
	var allow;
	var radiobtn = document.querySelector('input[type="radio"]:checked').value;
	if (radiobtn == null) {
		alert("Choisir mode de connexion");
	} else {
		allow = false;
		if (radiobtn == "utilisateur") {
			var users = JSON.parse(localStorage.getItem('users'));
			if (users != null) {
				for (var user in users) {
					if (users[user].username == document.getElementById('uname').value
							&& users[user].password == document.getElementById('psw').value) {
						//Allow login because user is found in db
						allow = true;
					}
				}
			}
		}
		else if (radiobtn == "respProg") {
			console.log('respo');
			if (document.getElementById('uname').value == "respo" 
				&& document.getElementById('psw').value == "THEresponsable") {
				allow = true;
			}
		} else {
			console.log('admin');
			if (document.getElementById('uname').value == "admin" 
				&& document.getElementById('psw').value == "root") {
				allow = true;
			}
		}
		allowLogin(allow);
	}
}

// function that allows login or not
function allowLogin(isAllowed) {
	if (isAllowed) {
		// who is trying to log in
		var who = document.querySelector('input[type="radio"]:checked').value;
		window.location="/Theater/home.jsp?user="+who;
	} else {
		alert("Mauvais nom d'utilisateur/Mot de passe");
	}
}

function Inscription() {
	window.location="/Theater/register.jsp";
}