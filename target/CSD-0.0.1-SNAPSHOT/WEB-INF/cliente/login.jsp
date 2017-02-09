<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${path}/autentificar" method="post">
				<div class="panel-heading">
					csd - Login
				</div>
				
				<div class="panel-body">
					<label for="username"></label>
					<input id="username" name="username" class="form-control" required>
					
					<label for="password"></label>
					<input type="password" id="password" name="password" class="form-control" required>
				</div>
				
				<div class="panel-footer">
					<button id="btn-login" class="btn btn-primary">Entrar</button>
				</div>
				
				<input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}">
			</form>

</body>
</html>