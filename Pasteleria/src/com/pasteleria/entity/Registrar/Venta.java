package com.pasteleria.entity.Registrar;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class Venta {
	private int codigoVenta;
	private LocalDate Fecha;
	private String CI;
	private String NIT;
	
	private MiLeer miLeer;
	private Locale locale;
	
	public Venta()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.codigoVenta = 0;
		this.Fecha = null;
		this.CI = "";
		this.NIT = "";
		
	}
	
	public Venta(int codigoVenta, int day, int month, int year, String CI, String NIT)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		
		this.codigoVenta = codigoVenta;
		this.Fecha = LocalDate.of(year, month, day);
		this.CI = CI;
		this.NIT = NIT;
	
	}
	
	public void mostrarDatos ()
	{
		if(this.codigoVenta != 0)
		{
			System.out.println("Venta:");
			System.out.println("\tFecha" + this.Fecha);
			System.out.println("\tEmpleado" + this.CI);
			System.out.println("\tCliente" + this.NIT);

			
		}
		
	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos de Venta");
		
		this.CI = miLeer.texto("\tEmpledo: ", miLeer.NOT_NULL);
		this.NIT = miLeer.texto("\tCliente: ", miLeer.NOT_NULL);
				
		System.out.println("Fecha de Vencimiento ");
		int day = miLeer.entero("\tDia: ", 1, 31);
		int month = miLeer.entero("\tMes: ", 1, 12);
		int year = miLeer.entero("\tAño: ", 2017, 2017);
		this.Fecha = LocalDate.of(year, month, day);
		
		
	}

	public int getCodigo()
	{
		return codigoVenta;
	}
	public void setFecha(LocalDate Fecha)
	{
		this.Fecha = Fecha;
	}
	public LocalDate getFecha()
	{
		return Fecha;
	}
	public String getCI()
	{
		return CI;
	}
	public void setCI(String CI)
	{
		this.CI = CI;
	}
	public String getNIT()
	{
		return NIT;
	}
	public void setNIT(String NIT)
	{
		this.NIT = NIT;
	}
	public boolean equals(Object o)
	{
	
		Venta v = (Venta) o;
		return (this.codigoVenta == v.getCodigo());
	}
	
	public boolean esCodigo(int codigo)
	{
		return (this.codigoVenta == codigo);
	}
	
	public void insert(Conexion conex) throws SQLException
	{
		conex.abrir();
		
		String query = "INSERT INTO Venta";
		query +=       " SET Fecha = '" + this.getFecha() + "',";
		query += 	   " CI = '" + this.getCI() + "',";
		query += 	   " NIT = '" + this.getNIT() + "' ";
		
		
		conex.insert(query);
		conex.cerrar();
		
		System.out.println("Registro Exitoso!");

		
	}


}
