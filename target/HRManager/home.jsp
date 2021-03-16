<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.nagarro.hrmanager.models.Employee"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Employee Details</title>
<style>
.custom-border {
	border: 1px solid #000;
}

.custom-title {
	margin-top: -12px;
	margin-left: 5px;
	height: 20px;
}

.custom-title-span {
	background-color: white;
	padding-right: 8px;
}

.float-child {
	float: right;
	margin-right: 3px;
	margin-bottom: 10px;
}
</style>
</head>
<body style="margin: 10px">
	<header>
		<div class="mb-5">
			<div style="padding-bottom: 10px">
				<div style="float: right;">
					<form action="SignOut">
						<button class="btn" type="submit">
							<i class="fa fa-times-circle"
								style="font-size: 50px; color: red;"></i>
						</button>
					</form>
				</div>
				<div style="float: right; padding-top: 14px;">
					<h3>
						Welcome
						<c:out value="${ userId }" />
						!
					</h3>
				</div>
			</div>
		</div>
	</header>
	<div class="custom-border">
		<h5 class="custom-title">
			<span class="custom-title-span">Employee Listings</span>
		</h5>
		<div class="m-4">
			<div>
				<div class="float-child">
					<form action="download">
						<input type="hidden" name="userId" value="userId"> <input
							type="submit" value="Download Employee Details">
					</form>
				</div>
				<div class="float-child">
					<a href="upload.jsp?userId=${ userId }"> <input type="submit"
						value="Upload Employee Details">
					</a>
				</div>
			</div>
			<div class="col-auto">
				<table class="table table-bordered table-responsive">
					<tr>
						<th class="text-center" scope="col">Employee Code</th>
						<th class="text-center" scope="col">Employee Name</th>
						<th class="text-center" scope="col">Location</th>
						<th class="text-center" scope="col">Email</th>
						<th class="text-center" scope="col">Date of Birth</th>
						<th class="text-center" scope="col">Action</th>
					</tr>
					<c:forEach items="${ employees }" var="employee">
						<tr>
							<td class="text-center">${ employee.getEmp_code() }</td>
							<td class="text-center">${ employee.getEmp_name() }</td>
							<td class="text-center">${ employee.getLoc() }</td>
							<td class="text-center">${ employee.getEmail() }</td>
							<td class="text-center">${ employee.getDob() }</td>
							<td class="text-center">
								<form action="edit" method="get">
									<input type="hidden" name="emp_code"
										value="${ employee.getEmp_code() }"> <input
										type="hidden" name="userId" value="${ userId }"> <input
										type="submit" value="Edit">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>