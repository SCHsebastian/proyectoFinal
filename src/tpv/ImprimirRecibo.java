package tpv;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;

public class ImprimirRecibo {
	
	static void imprimirTicket(Recibo recibo){
	      JTextPane jtp = new JTextPane();
	      jtp.setBackground(Color.white);
	      jtp.setFont(new Font("Dubai Medium", Font.BOLD, 16));
	      jtp.setText("Recibo de la tienda SCH SUMICOMPUTERS \n\n");
	      for (Producto prod : recibo.getProductos()) {
				jtp.setText(jtp.getText()+"\n\n"+prod.getNombre()+""+prod.getPrecio()+"€");
			}
			if (recibo.getDescuento() != null) {
				jtp.setText(jtp.getText()+recibo.getDescuento().getNombre());
				jtp.setText(jtp.getText()+"Descuenta "+recibo.getDescuento().getCantidad()+"€");
			}
			jtp.setText(jtp.getText()+"\n\n"+"TOTAL" +" "+recibo.getTotal()+"€");
	      boolean show = true;
	      try {
	        jtp.print(null, null, show, null, null, show);
	      } catch (java.awt.print.PrinterException ex) {
	        ex.printStackTrace();
	      }
	    }
}
