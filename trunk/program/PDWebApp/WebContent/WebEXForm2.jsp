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
    <form action="form2Servlet" method="POST" enctype='multipart/form-data'>
        Numer Pesel: <input type="text" name="personalNum" size="11"><br>
        Płeć: <select name="sex">
			<option value="-1" selected>(proszę wybrać:)</option>
			<option value="0">Mężczyzna</option>
			<option value="1">Kobieta</option>
		</select><br>
        Wiek: <input type="text" name="age" size="3"><br>
        Plik z dźwiękiem: <input type="file" name="voiceFile"> 
        <br><br><br>
        <input type="submit" value="Analizuj">
    </form>
    <br><br>
    <a href="index.jsp">Powrót</a>
</body>
</html>