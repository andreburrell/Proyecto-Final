package com.pasteleria.entity.Registrar;
import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;

import com.pasteleria.control.Conexion;
public class Cliente {
	private String NIT;
	private String nombreCliente;
	
	private MiLeer miLeer;
	private Locale locale;
	
	public Cliente()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.NIT = "";
		this.nombreCliente = "";
	}
	
	public Cliente(String NIT, String nombreCliente)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		
		this.NIT = NIT;
		this.nombreCliente = nombreCliente;
	
	}
	
	public void mostrarDatos ()
	{
		if(this.NIT != "")
		{
			System.out.println("Cliente:");
			System.out.println("\tNIT" + this.NIT);
			System.out.println("\tNombre" + this.nombreCliente);

			
		}
		
	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos del Cliente");
		
		this.NIT = miLeer.texto("\tNIT: ",miLeer.NOT_NULL);
		this.nombreCliente = miLeer.texto("\tNombre: ",miLeer.NOT_NULL);
		
	}
	
	public void setNIT(String nit)
	{
		this.NIT = nit;
		
	}
	
	public void setNombre(String Nombre) {
		this.nombreCliente = Nombre;
	}
	
	public String getNIT()
	{
	
		return this.NIT;
	}
	
	public String getNombre()
	{
		return this.nombreCliente;
	}
	
	public boolean equals(Object o)
	{
	
		Cliente c = (Cliente) o;
		return (this.NIT == c.getNIT());
	}
	
	public boolean esNIT(String nit)
	{
		return (this.NIT == nit);
	}
	
	public void insert(Conexion conex) throws SQLException
	{
		
		
		String query = "INSERT INTO Cliente";
		query +=       " SET NIT = '" + this.getNIT() + "',";
		query +=       " nombreCliente = '" + this.getNombre() + "' ";
		
		
		
		
		System.out.println("Registro Exitoso!");

		
	
}
		}

