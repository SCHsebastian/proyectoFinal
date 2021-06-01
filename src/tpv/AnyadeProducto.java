	package tpv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import java.awt.Choice;

public class AnyadeProducto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
		setResizable(false);
		setBounds(100, 100, 613, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(251, 11, 113, 14);
		contentPane.add(lblNewLabel);
		
		table = new JTable(4,4);
		table.setBounds(28, 193, 555, 64);
		JScrollPane scrollpane = new JScrollPane(table);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del producto");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(28, 55, 132, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel_2.setBounds(28, 89, 41, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ubicaci\u00F3n de la imagen");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel_3.setBounds(363, 87, 161, 23);
		contentPane.add(lblNewLabel_3);
		
		JButton BotonAnyadeProducto = new JButton("A\u00F1adir");
		BotonAnyadeProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAnyadeProducto.setBounds(251, 159, 89, 23);
		contentPane.add(BotonAnyadeProducto);
		
		textField = new JTextField();
		textField.setBounds(170, 57, 413, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 85, 225, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.setBounds(40, 282, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("A\u00F1adir todos los productos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(194, 282, 225, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBounds(471, 282, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("A\u00F1adir imagen");
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setBounds(383, 102, 120, 32);
		contentPane.add(btnNewButton_3);
		
		Choice choice = new Choice();
		choice.setBounds(79, 114, 225, 20);
		contentPane.add(choice);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tipo");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(28, 119, 41, 19);
		contentPane.add(lblNewLabel_2_1);
	}
}
