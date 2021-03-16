<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Upload Employee</title>
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
</style>
</head>
<body class="container">
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
			<span class="custom-title-span">Upload Employee Details</span>
		</h5>
		<div class="m-4">
			<form action="upload" method="post">
				<div class="row mt-3 mb-3 justify-content-md-center">
					<label for="emp_name" class="col-sm-2 col-form-label">Employee
						Name: </label>
					<div class="col-sm-10 col-md-6">
						<input type="text" class="form-control" id="emp_name"
							name="emp_name" required maxlength="100">
					</div>
				</div>
				<div class="row mt-3 mb-3 justify-content-md-center">
					<label for="loc" class="col-sm-2 col-form-label">Location:
					</label>
					<div class="col-sm-10 col-md-6">
						<input type="text" class="form-control" id="loc" name="loc"
							required maxlength="500">
					</div>
				</div>
				<div class="row mt-3 mb-3 justify-content-md-center">
					<label for="email" class="col-sm-2 col-form-label">Email: </label>
					<div class="col-sm-10 col-md-6">
						<input type="email" class="form-control" id="email" name="email"
							required maxlength="100">
					</div>
				</div>
				<div class="row mt-3 mb-3 justify-content-md-center">
					<label for="dob" class="col-sm-2 col-form-label">Date of
						Birth: </label>
					<div class="col-sm-10 col-md-6">
						<input type="date" class="form-control" id="dob" name="dob"
							required>
					</div>
				</div>
				<input type="hidden" name="userId" value="${ userId }">
				<div class="d-grid gap-2 d-md-flex justify-content-md-center">
					<button class="btn btn-outline-dark btn-block" type="submit">Save</button>
					<button class="btn btn-outline-dark btn-block" type="reset">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>