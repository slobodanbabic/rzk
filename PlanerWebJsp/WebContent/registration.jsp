<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registracija korisnika</title>
</head>
<body>
	<form action="/PlanerWebJsp/RegistrationServlet" method="post">
		<table>
			<tr>
				<td>Ime</td>
				<td><input type="text" name="firstName" id="firstName"></td>
			</tr>
			<tr>
				<td>Prezime</td>
				<td><input type="text" name="lastName" id="lastName"></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
			<tr>
				<td>Lozinka</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Registruj se" name="button" /></td>
			<tr>
		</table>
	</form>
</body>
</html>