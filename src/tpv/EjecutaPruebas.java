package tpv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class EjecutaPruebas {
	
	public static void main(String[] args) {
		for (int j = 0; j < 10; j++) {
			Producto nuevo = new Producto("Prueba"+j, 0, "uno","foto"+j);
			EjecucionProductos a = new EjecucionProductos();
			try {
				a.anyadirUnProducto(nuevo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
		/*
	ArrayList<Producto> leeBotones;
	try {
		leeBotones = EjecucionProductos.botones();
		for (Producto producto : leeBotones) {
			if(producto.getTipo().equals(categoria)) {
				JButton btnNewButton = new JButton(producto.getNombre());
				gridBagLayout.addLayoutComponent(btnNewButton,1);
			}
		}
	} catch (IOException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(getComponentPopupMenu(), "ERROR AL LEER LOS PRODUCTOS");
	}
	*/
}
