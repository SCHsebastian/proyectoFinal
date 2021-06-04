package tpv;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	public static java.util.Date fecha = new Date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
		iniciar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/tpv/Logo.png")));
		lblNewLabel.setBounds(134, -16, 561, 287);

		JPanel panel = new JPanel();
		panel.setBounds(10, 252, 831, 271);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Realizar Venta");
		JButton btnNewButton_1 = new JButton("A\u00F1adir Producto");
		JButton btnNewButton_2 = new JButton("A\u00F1adir Descuento");
		panel.add(btnNewButton);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton_2);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PantallaVenta window = new PantallaVenta();
							window.frmTerminalPuntoDe.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AnyadeProducto frame = new AnyadeProducto();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AnyadeDescuento frame = new AnyadeDescuento();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
	
	protected static void iniciar(){
		String DIR_BASE = "Productos";
		String DIR_BASE2 = "Facturas";
		String DIR_BASE3 = "Recibos";
		File directorio = new File(DIR_BASE);
		File directorioFacturas = new File(DIR_BASE2);
		File directorioRecibos = new File(DIR_BASE3);
		File nuevoFichero=new File(directorio,"productos");
		File nuevoFichero2=new File(directorio,"descuentos");
		File nuevoFichero3=new File(directorioFacturas,"contadorFacturas");
		File nuevoFichero4=new File(directorioRecibos,"contadorRecibos");
		if(!directorio.exists()){
		      System.out.println("El directorio no existe");
		      System.out.println("Lo creamos");
		      System.out.println(directorio.mkdir());
		      System.out.println("Vamos a crear un nuevo fichero");
		      if(!nuevoFichero.exists() && !nuevoFichero2.exists() && !nuevoFichero3.exists() && !nuevoFichero4.exists()) {
		    	  System.out.println("Vamos a crear un nuevo archivo");
		    	  try {
					nuevoFichero.createNewFile();
					nuevoFichero2.createNewFile();
					nuevoFichero3.createNewFile();
					nuevoFichero4.createNewFile();
				} catch (IOException e) {
			        System.out.println("OYE, al crear Ha habido un problema");
					e.printStackTrace();
				}}
		      else {
		    	  System.out.println("Vamos a leer los productos");
		    	  ImprimirFactura.numeroDeFacturas(directorioFacturas);
		    	  ImprimirRecibo.numeroDeRecibos(directorioRecibos);
		      }
		    } else {
		      System.out.println("El directorio existe");
		      if(!nuevoFichero.exists()) {
		    	  System.out.println("Vamos a crear un nuevo archivo");
					try {
						nuevoFichero.createNewFile();
					} catch (IOException e) {
				        System.out.println("OYE, al crear Ha habido un problema");
						e.printStackTrace();
					}
		      }
		      else {
		    	  System.out.println("Vamos a leer los productos");
		      }
		    }
	}
}
