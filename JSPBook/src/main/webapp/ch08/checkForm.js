function ckFun() {
			
			//아이디는 영문대소문자, 숫자, _ 가능
			let id = document.member.id;
			let pw = document.member.passwd1;
			let pwCk = document.member.passwd2;
			let name = document.member.name;
			let birth = document.member.birth;
			let tel = document.member.tel;
			
			let regId = /^[a-zA-Z0-9_]*$/;
			let regPw = /^[a-zA-Z0-9!@#$]*$/;
			let regName = /^[가-힣]*$/;
			let regBirth = /^[0-9\-]*$/;
			let regTel = /^[0-9\-]*$/;
			
			let form = document.member;
			
			if(id.value == "") {
				alert("아이디를 입력해주세요");
				id.focus();
				return false;
			}
			
			if(!id.value.match(regId)) {
				alert("아이디는 영문대소문자, 숫자, _ 만 가능합니다.");
				id.value = "";
				id.focus();
				
				return false;
			}
			
			//비밀번호 입력 유무
			
			if(pw.value == "") {
				alert("비밀번호를 입력하세요.");
				pw.value = "";
				pw.focus();
				return false;
			}
			
			
			//비밀번호는 6자리 이상 12자리 이하
			
			if(pw.value.length <= 6 || pw.value.length >= 12) {
				alert("비밀번호는 6자리 이상 12자리 이하로 입력하세요.");
				pw.value = "";
				pw.focus();
				return false;
			}
			
			//비밀번호는 영문 대소문자, 숫자, !,@,# 만 가능
			
			if(!pw.value.match(regPw)) {
				alert("아이디는 영문대소문자, !,@,# 만 가능합니다.");
				id.value = "";
				id.focus();
				
				return false;
			}
			
			//비밀번호와 비밀번호 확인 일치 여부
			
			if(pw.value != pwCk.value) {
				alert("비밀번호가 일치하지 않습니다.\n 비밀번호를 다시 입력해주세요.");
				pw.value = "";
				pwCk.value = "";
				pw.focus();
				
				return false;
			}
			
			//이름 입력 유무
			
			if(name.value == "") {
				alert("이름을 입력해 주세요.");
				name.value = "";
				name.focus();
				
				return false;
			}
			
			if(!name.value.match(regName)) {
				alert("아이디는 영문대소문자, 숫자, _ 만 가능합니다.");
				name.value = "";
				name.focus();
				
				return false;
			}
			
			//생년월일 입력유무
			
			if(birth.value == "") {
				alert("생년월일을 입력해 주세요.");
				birth.value = "";
				birth.focus();
				
				return false;
			}
			
			//생년월일 숫자만 가능
			
			if(!birth.value.match(regBirth)) {
				alert("생년월일은 숫자 또는 -만 가능합니다.");
				birth.value = "";
				birth.focus();
				
				return false;
			}
			
			//연락처 유무
			
			if(tel.value == "") {
				alert("연락처를 입력해주세요.");
				tel.value = "";
				tel.focus();
				
				return false;
			}
			
			//연락처 -만 가능

			if(!tel.value.match(regTel)) {
				alert("연락처는 숫자 또는 -만 가능합니다.");
				tel.value = "";
				tel.focus();
				
				return false;
			}
			
			form.submit();
			
		}