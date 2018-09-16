package com.pasteleria.entity.Actualizar;

import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class Empleado {
	private String CI;
	private String nombreEmpleado;
	private int telefonoEmpleado;
	private String direccionEmpleado;
	
	private MiLeer mileer;
	private Locale locale;
	
	public Empleado()
	{
		locale = Locale.forLanguageTag("es*BO");
		mileer = new MiLeer();
		
		this.CI = "";
		this.nombreEmpleado = "";
		this.telefonoEmpleado = 0;
		this.direccionEmpleado = "";
		
	}
	
	public Empleado (String CI, String nombreEmpleado, int telefonoEmpleado, String direccionEmpleado)
	{
		locale = Locale.forLanguageTag("es*BO");
		
		this.CI = CI;
		this.nombreEmpleado = nombreEmpleado;
		this.telefonoEmpleado = telefonoEmpleado;
		this.direccionEmpleado = direccionEmpleado;
		
	}
	
	public void leerDatos() throws SQLException, ClassNotFoundException
	{
		conexion conex = new conexion ( "localhost",   
					"tripcake's & more",  
					"root",  		  
					"");	 
		
		
		System.out.println("Ingrese el CI del CLiente");
		this.CI = mileer.texto("\tCI: ", mileer.NOT_NULL);
		System.out.println("Ingrese el nuevo nombre del Empleado");
		this.nombreEmpleado = mileer.texto("\tNombre: ", mileer.NOT_NULL);
		System.out.println("Ingrese el nuevo numero de Telefono");
		this.telefonoEmpleado = mileer.entero("\tTelefono: ", 0, 500);
		System.out.println("Ingrese la nueva direccion");
		this.direccionEmpleado = mileer.texto("\tDireccion: ", mileer.NOT_NULL);
		
	
	}
	
	public void mostrar()
	{
		System.out.println("Datos Actualizados del Empleado:");
		System.out.println("\tCI: " + this.CI);
		System.out.println("\tNombre Empleado: " + this.nombreEmpleado);
		System.out.println("\tTelefono: " + this.telefonoEmpleado);
		System.out.println("\tDireccion: " + this.direccionEmpleado);
	}
	
	public void setCI(String CI)
	{
		this.CI = CI;
	}
	public String getCI()
	{
		return this.CI;
	}
	public void setNombre(String Nombre)
	{
		this.nombreEmpleado = Nombre;
	}
	public String getNombre()
	{
		return this.nombreEmpleado;
	}
	public void setTelefono(int Telefono)
	{
		this.telefonoEmpleado = Telefono;
	}
	public int getTelefono()
	{
		return this.telefonoEmpleado;
	}
	public void setDireccion(String Direccion)
	{
		this.direccionEmpleado = Direccion;
	}
	public String getDireccion()
	{
		return this.direccionEmpleado;
	}
	public boolean equals(Object o)
	{
		Empleado e = (Empleado) o;
		return (this.CI == e.getCI() && this.nombreEmpleado == e.getNombre() 
				&& this.telefonoEmpleado == e.getTelefono() 
				&& this.direccionEmpleado == e.getDireccion());
	}
	public boolean esCI(String CI, String nombreEmpleado, int telefonoEmpleado, String direccionEmpleado)
	{
		return (this.CI == CI && this.nombreEmpleado == nombreEmpleado 
				&& this.telefonoEmpleado == telefonoEmpleado 
				&& this.direccionEmpleado == direccionEmpleado);
	}
	public void insertar(conexion conex) throws SQLException
	{
		try
		{
		conex.abrir();
		
		String query = 		"UPDATE empleado ";
		query +=			" SET nombreEmpleado = '" + this.getNombre() + "'";
		query +=			" AND telefonoEmpleado = '" + this.getTelefono() + "'";
		query +=			" AND direccionEmpleado =" + this.getDireccion() + "'";
		query +=			"WHERE CI = '" + this.getCI() + "'";
		
		conex.insert(query);
		
		System.out.println("");
		System.out.println("Datos del Empleado Modificados");
		
		conex.cerrar();
		}
		catch (SQLException e)
		{
			System.out.println("");
			System.out.println("El Empleado no Existe");
			
		}
	}

}
