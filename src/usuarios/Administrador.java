package usuarios;

public class Administrador extends Usuario implements AccionesUsuarios {
		
	private String contrasenya;
	
	public Administrador(String nombre, String DNI, String contrasenya) {
		super(nombre, DNI, (double) 0);
		this.setContrasenya(contrasenya);
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

}
