<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.usuario.proyecto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EVALUACION Y COMENTARIO</title>
<link href="css/eva_comen.css" rel="stylesheet" type="text/css">
</head>
<body>
<main>
<header id="main-header">
	
	<a id="logo-header" href="#">
		<img src="imagenes/7.jpg" width="60" height="70">
	</a> <!-- / #logo-header -->
<nav>
	
<ul>
<li><a href="index.jsp">Inicio</a></li>
<li><a href="hospedaje.jsp">Hospedaje</a></li>
<li><a href="lugares.jsp">Lugares de Interés</a></li>
<li><a href="comida.jsp">Comida Típica</a></li>
<li><a href="ubicacion.jsp">Ubicación</a></li>
<li><a href="formulario.jsp">Formulario </a></li>
</ul>			
	</nav><!-- / nav -->
</header>	
	
<br><br>
<%
String cedula=request.getParameter("cedula");
String pre1=request.getParameter("pre1");
String pre2=request.getParameter("pre2");	
String pre3=request.getParameter("pre3");
String pre4=request.getParameter("pre4");
String pre5=request.getParameter("cmbSitio");

Registro registro=new Registro();
out.print(registro.ingresarPreguntas(cedula,pre1,pre2,pre3,pre4,pre5));
%>

<br><br>
<center><p>Evaluacion y Comentario </p></center>
<form action="resultados.jsp" method="post">	
<center>
<table border="1">
				<tr>
				<th>Cedula</th>
				<td><input type="char" name="cedula" value="<%=cedula %>"  required/>*</td>
				</tr>
				<tr>
				<center><th WIDTH="250" HEIGHT="50">Calificación<br><br><input type="range"  min="0" max="3" " name="valoracion"></th><br>
				</tr>
				
				<tr>
				<th><label for="comment">Comentario <span class="required" aria-hidden="true">*</span></label></th><br>
				</tr>
				<tr>
				<td><textarea id="comment" name="comentario" cols="45" rows="8" maxlength="65525" required="required"></textarea></td>
				</tr>
				<tr>
				<th><input type="submit" value="ENVIAR COMENTARIO " "/></th>
				</tr>
				
</table>
</center>
</form>


</body>
</html>