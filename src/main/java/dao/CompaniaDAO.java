package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import beans.Compania;
import beans.Imagen;
import beans.Usuario;
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
	private static final String capitalize(String str) {

	      if (str == null || str.length() == 0) return str;

	      return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

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
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		String sql = "select usuario.idUsuario, usuario.nombre, usuario.apellidos, usuario.admin, imagen.ruta from usuario, imagen where imagen.idImagen=usuario.id_imagen;";
		try {
			con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            	int idUsuario=rs.getInt("usuario.idUsuario");
            	String nombre=capitalize(rs.getString("usuario.nombre"));
            	String apellidos=capitalize(rs.getString("usuario.apellidos"));
            	int admin= rs.getInt("usuario.admin");
            	String ruta=rs.getString("imagen.ruta");
            	Imagen img= new Imagen(0, ruta);
            	Usuario u= new Usuario();
            	u.setAdminInt(admin);
            	u.setNombre(nombre);
            	u.setIdUser(idUsuario);
            	u.setApellidos(apellidos);
            	u.setImg(img);
            	usuarios.add(u);
            }
            
            rs.close();
            st.close();
            con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return usuarios;
	}



}


