package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import beans.Compania;
import beans.Imagen;
import beans.Usuario;
import beans.VideoJuego;
import conex.BDConex;

public class JuegosDAO {
	private BDConex bdConex;
	private DataSource ds;
	private Connection con;

	
	public JuegosDAO() throws ServletException {
		bdConex = new BDConex();
		ds = bdConex.getDs();
	}
	
	public ArrayList<VideoJuego> juegosBBDD() {
		ArrayList<VideoJuego> arrVideojuegos = new ArrayList<VideoJuego>();
		String sql = "SELECT * FROM videojuegos";
		try {
			con = ds.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	int idJuego = rs.getInt("idJuego");
            	String titulo = rs.getString("titulo");
            	String descripcion = rs.getString("descripcion");
            	String trailer = rs.getString("trailer");
            	double precio = rs.getDouble("precio");
            	/* Compañia */
            	CompaniaDAO cDao = new CompaniaDAO();
            	Compania compania = cDao.obtenerCompaniaPorId(rs.getInt("id_compania"));
            	/* Imágenes */
            	ImagenDAO imgDao = new ImagenDAO();
            	Imagen imgCover = imgDao.obtenerImagenPorId(rs.getInt("id_imgCover"));
            	Imagen imgCoverMobile = imgDao.obtenerImagenPorId(rs.getInt("id_imgCoverMobile"));
            	Imagen imgBanner =  imgDao.obtenerImagenPorId(rs.getInt("id_imgBanner"));
            	/* Plataformas */
            	PlataformaDAO pDao = new PlataformaDAO();
            	/* Crear Juego */
            	VideoJuego juego = new VideoJuego(idJuego, titulo, descripcion, trailer, precio, compania, imgCover, imgCoverMobile, imgBanner,
            			pDao.obtenerPlataformasPorIdJuego(idJuego));
            	arrVideojuegos.add(juego);
            }
            rs.close();
            st.close();
            con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		return arrVideojuegos;
	}
}
