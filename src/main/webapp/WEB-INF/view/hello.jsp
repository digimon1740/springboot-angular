<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>CMS Manager | Login</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="font-awesome/css/font-awesome.css" rel="stylesheet">

	<link href="css/animate.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
	<div>
		<div>
			<h1 class="logo-name">CMS</h1>
		</div>
		<%--<h3>Welcome to IN+</h3>--%>
		<%--<p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.--%>
		<%--<!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->--%>
		<%--</p>--%>
		<%--<p>Login in. To see it in action.</p>--%>
		<form class="m-t" role="form" method="post" action="/login">
			<div class="form-group">
				<input type="text" name="username" class="form-control" placeholder="Username" required="">
			</div>
			<div class="form-group">
				<input type="password" name="password" class="form-control" placeholder="Password" required="">
			</div>
			<button type="submit" class="btn btn-primary block full-width m-b">Login</button>

			<%--<a href="#"><small>Forgot password?</small></a>--%>
			<%--<p class="text-muted text-center"><small>Do not have an account?</small></p>--%>
			<%--<a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>--%>
		</form>
		<p class="m-t"> <small>관리자외 접근을 차단합니다.
			불법 접근시 추적정보가 기록되며,<br>법적 처벌이 가해질 수 있습니다</small> </p>
	</div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-2.1.1.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>

</html>
