<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Çalışan Formu</title>
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
			<h2>Çalışan Formu</h2>
		</div>
		<frm:form action="employee-kaydet" modelAttribute="employee"
			method="POST">
			<frm:hidden path="employeeId" />
			<table>

				<tr>
					<td><label>First Name</label></td>
					<td><frm:input path="first_name" />
						<frm:errors path="first_name" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Last Name</label></td>
					<td><frm:input path="last_name" />
						<frm:errors path="last_name" cssClass="error" /></td>

				</tr>

				<tr>
					<td><label>Email</label></td>
					<td><frm:input type="email" path="email" /></td>
				</tr>

				<tr>
					<td><label>Phone</label></td>
					<td><frm:input path="phone_number" />
						<frm:errors path="phone_number" cssClass="error" /></td>
				</tr>

				<tr>
					<td><label>Hire Date</label></td>
					<td><frm:input type="date" path="hire_date" /></td>
				</tr>

				<tr>

					<td><label>Job</label></td>
					<td><frm:select path="jobs.jobs_id">

							<frm:options items="${jobs}" />

						</frm:select></td>
				</tr>

				<tr>
					<td><label>Salary</label></td>
					<td><frm:input path="salary" /><frm:errors path="salary" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Commission Percent</label></td>
					<td><frm:input path="commission_pct" /></td>
				</tr>
				<tr>
					<td><label>Manager</label></td>
					<td><frm:select path="manager.employeeId">
							<frm:options items="${managers}" />

						</frm:select></td>
				</tr>
				<tr>
					<td><label>Department</label></td>
					<td><frm:select path="department.departmentId">
							<frm:options items="${departments}" />

						</frm:select></td>
				</tr>


				<tr>
					<td></td>
					<td><frm:button type="submit" class="calisan-ekle">Kaydet</frm:button></td>
				</tr>

			</table>

		</frm:form>
	</div>


	<div id="container">
		<div id="content"></div>
	</div>
	<table>


	</table>
</body>
</html>

