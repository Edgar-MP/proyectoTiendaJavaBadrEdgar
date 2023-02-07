package beans;

import java.sql.Date;

public class Compra {
	private int idCompra, idUsuario;
	private Date fecha;
	public Compra(int idCompra, int idUsuario, Date fecha) { 
		this.idCompra = idCompra;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
	}
}
