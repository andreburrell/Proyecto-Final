package com.pasteleria.entity.Mostrar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class DetalleVentas {
	private int codigoVenta;
	private int codigoProducto;
	private double precio;
	private int cantidad;
	
	private Locale locale;
	private MiLeer miLeer;
	
	
	public DetalleVentas()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.codigoVenta = 0;
		this.codigoProducto = 0;
	}
	public DetalleVentas(int codigoVenta, int codigoProducto)
	{
		locale = Locale.forLanguageTag("es-BO");
		
		this.codigoVenta = 0;
		this.codigoProducto = 0;
	}
	
	public DetalleVentas(int codigoVenta, int codigoProducto, Conexion conex) throws SQLException
	{
		miLeer = new MiLeer();
		locale = Locale.forLanguageTag("es-BO");
		
		conex.abrir();
		
		String query = 	"SELECT *  ";
		query += 	   	"FROM  	DetalleVentas ";
		query +=		"WHERE	codigoProducto = " + this.codigoProducto;
		query +=		"AND codigoVentas = " + this.codigoVenta;
		
		ResultSet rs = conex.select(query);
		
		if (rs.next())
		{
			this.codigoVenta = rs.getInt(1);
			this.codigoProducto = rs.getInt(2);
			this.precio = rs.getDouble(3);
			this.cantidad = rs.getInt(4);
			
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
		
		String query = 	"SELECT cliente.NIT, cliente.nombreCliente, venta.Fecha, producto.nombre, "
				+ "detalleventas.precio as 'Precio Individual',"
				+ " detalleventas.precio * detalleventas.cantidad as 'Total' ";
		query +=		" FROM cliente, venta, detalleventas, producto ";
		query +=		"WHERE cliente.NIT = venta.NIT";
		query +=		" AND venta.codigoVenta = detalleventas.codigoVenta";
		query +=		" AND detalleventas.codigoProducto = producto.codigoProducto";
		
		ResultSet rs = conex2.select(query);
		
		if (rs.next())
		{
			System.out.println("");
			System.out.println("-Detalles de la Venta-");
			System.out.println(" NIT del Cliente: " + rs.getString(1));
			System.out.println(" Nombre: " + rs.getString(2));
			System.out.println(" Fecha: " + rs.getDate(3));
			System.out.println(" Nombre del Poducto: " + rs.getString(4));
			System.out.println(" Precio Individual: " + rs.getDouble(5));
			System.out.println(" Total: " + rs.getDouble(5));
			
			
		}
		else
		{
			System.out.println("");
			System.out.print("El Cliente No Existe");
			System.exit(0);
		}
		conex2.cerrar();
	}
	public void leerDetalleVentas()
	{
		System.out.println("Ingrese el codigo de Venta");
		this.codigoVenta = miLeer.entero("\tVenta: ", codigoVenta, codigoVenta);
		System.out.println("Ingrese el codigo del Producto");
		this.codigoProducto = miLeer.entero("\tProducto: ", codigoProducto, codigoProducto);
		
	}
	public void setVenta (int Venta)
	{
		this.codigoVenta = Venta;
	}
	public int getVenta(int Venta)
	{
		return this.codigoVenta;
	}
	public void setProducto (int Producto)
	{
		this.codigoProducto = Producto;
	}
	public int getProducto(int Producto)
	{
		return this.codigoProducto;
	}


}

