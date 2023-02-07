package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import beans.Compania;
import beans.Imagen;
import conex.BDConex;

public class CompaniaDAO {
	private BDConex bdConex;
	private DataSource ds;
	private Connection con;

	// con = ds.getConnection();
	
	public CompaniaDAO() throws ServletException {
		bdConex = new BDConex();
		ds = bdConex.getDs();
	}
	
	public Compania obtenerCompaniaPorId(int id) {
		Compania compania = null;
		String sql = "SELECT * FROM compania where idCompania = ?";
		try {
			con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
            if (rs.next())
            	compania = new Compania(id, rs.getString("nombre"), rs.getString("enlaceOficial"));
            rs.close();
            ps.close();
            con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return compania;
	}
}
