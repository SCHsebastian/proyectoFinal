package usuarios;

public class Empleado extends Usuario implements AccionesUsuarios{
	
	private String contrasenya;
	protected int numVentas;
	

	public Empleado(String nombre, String DNI, String contrasenya) {
		super(nombre, DNI, (double) 0);
		this.contrasenya=contrasenya;
	}
	
	private void nuevaVenta() {
		numVentas++;
	}
	
	
	public int getNumVentas() {
		return numVentas;
	}
	
	private void cambiarContrasenya(String nuevaContrasenya) {
		this.contrasenya=nuevaContrasenya;
	}
}
