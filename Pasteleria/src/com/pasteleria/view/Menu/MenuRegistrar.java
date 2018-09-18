package com.pasteleria.view.Menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.pasteleria.control.Conexion;
import com.pasteleria.entity.Registrar.Cliente;
import com.pasteleria.entity.Registrar.Compra;
import com.pasteleria.entity.Registrar.DetalleVenta;
import com.pasteleria.entity.Registrar.Empleado;
import com.pasteleria.entity.Registrar.Inventario;
import com.pasteleria.entity.Registrar.Produccion;
import com.pasteleria.entity.Registrar.Producto;
import com.pasteleria.entity.Registrar.Proveedor;
import com.pasteleria.entity.Registrar.Receta;
import com.pasteleria.entity.Registrar.Venta;

public class MenuRegistrar {


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
		System.out.println("@>>>>>>>>>>>>... PASTELERIA   ...<<<<<<<<<<<<@");
		System.out.println("@>>>>>>>>>>>.... BIENVENIDOS ....<<<<<<<<<<<<@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	}
	
	public void menuPrincipal()
	{
		System.out.println("----------------------------");
		System.out.println("1. Registrar Cliente");
		System.out.println("2. Registrar Compra");
		System.out.println("3. Registrar Detalle de Venta");
		System.out.println("4. Registrar Empleado");
		System.out.println("5. Registrar Iventario");
		System.out.println("6. Registrar Produccion");
		System.out.println("7. Registrar Producto");
		System.out.println("8. Registrar Proveedor");
		System.out.println("9. Registrar Receta");
		System.out.println("10. Registrar Venta");
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
			System.out.println(".......... GRACIAS POR SU COMPRA ...........");
			System.exit(0);
			break;
		case 1:
			
			//Registrar un cliente
			Cliente c;
			
			Conexion conex1 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			c = new Cliente(); 
			c.leerDatos();
			c.insert(conex1);
			
			menuPrincipal();
			break;
		case 2:
			
			//Registar una compra del proveedor
			Compra co;
			
			Conexion conex2 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			co = new Compra(); 
			co.leerDatos();
			co.insert(conex2);
			
			menuPrincipal();
			break;
			
		case 3:
			
			//Registrar el detalle de una venta
			DetalleVenta dv;
			
			Conexion conex3 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			dv = new DetalleVenta(); 
			dv.leerDatos();
			dv.insert(conex3);
			
			menuPrincipal();	
			break;
		case 4:
			
			//Registrar un empleado
			Empleado e;
			
			Conexion conex4 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			e = new Empleado(); 
			e.leerDatos();
			e.insert(conex4);
			
			menuPrincipal();
			break;
		case 5:

			Inventario i;
			
			Conexion conex5 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			i = new Inventario();
			i.leerDatos();
			i.insert(conex5);
			break;
		case 6:
			
			//Registrar la produccion
			Produccion pro;
			
			Conexion conex6 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			pro = new Produccion(); 
			pro.leerDatos();
			pro.insert(conex6);
			
			menuPrincipal();
			break;
		case 7:

			Producto p;
			
			Conexion conex7 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			p = new Producto();
			p.leerDatos();
			p.insert(conex7);
			break;
		case 8:
			
			//Registrar un proveedor
			Proveedor pr;
			
			Conexion conex8 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			pr = new Proveedor(); 
			pr.leerDatos();
			pr.insert(conex8);
			
			menuPrincipal();
			break;
		case 9:
	
			//Registrar una receta
			Receta r;
	
			Conexion conex9 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
	
			r = new Receta(); 
			r.leerDatos();
			r.insert(conex9);
	
			menuPrincipal();
			break;
		case 10:
			
			Venta v;
			
			Conexion conex10 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			v = new Venta();
			v.leerDatos();
			v.insert(conex10);
			
			menuPrincipal();
			break;
	}
	}




}
