<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<title>Flight Search App</title>
<style>
.center_div {
	margin: 0 auto;
	width: 60%;
}

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

.label-weight {
	font-weight: 500;
	background-color: #EBEBEC;
}
</style>
</head>
<body class="container">
	<header>
		<div class="mb-5"></div>
	</header>
	<div class="custom-border">
		<h5 class="custom-title">
			<span class="custom-title-span">Login In</span>
		</h5>
		<div class="m-4">
			<form action="SignIn" method="post" style="margin-top: 50px;">
				<div class="row mb-3 justify-content-md-center">
					<label for="userId" class="col-sm-2 col-form-label">UserName</label>
					<div class="col-sm-10 col-md-6">
						<input type="text" id="userId" name="userId" class="form-control"
							required minlength="5" maxlength="50">
					</div>
				</div>
				<div class="row mb-3 justify-content-md-center">
					<label for="password" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10 col-md-6">
						<input type="password" id="password" name="password"
							class="form-control" required minlength="5" maxlength="50">
					</div>
				</div>
				<div class="col-md-12 text-center">
					<button class="btn btn-primary" type="submit">Login</button>
				</div>
			</form>
			<br>
		</div>
	</div>
</body>
</html>