package com.pasteleria.entity.Registrar;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;


public class Compra {
	private int codigoProveedor;
	private int codigoInventario;
	private double precio;
	private double cantidad;
	private LocalDate fecha;
	private LocalDate fechaVencimiento;
	
	private MiLeer miLeer;
	private Locale locale;
	
	public Compra()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.codigoProveedor = 0;
		this.codigoInventario = 0;
		this.precio = 0.00;
		this.cantidad = 0.00;
		this.fecha = null;
		this.fechaVencimiento = null;
	}
	
	public Compra(int codigoProveedor, int day, int month, int year, int codigoInventario, 
					double precio, double cantidad)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		
		this.codigoProveedor = codigoProveedor;
		this.codigoInventario = codigoInventario;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fecha = LocalDate.of(year, month, day);
		this.fechaVencimiento = LocalDate.of(year, month, day);
	}
	
	public void mostrarDatos ()
	{
		
			System.out.println("Compra:");
			System.out.println("\tProveedor" + this.codigoProveedor);
			System.out.println("\tInventario" + this.codigoInventario);
			System.out.println("\tPrecio" + this.precio);
			System.out.println("\tCantidad" + this.cantidad);
			System.out.println("\tFecha" + this.fecha);
			System.out.println("\tVencimiento" + this.fechaVencimiento);

	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos de la Compra");
		
		this.codigoProveedor = miLeer.entero("\tProveedor: ", codigoProveedor, codigoProveedor);
		this.codigoInventario = miLeer.entero("\tInventario: ", codigoInventario, codigoInventario);
		this.precio = miLeer.decimal("\tPrecio: ", 0.00, 500.00);
		this.cantidad = miLeer.decimal("\tCantidad: ", 0.00, 500.00);
		
		System.out.println("Fecha de Compra: ");
		int day = miLeer.entero("\tDia: ", 1, 31);
		int month = miLeer.entero("\tMes: ", 1, 12);
		int year = miLeer.entero("\tAño: ", 2017, 2017);
		this.fecha = LocalDate.of(year, month, day);
		
		System.out.println("Fecha de Vencimiento: ");
		int day1 = miLeer.entero("\tDia: ", 1, 31);
		int month1 = miLeer.entero("\tMes: ", 1, 12);
		int year1 = miLeer.entero("\tAño: ", 2017, 2017);
		this.fechaVencimiento = LocalDate.of(year1, month1, day1);
		
		
	}

	public int getProveedor() {
		return codigoProveedor;
	}
	public void setProveedor(int Proveedor)
	{
		this.codigoProveedor = Proveedor;
	}
	
	public double getPrecio()
	{
		return precio;
	}
	
	public void setPrecio(double Precio)
	{
		this.precio = Precio;
	}
	
	public void setFecha(LocalDate Fecha) {
		this.fecha = Fecha;
	}
	
	public LocalDate getFecha()
	{
		return fecha;
	}
	public int getInventario()
	{
		return codigoInventario;
	}
	public void setInventario(int Inventario)
	{
		this.codigoInventario = Inventario;
	}
	public void setVencimiento(LocalDate Vencimiento) {
		this.fecha = Vencimiento;
	}
	
	public LocalDate getVencimiento()
	{
		return fechaVencimiento;
	}
	public double getCantidad()
	{
		return cantidad;
	}
	public void setCantidad(double Cantidad)
	{
		this.cantidad = Cantidad;
	}
	
	/*public boolean equals(Object o)
	{
	
		Compra co = (Compra) o;
		return (this.codigoCompra == co.getCompra());
	}
	
	public boolean escodigoCompra(int codigo)
	{
		return (this.codigoCompra == codigo);
	}
	*/
	public void insert(Conexion conex) throws SQLException
	{
		conex.abrir();
		
		String query = "INSERT INTO Compra";
		query +=	   " SET codigoProveedor = '" + this.getProveedor() + "',";
		query +=	   " codigoInventario = '" + this.getInventario() + "',";
		query +=	   " precio = '" + this.getPrecio() + "',";
		query +=	   " cantidad = '" + this.getCantidad() + "',";
		query +=       " fecha = '" + this.getFecha() + "',";
		query += 	   " fechaVencimiento = '" + this.getVencimiento() + "' ";
		
		
		conex.insert(query);
		conex.cerrar();
		
		System.out.println("Registro Exitoso!");

		
	
	}

}