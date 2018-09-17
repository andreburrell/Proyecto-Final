package com.pasteleria.view.Menu;

import java.sql.SQLException;

import com.pasteleria.control.Conexion;
import com.pasteleria.view.Menu.Menu;

public class Pantalla {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		Pantalla p = new Pantalla();
		p.correr();
	}
	
	public void correr() throws ClassNotFoundException, SQLException
	{
		Conexion conex = new Conexion("localhost",
										"pasteleria",
										"root",
										"");
		conex.abrir();
		
		Menu m = new Menu();
		m.ejecutarMenu();
		
		
	}

}
