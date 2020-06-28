<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Öğrenci Formu</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Ögrenci Formu</h2>
		</div>
		<frm:form action="ogrenci-kaydet" modelAttribute="ogrenci"
			method="POST">
			<frm:hidden path="id" />
			<table>
				<tr>
					<td><label>İsim</label></td>
					<td><frm:input path="isim" /><frm:errors path="isim" cssClass="error" /></td>
				</tr>

				<tr>
					<td><label>Soyisim</label></td>
					<td><frm:input path="soyisim" /><frm:errors path="soyisim" cssClass="error" /></td>
				</tr>

				<tr>
					<td><label>Öğrenci No</label></td>
					<td><frm:input path="ogrenciNo" /><frm:errors path="ogrenciNo" cssClass="error" /></td>
				</tr>

				<tr>
					<td></td>
					<td><frm:button value="save" name="save" class="calisan-ekle">Kaydet</frm:button></td>
				</tr>

			</table>

		</frm:form>
	</div>


	<div id="container">
		<div id="content"></div>
	</div>

</body>
</html>