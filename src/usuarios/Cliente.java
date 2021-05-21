package usuarios;

public class Cliente extends Usuario implements AccionesUsuarios {
	
	private boolean VIP;

	public Cliente(String nombre, String DNI) {
		super(nombre, DNI, (double) 0);
	}
	
	public boolean esVIP(){
		return VIP;
	}

}
