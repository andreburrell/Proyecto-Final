package com.pasteleria.view.Menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.pasteleria.control.Conexion;
import com.pasteleria.entity.Actualizar.Cliente;
import com.pasteleria.entity.Actualizar.Empleado;

public class MenuActualizar {

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
		System.out.println("1. Actualizar Cliente");
		System.out.println("2. Actualizar Empleado");
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
			c.insertar(conex1);
			c.mostra();
			
			menuPrincipal();
			break;
		case 2:
			
			//Actualizar un empleado
			Empleado e;
			
			Conexion conex2 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			e = new Empleado(); 
			e.leerDatos();
			e.insertar(conex2);
			e.mostrar();
			
			menuPrincipal();
			break;
		}
	}

	
}
