package beans;

public class Compania {
	private int id;
	private String nombre, enlaceOficial;
	
	public Compania(int id, String nombre, String enlaceOficial) {
		this.id = id;
		this.nombre = nombre;
		this.enlaceOficial = enlaceOficial;
	}
	
	public Compania() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEnlaceOficial() {
		return enlaceOficial;
	}

	public void setEnlaceOficial(String enlaceOficial) {
		this.enlaceOficial = enlaceOficial;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
