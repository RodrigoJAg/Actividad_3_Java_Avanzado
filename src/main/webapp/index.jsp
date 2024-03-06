<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="control.*" %>
 <%@ page import="java.util.*" %>
 
 <%@taglib prefix="sesion" uri="/WEB-INF/tlds/sesion.tld" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actividad 3 Java Avanzado Rodrigo Aguilar 2902637</title>
<link rel="stylesheet" href="./Style.css">
</head>
<body>
	
	<main class="contenedor">
		<section class="ap">
		
		
		<div>
		<% HttpSession sesion = request.getSession(false); 
		
		if (sesion.getAttribute("Username") == null){%> 
		<form action="mostrar" class="area" method="post">
 				   
				<h1>Calcula el area y perimetro del triangulo</h1>
				<p>Altura triangulo</p>
				<input type="text" name="Altura" value="">
				<p>Base triangulo</p>
				<input type="text" name="Base" value=""> <br>
				<input type="submit" value="Calcular">
				
			</form>
		<%
		
		Cookie ck[] = request.getCookies();
		for(int i = 0; i < ck.length; i++){
			if(ck[i].getName().equals("a")){
				out.println("Calculo anterior: " + ck[i].getValue() + " + ");
			}	if(ck[i].getName().equals("b")){
				out.println(ck[i].getValue() + " = ");
			}	if(ck[i].getName().equals("resultadoA")){
				out.println("Area: " + ck[i].getValue() + " Y ");
			}	if(ck[i].getName().equals("resultadoP")){
				out.println("Perimetro: " + ck[i].getValue());
			}
			}
		%>
		<form action="./Register.jsp"><input type="submit" value="Ingresar"></form>
		
		<%}else{%>
		<form action="mostrarUserCache" class="area" method="post">
 				   
				<h1>Calcula el area y perimetro del triangulo</h1>
				<p>Altura triangulo</p>
				<input type="text" name="Altura" value="">
				<p>Base triangulo</p>
				<input type="text" name="Base" value=""> <br>
				<input type="submit" value="Calcular">
				<input type="hidden" name ="Username" value="<%=sesion.getAttribute("Username")  %>">
				
			</form>
			<p><%out.println("Hola! " + sesion.getAttribute("Username") + "\n"); %></p>
		<%
		Enumeration e = sesion.getAttributeNames();
		
		if(e.hasMoreElements()){
			out.println("Calculo anterior: ");
			out.println("Altura: " + sesion.getAttribute("a"));
			out.println(" + Base: " + sesion.getAttribute("b"));
			out.println(" = Area: " + sesion.getAttribute("resultadoA"));
			out.println(" Perimetro " + sesion.getAttribute("resultadoP"));
		} sesion.removeAttribute("Username");%>
		<form action="./index.jsp"><input type="submit" value="Salir"></form>
		<%} %>
		
		</div>
			
		</section>
		
	</main>
</body>
</html>