package tpv;

import java.awt.BorderLayout;
import tpv.EscribeProducto;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class EnsenyaOpciones extends JFrame {

	private JPanel contentPane;
	private EscribeProducto anyade = new EscribeProducto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnsenyaOpciones frame = new EnsenyaOpciones();
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
	public EnsenyaOpciones() {
		setPreferredSize(new Dimension(1920, 1080));
		setSize(new Dimension(1920, 1080));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Añadir Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto nuevo = new Producto("ejemplo",0.5,"ninguna.jpg");
				try {
					anyade.anyadirUnProducto(nuevo);
					System.out.println("Producto añadido");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Ha habido un error al añadir el producto");
				}
				
			}
		});
		contentPane.add(btnNewButton);
	}
	


}
