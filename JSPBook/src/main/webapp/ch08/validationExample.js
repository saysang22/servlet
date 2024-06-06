function btnEv() {

	let id = document.querySelector("#id");
	let passwd = document.querySelector("#passwd");
	let passwdCk = document.querySelector("#passwdCk")
	let name = document.querySelector("#name");

	let regId = /^[a-zA-Z0-9]*$/;
	let regPasswd = /^[0-9]{6,12}$/;
	let regName = /^[가-힣]*$/;

	let idMsg = ["아이디는 영문 소문자와 숫자로만 입력하세요!", "아이디를 입력해주세요."];
	let passwdMsg = ["비밀번호를 입력해주세요!", "비밀번호는 6자 이상 12자리 이하로 입력하세요."];
	let passwdCkMsg = "비밀번호를 올바르게 입력하세요!";
	let nameMsg = ["이름을 입력해주세요!","이름은 한글로만 입력하세요!"];
	
	//아이디가 비어있을 경우
	if (id.value == "") {

		alert(idMsg[1])

		id.focus();

		return false;

	}
	
	//아이디가 영문 소문자와 숫자가 아닌 경우
	if (!id.value.match(regId)) {

		alert(idMsg[0]);

		id.value = "";

		id.focus();

		return false;

	}
	
	//비밀번호가 비어 있을 경우
	if(passwd.value == "") {
		alert(passwdMsg[0]);
		
		passwd.focus();
		
		return false;
	}
	
	//비밀번호가 6자리 이상, 12자리 이하가 아닐 경우
	if(!passwd.value.match(regPasswd)) {
		alert(passwdMsg[1]);
		passwd.focus();
		
		return false;
	}
	
	//비밀번호 체크
	if(passwdCk.value != passwd.value) {
		alert(passwdCkMsg);
		return false;
	}
	
	//이름이 비어있는 경우
	if(name.value == "") {
		alert(nameMsg[0]);
		return false;
	}
	
	//이름이 한글이 아닐 경우
	if(!name.value.match(regName)) {
		alert(nameMsg[1]);
		name.focus();
		
		return false;
	}
	


	signUp.submit();

}

function popup() {
	
	let url = "popup.html";
	let name = "popup";
	let option = "width = 300, height = 400, left = 100, top = 100";
	
	window.open(url, name, option);
}