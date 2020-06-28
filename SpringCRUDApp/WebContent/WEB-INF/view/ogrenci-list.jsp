<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Öğrenciler</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Ögrenci Listeleme</h2>
		</div>
		<hr>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>İsim</th>
						<th>Soyisim</th>
						<th>Öğrenci No</th>
						<th>İşlem</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${ogrenciler}" var="ogrenci">
						<!-- ogrenciler içinde geziyorsun ve gezerken herbir rowa referans yapan değişken ogrenci -->
						
						<c:url var="updateLink" value="/ogrenci/ogrenci-guncelle">
						     <c:param name="ogrenciId" value="${ogrenci.id}"/>
						</c:url>
						
						<c:url var="deleteLink" value="/ogrenci/ogrenci-sil">
						     <c:param name="ogrenciId" value="${ogrenci.id}"/>
						</c:url>
						
						<tr>
							<td>${ogrenci.id}</td>
							<td>${ogrenci.isim}</td>
							<td>${ogrenci.soyisim}</td>
							<td>${ogrenci.ogrenciNo}</td>
							<td>
							<!--<a href="${updateLink}">Güncelle</a> -->
							<button onclick="window.location.href='${updateLink}'" class="update-button">Güncelle</button>							
							<button onclick="if (confirm('Siliyoruz, emin misin?')) window.location.href='${deleteLink}'" class="delete-button">Sil</button>
							
							</td>

						</tr>
					</c:forEach>
				</tbody>

			</table>
			<hr>
			<button onclick="window.location.href='ogrenci-ekle'" class="calisan-ekle">Öğrenci
				Ekle</button>
			<!-- yukarıdaki ie aynı => <a href="ogrenci-ekle">Öğrenci Ekle</a> -->
		</div>
	</div>
</body>
</html>