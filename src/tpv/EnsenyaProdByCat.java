package tpv;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;

public class EnsenyaProdByCat extends JPanel {

	/**
	 * Create the panel.
	 */
	public EnsenyaProdByCat(String categoria) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		categoria="uno";
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
		
	}

}
