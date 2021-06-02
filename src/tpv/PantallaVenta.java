package tpv;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.itextpdf.text.DocumentException;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextArea;

public class PantallaVenta{

	private JFrame frmTerminalPuntoDe;
	private JTextField buscarProducto;
	private static ArrayList<Producto> paraFactRec= new ArrayList<>();
	public static Descuento paDescontar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public PantallaVenta() {
		initialize();
		iniciar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//INICIALIZAMOS LA PANTALLA DE VENTAS
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
		
		//AÑADIMOS LOS ELEMENTOS
		
		JLabel schSumiComputer = new JLabel("SCH SUMI COMPUTER");
		schSumiComputer.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		schSumiComputer.setHorizontalAlignment(SwingConstants.CENTER);
		schSumiComputer.setBounds(616, 11, 405, 48);
		
		//PANEL DE CARRITO
		JPanel botoneraCarrito = new JPanel();
		botoneraCarrito.setBounds(10, 596, 449, 74);
		botoneraCarrito.setLayout(new GridLayout(1, 0, 0, 0));
		
		//BOTONES DE CARRITO
		JButton borraSeleccionados = new JButton("Borrar Cesta");
		botoneraCarrito.add(borraSeleccionados);
		
		JButton ensenyaDescuentos = new JButton("Aplicar Descuento");
		botoneraCarrito.add(ensenyaDescuentos);
		
		JButton ensenyaTotal = new JButton("Total");
		botoneraCarrito.add(ensenyaTotal);
		
		//OPCIONES DE PRODUCTOS ETC
		JPanel botoneraOpcProductos = new JPanel();
		botoneraOpcProductos.setBounds(479, 70, 680, 48);
		
		GridBagLayout gbl_botoneraOpcProductos = new GridBagLayout();
		gbl_botoneraOpcProductos.columnWidths = new int[]{111, 0, 0, 137, 86, 0};
		gbl_botoneraOpcProductos.rowHeights = new int[]{0, 0};
		gbl_botoneraOpcProductos.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_botoneraOpcProductos.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		botoneraOpcProductos.setLayout(gbl_botoneraOpcProductos);
		
		JButton seleccionaCategoria = new JButton("Seleccionar Categoria");
		GridBagConstraints gbc_seleccionaCategoria = new GridBagConstraints();
		gbc_seleccionaCategoria.fill = GridBagConstraints.BOTH;
		gbc_seleccionaCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_seleccionaCategoria.gridx = 0;
		gbc_seleccionaCategoria.gridy = 0;
		botoneraOpcProductos.add(seleccionaCategoria, gbc_seleccionaCategoria);
		
		JButton facturar = new JButton("Facturar");
		GridBagConstraints gbc_facturar = new GridBagConstraints();
		gbc_facturar.fill = GridBagConstraints.BOTH;
		gbc_facturar.insets = new Insets(0, 0, 0, 5);
		gbc_facturar.gridx = 1;
		gbc_facturar.gridy = 0;
		botoneraOpcProductos.add(facturar, gbc_facturar);
		
		JButton recibo = new JButton("Recibo");
		GridBagConstraints gbc_recibo = new GridBagConstraints();
		gbc_recibo.fill = GridBagConstraints.BOTH;
		gbc_recibo.insets = new Insets(0, 0, 0, 5);
		gbc_recibo.gridx = 2;
		gbc_recibo.gridy = 0;
		botoneraOpcProductos.add(recibo, gbc_recibo);
		
		buscarProducto = new JTextField();
		buscarProducto.setToolTipText("");
		GridBagConstraints gbc_buscarProducto = new GridBagConstraints();
		gbc_buscarProducto.fill = GridBagConstraints.BOTH;
		gbc_buscarProducto.insets = new Insets(0, 0, 0, 5);
		gbc_buscarProducto.gridx = 3;
		gbc_buscarProducto.gridy = 0;
		botoneraOpcProductos.add(buscarProducto, gbc_buscarProducto);
		buscarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		buscarProducto.setText("Buscar producto...");
		buscarProducto.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		GridBagConstraints gbc_buscar = new GridBagConstraints();
		gbc_buscar.fill = GridBagConstraints.BOTH;
		gbc_buscar.gridx = 4;
		gbc_buscar.gridy = 0;
		botoneraOpcProductos.add(buscar, gbc_buscar);
		
		//DONDE SE GENERAN LOS BOTONES
		JPanel panel = new JPanel();
		panel.setBounds(479, 129, 680, 541);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		//LA CESTA
		JTextArea cesta = new JTextArea();
		cesta.setBounds(10, 11, 449, 565);
		
		//AÑADIMOS TODISIMO
		frmTerminalPuntoDe.getContentPane().add(botoneraCarrito);
		frmTerminalPuntoDe.getContentPane().add(botoneraOpcProductos);
		frmTerminalPuntoDe.getContentPane().add(panel);
		frmTerminalPuntoDe.getContentPane().add(schSumiComputer);
		frmTerminalPuntoDe.getContentPane().add(cesta);
		
		
		recibo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(paDescontar == null) {
					ImprimirRecibo.imprimirTicket(new Recibo(paraFactRec));
				}else {
					ImprimirRecibo.imprimirTicket(new Recibo(paraFactRec, paDescontar));
				}
			}
		});
		
		ensenyaDescuentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					panel.removeAll();
					buscaDescuentos(panel, cesta);
					panel.updateUI();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}});
		
		ensenyaTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total(cesta);
			}
		});
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				buscaProducto(panel,cesta);
				panel.updateUI();
			}
		});
		seleccionaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				selectCategoria(panel,cesta);
				panel.updateUI();
			}
		});
		borraSeleccionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paraFactRec.clear();
				cesta.setText(null);
			}
		});

		facturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						if(paDescontar == null) {
							ImprimirFactura.crearPDF(new Factura(paraFactRec, JOptionPane.showInputDialog("Introduce el CIF del Cliente")));
						}
						else {
							ImprimirFactura.crearPDF(new Factura(paraFactRec, paDescontar, JOptionPane.showInputDialog("Introduce el CIF del Cliente")));
						}
					paraFactRec.clear();
				} catch (HeadlessException | FileNotFoundException | DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}	

	protected void total(JTextArea cesta) {
		double suma=0;
		for (Producto producto : paraFactRec) {
			suma+=producto.getPrecio();
		}
		cesta.setText(""+suma);		
	}
	
	protected void buscaDescuentos(JPanel panel, JTextArea cesta) throws IOException {
		for (Descuento d : TodoDescuento.botonesDescuento()) {
			JButton botones = new JButton(d.getNombre());
			panel.add(botones);
			botones.addActionListener(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(cesta, "Recuerda que antes has de presionar TOTAL");
					cesta.setText("El total con descuento incluido es: "+ (Double.parseDouble(cesta.getText())*d.getCantidad()));
					PantallaVenta.paDescontar = d;
				}
			});}
			
	}

	protected void buscaProducto(JPanel panel, JTextArea cesta) {
		String nombre=buscarProducto.getText();
		ArrayList<Producto> leeBotones;
		try {
			leeBotones = TodoProductos.botones();
			for (Producto producto : leeBotones) {
				if(producto.getNombre().equals(nombre)) {
					JButton btnNewButton = new JButton(producto.getNombre());
					panel.add(btnNewButton);
					cesta.setText(cesta.getText()+"\n"+producto.getNombre()+" "+producto.getPrecio());
					paraFactRec.add(producto);
				}
			}
		} catch (IOException o) {
			o.printStackTrace();
			JOptionPane.showMessageDialog(panel, "ERROR AL LEER LOS PRODUCTOS");
		}
	}
	
	protected void buscaCategoria(JPanel panel, String categ, JTextArea cesta) {
		ArrayList<Producto> leeBotones;
		try {
			leeBotones = TodoProductos.botones();
			for (Producto producto : leeBotones) {
				if(producto.getTipo().equals(categ)) {
					JButton btnNewButton = new JButton(producto.getNombre());
					panel.add(btnNewButton);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cesta.setText(cesta.getText()+"\n"+producto.getNombre()+" "+producto.getPrecio());
							paraFactRec.add(producto);
						}
					});
				}
			}
		} catch (IOException o) {
			o.printStackTrace();
			JOptionPane.showMessageDialog(panel, "ERROR AL LEER LOS PRODUCTOS");
		}
		
	}
	
	protected void selectCategoria(JPanel panel, JTextArea cesta) {
		ArrayList<String> categorias = new ArrayList<>();
		ArrayList<Producto> leeBotones;
		try {
			leeBotones = TodoProductos.botones();
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
						buscaCategoria(panel, cat, cesta);
						panel.updateUI();
					}
				});
				
			}
		}
			catch (Exception e) {
				JOptionPane.showMessageDialog(panel, "ERROR AL LEER LOS PRODUCTOS");
			}
	}

	protected static void iniciar(){
		String DIR_BASE = "Productos";
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
