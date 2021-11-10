<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>약품 등록 요청</title>
  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">

  <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script>
  <script src="../bootstrap/dist/bootstrap.css"></script>
  
   <script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
        	
           if(!document.medicineRequest.name.value){
                alert("약품 이름을 작성해 주세요.");
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
<h1>약품 등록 요청</h1>
<form name = "medicineRequest" action='request' onsubmit="return checkValue()">

<div class="col-md-6">
  <label for="validationServer04" class="form-label">-약품 정보에 도움을 주셔서 감사합니다.-</label>
 
</div>


  <div class="mb-3 row">
    <label for='m-name' class="col-sm-3 col-form-label">* 약품명</label>
    <div class="col-sm-6">
      <input id='m-name' type='text' name='name' class="form-control">
    </div>
</div>

<div class="mb-3 row">
    <label for='m-age' class="col-sm-3 col-form-label">권장 연령</label>
    <div class="col-sm-6">
      <input id='m-age' type='text' name='age' >
      <input type="button" name = 'idCheck' value="중복체크"> 
    </div>
</div>
<div class="mb-3 row">
  <label for='m-shape' class="col-sm-3 col-form-label">약품 모양</label>
  <div class="col-sm-6">
    <input id='m-shape' type='text' name='shape' class="form-control">
  </div>
</div>
<div class="mb-3 row">
  <label for='m-color' class="col-sm-3 col-form-label">약품 색상</label>
  <div class="col-sm-6">
    <input id='m-color' type='text' name='color' class="form-control">
  </div>
</div>
<div class="mb-3 row">
    <label for='m-effect' class="col-sm-3 col-form-label">약품 효능</label>
    <div class="col-sm-6">
      <input id='m-effect' type='text' name='effect' class="form-control">
    </div>
</div>
  <div class="col-12">
    <button class="btn btn-primary btn-sm" >약품 등록 신청</button>
  </div>

</div>




<!-- <div class="mb-3 row">
  <label for='f-photo' class="col-sm-2 col-form-label">성별</label>
  <div class="col-sm-6">
  
    <select id='f-sex' name='sex' class="form-control">
    <option value = "" placeholder="성별"></option>
    <option value = "남성">남자</option>
    <option value = "여성">여자</option>
    </select>
    
  </div>
</div> -->

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









