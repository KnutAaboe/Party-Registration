<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<script src="js/paamelding.js" defer></script>
<title>Påmelding</title>
<!-- type="text/javascript" -->
</head>
<body>
	<h2>Påmelding</h2>
	<h3 id="err" style="color: red">${err}</h3>
	<form method="post" class="pure-form pure-form-aligned" id="paameldingForm" action="/Dat108_%20Gr25_Obl3/OB">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label>
				<input type="text" name="fornavn" id="fornavn" value="${fn}" />
				<font id="fornavnErr" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label>
				<input type="text" name="etternavn" id="etternavn" value="${en}" />
				<font id="etternavnErr" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label>
				<input type="text" name="mobil" id="mobil" value="${mob}" />
				<font id="mobilErr" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label>
				<input type="password" name="passord" id="passord" value="${pass}" />
				<font id="passordErr" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert" id="passordRepetert"
					value="${pass2}" />
				<font id="passordRepetertErr" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="kjønn">Kjønn:</label>
					<input type="radio" name="kjonn" value="mann"/>mann
					<input type="radio" name="kjonn" value="kvinne"/>kvinne
				<font id="kjonnErr" color="red"></font>
			</div>
			<div class="pure-controls">
				<button type="button" id="sub" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>

</body>
</html>