function Connexion() {
	window.location="/Theater";
}
function loadData() {
	//passer liste des clients au controleur
	document.getElementById("clientsList").value = localStorage.getItem('users');
}
function signUp() {
	var users = JSON.parse(localStorage.getItem('users'));
	var name = document.getElementById('nom').value;
	var surname = document.getElementById('prénom').value;
	var username = document.getElementById('login').value;
	var password = document.getElementById('mdp').value;
	var mail = document.getElementById('mail').value;
	var phone = document.getElementById('tel').value;
	
	if (!checkMail(mail)) {
		alert("Adresse mail non conforme");
	} else if (!checkPhone(phone)) {
		alert("Numéro de téléphone non conforme");
	} else {
		document.getElementById("registerForm").submit();
		if (document.getElementById("addingClient") == "The client already exists") {
			alert("Le compte existe déjà");
		} else {
			users.push({
			'nom' : name,
			'prénom' : surname,
			'login' : username,
			'mdp' : password,
			'mail' : mail,
			'tel' : phone
		});
		alert("Nouvel utilisateur créé");
		localStorage.setItem('users', JSON.stringify(users));
		}
	}
}

function checkMail(user_mail) {
	 return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(user_mail);
}

function checkPhone(user_phone) {
	return !isNaN(user_phone)
	&& user_phone.length == 10 
		&& user_phone.charAt(0) == '0';
}