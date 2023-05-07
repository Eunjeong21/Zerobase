<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Hahmlet:wght@100;300&family=Noto+Serif+KR&display=swap')
	;

* {
	font-family: 'Hahmlet', serif;
}

.current {
	margin-top: 15px;
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

.wifi-table tr:nth-child(even) {
	background-color: #f2f2f2;
}

.wifi-table tr:hover {
	background-color: #ddd;
}

.wifi-table th {
	width: 40%;
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

.bookmark-select {
	width: 10%;
}
</style>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<div class="line">
		<span><a href="home.jsp">홈</a></span>
		<span><a href="history.jsp">위치 히스토리 목록</a></span>
		<span><a href="wifi-info.jsp">Open API 와이파이 정보 가져오기</a></span>
		<span><a href="show-bookmark.jsp">북마크 보기</a></span>
		<span><a href="bookmark-group.jsp">북마크 그룹 관리</a></span>
	</div>
	<div class="current">
		<select class="bookmark-select">
		<%--북마크 그룹 추가될 때마다 그룹 추가에 연동--%>
			<option value="group1">그룹 1</option>
			<option value="group2">그룹 2</option>
			<option value="group3">그룹 3</option>
			<option value="group4">그룹 4</option>
		</select>
		<button>북마크 추가하기</button>
	</div>
	<table class="wifi-table">
		<thead>
			<tr>
				<th>거리(KM)</th>
				<td></td>
			</tr>
			<tr>	
				<th>관리번호</th>
				<td></td>
			</tr>
			<tr>	
				<th>자치구</th>
				<td></td>
			</tr>
			<tr>	
				<th>와이파이명</th>
				<td></td>
			</tr>
			<tr>	
				<th>도로명주소</th>
				<td></td>
			</tr>
			<tr>	
				<th>상세주소</th>
				<td></td>
			</tr>
			<tr>	
				<th>설치위치(층)</th>
				<td></td>
			</tr>
			<tr>	
				<th>설치유형</th>
				<td></td>
			</tr>
			<tr>
				<th>설치기관</th>
				<td></td>
			</tr>
			<tr>	
				<th>서비스구분</th>
				<td></td>
			</tr>
			<tr>	
				<th>망종류</th>
				<td></td>
			</tr>
			<tr>	
				<th>설치년도</th>
				<td></td>
			<tr>	
				<th>실내외구분</th>
				<td></td>
			</tr>
			<tr>	
				<th>WIFI접속환경</th>
				<td></td>
			</tr>
			<tr>	
				<th>X좌표</th>
				<td></td>
			</tr>
			<tr>	
				<th>Y좌표</th>
				<td></td>
			<tr>
				<th>작업일자</th>
				<td></td>
			</tr>
		</thead>
	</table>
	<script>
		const currentLocation = document.getElementById("currentLocation");
		currentLocation.addEventListener("click", function() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					const lat = position.coords.latitude;
					const lnt = position.coords.longitude;
					document.getElementById("lat").value = lat;
					document.getElementById("lnt").value = lnt;
				}, function failure(error) {
					if (error.code) {
						alert('failure!');
					}
				});
			} else {
				alert('not found')
			}
		});
	</script>
</body>
</html>