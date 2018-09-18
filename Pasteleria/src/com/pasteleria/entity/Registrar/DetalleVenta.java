package com.pasteleria.entity.Registrar;
import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class DetalleVenta {
	private int codigoVenta;
	private int codigoProducto;
	private double precio;
	private int cantidad;
	
	private MiLeer miLeer;
	private Locale locale;
	
	public DetalleVenta()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.codigoVenta = 0;
		this.codigoProducto = 0;
		this.precio = 0.00;
		this.cantidad = 0;
	}
	
	public DetalleVenta(int codigoVenta, int codigoProducto, double precio, int cantidad)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		
		this.codigoVenta = codigoVenta;
		this.codigoProducto = codigoProducto;
		this.precio = precio;
		this.cantidad = cantidad;
	
	}
	
	public void mostrarDatos ()
	{
		if(this.codigoVenta != 0)
		{
			System.out.println("Detalle Venta:");
			System.out.println("\tVenta" + this.codigoVenta);
			System.out.println("\tProducto" + this.codigoProducto);
			System.out.println("\tPrecio" + this.precio);
			System.out.println("\tCantidad" + this.cantidad);

			
		}
		
	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos de Detalles de Venta");
		
		this.codigoVenta = miLeer.entero("\tVenta: ", codigoVenta, codigoVenta);
		this.codigoProducto = miLeer.entero("\tProducto: ", codigoProducto, codigoProducto);
		this.precio = miLeer.decimal("\tPrecio: ", 0.00, 500.00);
		this.cantidad = miLeer.entero("\tCantidad: ", 0, 50);
		
	}
	
	public int getVenta() {
		return codigoVenta;
	}

	public void setVenta(int Venta) {
		this.codigoVenta = Venta;
	}
	public int getProducto()
	{
		return codigoProducto;
	}
	public void setProducto(int Producto)
	{
		this.codigoProducto = Producto;
	}
	public double getPrecio()
	{
		return precio;
	}
	public void setPrecio(double Precio)
	{
		this.precio = Precio;
	}
	public int getCantidad()
	{
		return cantidad;
	}
	public void setCantidad(int Cantidad)
	{
		this.cantidad = Cantidad;
	}
	/*public boolean equals(Object o)
	{
		DetalleVenta dv = (DetalleVenta) o;
		return (this.codigoDetalleVenta == dv.getCodigo());
	}
	public boolean escodigoDetalleVenta(int codigo)
	{
		return (this.codigoDetalleVenta == codigo);
	}
	*/
	public void insert(Conexion conex) throws SQLException
	{
		conex.abrir();
		
		String query = "INSERT INTO DetalleVentas";
		query +=       " SET codigoVenta = '" + this.getVenta() + "',";
		query +=	   " codigoProducto = '" + this.getProducto() + "',";
		query +=	   " precio = '" + this.getPrecio() + "',";
		query +=       " cantidad = '" + this.getCantidad() + "' ";
		
		
		conex.insert(query);
		conex.cerrar();
		
		System.out.println("Registro Exitoso!");

		
	}

}

