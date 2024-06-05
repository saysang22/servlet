
function btnEv() {
	//alert("제출완료");

	let id = document.querySelector("#id");

	let regId = /^[a-zA-Z0-9]*$/;

	let idMsg = ["아이디는 영문 소문자와 숫자로만 입력하세요!", "아이디를 입력해주세요."];

	if (id.value == "") {
		alert(idMsg[1])
		id.focus();
		return false;
	}

	if (!id.value.match(regId)) {
		alert(idMsg[0]);
		id.value = "";
		id.focus();

		return false;
	}


	signUp.submit();
}


