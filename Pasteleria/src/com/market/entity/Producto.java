package com.market.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.market.control.Conexion;
import com.market.view.ReadTypes;

public class Producto {
	
	private int idProducto;
	private String nombre;
	private double precio;
	private int cantidad;
	private Date fechaElaboración;
	private Date fechaVencimiento;
	private int idCategoria;
	
	
		
	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int IdProducto) {
		this.idProducto = IdProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int Cantidad) {
		this.cantidad = Cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaElaboración() {
		return fechaElaboración;
	}

	public void setFechaElaboración(Date fechaElaboración) {
		this.fechaElaboración = fechaElaboración;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public boolean es(int codigo){
		return this.idProducto == codigo;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
		
		return "Producto [idProducto=" + idProducto + ",cantidad=" + cantidad +",  nombre=" + nombre + ", precio=" + precio
				+ ", fechaElaboración=" + formato.format(fechaElaboración) + ", fechaVencimiento=" + formato.format(fechaVencimiento) + "]";
	}
	
	public void insert(){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Insert into `producto` ("
				+ "`nombre`,"
				+ " `precio`,"
				+ " `fechaElaboracion`, "
				+ " `fechaVencimiento`,"
				+ " `cantidad`,"
				+ " `categoria`) "
				+ " values(?,?,?,?,?,?); ";
		
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, nombre);
			conexion.getSentencia().setDouble(2, precio);
			conexion.getSentencia().setDate(3, ReadTypes.cASqlDate(fechaElaboración));
			conexion.getSentencia().setDate(4, ReadTypes.cASqlDate(fechaVencimiento));
			conexion.getSentencia().setInt(5, cantidad);
			conexion.getSentencia().setInt(6, idCategoria);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void update(Producto producto){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "Update producto "
				+ " set nombre = ?, "
				+ " precio = ?, "
				+ " fechaElaboracion = ?, "
				+ " fechaVencimiento = ?, "
				+ " cantidad = ?, "
				+ "	categoria = ? "
				+ "	where idProducto = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, producto.getNombre());
			conexion.getSentencia().setDouble(2, producto.getPrecio());
			conexion.getSentencia().setDate(3, ReadTypes.cASqlDate(producto.getFechaElaboración()));
			conexion.getSentencia().setDate(4, ReadTypes.cASqlDate(producto.getFechaVencimiento()));
			conexion.getSentencia().setInt(5, producto.getCantidad());
			conexion.getSentencia().setInt(6, producto.getIdCategoria());
			conexion.getSentencia().setInt(7, producto.getIdProducto());
			conexion.modificacion();
			conexion.close();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void search(int codigo){
		String sql;
		ResultSet resultados;
		Conexion conexion = new Conexion();
		sql = " Select "
				+ "idProducto,"
				+ "nombre, "
				+ "precio, "
				+ "cantidad, "
				+ "fechaElaboracion, "
				+ "fechaVencimiento, "
				+ "categoria "
				+ "from producto "
				+ "where producto.idProducto = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				setIdProducto(resultados.getInt("idProducto"));
				setNombre(resultados.getString("nombre"));
				setPrecio(resultados.getDouble("precio"));
				setCantidad(resultados.getInt("cantidad"));
				setFechaElaboración(resultados.getDate("fechaElaboracion"));
				setFechaVencimiento(resultados.getDate("fechaVencimiento"));
				setIdCategoria(resultados.getInt("idCategoria"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(int codigo){
		String sql;
		Conexion conexion = new Conexion();
		
		sql = "delete from producto "
				+ "where idProducto = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			conexion.modificacion();
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList <Producto> list(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto producto;
		ResultSet resultados;
		String sql;
		
		Conexion conexion = new Conexion();
		sql = "Select * from producto ";
		try {
			conexion.consulta(sql);
			resultados = conexion.resultado();
			
			while (resultados.next()){
				producto = new Producto();
				producto.setIdProducto(resultados.getInt("idProducto"));
				producto.setNombre(resultados.getString("nombre"));
				producto.setPrecio(resultados.getDouble("precio"));
				producto.setFechaElaboración(resultados.getDate("fechaElaboracion"));
				producto.setFechaVencimiento(resultados.getDate("fechaVencimiento"));
				producto.setCantidad(resultados.getInt("cantidad"));
				producto.setIdCategoria(resultados.getInt("idCategoria"));
				
				productos.add(producto);
			}
			
			conexion.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return productos;
	}
}