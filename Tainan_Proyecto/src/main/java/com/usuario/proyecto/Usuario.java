package com.usuario.proyecto;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import com.usuario.datos.Conexion;

public class Usuario {
	
		
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String contraseña;
	private String estado;
	private String fecha;
	private String foto;


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEdad() {
		return email;
	}

	public void setEdad(String edad) {
		this.email = edad;
	}
	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}




	public String consultarUsuarios()
	{
		String sql="SELECT * FROM tb_usuarios ORDER BY cedula";
		Conexion con=new Conexion();
		String tabla="<table border=2><th>Cedula</th><th>Nombre</th><th>Apellido</th><th>Email</th><th>Contraseña</th><th>Estado</th><th>Fecha</th><th>Foto</th>";
		ResultSet rs=null;
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				tabla+="<tr><td>"+rs.getString(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getString(5)+"</td>"
						+ "<td>"+rs.getString(6)+"</td>"
						+ "<td>"+rs.getString(7)+"</td>"
						+ "<td>"+rs.getString(8)+"</td>"
						+ "</td></tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla+="</table>";
		return tabla;
	}
	public String ingresarUsuario(String cedula, String nombre, String apellido,String email,String contraseña,String estado,String fecha,String foto)
	{
		String result="";
		Conexion con=new Conexion();
		PreparedStatement us=null;
		String sql="INSERT INTO tb_usuarios (cedula,nombre,"
				+ "apellido,email,contraseña,estado,fecha,foto) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try{
			us=con.getConexion().prepareStatement(sql);
			us.setString(1,cedula);
			us.setString(2,nombre);
			us.setString(3,apellido);
			us.setString(4,email);
			us.setString(5,contraseña);
			us.setString(6,fecha);
			us.setString(7,estado);
			us.setString(8,foto);
			if(us.executeUpdate()==1)
			{
				result=
					"Usuario Ingresado " + nombre + apellido;
			}
			else
			{
				result="Error en inserción";
			}
		}
		catch(Exception ex)
		{
			result=ex.getMessage();
		}
		finally
		{
			try
			{
				us.close();
				con.getConexion().close();
			}
			catch(Exception ex)
			{
				System.out.print(ex.getMessage());
			}
		}
		return result;
	}
	public String mostrarUsuario()
	{
		String combo="<select name=cmbUsuario>";
		String sql="SELECT * FROM tb_usuarios";
		ResultSet rs=null;
		Conexion cone=new Conexion();
		try
		{
			rs=cone.Consulta(sql);
			while(rs.next())
			{
				combo+="<option value="+rs.getString(1)+ ">"+rs.getString(2)+"</option>";
			}
			combo+="</select>";
		}
		catch(SQLException e)
		{
			System.out.print(e.getMessage());
		}
		return combo;
	}


	
	


	

}
