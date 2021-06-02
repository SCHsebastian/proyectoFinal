package tpv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ImprimirFactura {
	
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
		
		if (factura.getDescuento() != null) {
			tabla.addCell(factura.getDescuento().getNombre());
			tabla.addCell("Descuenta "+factura.getDescuento().getCantidad()+"€");
		}

		//Añadimos la tabla al documento
		documento.add(tabla);
		documento.addAuthor("SCH SumiComputer");
		documento.addCreationDate();

		//Cerramos el documento
		documento.close();
	}
	
}
