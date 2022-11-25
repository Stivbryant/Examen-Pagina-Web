<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.usuario.proyecto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORMULARIO</title>
<link href="css/formulario.css" rel="stylesheet" type="text/css">
</head>
<body>
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
</header><!-- / #main-header -->
<br></br><br></br><br></br>
<p>Registro de usuarios</p>
 <form action="preguntas.jsp" method="post">	   
<table border="0">
				<tr>
				<td>Cedula</td>
				<td><input type="char" name="cedula"   required/>*</td>
				</tr>				
						
				<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre"  required/>*</td>
				</tr>
				<tr>
				<td>Apellido</td>
				<td><input type="text" name="apellido"   required/>*</td>
				</tr>	
				
				<tr>
				<td>Correo Electronico</td>
				<td><input type="email" name="txtemail" required/>*</td>
				</tr>
	
				<tr>
				<td>Contraseña</td>
				<td><input type="password" name="contraseña"  minlength="5" required/>*</td>
				</tr>
				
				<tr>
				<td>Estado Civil</td>
				<td><select name="cmbCivil">
					<option value="Soltero">Soltero</option>
					<option value="Casado">Casado</option>
					<option value="Divorciado">Divorciado</option>
					<option value="Viudo">Viudo</option>				
				</select></td>
				</tr>
				<tr>
				<td>Fecha </td>
				<td><input type="datetime-local" name="fecha"  required/>*</td>
				</tr>
				<tr>
				<td>Foto </td>
				<td><input type="file" name="foto"  required/>*</td>
				</tr>
														
				<tr>
				<td><br><input type="submit" value="REGISTRAR"/><td/><br>
				<input type="reset" value="BORRAR"/><br>
				</tr>
				</table>
</form>

<br></br><br></br><br></br><br></br><br></br>
<footer id="main-footer">
<ul>
		<li>
		<a href="https://www.facebook.com/profile.php?id=100004943611752">
		<img src="imagenes/facebook.png" width="40" height="20"/>
		</a>
		</li>
		<li>
		<a href="https://www.instagram.com/stivenm_2001/"> 
		<img src="imagenes/instagram.png" width="40" height="20"/>		
		</a>
		</li>
		<li>
		<a href=https://twitter.com/BryanMu05281680>
		<img src="imagenes/twitter.png" width="40" height="20"/>		
		</a>
		</li>
	    </ul>

	</footer><!-- / #main-footer -->
</body>
</html>