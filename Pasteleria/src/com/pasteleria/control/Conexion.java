package com.pasteleria.control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private String host;
	private final int PORT = 3306;
	private String dbName;
	private String uname;
	private String pwd;

	private Connection conn;

	public conexion(String host, 
			String dbName, 
			String uname, 
			String pwd) throws ClassNotFoundException
	{
		
		try 
		{
			Class.forName("org.mariadb.jdbc.Driver");  
		} 
		catch (ClassNotFoundException e) {
			System.out.println("\nNo se encontro instalado el Conector Java para MySQL.");
			throw (e);
		}

		this.host = host;
		this.dbName = dbName;
		this.uname = uname;
		this.pwd = pwd;
		
		System.out.println("Se enonctro instalado el Conector Java para MySQL");
		
	}
	
	public void abrir() throws SQLException
	{
		
		String url = "jdbc:mariadb://" + 
		             host + ":" +  
				     PORT + "/" + 
		             dbName;
		//System.out.println ("DB Connection URL: " + url);

		try 
		{
			conn = DriverManager.getConnection(url, uname, pwd);
			System.out.println("Conexión con la Base de Datos, establecida!");
		}
		catch (SQLException e)
		{
			System.out.println("Estado: " + e.getSQLState());
			if (e.getSQLState().equals("08S01"))
				System.out.println("\nNo se pudo establecer la conexion con el Servidor.");

			throw(e);
		}
		
	}

	public void cerrar() throws SQLException
	{
		
		conn.close();
		
	}

	public void insert(String query) throws SQLException
	{
		
		this.abrir();
		
		Statement s = null;

		// Crear el Statement
		try 
		{
			s = conn.createStatement();
		} 
		catch (SQLException e) 
		{
			throw(e);
		}

		// Ejecutar la Inserción
		try 
		{				
			//System.out.println ("QUERY: " + query);
			s.executeUpdate(query);
		}
		catch (SQLException e) 
		{
			throw(e);
		}
		this.cerrar();
	}
	public void update(String query) throws SQLException
	{
		
this.abrir();
		
		Statement s = null;

		// Crear el Statement
		try 
		{
			s = conn.createStatement();
		} 
		catch (SQLException e) 
		{
			throw(e);
		}

		// Ejecutar la Inserción
		try 
		{				
			//System.out.println ("QUERY: " + query);
			s.executeUpdate(query);
		}
		catch (SQLException e) 
		{
			throw(e);
		}
		this.cerrar();
		insert(query);
		
	}

	public void delete(String query) throws SQLException
	{
		
		insert(query);
		
	}

	public ResultSet select(String query) throws SQLException
	{
		this.abrir();
		
		Statement s = null;
		ResultSet rs = null;

		// Crear el Statement
		try
		{
			s = conn.createStatement();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			throw(e);
		}

		// Ejecutar la consulta
		try 
		{
			System.out.println("QUERY: " + query);
			rs = s.executeQuery(query);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			throw(e);
		}

		this.cerrar();
		
		return rs;
	}
}

