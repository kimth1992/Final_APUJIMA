<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원가입</title>
  <link rel="stylesheet" href="${contextPath}/node_modules/bootstrap/dist/css/bootstrap.css">

  <script src="${contextPath}/node_modules/@popperjs/core/dist/umd/popper.js"></script>
  <script src="${contextPath}/bootstrap/dist/bootstrap.css"></script>
  

<script>
 
function idCheck(){
  
  window.open("${contextPath}/app/member/idCheckForm.jsp", "IdCheck", "width=400 height = 350")
  
}
function nicknameCheck(){
    
   window.open("${contextPath}/member/NicknameCheckForm.jsp", "NicknameCheck", "width=400 height = 350")
    
  }
</script>

<script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
          
           if(!document.userInfo.grade.value){
                alert("회원구분을 선택하세요.");
                return false;
            }
          
            if(!document.userInfo.name.value){
                alert("이름을 입력하세요.");
                return false;
            } 
            
            if(!document.userInfo.nickname.value){
                alert("별명을 입력하세요.");
                return false;
            } 
            
         /*  if(!document.userInfo.nicNameDuplication.value != "nicNameCheck"){
                alert("별명 중복체크를 해주세요.");
                return false;
            } 
         */
            
            if(!document.userInfo.id.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            
      /*       if(!document.userInfo.idDuplication.value != "idCheck"){
                alert("아이디 중복체크를 해주세요.");
                return false;
            }  */
            
            if(!document.userInfo.password.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
          
            if(!document.userInfo.email.value){
                alert("이메일을 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.birthyy.value){
                alert("생년월일을 입력하세요.");
                return false;
            }
            if(!document.userInfo.birthmm.value){
                alert("생년월일을 입력하세요.");
                return false;
            }
            if(!document.userInfo.birthdd.value){
                alert("생년월일을 입력하세요.");
                return false;
            }
            if(!document.userInfo.tel.value){
                alert("연락처를 입력하세요.");
                return false;
            }
            if(!document.userInfo.sex.value){
                alert("성별을 선택하세요.");
                return false;
            } 
        }
    </script>
    
 <script>
function div_OnOff(v,id){
 // 라디오 버튼 value 값 조건 비교
 if(v == "2"){
  document.getElementById(id).style.display = ""; // 보여줌
 }else{
  document.getElementById(id).style.display = "none"; // 숨김
 }
}
</script>




  
  <style>
  .container {
    xborder: 1px solid red;
    width: 640px;
  }
  .gender{
    xborder: 1px solid red;
    width: 100px;
    margin-top: 5px;
  }
  </style>
  
</head>
<body>
<div class="container">
<div class=""></div>
<h1>회원가입</h1>
<form name = "userInfo" action='add' method='post'  enctype="multipart/form-data" onsubmit="return checkValue()" >

<div class="col-md-6">
  <label for="validationServer04" class="form-label">-APUJIMA에 오신 것을 환영합니다-</label>
 
</div>

  <div class="mb-3 row">
    <label for='f-grade' class="col-sm-3 col-form-label">* 구분</label>
    <div class="col-sm-6">
      <input id='member' type='radio' name='grade' value = "1" onclick="div_OnOff(this.value,'con');">
      <label>일반</label>
      <input id='doctor' type='radio' name='grade' value = "2" onclick="div_OnOff(this.value,'con');">
      <label>의사</label>
    </div>
</div>

  <div class="mb-3 row">
    <label for='f-name' class="col-sm-3 col-form-label">* 이름</label>
    <div class="col-sm-6">
      <input id='f-name' type='text' name='name' class="form-control">
    </div>
</div>



  <div class="mb-3 row">
    <label for='f-nickname' class="col-sm-3 col-form-label">* 별명</label>
    <div class="col-sm-6">
      <input id='f-nickname' type='text' name='nickname' class ="form-control">
     <div class="invalid-feedback">
        이미 존재하는 별명입니다.
     </div>
   </div>
     <div class ="col-auto">
       <button id = "x-nickname-check-btn" type ="button" class ="btn btn-primary form-control">중복검사</button>
    </div>
    
</div>



<div class="mb-3 row">
    <label for='f-id' class="col-sm-3 col-form-label">* 아이디</label>
    <div class="col-sm-6">
      <input id='f-id' type='text' name='id' class ="form-control">
      <div class="invalid-feedback">
        이미 존재하는 아이디입니다.
    </div>
   </div>
   <div class ="col-auto">
    <button id ="x-id-check-btn" type = "button" class ="btn btn-primary form-control">중복검사</button>
    </div>
    
</div>
<div class="mb-3 row">
  <label for='f-password' class="col-sm-3 col-form-label">* 비밀번호</label>
  <div class="col-sm-6">
    <input id='f-password' type='password' name='password' class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-passwordcheck' class="col-sm-3 col-form-label">* 비밀번호확인</label>
  <div class="col-sm-6">
    <input id='f-passwordcheck' type='password' name='passwordcheck' class="form-control">
  </div>
</div>
<div class="mb-3 row">
    <label for='f-email' class="col-sm-3 col-form-label">* 이메일</label>
    <div class="col-sm-6">
      <input id='f-email' type='email' name='email' class="form-control">
    </div>
</div>

<div class="mb-3 row">
  <label for='f-birth' class="col-sm-3 col-form-label">* 생일</label>
  <div class="col-sm-6">
      <input id = 'f-birth' type="text" name="birthyy"  maxlength="4" placeholder="년(4자)" size="6" >
          <select name="birthmm">
              <option value="">월</option>
              <option value="01" >1</option>
              <option value="02" >2</option>
              <option value="03" >3</option>
              <option value="04" >4</option>
              <option value="05" >5</option>
              <option value="06" >6</option>
              <option value="07" >7</option>
              <option value="08" >8</option>
              <option value="09" >9</option>
              <option value="10" >10</option>
              <option value="11" >11</option>
              <option value="12" >12</option>
            </select>
        <input type="text" name="birthdd" maxlength="2" placeholder="일" size="4" >

  </div>
  </div>


<div class="mb-3 row">
  <label for='f-tel' class="col-sm-3 col-form-label">* 휴대전화</label>
  <div class="col-sm-6">
    <input id='f-tel' type='tel' name='tel' placeholder ="010-0000-0000" class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-photo' class="col-sm-3 col-form-label">사진</label>
  <div class="col-sm-6">
    <input id='f-photo' type='file' name='photoPart' class="form-control">
  </div>
</div>

  <div class="mb-3 row">
    <label for='f-grade' class="col-sm-3 col-form-label">* 성별</label>
    <div class="col-sm-6">
      <input id='f-sex' type='radio' name='sex' value = "남">
      <label>남자</label>
      <input id='f-sex' type='radio' name='sex' value = "여">
      <label>여자</label>
    </div>
</div>

<div id="con" style = "display:none">
 <div class="mb-3 row" >
    <label for='f-major' class="col-sm-3 col-form-label">* 전문분야</label>
    <div class="col-sm-6">
     <input id='f-major' type='text' name='major' class="form-control">
    </div>
</div>


 <div class="mb-3 row" >
    <label for='f-license' class="col-sm-3 col-form-label">* 의사 자격증</label>
    <div class="col-sm-6">
     <input id='f-license' type='file' name='license' class="form-control">
    </div>
</div>

 <div class="mb-3 row" >
    <label for='f-page' class="col-sm-3 col-form-label">홈페이지</label>
    <div class="col-sm-6">
     <input id='f-page' type='text' name='homepage' class="form-control">
    </div>
</div>

 <div class="mb-3 row" >
    <label for='f-introduce' class="col-sm-3 col-form-label">인사말</label>
    <div class="col-sm-6">
     <input id='f-introduce' type='text' name='introduce' class="form-control">
    </div>
</div>

</div>
  <div class="col-12">
    <button id ="x-add-btn" class ="btn btn-primary btn-sm">등록</button>
    <!--  <input type = 'submit' value = '회원가입' class="btn btn-primary btn-sm" >-->
  </div>
</form>
</div><!-- .container -->
<!-- <label for='f-name'>이름</label> <input id='f-name' type='text' name='name'><br>
<label for='f-email'>이메일</label> <input id='f-email' type='email' name='email'><br>
<label for='f-password'>암호</label> <input id='f-password' type='password' name='password'><br>
<label for='f-photo'>사진</label> <input id='f-photo' type='text' name='photo'><br>
<label for='f-tel'>전화</label> <input id='f-tel' type='tel' name='tel'><br>
<button>등록</button><br>
</form>  -->

 <script>
 var addBtn = document.querySelector("#x-add-btn");
 var nicknameTag = document.querySelector("#f-nickname");
 var idTag = document.querySelector("#f-id");
 
 addBtn.setAttribute("disabled", "disabled");

document.querySelector ("#x-nickname-check-btn").onclick = () => {
	 var xhr = new XMLHttpRequest();
	 xhr.addEventListener("load", function() {
		  if (this.responseText == "false"){
			  addBtn.removeAttribute("disabled");
			   nicknameTag.classList.remove("is-invalid");
		  } else {
			  addBtn.setAttribute("disabled", "disabled");
			  nicknameTag.classList.add("is-invalid");
		  }
		  })
		  xhr.open("get","checkNickname?nickname=" + nicknameTag.value);
	    xhr.send();
};



document.querySelector ("#x-id-check-btn").onclick = () =>{
	   var xhr = new XMLHttpRequest();
	   xhr.addEventListener("load", function() {
	      if (this.responseText == "false"){
	         addBtn.removeAttribute("disabled");
	         idTag.classList.remove("is-invalid");
	      } else {
	        addBtn.setAttribute("disabled","disabled");
	        idTag.classList.add("is-invalid");
	      }
	      })
	      xhr.open("get","checkId?id=" + idTag.value);
	      xhr.send();
	};



 
 </script>




</body>
</html>

