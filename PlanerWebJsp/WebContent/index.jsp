<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${ message}
	<form action="/PlanerWebJsp/LoginServlet" method="post">
		<table>
			<tr>
				<td>username</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Prijavi se" name="button" /></td>
			</tr>

			<tr>
				<td><a href="registration.jsp">Registracija</a></td>
			</tr>
		</table>
	</form>
</body>
</html>