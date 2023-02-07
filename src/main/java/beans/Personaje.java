package beans;

public class Personaje {
	private int idPersonaje;
	private String nombre;
	private VideoJuego juego;
	private Imagen imagen;
	
	public Personaje(int idPersonaje, VideoJuego juego, Imagen imagen, String nombre) {
		this.idPersonaje = idPersonaje;
		this.juego = juego;
		this.imagen = imagen;
		this.nombre = nombre;
	}

	public Personaje() {

	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public VideoJuego getJuego() {
		return juego;
	}

	public void setJuego(VideoJuego juego) {
		this.juego = juego;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}
	
	
}
