<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style>

	@import url('https://fonts.googleapis.com/css2?family=Hahmlet:wght@100;300&family=Noto+Serif+KR&display=swap');
	
	* {
	font-family: 'Hahmlet', serif;
	}
	
	.wifi-table {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
	margin: auto;
	margin-top: 15px;
	}

	.wifi-table td, .wifi-table th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
	}

	.wifi-table tr:nth-child(even){background-color: #f2f2f2;}

	.wifi-table tr:hover {background-color: #ddd;}

	.wifi-table th {
  		padding-top: 12px;
  		padding-bottom: 12px;
  		background-color: #04AA6D;
  		color: white;
  	}
  	
  	.line span:nth-child(n+2) {
  		position: relative;
  		margin-left: 5px;
  		padding-left: 10px;
  	}
  	
  	.line span:nth-child(n+2)::after {
  		position: absolute;
  		left: 0;
  		top: 3px;
  		content: "";
  		width: 1px;
  		height: 15px;
  		background-color: black;
  	}
}
</style>
</head>
<body>
	<h1>북마크 목록</h1>
	<div class="line">
		<span><a href="home.jsp">홈</a></span>
		<span><a href="history.jsp">위치 히스토리 목록</a></span>
		<span><a href="wifi-import.jsp">Open API 와이파이 정보 가져오기</a></span>
		<span><a href="show-bookmark.jsp">북마크 보기</a></span>
		<span><a href="bookmark-group.jsp">북마크 그룹 관리</a></span>
	</div>
	<table class="wifi-table">
	<thead>
	<tr>
		<th>ID</th>
		<th>북마크 이름</th>
		<th>와이파이명</th>
		<th>등록일자</th>
		<th>비고</th>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td><a href="bookmark-delete.jsp">삭제</a></td>
	</tr>
	</thead>
	</table>
</body>
</html>