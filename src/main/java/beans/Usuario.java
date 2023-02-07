package beans;

public class Usuario {
	private int idUser;
	private Imagen img;
	private String nombre, apellidos, desc, dir, cp, municipio, provincia, pais, tlf, email, passw;
	private boolean admin;
	
	public Usuario(int idUser, Imagen img, String nombre, String apellidos, String desc, String dir, String cp,
			String municipio, String provincia, String pais, String tlf, String email, String passw, boolean admin) {
		this.idUser = idUser;
		this.img = img;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.desc = desc;
		this.dir = dir;
		this.cp = cp;
		this.municipio = municipio;
		this.provincia = provincia;
		this.pais = pais;
		this.tlf = tlf;
		this.email = email;
		this.passw = passw;
		this.admin = admin;
	}
	
	public Usuario() {
		
	}
	
	
	
}
