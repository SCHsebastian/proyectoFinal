package tpv;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LeeProductos {

	public static ArrayList botones() throws IOException {	
		ArrayList <Producto> implementar = new ArrayList <Producto>();
		InputStream input = new FileInputStream("C:\\Users\\sebas\\eclipse-workspace\\proyectoFinal\\ProyectoFinal\\Productos\\productos.esto");  
		try(DataInputStream dis=new DataInputStream(input)){
	      while(true) {
	        String nombre = dis.readUTF();
	        double precio = dis.readDouble();
	        String foto = dis.readUTF();
	        Producto leido = new Producto(nombre, precio, foto);
	        implementar.add(leido);
	        System.out.println("producto anyadido");
	      }
	    } catch (EOFException eofe){
	      System.out.println("Terminado de leer");
	    }
		return implementar;
	  }
}
