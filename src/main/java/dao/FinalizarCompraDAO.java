package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import com.oracle.wls.shaded.org.apache.regexp.recompile;

import beans.Imagen;
import conex.BDConex;

public class FinalizarCompraDAO {
	private BDConex bdConex;
	private DataSource ds;
	private Connection con;
	
	public FinalizarCompraDAO() throws ServletException {
		bdConex = new BDConex();
		ds = bdConex.getDs();
	}
	
	private static final String capitalize(String str) {

	      if (str == null || str.length() == 0) return str;

	      return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

	  }
	public int IdMasGrande() {
		String sql = "select max(idCompra) from compra";
		int id=0;
		try {
			con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
	        if(rs.next()) {
	        	id=rs.getInt("max(idCompra)");
	        }
	        rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void CrearCompra(int idUsuario, double total) {
		int idCompra=IdMasGrande();
		if(idCompra==0) {
			idCompra=1;
		}
		else {
			idCompra+=1;
		}
		String sql = "INSERT INTO compra (idCompra, fecha, id_usuario)VALUES (?,sysdate(), ?, ?);";
		try {
			con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idCompra);
			ps.setInt(2, idUsuario);
			ps.setDouble(3, total);
			ps.executeUpdate();
            ps.close();
            con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void CrearLineaPedido( int cantidad, int id_juego) {
		int idCompra=IdMasGrande();
		String sql = "INSERT INTO lineapedido (cantidad, id_juego, id_compra )VALUES ( ?, ?, ? );";
		try {
			con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cantidad);
			ps.setInt(2, id_juego);
			ps.setInt(3, idCompra);
			ps.executeUpdate();
			
            ps.close();
            con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	
}
