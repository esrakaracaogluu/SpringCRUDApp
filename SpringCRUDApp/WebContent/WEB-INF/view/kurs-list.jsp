<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kurs Formu</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Kurs Listeleme</h2>
		</div>
		<hr>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Kurs Adı</th>
						<th>Saat</th>
	       				<th>Ogretmen Id</th>		
						<th>İşlem</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${kurs}" var="krs">
						<c:url var="updateLink" value="/kurs/kurs-guncelle">
							<c:param name="kursId" value="${krs.id}"></c:param>
						</c:url>
						
						<c:url var="deleteLink" value="/kurs/kurs-sil">
							<c:param name="kursId" value="${krs.id}"></c:param>
						</c:url>
						<tr>
							<td>${krs.id}</td>
							<td>${krs.kursAdi}</td>
							<td>${krs.saat}</td>
							<td>${krs.ogretmen.ogrId}</td>
							
							<td><button onclick="window.location.href='${updateLink}'" class="update-button">Güncelle</button>
							<button onclick="if (confirm('Siliyoruz, emin misin?')) window.location.href='${deleteLink}'" class="delete-button">Sil</button>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<button onclick="window.location.href='kurs-ekle'" class="calisan-ekle">Kurs Ekle</button>

		</div>
	</div>
</body>
</html>