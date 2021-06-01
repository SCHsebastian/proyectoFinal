package tpv;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;

public class LaPantalla {

	private JFrame frmTerminalPuntoDe;
	private static final String DIR_BASE = "Productos";
	private JTextField buscarProducto;
	private final JList list = new JList();
	private static String categoria="uno";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaPantalla window = new LaPantalla();
					window.frmTerminalPuntoDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LaPantalla() {
		initialize();
		iniciar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTerminalPuntoDe = new JFrame();
		frmTerminalPuntoDe.setName("ventanaVentas");
		frmTerminalPuntoDe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmTerminalPuntoDe.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		frmTerminalPuntoDe.setForeground(Color.BLUE);
		frmTerminalPuntoDe.setTitle("TERMINAL PUNTO DE VENTA");
		frmTerminalPuntoDe.setType(Type.UTILITY);
		frmTerminalPuntoDe.setResizable(false);
		frmTerminalPuntoDe.setBounds(100, 100, 1200, 720);
		frmTerminalPuntoDe.getContentPane().setLayout(null);
		list.setBounds(10, 11, 449, 574);
		frmTerminalPuntoDe.getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("SCH SUMI COMPUTER");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(616, 11, 405, 48);
		frmTerminalPuntoDe.getContentPane().add(lblNewLabel);
		
		EnsenyaProdByCat ensenyaProductos = new EnsenyaProdByCat(categoria);
		ensenyaProductos.setBounds(469, 129, 715, 541);
		frmTerminalPuntoDe.getContentPane().add(ensenyaProductos);
		GridBagLayout gbl_ensenyaProductos = new GridBagLayout();
		gbl_ensenyaProductos.columnWidths = new int[] {5};
		gbl_ensenyaProductos.rowHeights = new int[]{0};
		gbl_ensenyaProductos.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_ensenyaProductos.rowWeights = new double[]{Double.MIN_VALUE};
		ensenyaProductos.setLayout(gbl_ensenyaProductos);
		
		JPanel botoneraCarrito = new JPanel();
		botoneraCarrito.setBounds(10, 596, 449, 74);
		frmTerminalPuntoDe.getContentPane().add(botoneraCarrito);
		botoneraCarrito.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton borraSeleccionados = new JButton("Eliminar seleccionado");
		botoneraCarrito.add(borraSeleccionados);
		
		JButton ensenyaDescuentos = new JButton("Aplicar Descuento");
		botoneraCarrito.add(ensenyaDescuentos);
		ensenyaDescuentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EnesenyaDescuentos().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton ensenyaTotal = new JButton("Total");
		ensenyaTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botoneraCarrito.add(ensenyaTotal);
		
		JPanel botoneraOpcProductos = new JPanel();
		botoneraOpcProductos.setBounds(479, 70, 680, 48);
		frmTerminalPuntoDe.getContentPane().add(botoneraOpcProductos);
		GridBagLayout gbl_botoneraOpcProductos = new GridBagLayout();
		gbl_botoneraOpcProductos.columnWidths = new int[]{191, 137, 86, 0};
		gbl_botoneraOpcProductos.rowHeights = new int[]{0, 0};
		gbl_botoneraOpcProductos.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_botoneraOpcProductos.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		botoneraOpcProductos.setLayout(gbl_botoneraOpcProductos);
		JButton seleccionaCategoria = new JButton("Seleccionar Categoria");
		GridBagConstraints gbc_seleccionaCategoria = new GridBagConstraints();
		gbc_seleccionaCategoria.fill = GridBagConstraints.BOTH;
		gbc_seleccionaCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_seleccionaCategoria.gridx = 0;
		gbc_seleccionaCategoria.gridy = 0;
		botoneraOpcProductos.add(seleccionaCategoria, gbc_seleccionaCategoria);
		
		buscarProducto = new JTextField();
		GridBagConstraints gbc_buscarProducto = new GridBagConstraints();
		gbc_buscarProducto.fill = GridBagConstraints.BOTH;
		gbc_buscarProducto.insets = new Insets(0, 0, 0, 5);
		gbc_buscarProducto.gridx = 1;
		gbc_buscarProducto.gridy = 0;
		botoneraOpcProductos.add(buscarProducto, gbc_buscarProducto);
		buscarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		buscarProducto.setText("Buscar producto...");
		buscarProducto.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		GridBagConstraints gbc_buscar = new GridBagConstraints();
		gbc_buscar.fill = GridBagConstraints.BOTH;
		gbc_buscar.gridx = 2;
		gbc_buscar.gridy = 0;
		botoneraOpcProductos.add(buscar, gbc_buscar);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoria=buscarProducto.getText();
				ensenyaProductos.updateUI();
			}
		});
		seleccionaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EnsenyaProductos().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		borraSeleccionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
	
	
	private static void iniciar(){
		File directorio = new File(DIR_BASE);
		File nuevoFichero=new File(directorio,"productos");
		File nuevoFichero2=new File(directorio,"descuentos");
		if(!directorio.exists()){
		      System.out.println("El directorio no existe");
		      System.out.println("Lo creamos");
		      System.out.println(directorio.mkdir());
		      System.out.println("Vamos a crear un nuevo fichero");
		      if(!nuevoFichero.exists() && !nuevoFichero2.exists()) {
		    	  System.out.println("Vamos a crear un nuevo archivo");
		    	  try {
					nuevoFichero.createNewFile();
					nuevoFichero2.createNewFile();
				} catch (IOException e) {
			        System.out.println("OYE, al crear Ha habido un problema");
					e.printStackTrace();
				}}
		      else {
		    	  System.out.println("Vamos a leer los productos");

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