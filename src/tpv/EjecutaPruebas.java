package tpv;

import java.io.IOException;

public class EjecutaPruebas {
	
	public static void main(String[] args) {
		EjecucionProductos a = new EjecucionProductos();
		Producto nuevo = new Producto("Prueba", 0, "uno","foto");
		try {
			a.anyadirUnProducto(nuevo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
		
}
