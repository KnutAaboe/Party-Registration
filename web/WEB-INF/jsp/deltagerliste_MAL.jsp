<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>

		<c:forEach var="deltager" items="${deltagere}" varStatus="loop">
			<tr bgcolor="${deltager.tlf == mob ? '#aaffaa' : '#ffffff'}" id="PersonNr${loop.index}">
				<td align="center">${deltager.kjonn == 'mann' ? '&#9794;' : '&#9792;'}</td> <!-- deltager.kjonn == "mann" ? "&#9794;" : "&#9792;"-->
				<th align="left">${deltager.fn} ${deltager.en}</th>
				<th align="left">${deltager.tlf}</th>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="/Dat108_%20Gr25_Obl3/loggut">Ferdig</a>
	</p>
</body>
</html>