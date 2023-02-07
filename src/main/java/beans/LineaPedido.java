package beans;

public class LineaPedido {
	private int idLineaPedido, cantidad, idJuego, idCompra;

	public LineaPedido(int idLineaPedido, int cantidad, int idJuego, int idCompra) {
		this.idLineaPedido = idLineaPedido;
		this.cantidad = cantidad;
		this.idJuego = idJuego;
		this.idCompra = idCompra;
	}
}
