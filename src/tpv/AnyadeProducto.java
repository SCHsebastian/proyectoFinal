	package tpv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;

public class AnyadeProducto extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField precio;
	private JTextField tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public AnyadeProducto() {
		setTitle("A\u00F1adir un producto");
		setResizable(false);
		setBounds(100, 100, 640, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir productos");
		lblNewLabel.setBounds(256, 16, 113, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del producto");
		lblNewLabel_1.setBounds(19, 60, 132, 23);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
		
		nombre = new JTextField();
		nombre.setBounds(175, 61, 437, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(19, 96, 41, 22);
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		contentPane.add(lblNewLabel_2);
		
		precio = new JTextField();
		precio.setBounds(84, 97, 284, 20);
		precio.setColumns(10);
		contentPane.add(precio);
		
		JLabel lblNewLabel_3 = new JLabel("Ubicaci\u00F3n de la imagen");
		lblNewLabel_3.setBounds(388, 103, 152, 22);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tipo");
		lblNewLabel_2_1.setBounds(25, 138, 29, 22);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		contentPane.add(lblNewLabel_2_1);
		
		tipo = new JTextField();
		tipo.setBounds(84, 139, 284, 20);
		tipo.setColumns(10);
		contentPane.add(tipo);
		
		JButton anyadeImagen = new JButton("A\u00F1adir imagen");
		anyadeImagen.setBounds(398, 131, 214, 59);
		contentPane.add(anyadeImagen);
		
		anyadeImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG, GIF, BMP, PNG", "jpg", "gif", "bmp", "png");
				    fileChooser.setFileFilter(filter);
				int respuesta = fileChooser.showOpenDialog(null);
				
				if (respuesta == JFileChooser.APPROVE_OPTION) {
					File fotito = new File(fileChooser.getSelectedFile().getAbsolutePath());
					fotito.getAbsoluteFile();
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 219, 619, 67);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton borrar = new JButton("Borrar");
		panel.add(borrar);
		
		JButton botonAnyadeProducto = new JButton("A\u00F1adir");
		panel.add(botonAnyadeProducto);
		
		JButton salir = new JButton("Salir");
		panel.add(salir);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		botonAnyadeProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
