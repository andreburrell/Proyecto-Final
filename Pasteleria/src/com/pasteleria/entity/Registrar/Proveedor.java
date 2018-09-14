package com.pasteleria.entity.Registrar;

import java.sql.SQLException;
import java.util.Locale;

import com.pasteleria.control.MiLeer;
import com.pasteleria.control.Conexion;

public class Proveedor {
	private int codigoProveedor;
	private String nombre;
	private String empresa;
	private int telefono;
	
	private MiLeer miLeer;
	private Locale locale;
	
	public Proveedor()
	{
		locale = Locale.forLanguageTag("es-BO");
		miLeer = new MiLeer();
		
		this.codigoProveedor = 0;
		this.nombre = "";
		this.empresa = "";
		this.telefono = 0;
		
	}
	
	public Proveedor(int codigoProveedor, String empresa, 
						int telefono, String nombre)
	{
		locale = Locale.forLanguageTag("es-BO");
		 
		
		this.codigoProveedor = codigoProveedor;
		this.nombre = nombre;
		this.empresa = empresa;
		this.telefono = telefono;
		
	
	}
	
	public void mostrarDatos ()
	{
		if(this.codigoProveedor != 0)
		{
			System.out.println("Proveedor:");
			System.out.println("\tNombre" + this.nombre);
			System.out.println("\tEmpresa" + this.empresa);
			System.out.println("\tTelefono" + this.telefono);
			
		}
		
	}
	
	public void leerDatos ()
	{
		System.out.println("Ingrese los Datos del Proveedor");
		
		this.nombre = miLeer.texto("\tNombre: ",miLeer.NOT_NULL);
		this.empresa = miLeer.texto("\tEmpresa: ", miLeer.NOT_NULL);
		this.telefono = miLeer.entero("\tTelefono: ", 0, 50);
			
	}

	public int getCodigo() {
		return codigoProveedor;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setEmpresa(String Empresa)
	{
		this.empresa = Empresa;
	}
	
	public String getEmpresa()
	{
		return this.empresa;
	}
	
	public void setTelefono(int Telefono)
	{
		this.telefono = Telefono;
	}
	
	public int getTelefono()
	{
		return this.telefono;
	}
	
	public boolean equals(Object o)
	{
	
		Proveedor pr = (Proveedor) o;
		return (this.codigoProveedor == pr.getCodigo());
	}
	
	public boolean esCodigo(int codigo)
	{
		return (this.codigoProveedor == codigo);
	}
	
	public void insert(Conexion conex) throws SQLException
	{
		conex.abrir();
		
		String query = "INSERT INTO Proveedor";
		query +=       " SET nombre = '" + this.getNombre() + "', ";
		query +=       " empresa = '" + this.getEmpresa() + "', ";
		query +=       " telefono = '" + this.getTelefono() + "' ";
			
		
		conex.insert(query);
		conex.cerrar();
		
		System.out.println("Registro Exitoso!");


	}

}
