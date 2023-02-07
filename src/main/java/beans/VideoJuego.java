package beans;

public class VideoJuego {
	private int idJuego;
	private String titulo, descripcion, trailer;
	private double precio;
	private Compania compania;
	private Imagen imgCover, imgCoverMobile, imgBanner;
	
	public VideoJuego(int idJuego, String titulo, String descripcion, String trailer, double precio, Compania compania,
			Imagen imgCover, Imagen imgCoverMobile, Imagen imgBanner) {
		this.idJuego = idJuego;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.trailer = trailer;
		this.precio = precio;
		this.compania = compania;
		this.imgCover = imgCover;
		this.imgCoverMobile = imgCoverMobile;
		this.imgBanner = imgBanner;
	}

	public VideoJuego() {
		
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	public Imagen getImgCover() {
		return imgCover;
	}

	public void setImgCover(Imagen imgCover) {
		this.imgCover = imgCover;
	}

	public Imagen getImgCoverMobile() {
		return imgCoverMobile;
	}

	public void setImgCoverMobile(Imagen imgCoverMobile) {
		this.imgCoverMobile = imgCoverMobile;
	}

	public Imagen getImgBanner() {
		return imgBanner;
	}

	public void setImgBanner(Imagen imgBanner) {
		this.imgBanner = imgBanner;
	}
	
	
	
}
