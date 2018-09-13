package com.pasteleria.entity.Actualizar;

import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class Cliente {
	private String NIT;
	private String nombreCliente;
	
	private MiLeer mileer;
	private Locale locale;
	
	public Cliente()
	{
		locale = Locale.forLanguageTag("es*BO");
		mileer = new MiLeer();
		
		this.NIT = "";
		this.nombreCliente = "";
		
	}
	
	public Cliente (String NIT, String nombreCliente)
	{
		locale = Locale.forLanguageTag("es*BO");
		
		this.NIT = NIT;
		this.nombreCliente = nombreCliente;
		
	}
	
	public void leerDatos() throws SQLException, ClassNotFoundException
	{
		Conexion conex = new Conexion ( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	 
		
		
		System.out.println("Ingrese el NIT del CLiente");
		this.NIT = mileer.texto("\tNIT: ", mileer.NOT_NULL);
		System.out.println("Ingrese el nuevo nombre del Cliente");
		this.nombreCliente = mileer.texto("\tNombre: ", mileer.NOT_NULL);
	
	}
	
	public void mostra()
	{
		System.out.println("Nombre del Cliente Nuevo");
		System.out.println("\tNIT: " + this.NIT);
		System.out.println("\tNombre CLiente: " + this.nombreCliente);
	}
	
	public void setNIT(String NIT)
	{
		this.NIT = NIT;
	}
	public String getNIT()
	{
		return this.NIT;
	}
	public void setNombre(String Nombre)
	{
		this.nombreCliente = Nombre;
	}
	public String getNombre()
	{
		return this.nombreCliente;
	}
	public boolean equals(Object o)
	{
		Cliente c = (Cliente) o;
		return (this.NIT == c.getNIT() && this.nombreCliente == c.getNombre());
	}
	public boolean esNIT(String NIT, String nombreCliene)
	{
		return (this.NIT == NIT && this.nombreCliente == nombreCliente);
	}
	public void insertar(Conexion conex) throws SQLException
	{
		try
		{
		conex.abrir();
		
		String query = 	"UPDATE cliente ";
		query+=			" SET nombreCliente = '" + this.getNombre() + "'";
		query+=			"WHERE NIT = '" + this.getNIT() + "'";
		
		conex.insert(query);
		
		System.out.println("");
		System.out.println("Nombre del Cliente Modificado");
		
		conex.cerrar();
		}
		catch (SQLException e)
		{
			System.out.println("");
			System.out.println("El CLiente no Existe");
			
		}
	}



}
