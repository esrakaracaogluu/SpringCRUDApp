<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kurs Formu</title>
</head>
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
		<frm:form action="kurs-kaydet" modelAttribute="kurs" method="POST">
		<frm:hidden path="id"/>
			<table>
				<tr>
					<td><label>Kurs Adı</label></td>
					<td><frm:input path="kursAdi" /><frm:errors path="kursAdi" cssClass="error" />
				</tr>

				<tr>
					<td><label>Saat</label></td>
					<td><frm:input path="saat" /><frm:errors path="saat" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Ogretmen</label></td>
					<td><frm:select path="ogretmen.ogrId">
							<frm:options items="${ogretmenler}" />

						</frm:select></td>
				</tr>
				<tr>
				   <td></td>
				   <td><frm:button name="save" value="save" class="calisan-ekle">Kaydet</frm:button>
			</table>
		</frm:form>
	</div>


	<div id="container">
		<div id="content"></div>
	</div>
</body>
</html>