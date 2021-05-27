package tpv;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class EjecucionProductos {

	public void anyadirUnProducto(Producto nuevo) throws IOException{  //Se a�ade un �nico producto.
		FileOutputStream archivo=new FileOutputStream("Productos\\productos.txt",true);
	    DataOutputStream data = new DataOutputStream(archivo);
	    data.writeUTF(nuevo.getNombre());
	    data.writeDouble(nuevo.getPrecio());
	    data.writeUTF(nuevo.getFoto());
	    data.close();
	}
	
	public void anyadirAFichero(ArrayList<Producto> lista) throws IOException {  //Se a�ade un array list con productos a a�adir al documento de guardado.
		String nom;
		double pre;
		String fot;
		FileOutputStream archivo=new FileOutputStream("Productos\\productos.txt",true);
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
	
	public static ArrayList<Producto> botones() throws IOException {	 // Se devuelve el array de productos para crear los botones necesarios.
		ArrayList <Producto> implementar = new ArrayList <Producto>();
		InputStream input = new FileInputStream("Productos\\productos.txt");  
		try(DataInputStream dis=new DataInputStream(input)){
	      while(true) {
	        String nombre = dis.readUTF();
	        double precio = dis.readDouble();
	        String foto = dis.readUTF();
	        Producto leido = new Producto(nombre, precio, foto);
	        implementar.add(leido);
	      }
	    } catch (EOFException eofe){
	      System.out.println("Terminado de leer");
	    }
		return implementar;
	  }

}
