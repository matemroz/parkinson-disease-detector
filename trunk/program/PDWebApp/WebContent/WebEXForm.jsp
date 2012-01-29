<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formularz detekcji choroby Parkinsona</title>
</head>
<body>
	<h1>Formularz detekcji choroby Parkinsona</h1>
    <form action="pDDetectorFormServlet" method="POST" enctype='multipart/form-data'>
        <table>
        <tr><td>Numer Pesel: </td><td><input type="text" name="personalNum" size="11"></td></tr>
        <tr><td>Płeć: </td><td><select name="sex">
			<option value="-1" selected>(proszę wybrać:)</option>
			<option value="0">Mężczyzna</option>
			<option value="1">Kobieta</option>
		</select></td></tr>
        <tr><td>Wiek: </td><td><input type="text" name="age" size="3"></td></tr>
        <tr><td>Plik z dźwiękiem: </td><td><input type="file" name="voiceFile"></td></tr> 
        <tr><td></td><td><input type="submit" value="Analizuj"></td>
        </table>
    </form>
</body>
</html>