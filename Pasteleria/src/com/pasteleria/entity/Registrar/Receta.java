package com.pasteleria.entity.Registrar;
import java.sql.SQLException;
import java.util.Locale;
import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

	public class Receta {
		private int codigoProducto;
		private int codigoInventario;
		private double cantidad;
		
		private MiLeer miLeer;
		private Locale locale;
		
		public Receta()
		{
			locale = Locale.forLanguageTag("es-BO");
			miLeer = new MiLeer();
			
			this.codigoProducto = 0;
			this.codigoInventario = 0;
			this.cantidad = 0.00;
		}
		
		public Receta(int codigoProducto, int codigoInventario, double cantidad)
		{
			locale = Locale.forLanguageTag("es-BO");
			 
			
			this.codigoProducto = codigoProducto;
			this.codigoInventario = codigoInventario;
			this.cantidad = cantidad;
		}
		
		public void mostrarDatos ()
		{
			
				System.out.println("Receta:");
				System.out.println("\tProducto" + this.codigoProducto);
				System.out.println("\tInventario" + this.codigoInventario);
				System.out.println("\tCantidad" + this.cantidad);
				
		}
		
		public void leerDatos ()
		{
			System.out.println("Ingrese los Datos de la Receta");
			
			this.codigoProducto = miLeer.entero("\tProveedor: ", codigoProducto, codigoProducto);
			this.codigoInventario = miLeer.entero("\tInventario: ", codigoInventario, codigoInventario);
			this.cantidad = miLeer.decimal("\tCantidad: ", 0.00, 500.00);		
			
		}

		public int getProducto() {
			return codigoProducto;
		}
		public void setProducto(int Producto)
		{
			this.codigoProducto = Producto;
		}
		
		public int getInventario()
		{
			return codigoInventario;
		}
		public void setInventario(int Inventario)
		{
			this.codigoInventario = Inventario;
		}
		public double getCantidad()
		{
			return cantidad;
		}
		public void setCantidad(double Cantidad)
		{
			this.cantidad = Cantidad;
		}
		public void insert(Conexion conex) throws SQLException
		{
			conex.abrir();
			
			String query = "INSERT INTO Receta";
			query +=	   " SET codigoProducto = '" + this.getProducto() + "',";
			query +=	   " codigoInventario = '" + this.getInventario() + "',";
			query +=	   " cantidad = '" + this.getCantidad() + "' ";
					
			conex.insert(query);
			conex.cerrar();
			
			System.out.println("Registro Exitoso!");
			
		
		}


	}


