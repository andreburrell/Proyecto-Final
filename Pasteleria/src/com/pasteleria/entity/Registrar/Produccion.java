package com.pasteleria.entity.Registrar;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;
import com.pasteleria.control.Conexion;

public class Produccion {
	private int codigoProducto;
	private double cantidad;
	private LocalDate fecha;
	private String descripcion;
	
	private MiLeer miLeer;
	private Locale locale;
	
	public Produccion()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.codigoProducto = 0;
		this.cantidad = 0.00;
		this.fecha = null;
		this.descripcion = "";
	}
	
	public Produccion(int codigoProducto, double cantidad, int day, int month, int year, String descripcion)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.fecha = LocalDate.of(year, month, day);
		this.descripcion = descripcion;
	}
	
	public void mostrarDatos ()
	{
		
			System.out.println("Receta:");
			System.out.println("\tProducto" + this.codigoProducto);
			System.out.println("\tCantidad" + this.cantidad);
			System.out.println("\tFecha" + this.fecha);
			System.out.println("\tDescripcion" + this.descripcion);
	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos de la Receta");
		
		this.codigoProducto = miLeer.entero("\tProducto: ", codigoProducto, codigoProducto);
		this.cantidad = miLeer.decimal("\tCantidad: ", 0.00, 500.00);
		this.descripcion = miLeer.texto("\tDescripcion: ", miLeer.NOT_NULL);
		
		System.out.println("Fecha de Elaboracion: ");
		int day = miLeer.entero("\tDia: ", 1, 31);
		int month = miLeer.entero("\tMes: ", 1, 12);
		int year = miLeer.entero("\tAño: ", 2017, 2017);
		this.fecha = LocalDate.of(year, month, day);
		
	}

	public int getProducto() {
		return codigoProducto;
	}
	public void setProducto(int Producto)
	{
		this.codigoProducto = Producto;
	}
	public double getCantidad()
	{
		return cantidad;
	}
	public void setCantidad(double Cantidad)
	{
		this.cantidad = Cantidad;
	}
	public LocalDate getFecha()
	{
		return fecha;
	}
	public void setFecha(LocalDate Fecha)
	{
		this.fecha = Fecha;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void serDescripcion(String Descripcion)
	{
		this.descripcion = Descripcion;
	}
	public void insert(Conexion conex) throws SQLException
	{
		conex.abrir();
		
		String query = "INSERT INTO Produccion";
		query +=	   " SET codigoProducto = '" + this.getProducto() + "',";
		query +=	   " cantidad = '" + this.getCantidad() + "',";
		query += 	   " fecha = '" + this.getFecha() + "',";
		query +=	   " descripcion = '" + this.getDescripcion() + "' ";
				
		conex.insert(query);
		conex.cerrar();
		
		System.out.println("Registro Exitoso!");
		
	
	}

}
