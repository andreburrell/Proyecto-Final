package com.pasteleria.entity.Registrar;
import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class Inventario {
	
	private int codigoInventario;
	private String nombre;
	private String unidad;
	private double cantidad;

	
	private MiLeer miLeer;
	private Locale locale;
	
	public Inventario()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.codigoInventario = 0;
		this.nombre = "";
		this.unidad = "";
		this.cantidad = 0.00;
		
	}
	
	public Inventario(int codigoInventario, String nombre, String unidad, double cantidad)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		
		this.codigoInventario = codigoInventario;
		this.nombre = nombre;
		this.unidad = unidad;
		this.cantidad = cantidad;
		
	
	}
	
	public void mostrarDatos ()
	{
		if(this.codigoInventario != 0)
		{
			System.out.println("Proveedor:");
			System.out.println("\tNombre" + this.nombre);
			System.out.println("\tUnidad" + this.unidad);
			System.out.println("\tCantidad" + this.cantidad);
			
		}
		
	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos del Inventario");
		
		this.nombre = miLeer.texto("\tNombre del Producto: ",miLeer.NOT_NULL);
		this.unidad = miLeer.texto("\tUnidad: ", miLeer.NOT_NULL);
		this.cantidad = miLeer.decimal("\tCantidad: ", 0.00, 200.00);
			
	}

	public int getCodigo() {
		return codigoInventario;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setUnidad(String Unidad)
	{
		this.unidad = Unidad;
	}
	
	public String getUnidad()
	{
		return this.unidad;
	}
	
	public void setCantidad(double Cantidad)
	{
		this.cantidad = Cantidad;
	}
	
	public double getCantidad()
	{
		return this.cantidad;
	}
	
	public boolean equals(Object o)
	{
	
		Inventario i = (Inventario) o;
		return (this.codigoInventario == i.getCodigo());
	}
	
	public boolean esCodigo(int codigo)
	{
		return (this.codigoInventario == codigo);
	}
	
	public void insert(Conexion conex) throws SQLException
	{
		conex.abrir();
		
		String query = "INSERT INTO Inventario";
		query +=       " SET nombre = '" + this.getNombre() + "', ";
		query +=       " unidad = '" + this.getUnidad() + "', ";
		query +=       " cantidad = '" + this.getCantidad() + "' ";
			
		
		conex.insert(query);
		conex.cerrar();
		
		System.out.println("Registro Exitoso!");


	}
	

}

