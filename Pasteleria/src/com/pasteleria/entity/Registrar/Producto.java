package com.pasteleria.entity.Registrar;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class Producto {
	private int codigoProducto;
	private String nombre;
	private LocalDate fechaVencimiento;
	private int stock;
	
	private MiLeer miLeer;
	private Locale locale;
	
	public Producto()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.codigoProducto = 0;
		this.nombre = "";
		this.fechaVencimiento = null;
		this.stock = 0;
		
	}
	
	public Producto(int codigoProducto, String nombre, int day, int month, int year, int stock)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		
		this.codigoProducto = codigoProducto;
		this.nombre = nombre;
		this.fechaVencimiento = LocalDate.of(year, month, day);
		this.stock = stock;
		
	}
	
	public void mostrarDatos ()
	{
		if(this.codigoProducto != 0)
		{
			System.out.println("Compra:");
			System.out.println("\tNombre" + this.nombre);
			System.out.println("\tVencimiento" + this.fechaVencimiento);
			System.out.println("\tStock" + this.stock);

		}
	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos del Producto");
		
		this.nombre = miLeer.texto("\tNombre: ", miLeer.NOT_NULL);
		this.stock = miLeer.entero("\tStock: ", 0, 500);
		
		System.out.println("Fecha de Vencimiento: ");
		int day1 = miLeer.entero("\tDia: ", 1, 31);
		int month1 = miLeer.entero("\tMes: ", 1, 12);
		int year1 = miLeer.entero("\tAño: ", 2017, 2017);
		this.fechaVencimiento = LocalDate.of(year1, month1, day1);
		
	
	}
	public int getProducto()
	{
		return codigoProducto;
	}
	public void setNombre(String Nombre)
	{
		this.nombre = Nombre;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setVencimiento(LocalDate Vencimiento)
	{
		this.fechaVencimiento = Vencimiento;
	}
	public LocalDate getVencimiento()
	{
		return fechaVencimiento;
	}
	public void setStock(int Stock)
	{
		this.stock = Stock;
	}
	public int getStock()
	{
		return stock;
	}
	public boolean equals(Object o)
	{
	
		Producto p = (Producto) o;
		return (this.codigoProducto == p.getProducto());
	}
	
	public boolean escodigoProducto(int codigo)
	{
		return (this.codigoProducto == codigo);
	}
	
	public void insert(Conexion conex) throws SQLException
	{
		conex.abrir();
		
		String query = "INSERT INTO Producto";
		query +=	   " SET nombre = '" + this.getNombre() + "',";
		query += 	   " fechaVencimiento = '" + this.getVencimiento() + "', ";
		query +=	   " stock = '" + this.getStock() + "' ";
		
		conex.insert(query);
		conex.cerrar();
		
		System.out.println("Registro Exitoso!");

	}

}
