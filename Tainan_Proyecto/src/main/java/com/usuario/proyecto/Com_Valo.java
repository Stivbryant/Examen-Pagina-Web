package com.usuario.proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usuario.datos.Conexion;

public class Com_Valo {
	private String cedula;
	private String comentario;
	private int valoracion;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public String ingresarVal_Com(String cedula,  String comentario,int valoracion)
	{
		String result="";
		Conexion con=new Conexion();
		PreparedStatement us=null;
		String sql="INSERT INTO tb_com_val (comentario,"
				+ "valoracion,cedula) "
				+ "VALUES(?,?,?)";
		try{
			us=con.getConexion().prepareStatement(sql);
			us.setString(3, cedula);
			us.setString(1,comentario);
			us.setInt(2,valoracion);				
			if(us.executeUpdate()==1)
			{
				result="Valoracion y Comentario Registrado";
					
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
	public String consultarVal_Com()
	{
		String sql="SELECT * FROM tb_com_val ORDER BY cedula";
		Conexion con=new Conexion();
		String tabla="<table border=2>"
				+ "<th>Cedula</th>"
				+ "<th>Comentario</th>"
				+ "<th>Valoracion</th>";
				
		ResultSet rs=null;
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				tabla+="<tr><td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(1)+"</td>"
						+ "<td>"+rs.getInt(2)+"</td>"
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
	public String mostrarVal_Com()
	{
		String combo="<select name=cmbCom_Val>";
		String sql="SELECT * FROM tb_com_val";
		ResultSet rs=null;
		Conexion cone=new Conexion();
		try
		{
			rs=cone.Consulta(sql);
			while(rs.next())
			{
				combo+="<option value="+rs.getString(1)+ ">"+rs.getInt(2)+"</option>";
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
