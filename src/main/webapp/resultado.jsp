<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="calculo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado</title>
<link rel="stylesheet" href="./Style.css" >
</head>
<body>

<section class="res">
	
	<h1>El area del triangulo es:</h1>
	
	<p><% double area = (double) request.getAttribute("AreaResuelta"); out.println(area);%><p>
	
	<h1>El perimetro del triangulo es:</h1>
	
	<p><% double perimetro = (double) request.getAttribute("PerimetroResuelto"); out.println(perimetro);%><p>
	
	
	<form action="index.jsp">
		<input type ="submit" value="Volver">
	</form>
	
	
	</section>
	

</body>
</html>