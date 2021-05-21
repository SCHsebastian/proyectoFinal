package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Administracion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administracion window = new Administracion();
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
	public Administracion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(452, 162));
		frame.setMaximumSize(new Dimension(452, 162));
		frame.setBounds(100, 100, 452, 162);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMaximumSize(new Dimension(465, 165));
		menuBar.setMinimumSize(new Dimension(462, 162));
		menuBar.setBounds(0, 0, 446, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Men\u00FA");
		mnNewMenu.setBackground(Color.GRAY);
		menuBar.add(mnNewMenu);
		
		JMenuItem Inicio = new JMenuItem("Inicio");
		mnNewMenu.add(Inicio);
		
		JMenuItem Administracion = new JMenuItem("Administraci\u00F3n");
		mnNewMenu.add(Administracion);
		
		JMenuItem Errores = new JMenuItem("Informe de errores");
		mnNewMenu.add(Errores);
		
		JButton todoInventario = new JButton("Gestionar Inventario");
		todoInventario.setBounds(10, 33, 131, 31);
		frame.getContentPane().add(todoInventario);
		
		JButton todoFacturas = new JButton("Gestionar Facturas");
		todoFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		todoFacturas.setBounds(151, 33, 131, 31);
		frame.getContentPane().add(todoFacturas);
		
		JButton todoUsuarios = new JButton("Gestionar Usuarios");
		todoUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		todoUsuarios.setBounds(292, 33, 131, 31);
		frame.getContentPane().add(todoUsuarios);
		
		JButton todoPromociones = new JButton("Gestionar Promociones");
		todoPromociones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		todoPromociones.setBounds(10, 75, 198, 31);
		frame.getContentPane().add(todoPromociones);
		
		JButton todoProveedores = new JButton("Gestionar Proveedores");
		todoProveedores.setBounds(233, 75, 190, 31);
		frame.getContentPane().add(todoProveedores);
	}
}
