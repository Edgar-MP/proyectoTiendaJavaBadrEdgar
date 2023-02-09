package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import beans.Imagen;
import beans.Usuario;
import conex.BDConex;

public class ClienteDAO {

	private BDConex bdConex;
	private DataSource ds;
	private Connection con;
		
	public ClienteDAO() throws ServletException {
		bdConex = new BDConex();
		ds = bdConex.getDs();
	}
	
	/* Método que devuelve un cliente pasandole el nombre y la contraseña*/
	public Usuario buscaCliente(String nombre, String password) {
		String sql = "SELECT * FROM usuario, imagen WHERE usuario.nombre = '"+nombre+"' AND usuario.password = '"+password+"' "
				+ "AND usuario.id_imagen = imagen.idImagen";
		Usuario user = null;
		try {
			/*
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, password);
			*/
			con = ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
            	/*  img user*/
            	Imagen img = new Imagen(rs.getInt("idImagen"), rs.getString("ruta"));
            	System.out.print(img);
            	/* Usuario */
            	user = new Usuario();
            	user.setIdUser(rs.getInt("idUsuario"));
            	user.setNombre(rs.getString("nombre"));
            	user.setApellidos(rs.getString("apellidos"));
            	user.setDesc(rs.getString("descripcion"));
            	user.setDir(rs.getString("direccion"));
            	user.setCp(rs.getString("codigoPostal"));
            	user.setProvincia(rs.getString("municipio"));
            	user.setPais(rs.getString("pais"));
            	user.setTlf(rs.getString("telefono"));
            	user.setEmail(rs.getString("email"));
            	user.setPassw(rs.getString("password"));
            	user.setAdmin(rs.getBoolean("admin"));
            	user.setImg(img);
            }
            rs.close();
            st.close();
            con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return user;
	}
	
	public void cambiarPassw(String username, String passw) {
		String sql = "UPDATE usuario SET password = ? WHERE nombre = ?";
		try {
			con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, passw);
			ps.setString(2, username);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* Método que devuelve si existe un cliente pasandole el nombre */
	public boolean buscaCliente(String nombre) {
		boolean existe = false;
		String sql = "SELECT * FROM usuario WHERE nombre = '" + nombre + "'";
		try {
			con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            	existe = true;
            rs.close();
            st.close();
            con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return existe;
	}
	
	//Método para introducir un nuevo usuario en la base de datos
	public boolean guardarCliente(Usuario u) {
		boolean guardado = false;
		String sql = "INSERT INTO usuario(nombre, apellidos, descripcion, direccion, codigoPostal, municipio, provincia, pais, telefono, email, password, admin, id_imagen) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		System.out.println(u.getCp());
        try {
            Connection con = ds.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
          st.setString(1, u.getNombre());
          st.setString(2, u.getApellidos());
          st.setString(3, u.getDesc());
          st.setString(4, u.getDir());
          st.setString(5, u.getCp());
          st.setString(6, u.getMunicipio());
          st.setString(7, u.getProvincia());
          st.setString(8, u.getPais());
          st.setString(9, u.getTlf());
          st.setString(10, u.getEmail());
          st.setString(11, u.getPassw());
          st.setInt(12, 0);
          if(u.getImg()==null) {
        	  st.setInt(13, 1);
          }
          else {
        	  st.setInt(13, u.getImg().getIdImagen());
          }
          st.executeUpdate();
          guardado = true;
            
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error en metodo guardarCliente: " + ex);
        }
		
		return guardado;
	}
	
	/* Método que devuelve si existe un cliente pasandole el nombre */
	/*
	public int cantClientesRegistrados() {
		String sql = "SELECT count(*) AS cantCli FROM clientes";
		int cantClientes = 0;
		try {
			con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
            	cantClientes = rs.getInt("cantCli");
            rs.close();
            st.close();
            con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cantClientes;
	}
	*/
	
	
	/*
	public boolean actualizarCliente(Cliente c) {
		boolean editado = false;
		String sql = "UPDATE clientes SET nombre = ?, pasword = ?, domicilio = ?, "
				+ "codigopostal = ?, telefono = ?, email = ?)";
        try {
            Connection con = ds.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ;
            st.setString(1, c.getNombre());
            st.setString(2, c.getPassword());
            st.setString(3, c.getDomicilio());
            st.setString(4, c.getCodigoPostal());
            st.setString(5, c.getTelefono());
            st.setString(6, c.getEmail());
            
            st.executeUpdate();
            editado = true;
            
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error en metodo actualizarCliente: " + ex);
        }
		
		return editado;
	}
	*/
}
