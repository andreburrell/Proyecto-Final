package com.pasteleria.view.Menu;
import java.sql.SQLException;
import java.util.Scanner;

import com.pasteleria.control.Conexion;
import com.pasteleria.entity.Mostrar.Cliente;
import com.pasteleria.entity.Registrar.Compra;
import com.pasteleria.entity.Mostrar.DetalleVentas;
import com.pasteleria.entity.Registrar.Empleado;
/*import com.pasteleria.entity.Registrar.Producto;
import com.pasteleria.entity.Registrar.Proveedor;
import com.pasteleria.entity.Registrar.Receta;
import com.pasteleria.entity.Registrar.Venta;*/
public class MenuMostrar {
	
	public void ejecutarMenu() throws ClassNotFoundException, SQLException
	{
		Titulo();
		menuPrincipal();
		int opcion = getInput();
		accion(opcion);
	}
	
	
	public void Titulo()
	{
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@>>>>>>>>>...Pasteleria ...<<<<<<<<<<@");
		System.out.println("@>>>>>>>>>>>.... BIENVENIDOS ....<<<<<<<<<<<<@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	}
	
	public void menuPrincipal()
	{
		System.out.println("----------------------------");
		System.out.println("1. Mostrar Cliente");
		System.out.println("2. Mostrar Detalle de Venta");
		System.out.println("0. Salir");

		
	}
	
	private int getInput()
	{

		Scanner s = new Scanner(System.in);
		int opcion = -1;
		if (opcion < 0 || opcion > 1)
		{
			try
			{
				System.out.print("Ingrese su opcion: ");
				opcion = Integer.parseInt(s.nextLine());

			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalida Eleccion, intente de nuevo");
			}

		}
		else
		{
			System.out.println("Ingrese un numero correcto");
			return opcion;
		}

		return opcion;
	}
	
	public void accion(int opcion) throws ClassNotFoundException, SQLException
	{
		switch(opcion)   //Switch es para los casos que por cada numero representa un accion que se cumple
		{
		case 0:
			//Finalizar la Aplicacion
			System.out.println("... Gracias por usarnos esperamos un 100 ...");
			System.out.println(".......... by:  Andres Burrell  ..........");
			System.out.println("........... and  Paul Fernandez  ...........");
			System.exit(0);
			break;
			case 1: 
			
			//Registrar un cliente
			Cliente c;
			
			Conexion conex2 = new Conexion( "localhost",   
					"tripcake's & more",  
					"root",  		  
					"");	
			
			c = new Cliente();
			c.leerNIT();
			c.mostrar();
			break;
				
		case 2:
			
			//Registrar el detalle de una venta
			DetalleVentas dv;
			
			Conexion conex3 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			dv = new DetalleVentas(); 
			dv.leerDetalleVentas();
			dv.mostrar();
			
			menuPrincipal();	
			break;
		}}}