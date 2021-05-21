package usuarios;

public abstract class Usuario implements AccionesUsuarios{
	
	protected double dinero;
	protected String nombre;
	protected String DNI;
	String instruccionSQL;
	
	
	protected Usuario(String nombre, String DNI){
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		dinero=0;
		instruccionSQL = "INSERT INTO USUARIO(nombre, DNI, dinero) VALUES ('"+nombre+"', '"+DNI+"',"+dinero+")";
	}
	
	protected Usuario(String nombre, String DNI, double dinero){
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		this.dinero = dinero;
		instruccionSQL = "INSERT INTO USUARIO(nombre, DNI, dinero) VALUES ('"+nombre+"', '"+DNI+"',"+dinero+")";
	}
}
