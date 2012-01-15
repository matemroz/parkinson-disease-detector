<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formularz obsługi środków na koncie</title>
</head>
<body>
	<h1>Formularz obsługi środków na koncie</h1>
    <form action="accountOperationServlet" method="POST">
        Imię: <input type="text" name="imie" size="20"><br>
        Środki: <input type="text" name="srodki" size="20"><br>
        <br><br>
        <input type="submit" value="Wpłać">
    </form>
    <br><br>
    <a href="index.jsp">Powrót</a>
</body>
</html>