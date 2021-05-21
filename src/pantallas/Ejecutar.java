package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Ejecutar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejecutar window = new Ejecutar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejecutar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 337, 118);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton vender = new JButton("Vender");
		vender.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(vender);
		
		JButton facturas = new JButton("Facturas");
		facturas.setBounds(109, 11, 89, 23);
		frame.getContentPane().add(facturas);
		
		JButton inventario = new JButton("Inventario");
		inventario.setBounds(208, 11, 100, 23);
		frame.getContentPane().add(inventario);
		
		JButton nuevoVIP = new JButton("Nuevo socio VIP");
		nuevoVIP.setBounds(10, 45, 147, 23);
		frame.getContentPane().add(nuevoVIP);
		
		JButton cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		cerrarSesion.setBounds(180, 45, 128, 23);
		frame.getContentPane().add(cerrarSesion);
	}

}
