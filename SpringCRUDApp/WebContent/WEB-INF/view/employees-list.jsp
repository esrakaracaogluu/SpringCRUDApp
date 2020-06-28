<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kitap Listeleme</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Çalışan Listeleme</h2>
		</div>
		<hr>
	</div>
	<div id="container">
		<div id="content">

			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>E-mail</th>
						<th>Phone Number</th>
						<th>Hire Date</th>
						<th>Job Title</th>
						<th>Salary</th>
						<th>COMMISSION PCT</th>
						<th>Manager Id</th>
					    <th>Department Id</th>
		    		    <th>İşlem</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${calisan}" var="calsn">
					<c:url var="updateLink" value="/employees/employee-guncelle">
							<c:param name="empId" value="${calsn.employeeId}"></c:param>
						</c:url>
						
						<c:url var="deleteLink" value="/employees/employee-sil">
							<c:param name="empId" value="${calsn.employeeId}"></c:param>
						</c:url>
						<tr>

							<td>${calsn.employeeId}</td>
							<td>${calsn.first_name}</td>
							<td>${calsn.last_name}</td>
							<td>${calsn.email}</td>
                            <td>${calsn.phone_number}</td>
							<td>${calsn.hire_date}</td>
							<td>${calsn.jobs.job_title}</td>
							<td>${calsn.salary}</td>
							<td>${calsn.commission_pct}</td>
							<td>${calsn.manager.first_name}</td>
							<td>${calsn.department.departmentName}</td>
							
							<td><button onclick="window.location.href='${updateLink}'" class="update-button">Güncelle</button>
							<button onclick="if (confirm('Bu kaydı silmek istediğinize emin misiniz?')) window.location.href='${deleteLink}'" class="delete-button">Sil</button>
							</td>
   					   </tr>
				</c:forEach>

				</tbody>

			</table>
              <hr>
			<button onclick="window.location.href='employee-ekle'" class="calisan-ekle">Ekle</button>
		</div>
	</div>

</body>
</html>