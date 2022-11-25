package com.usuario.proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usuario.datos.Conexion;

public class Registro {
	private String cedula;
	private String pre1;
	private String pre2;
	private String pre3;
	private String pre4;
	private String pre5;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	
	public String getPre1() {
		return pre1;
	}
	public void setPre1(String pre1) {
		this.pre1 = pre1;
	}
	public String getPre2() {
		return pre2;
	}
	public void setPre2(String pre2) {
		this.pre2 = pre2;
	}
	public String getPre3() {
		return pre3;
	}
	public void setPre3(String pre3) {
		this.pre3 = pre3;
	}
	public String getPre4() {
		return pre4;
	}
	public void setPre4(String pre4) {
		this.pre4 = pre4;
	}
	public String getPre5() {
		return pre5;
	}
	public void setPre5(String pre5) {
		this.pre5 = pre5;
	}
	
	public String ingresarPreguntas(String cedula, String pre1,String pre2,String pre3,String pre4,String pre5)
	{
		String result="";
		Conexion con=new Conexion();
		PreparedStatement us=null;
		String sql="INSERT INTO tb_registro_pre (cedula,pre_1,"
				+ "pre_2,pre_3,pre_4,pre_5) "
				+ "VALUES(?,?,?,?,?,?)";
		try{
			us=con.getConexion().prepareStatement(sql);
			us.setString(1,cedula);
			us.setString(2,pre1);
			us.setString(3,pre2);				
			us.setString(4,pre3);	
			us.setString(5,pre4);
			us.setString(6,pre5);
			if(us.executeUpdate()==1)
			{
				result=" Preguntas Registradas " ;
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
	public String consultarPreguntas()
	{
		String sql="SELECT * FROM tb_registro_pre ORDER BY cedula";
		Conexion con=new Conexion();
		String tabla="<table border=2>"			
				+ "<th>Cuál fue el propósito principal de tu visita</th>"
				+ "<th>Es clara la información de la página</th>"
				+ "<th>Encuentras nuestro sitio atractivo</th>"
				+ "<th>Tiene confianza en el sitio</th>"
				+ "<th>Recomendaría este sitio a tus amigos y familiares</th>"
				+ "<th>Cedula</th>";
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
	public String mostrarPreguntas()
	{
		String combo="<select name=cmbRegistro>";
		String sql="SELECT * FROM tb_registro_pre";
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
