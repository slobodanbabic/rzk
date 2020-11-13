<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home page</title>
	

	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	
	
	 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
	
	<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

	<script>
		$(document).ready(function() {
			$("input.timepicker").timepicker({
				timeFormat : 'HH:mm',
			});
		});
	</script>
</head>
<body>
	<div class="container-fluid">
	<h3 align="center">Dobro dosli u Planer!</h3>

	<form action="/PlanerWebJsp/SearchEvents">
		<table>
			<tr>
				<th>Prikaz obaveza</th>
			</tr>
			<tr>
				<td>Izaberite dautm</td>
				<td><input type="date" name="date"></td>
				<td><input type="submit" value="Pretrazi"></td>
			</tr>
		</table>
		<br>
		<c:if test="${!empty events}">
			<table border="1">
				<tr>
					<th>Tip obaveze</th>
					<th>Opis obaveze</th>
					<th>Datum</th>
					<th>Pocetak</th>
					<th>Kraja</th>
				</tr>
				<c:forEach items="${events}" var="event">
					<tr>
						<td>${event.eventType.name}</td>
						<td>${event.description}</td>
						<td><fmt:formatDate value="${event.fromDate}"
								pattern="MM-dd-yyyy" /></td>
						<td><fmt:formatDate value="${event.fromDate}" pattern="HH:mm" /></td>
						<td><fmt:formatDate value="${event.toDate}" pattern="HH:mm" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
	<br>
	<br>


	<form action="/PlanerWebJsp/CreateEventServlet" method="get">

		<table border="1">
			<tr>
				<th>Dodavanje nove obaveze</th>
			</tr>
			<tr>
				<td>Tip obaveze</td>
				<td><select name="eventType">
						<c:forEach items="${bean.getTypes() }" var="entry">
							<option value="${entry.key}">${entry.value }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Opis obaveze</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Datum</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td>Pocetak</td>
				<td><input type="text" class="timepicker" name="fromTime"></td>
			</tr>
			<tr>
				<td>Kraj</td>
				<td><input type="text" class="timepicker" name="toTime"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Sacuvaj"></td>
				<td>&nbsp;</td>
			</tr>
		</table>


	</form>
	<br>
	<br>
	<form action="/PlanerWebJsp/LogoutServlet" method="post">
		<input type="submit" value="Odjavi se">
	</form>
	</div>
</body>
</html>