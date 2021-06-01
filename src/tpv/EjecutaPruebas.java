package tpv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public static void main(String[] args) throws IOException, DocumentException {
		Factura prueba = new Factura(EjecucionProductos.botones(), TodoDescuento.botonesDescuento().get(1), "CifDelCliente");
		crearPDF(prueba);
		
		
	}
	
	public static void crearPDF(Factura factura) throws FileNotFoundException, DocumentException {
		
		//Se crea el doc
		Document documento = new Document();
		
		//El OutPutStream para el fichero donde crearemos el PDF
		FileOutputStream ficheroPDF = new FileOutputStream("Factura"+factura.getNumeroFactura()+".pdf");
		
		
		//Se asocia el documento de OutputStream	
		PdfWriter.getInstance(documento, ficheroPDF);
		
		// Se abre el documento	
		documento.open();
		
		//Parrafo		
		Paragraph titulo = new Paragraph("Factura del cliente "+ factura.getCif()+ " \n\n",
				FontFactory.getFont("arial",
						22,
						Font.BOLD,
						BaseColor.BLUE));
		
		//Añadimos el titulo al documento
		documento.add(titulo);
				
		//Creamos una tabla
		PdfPTable tabla = new PdfPTable(2);
		tabla.addCell("Producto");
		tabla.addCell("Precio");
		
		for (Producto prod : factura.getProductos()) {
			tabla.addCell(prod.getNombre());
			tabla.addCell(""+prod.getPrecio()+"€");
		}
		tabla.addCell("TOTAL");
		tabla.addCell(""+factura.getTotal()+"€");
		
		//Añadimos la tabla al documento
		documento.add(tabla);
		documento.addAuthor("SCH SumiComputer");
		documento.addCreationDate();
		
		//Cerramos el documento		
		documento.close();
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
