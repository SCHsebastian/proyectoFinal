package tpv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class EjecutaPruebas {
	
	
	public static void main(String[] args) {
		System.out.println("");
	}
	
	/*
	public static void main(String[] args) {
		for (int j = 0; j < 10; j++) {
			Producto nuevo = new Producto("Prueba"+j, 2*(double)(j+1), "uno","foto"+j);
			EjecucionProductos a = new EjecucionProductos();
			try {
				a.anyadirUnProducto(nuevo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	*/
	
	
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
