package pantallas;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Main {

	private JFrame frmProyectoFinal;
	private JPasswordField contrasenya;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmProyectoFinal.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProyectoFinal = new JFrame();
		frmProyectoFinal.setResizable(false);
		frmProyectoFinal.setTitle("Proyecto Final");
		frmProyectoFinal.setBounds(100, 100, 400, 309);
		frmProyectoFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyectoFinal.getContentPane().setLayout(null);
		
		JButton salir = new JButton("Salir");
		salir.setBounds(262, 192, 89, 31);
		frmProyectoFinal.getContentPane().add(salir);
		
		contrasenya = new JPasswordField();
		contrasenya.setToolTipText("Contrase\u00F1a...");
		contrasenya.setBounds(31, 141, 320, 23);
		frmProyectoFinal.getContentPane().add(contrasenya);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario");
		lblNewLabel.setBounds(31, 29, 320, 23);
		frmProyectoFinal.getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(31, 111, 320, 23);
		frmProyectoFinal.getContentPane().add(lblContrasea);
		
		JButton iniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		iniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		iniciarSesion.setBounds(31, 192, 140, 31);
		frmProyectoFinal.getContentPane().add(iniciarSesion);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(31, 63, 320, 23);
		frmProyectoFinal.getContentPane().add(comboBox);
		
		JMenuBar menuBar = new JMenuBar();
		frmProyectoFinal.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Men\u00FA");
		mnNewMenu.setBackground(Color.GRAY);
		menuBar.add(mnNewMenu);
		
		JMenuItem Inicio = new JMenuItem("Inicio");
		mnNewMenu.add(Inicio);
		
		JMenuItem Errores = new JMenuItem("Informe de errores");
		mnNewMenu.add(Errores);
		
		
		//------- Conexión BBDD
		
		try {
			Connection conecta=DriverManager.getConnection(
					"jdbc:mysql://proyectofinalsch.mysql.database.azure.com:3306/final", "sebastian@proyectofinalsch", "Final123");
			
			String consulta = "SELECT nombre FROM final.usuario, final.administrador, final.empleado where id=?";
			
			PreparedStatement seleccionUsuarios = conecta.prepareStatement(consulta);
			
			seleccionUsuarios.setString(1, "idAdministrador");
			seleccionUsuarios.setString(1, "idEmpleado");
			
			ResultSet resultado = seleccionUsuarios.executeQuery();
			
			while(resultado.next()) {
				comboBox.addItem(resultado.getString(1));
			}
			
			resultado.close();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
