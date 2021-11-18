<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<head>
<style>

header {
  position: relative;
}

	li {
		margin-left: 40px;
	}
	
	.btn4 {
  padding: 10px;
  color: #fff;
  font-family: sans-serif;
  text-transform: uppercase;
  text-align: center;
  position: relative;
  text-decoration: none !important;
  display:inline-block;
}

	.btn4::before {
  content: '';
  position: absolute;
  bottom: 0%;
  left: 0px;
  width: 100%;
  height: 1px;
  background: white;
  display: block;
  -webkit-transform-origin: right top;
  -ms-transform-origin: right top;
  transform-origin: right top;
  -webkit-transform: scale(0, 1);
  -ms-transform: scale(0, 1);
  transform: scale(0, 1);
  -webkit-transition: transform 0.4s cubic-bezier(1, 0, 0, 1);
  transition: transform 0.4s cubic-bezier(1, 0, 0, 1);
}

.btn4:hover::before {
  -webkit-transform-origin: left top;
  -ms-transform-origin: left top;
  transform-origin: left top;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1)
}

input.img-button {
        background: url("/apus/img/header/white_logo.svg") no-repeat;
        border: none;
        width: 185px;
        height: 31px;
        cursor: pointer;
      }
      
.searchbar {
    margin-bottom: auto;
    margin-top: auto;
    height: 40px;
    background-color: #91929281;
    border-radius: 30px;
    padding: 10px;
    }

    .search_input{
    color: white;
    border: 0;
    outline: 0;
    background: none;
    width: 0;
    caret-color:transparent;
    line-height: 8px;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_input{
    padding: 0 10px;
    width: 200px;
    caret-color:#253629;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_icon{
    background: white;
    color: #253629;
    }

    .searchbar> .s_icon {
    height: 28px;
    width: 28px;
    float: right;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    color:white;
    text-decoration:none;
    }
    
    input::placeholder {color:#ccc;}
		input::-webkit-input-placeholder {color:#ccc;}
		input:-ms-input-placeholder {color:#ccc;}
		 
		textarea::placeholder {color:#ccc;}
		textarea::-webkit-input-placeholder {color:#ccc;}
		textarea:-ms-input-placeholder {color:#ccc;}

    .no-italics {
    font-style: normal;   
}

</style> 
</head>
<header>
<nav class="navbar navbar-expand-lg navbar-light bg-transparent" style="height: 120px; border-bottom: solid 1px rgba(252, 246, 246, 0.438); margin-bottom: 30px;">
  <div class="container-fluid">
    <a class="navbar-brand" href="/apus/home">
    <input type="button" class="img-button"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="btn4" href="#" style="color: white">소개</a>
        </li>
        <li class="nav-item">
          <a class="btn4" href="${contextPath}/app/medicine/list" style="color: white">약국</a>
        </li>
        <li class="nav-item">
          <a class="btn4" href="${contextPath}/app/doctorinfo/list" style="color: white">HEALER</a>
        </li>
        <li class="nav-item">
          <a class="btn4" href="${contextPath}/app/board/list" style="color: white">커뮤니티</a>
        </li>
        <li>
				    <!-- <form class="d-flex">
				      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
				      <button type="button" class="btn" style="color: white">search</button>
				    </form>
				     -->
				     
				     <div class="container h-100">
					      <div class="d-flex justify-content-center h-100">
					        <div class="searchbar">
					          <input class="search_input" type="text" placeholder="Search...">
					          <a href="#" class="s_icon"><i class="bi bi-search" style="margin-bottom: 10px;"></i></a>
					        </div>
					      </div>
					    </div>
				</li>
				<!-- 로그인 x -->
				<c:if test="${empty sessionScope.loginUser}">
				<li>
				<a href="${contextPath}/app/auth/loginForm" class="btn4" style="color: white;">
			   로그인
			  </a>
			  <a href="${contextPath}/app/member/form" class="btn4" style="color: white;">
         회원가입
        </a>
			  </li>
			  </c:if>
			  <!-- 로그인 o -->
			  <c:if test="${not empty sessionScope.loginUser}">
			  <li>
        <a href="auth/userInfoList" class="button" style="color: white"><b>${loginUser.nickname}</b></a>
        <i class="no-italics" style="color: darkgrey">&nbsp;님 <br>환영합니다!</i>
        </li>
        <li>
        <form name="logout" action= 'auth/logout' method = "get">
        <a class="btn4 "href="javascript:logout.submit();" style="color: white">로그아웃</a>
        </form>
        </li>
			  </c:if>
      </ul>
    </div>
  </div>
</nav>
</header>