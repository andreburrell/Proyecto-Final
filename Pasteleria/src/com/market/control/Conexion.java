package com.market.control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	
	private Connection conn = null;
	private PreparedStatement sentencia = null;
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://localhost/Pasteleria";

	public Conexion() {

		String USER = "root";
		String PASS = "";
		try {
			
			Class.forName(JDBC_DRIVER);
			System.out.println("Conectando a la base de datos...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void consulta(String sql) throws Throwable {
		sentencia = conn.prepareStatement(sql);
	}

	public ResultSet resultado() throws Throwable {
		return sentencia.executeQuery();
	}
	
	public int modificacion() throws Throwable {
		return sentencia.executeUpdate();
		
	}
	
	public void close() throws SQLException {
		if (sentencia != null) {
			sentencia.close();
		}
		
		if (conn != null) {
			conn.close();
		}
	}

	public PreparedStatement getSentencia() {
		return sentencia;
	}
}

