package tpv;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TodoDescuento {

		public void anyadirUnDescuento(Descuento nuevo) throws IOException{  //Se añade un único descuento.
			FileOutputStream archivo=new FileOutputStream("Productos\\descuentos.txt",true);
		    DataOutputStream data = new DataOutputStream(archivo);
		    data.writeUTF(nuevo.getNombre());
		    data.writeDouble(nuevo.getCantidad());
		    data.close();
		}
		
		
		public static ArrayList<Descuento> botonesDescuento() throws IOException {	 // Se devuelve el array de descuentos para crear los botones necesarios.
			ArrayList <Descuento> implementar = new ArrayList <Descuento>();
			InputStream input = new FileInputStream("Productos\\descuentos.txt");  
			try(DataInputStream dis=new DataInputStream(input)){
		      while(true) {
		        String nombre = dis.readUTF();
		        double cantidad = dis.readDouble();
		        Descuento leido = new Descuento(nombre, cantidad);
		        implementar.add(leido);
		      }
		    } catch (EOFException eofe){
		      System.out.println("Terminado de leer");
		    }
			return implementar;
		  }

}
