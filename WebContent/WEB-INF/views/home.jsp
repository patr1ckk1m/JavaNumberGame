<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Great Number Game</title>
</head>
<body>
	<h1>Welcome to the great number game</h1>
	<h3>I am thinking of a number between 1 and 100</h3>
	<h3>Take a guess!</h3>
	<form action = "/NumberGame/index" method = "post">
		<input type = "text" name = "number">
		<input type = "submit" value = "Submit">
	</form>
	
	<h3>${randomsession}</h3>
</body>
</html>