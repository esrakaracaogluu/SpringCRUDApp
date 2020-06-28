<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giriş Ekranı</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style3.css" />
<style >
 .error{
    color:red;
 }

</style>
</head>
<body>
	
		<frm:form action="baglan" modelAttribute="kullanici" method="POST" class="box">
			<center><h1>Login</h1></center>
			<div class="textbox">
				<frm:input path="username" placeholder="username" />
				<frm:errors path="username" cssClass="error" />

			</div>
			<div class="textbox">
				<frm:input path="password" type="password" placeholder="password" />
				<frm:errors path="password" cssClass="error" />

			</div>

			<input value="Giriş" type="Submit" >

		</frm:form>
</body>
</html>