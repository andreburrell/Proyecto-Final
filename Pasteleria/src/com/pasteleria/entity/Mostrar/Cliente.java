package com.pasteleria.entity.Mostrar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class Cliente {
	
	private String NIT;
	private String nombreCliente;
	
	private Locale locale;
	private MiLeer miLeer;
	
	
	public Cliente()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.NIT = "";
	}
	public Cliente(String NIT)
	{
		locale = Locale.forLanguageTag("es-BO");
		
		this.NIT = NIT;
	}
	
	public Cliente(String NIT, Conexion conex) throws SQLException
	{
		miLeer = new MiLeer();
		locale = Locale.forLanguageTag("es-BO");
		
		conex.abrir();
		
		String query = 	"SELECT *  ";
		query += 	   	"FROM  	Cliente ";
		query +=		"WHERE	NIT = " + this.NIT;
		
		ResultSet rs = conex.select(query);
		
		if (rs.next())
		{
			this.NIT = rs.getString(1);
			this.nombreCliente = rs.getString(2);
			
		}
		conex.cerrar();
		
	}
	
	public void mostrar() throws SQLException, ClassNotFoundException
	{
		Conexion conex2 = new Conexion ( "localhost",   
				"pasteleria",  
				"root",  		  
				"");	
		
		miLeer = new MiLeer();
		locale = Locale.forLanguageTag("es-BO");
		
		conex2.abrir();
		
		String query = 	"SELECT cliente.NIT, cliente.nombreCliente";
		query +=		" FROM cliente ";
		query +=		"WHERE NIT = " + this.NIT;
		
		ResultSet rs = conex2.select(query);
		
		if (rs.next())
		{
			System.out.println("");
			System.out.println("-Detalles del Cliente-");
			System.out.println(" NIT del Cliente: " + rs.getString(1));
			System.out.println(" Nombre: " + rs.getString(2));
			
		}
		else
		{
			System.out.println("");
			System.out.print("El Cliente No Existe");
			System.exit(0);
		}
		conex2.cerrar();
	}
	public void leerNIT()
	{
		System.out.println("Ingrese el NIT del Cliente");
		this.NIT = miLeer.texto("\tNIT: ", miLeer.NOT_NULL);
	}
	public void setNIT (String NIT)
	{
		this.NIT = NIT;
	}
	public String getNIT(String NIT)
	{
		return this.NIT;
	}

}

