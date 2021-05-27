package tpv;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.Locale;

public class MuestraPantalla {
	private JFrame frame;
	private static final String DIR_BASE = "Productos";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		iniciar();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuestraPantalla window = new MuestraPantalla();
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
	public MuestraPantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(1920, 1080));
		frame.setResizable(false);
		frame.getContentPane().setLocale(new Locale("es", "ES"));
		frame.getContentPane().setMinimumSize(new Dimension(1920, 1080));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 496, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static void iniciar(){
		File directorio = new File(DIR_BASE);
		File nuevoFichero=new File(directorio,"productos.txt");
		if(!directorio.exists()){
		      System.out.println("El directorio no existe");
		      System.out.println("Lo creamos");
		      System.out.println(directorio.mkdir());
		      System.out.println("Vamos a crear un nuevo fichero");
		      if(!nuevoFichero.exists()) {
		    	  System.out.println("Vamos a crear un nuevo archivo");
		    	  try {
					nuevoFichero.createNewFile();
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