package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import beans.Cliente;
import beans.Usuario;
import conex.BDConex;

public class ClienteDAO {

	private BDConex bdConex;
	private DataSource ds;
	private Connection con;
		
	public ClienteDAO() throws ServletException {
		bdConex = new BDConex();
		con = bdConex.getCon();
		ds = bdConex.getDs();
	}
	
	/* Método que devuelve un cliente pasandole el nombre y la contraseña*/
	public Usuario buscaCliente(String nombre, String password) {
		String sql = "SELECT * FROM clientes WHERE nombre = '" + nombre + "' AND password = '" + password +"'";
		Usuario cliente = null;
		/*try {
			con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            	cliente = new Usuario(rs.getInt("id"),
	            						nombre,
	            						password,
	            						rs.getString("domicilio"),
	            						rs.getString("codigopostal"),
	            						rs.getString("telefono"),
	            						rs.getString("email"));
            rs.close();
            st.close();
            con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} */
		return cliente;
	}
	
	/* Método que devuelve si existe un cliente pasandole el nombre */
	public boolean buscaCliente(String nombre) {
		boolean existe = false;
		String sql = "SELECT * FROM clientes WHERE nombre = '" + nombre + "'";
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
	
	/* Método que devuelve si existe un cliente pasandole el nombre */
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
	
	public boolean guardarCliente(Cliente c) {
		boolean guardado = false;
		String sql = "INSERT INTO clientes(id, nombre, password, domicilio, codigopostal, telefono, email) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = ds.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setInt(1, c.getId());
            st.setString(2, c.getNombre());
            st.setString(3, c.getPassword());
            st.setString(4, c.getDomicilio());
            st.setString(5, c.getCodigoPostal());
            st.setString(6, c.getTelefono());
            st.setString(7, c.getEmail());
            
            st.executeUpdate();
            guardado = true;
            
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error en metodo guardarCliente: " + ex);
        }
		
		return guardado;
	}
	
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
}
