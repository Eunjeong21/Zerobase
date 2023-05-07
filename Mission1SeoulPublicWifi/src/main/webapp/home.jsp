<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
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
</style>
</head>
<body>
<%
//DbInfo dbInfo = new DbInfo();
//List<WifiInfo> wifiList = dbInfo.dbSelect();

//GetDistance gDistance = new GetDistance();
//int d = GetDistance.distance(WifiInfo.getLat, WifiInfo.getLnt);

%>
	
	<h1>와이파이 정보 구하기</h1>
	<div class="line">
		<span><a href="home.jsp">홈</a></span>
		<span><a href="history.jsp">위치 히스토리 목록</a></span>
		<span><a href="wifi-import.jsp">Open API 와이파이 정보 가져오기</a></span>
		<span><a href="show-bookmark.jsp">북마크 보기</a></span>
		<span><a href="bookmark-group.jsp">북마크 그룹 관리</a></span>
	</div>
	<div class="current">
		<label for="lat">LAT:</label>
		<input type="text" placeholder="위도" id="lat">
		<label for="lnt">, LNT:</label>
		<input type="text" placeholder="경도" id="lnt">
		<button id="currentLocation">내 위치 가져오기</button>
		<button>근처 WIFI 정보 보기</button>
	</div>
	<table class="wifi-table">
		<thead>
			<tr>
				<th>거리(KM)</th>
				<th>관리번호</th>
				<th>자치구</th>
				<th>와이파이명</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>설치위치(층)</th>
				<th>설치유형</th>
				<th>설치기관</th>
				<th>서비스구분</th>
				<th>망종류</th>
				<th>설치년도</th>
				<th>실내외구분</th>
				<th>WIFI접속환경</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>작업일자</th>
			</tr>
			<tr>
				<%--   
				<%
					for(WifiInfo wifi: wifiList) {
				%>
						<tr>
						//<td>gDistance()</td>
						<td><%=wifi.getxSwifiMgrNo()%></td>
						<td><%=wifi.getxSwifiWrdofc()%></td>
						<td><%=wifi.getxSwifiMainNm()%></td>
						<td><%=wifi.getxSwifiAdres1()%></td>
						<td><%=wifi.getxSwifiAdres2()%></td>
						<td><%=wifi.getxSwifiInstlTy()%></td>
						<td><%=wifi.getxSwifiInstlMby()%></td>
						<td><%=wifi.getxSwifiSvcSe()%></td>
						<td><%=wifi.getxSwifiCnstcYear()%></td>
						<td><%=wifi.getxSwifiInoutDoor()%></td>
						<td><%=wifi.getxSwifiRemars3()%></td>
						<td><%=wifi.getLat()%></td>
						<td><%=wifi.getLnt()%></td>
						<td><%=wifi.getWorkDttm()%></td>
						</tr>
				<%
					}
				%> --%>
			</tr>
		</thead>
	</table>
	
	<script>
		const currentLocation = document.getElementById("currentLocation");
		currentLocation.addEventListener("click", function() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					const curLat = position.coords.latitude;
					const curLnt = position.coords.longitude;
					document.getElementById("lat").value = curLat;
					document.getElementById("lnt").value = curLnt;
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