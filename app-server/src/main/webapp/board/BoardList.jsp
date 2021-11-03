<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>게시판 목록</title>
   <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">
  
  <script src="../node_modules/@popperjs/core//dist/umd/popper.js"></script>
  <script src="../node_modules/bootstrap/dist/js/bootstrap.js"></script>
  
  <style>
    .container {
    xborder: 1px solid red;
    xwidth: 640px;
    }
  </style>
  
</head>
<body>
<div class="container">
<h1>게시판 목록</h1>
<a href='form' class="btn btn-outline-primary btn-sm">분류</a><br>
<table class="table table-hover">
<thead>
  <tr>
    <th>번호</th>
    <th>게시판 종류</th>
    <th>제목</th>
    <th>내용</th>
    <th>작성자</th>
    <th>작성일</th>
    <th>조회</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${boardList}" var="board">
<tr>
    <td>${board.no}</td>
    <td>${board.whichBoard}</td>
    <td><a href='detail?no=${board.no}'>${board.title}</a></td> 
    <td>${board.content}</td> 
    <td>${board.writer.id}</td> 
    <td>${board.registeredDate}</td> 
    <td>${board.viewCount}</td> 
</tr>
</c:forEach>
</tbody>
</table>
</div><!-- .container -->
</body>
</html>







