function Connexion() {
	window.location="/Theater";
}

function signUp() {
	var users = [];
	var name = document.getElementById('name').value;
	var surname = document.getElementById('surname').value;
	var username = document.getElementById('uname').value;
	var password = document.getElementById('psw').value;
	var mail = document.getElementById('mail').value;
	var phone = document.getElementById('number').value;
	
	if (!checkMail(mail)) {
		alert("Adresse mail non conforme");
	} else if (!checkPhone(phone)) {
		alert("Numéro de téléphone non conforme");
	} else {
		document.getElementById("registerForm").submit();
//		users.push({
//			'name' : name,
//			'surname' : surname,
//			'username' : username,
//			'password' : password,
//			'mail' : mail,
//			'phone' : phone
//		});
//		alert("Nouvel utilisateur créé");
//		localStorage.setItem('users', JSON.stringify(users));
	}
}

function checkMail(user_mail) {
	 return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(user_mail);
}

function checkPhone(user_phone) {
	return Number.isInteger(user_phone)
	&& user_phone.length == 10 
		&& user_phone.charAt(0) == '0';
}