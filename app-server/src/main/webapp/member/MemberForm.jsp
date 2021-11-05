<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원가입</title>
  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">

  <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script>
  <script src="../bootstrap/dist/bootstrap.css"></script>
  
   <script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(!document.userInfo.id.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.password.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
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
<form name = "userInfo" action='add' onsubmit="return checkValue()">

<div class="col-md-6">
  <label for="validationServer04" class="form-label">-일반회원 가입 페이지-</label>
 
</div>
  <div class="mb-3 row">
    <label for='f-name' class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-6">
      <input id='f-name' type='text' name='name' class="form-control">
    </div>
</div>
<div class="mb-3 row">
    <label for='f-id' class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-6">
      <input id='f-id' type='text' name='id' >
      <input type="button" name = 'idCheck' value="중복체크"> 
    </div>
</div>
<div class="mb-3 row">
  <label for='f-password' class="col-sm-2 col-form-label">암호</label>
  <div class="col-sm-6">
    <input id='f-password' type='password' name='password' class="form-control">
  </div>
</div>
<div class="mb-3 row">
    <label for='f-email' class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-6">
      <input id='f-email' type='email' name='email' class="form-control">
    </div>
</div>

<div class="mb-3 row">
  <label for='f-phoneNum' class="col-sm-2 col-form-label">생일</label>
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
  <label for='f-phoneNum' class="col-sm-2 col-form-label">휴대전화</label>
  <div class="col-sm-6">
    <input id='f-phoneNum' type='text' name='phoneNum' class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-photo' class="col-sm-2 col-form-label">사진</label>
  <div class="col-sm-6">
    <input id='f-photo' type='text' name='photo' class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='f-photo' class="col-sm-2 col-form-label">성별</label>
  <div class="col-sm-6">
  
    <select id='f-photo' name='sex' class="form-control">
    <option value = "">성별</option>
    <option value = "남성">남자</option>
    <option value = "여성">여자</option>
    </select>
    
  </div>
</div>
  <div class="col-12">
    <button class="btn btn-primary btn-sm" >회원 가입</button>
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
</body>
</html>









