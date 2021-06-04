package tpv;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AnyadeDescuento extends JFrame {

	private JPanel contentPane;
	private JTextField cantidad;
	private JTextField nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public AnyadeDescuento() {
		setBounds(100, 100, 525, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A\u00D1ADIR DESCUENTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(271, 11, 188, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del descuento");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_1.setBounds(24, 39, 201, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total del descuento en \u20AC");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_2.setBounds(34, 96, 206, 40);
		contentPane.add(lblNewLabel_2);
		
		cantidad = new JTextField();
		cantidad.setBounds(284, 103, 105, 34);
		contentPane.add(cantidad);
		cantidad.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(235, 45, 257, 32);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 144, 509, 94);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton borrar = new JButton("Borrar");
		panel.add(borrar);
		
		JButton anyadeDescuento = new JButton("A\u00F1adir");
		panel.add(anyadeDescuento);
		JButton salir = new JButton("Salir");
		panel.add(salir);
		
		JLabel lblNewLabel_3 = new JLabel("\u20AC");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_3.setBounds(399, 105, 46, 31);
		contentPane.add(lblNewLabel_3);
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		anyadeDescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TodoDescuento.anyadirUnDescuento(new Descuento(nombre.getText(), Double.parseDouble(cantidad.getText())));
					JOptionPane.showMessageDialog(anyadeDescuento, "El descuento ha sido añadido con éxito.");
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre.setText(null);
				cantidad.setText(null);
			}
		});
	}
}
