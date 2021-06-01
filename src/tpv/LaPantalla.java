package tpv;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
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

public class LaPantalla {

	private JFrame frmTerminalPuntoDe;
	private static final String DIR_BASE = "Productos";
	private JTextField buscarProducto;
	private final JList list = new JList();
	private static String categoria;
	private static String nombre;
	private static ArrayList<Producto> paraFactRec = new ArrayList();
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
		
		JPanel botoneraCarrito = new JPanel();
		botoneraCarrito.setBounds(10, 596, 449, 74);
		frmTerminalPuntoDe.getContentPane().add(botoneraCarrito);
		botoneraCarrito.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton borraSeleccionados = new JButton("Eliminar seleccionado");
		botoneraCarrito.add(borraSeleccionados);
		
		JButton ensenyaDescuentos = new JButton("Aplicar Descuento");
		botoneraCarrito.add(ensenyaDescuentos);
		JButton ensenyaTotal = new JButton("Total");
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
		buscarProducto.setToolTipText("");
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
		
		JPanel panel = new JPanel();
		panel.setBounds(479, 129, 680, 541);
		frmTerminalPuntoDe.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				buscaProducto(panel);
				panel.updateUI();
			}
		});
		seleccionaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				selectCategoria(panel);
				panel.updateUI();
			}
		});
		borraSeleccionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
	
	
	protected void ensenyaProductos(JPanel panel) {
		ArrayList<Producto> leeBotones;
		try {
			leeBotones = EjecucionProductos.botones();
			for (Producto producto : leeBotones) {
					JButton btnNewButton = new JButton(producto.getTipo());
					panel.add(btnNewButton);
				}
		} catch (IOException o) {
			o.printStackTrace();
			JOptionPane.showMessageDialog(panel, "ERROR AL LEER LOS PRODUCTOS");
		}
	}

	protected void buscaProducto(JPanel panel) {
		nombre=buscarProducto.getText();
		ArrayList<Producto> leeBotones;
		try {
			leeBotones = EjecucionProductos.botones();
			for (Producto producto : leeBotones) {
				if(producto.getNombre().equals(nombre)) {
					JButton btnNewButton = new JButton(producto.getNombre());
					panel.add(btnNewButton);
				}
			}
		} catch (IOException o) {
			o.printStackTrace();
			JOptionPane.showMessageDialog(panel, "ERROR AL LEER LOS PRODUCTOS");
		}
		
	}
	
	protected void buscaCategoria(JPanel panel, String categ) {
		ArrayList<Producto> leeBotones;
		try {
			leeBotones = EjecucionProductos.botones();
			for (Producto producto : leeBotones) {
				if(producto.getTipo().equals(categ)) {
					JButton btnNewButton = new JButton(producto.getNombre());
					panel.add(btnNewButton);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							list.updateUI();
						}
					});
				}
			}
		} catch (IOException o) {
			o.printStackTrace();
			JOptionPane.showMessageDialog(panel, "ERROR AL LEER LOS PRODUCTOS");
		}
		
	}
	
	protected void selectCategoria(JPanel panel) {
		ArrayList<String> categorias = new ArrayList<>();
		ArrayList<Producto> leeBotones;
		try {
			leeBotones = EjecucionProductos.botones();
			for (Producto producto : leeBotones) {
				if(!categorias.contains(producto.getTipo())) {
					categorias.add(producto.getTipo());
				}
			}
			for (String cat : categorias) {
				JButton btnNewButton = new JButton(cat);
				panel.add(btnNewButton);
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						buscaCategoria(panel, cat);
						panel.updateUI();
					}
				});
				
			}
		}
			catch (Exception e) {
				JOptionPane.showMessageDialog(panel, "ERROR AL LEER LOS PRODUCTOS");
			}
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
