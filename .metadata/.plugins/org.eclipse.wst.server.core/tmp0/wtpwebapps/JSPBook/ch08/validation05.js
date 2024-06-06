function ckfn() {
		
		let id = document.Member.id;
		console.log(id.value);
		let pw = document.Member.passwd;
		let name = document.Member.name;
		let phone = document.Member.phone1.value + "-" + document.Member.phone2.value + "-" + document.Member.phone3.value;
		let email = document.Member.email;
		
		let regId = /^[a-zA-Z0-9_]*$/;
		let regName = /^[가-힣]*$/;
		let regPw = /^[0-9]*$/;
		let regPhone = /^\d{3}-\d{3,4}-\d{4}$/;
		let regEmail = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;

		
		if(!id.value.match(regId)) {
			alert("아이디는 문자로 시작해주세요오오오!");
			id.value = "";
			id.focus();
			return false;
		}
		
		if(!pw.value.match(regPw)) {
			alert("숫자만 입력해주세요.");
			pw.value = "";
			pw.focus();
			return false;
		}
		
		if(!name.value.match(regName)) {
			alert("한글로 입력해주세요.");
			name.value = "";
			name.focus();
			return false;
		}
		
		if(!regPhone.test(phone)) {
			alert("연락처를 입력해주세요.");
			
			return false;
		}
		
		if(!email.value.match(regEmail)) {
			alert("이메일을 입력해주세요.");
			email.value = "";
			email.focus();
			return false;
		}

		Member.submit();
		
	}