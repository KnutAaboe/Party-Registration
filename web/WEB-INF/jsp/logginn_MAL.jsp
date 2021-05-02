<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<script  src="js/LoggInn.js" defer></script>
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p>Det er kun registrerte deltagere som får se deltagerlisten.</p>
	<p>
		<font color="red" id="error"></font>
	</p>
	<form method="post" id="form" class="pure-form pure-form-aligned" action="/Dat108_%20Gr25_Obl3/logginn">
		<fieldset>
			<div class="pure-control-group">
				<label for="mobil">Mobil:</label> <input type="text" id="mob" name="mobil" />
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input type="password" id="pass" name="passord" />
			</div>
			<div class="pure-controls">
				<button type="submit" id="sub" class="pure-button pure-button-primary">Logg
					inn</button>
			</div>
		</fieldset>
	</form>

</body>
</html>