package com.pasteleria.entity.Registrar;
import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class Empleado {
	
	private String CI;
	private String nombreEmpleado;
	private int telefonoEmpleado;
	private String direccionEmpleado;
	
	private MiLeer miLeer;
	private Locale locale;
	
	public Empleado()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.CI = "";
		this.nombreEmpleado = "";
		this.telefonoEmpleado = 0;
		this.direccionEmpleado = "";
	}
	
	public Empleado(String CI, String nombreEmpleado, int telefonoEmpleado, String direccionEmpleado)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		
		this.CI = CI;
		this.nombreEmpleado = nombreEmpleado;
		this.telefonoEmpleado = telefonoEmpleado;
		this.direccionEmpleado = direccionEmpleado;
	
	}
	
	public void mostrarDatos ()
	{
		if(this.CI != "")
		{
			System.out.println("Empleado:");
			System.out.println("\tCI" + this.CI);
			System.out.println("\tNombre" + this.nombreEmpleado);
			System.out.println("\tTelefono" + this.telefonoEmpleado);
			System.out.println("\tDireccion" + this.direccionEmpleado);

			
		}
		
	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos del Empleado");
		
		this.CI = miLeer.texto("\tCI: ",miLeer.NOT_NULL);
		this.nombreEmpleado = miLeer.texto("\tNombre: ",miLeer.NOT_NULL);
		this.telefonoEmpleado = miLeer.entero("\tTelefono: ", telefonoEmpleado, telefonoEmpleado);
		this.direccionEmpleado = miLeer.texto("\tDireccion: ", miLeer.NOT_NULL);
		
	}
	public void setCI(String CI)
	{
		this.CI = CI;
	}
	public String getCI()
	{
		return this.CI;
	}
	public void setNombre(String Nombre) {
		this.nombreEmpleado = Nombre;
	}
	
	public String getNombre()
	{
		return this.nombreEmpleado;
	}
	
	public void setDireccion(String Direccion)
	{
		this.direccionEmpleado = Direccion;
	}
	
	public String getDireccion()
	{
		return this.direccionEmpleado;
	}
	
	public void setTelefono(int Telefono)
	{
		this.telefonoEmpleado = Telefono;
	}
	
	public int getTelefono()
	{
		return this.telefonoEmpleado;
	}
	
	public boolean equals(Object o)
	{
	
		Empleado e = (Empleado) o;
		return (this.CI == e.getCI());
	}
	
	public boolean esCI(String ci)
	{
		return (this.CI == ci);
	}
	
	public void insert(Conexion conex) throws SQLException
	{
		conex.abrir();
		
		String query = "INSERT INTO Empleado";
		query +=       " SET CI = '" + this.getCI() + "',";
		query +=       " nombreEmpleado = '" + this.getNombre() + "', ";
		query += 	   " telefonoEmpleado = '" + this.getTelefono() + "', ";
		query += 	   " direccionEmpleado = '" + this.getDireccion() + "' ";
		
		
		conex.insert(query);
		conex.cerrar();
		
		System.out.println("Registro Exitoso!");

		
	}

}

