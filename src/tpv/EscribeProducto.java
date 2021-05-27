package tpv;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EscribeProducto {
	
	public void anyadirUnProducto(Producto nuevo) throws IOException{
		FileOutputStream archivo=new FileOutputStream("C:\\Users\\sebas\\eclipse-workspace\\proyectoFinal\\ProyectoFinal\\Productos\\productos.esto",true);
	    DataOutputStream data = new DataOutputStream(archivo);
	    data.writeBytes(nuevo.getNombre());
	    data.writeDouble(nuevo.getPrecio());
	    data.writeBytes(nuevo.getFoto());
	}
	
	public void anyadirAFichero(ArrayList<Producto> lista) throws IOException {
		String nom;
		double pre;
		String fot;
		FileOutputStream archivo=new FileOutputStream("C:\\Users\\sebas\\eclipse-workspace\\proyectoFinal\\ProyectoFinal\\Productos\\productos.esto",true);
	    try (DataOutputStream data = new DataOutputStream(archivo)) {
			for (Producto producto : lista) {
				nom = producto.getNombre();
				pre = producto.getPrecio();
				fot = producto.getFoto();
				
				data.writeUTF(nom);
				data.writeDouble(pre);
				data.writeUTF(fot);
			}
		}
	}

}
