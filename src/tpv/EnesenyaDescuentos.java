package tpv;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EnesenyaDescuentos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnesenyaDescuentos frame = new EnesenyaDescuentos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public EnesenyaDescuentos() throws IOException {
		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(3, 3));
		setContentPane(contentPane);
		ArrayList<Descuento> leeBotones = TodoDescuento.botonesDescuento();
		for (Descuento descuento : leeBotones) {
			JButton btnNewButton = new JButton(descuento.getNombre());
			contentPane.add(btnNewButton);
	}

}
}
