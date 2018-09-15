package com.pasteleria.view.Menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.pasteleria.control.Conexion;

public class Menu {
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
		System.out.println("------PANTALLA PRINCIPAL------");
		System.out.println("1. Registrar");
		System.out.println("2. Actualizar");
		System.out.println("3. Mostrar");
		System.out.println("4. Salir");

		
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
			
			MenuRegistrar mr;
			
			Conexion conex1 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			mr = new MenuRegistrar(); 
			mr.ejecutarMenu();
			break;
			
		/*case 2:
			
			MenuActualizar ma;
			
			Conexion conex2 = new conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			ma = new MenuActualizar(); 
			ma.ejecutarMenu();
			break;
			
		case 3:
			
			MenuMostrar mm;
			
			Conexion conex3 = new Conexion( "localhost",   
					"pasteleria",  
					"root",  		  
					"");	
			
			mm = new MenuMostrar(); 
			mm.ejecutarMenu();
			break;*/
			}
		}

}
