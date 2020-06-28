<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html lang="en" dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seçim Ekranı</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style4.css" />

</head>
<body >
    <div class="container">
    <h1>Seçim Yapınız!</h1>
	<button onclick="window.location.href='ogrenci/list'"
		class="btn btn1">Student</button>
	
	<button onclick="window.location.href='kurs/list'"
		class="btn btn1">Course</button>

	<button onclick="window.location.href='employees/list'"
		class="btn btn1">Employee</button>
	</div>
</body>
</html>