package proyectofinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class AcercaDeTienda extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_1_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AcercaDeTienda dialog = new AcercaDeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AcercaDeTienda() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDeTienda.class.getResource("/imagenes/Logo.png")));
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 285);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel_1 = new JLabel("Programadores");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(142, 68, 142, 22);
		contentPanel.add(lblNewLabel_1);

		lblNewLabel = new JLabel("Tienda de Cer\u00E1micos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(new Rectangle(147, 10, 143, 33));
		lblNewLabel.setBounds(76, 10, 416, 33);
		contentPanel.add(lblNewLabel);

		lblNewLabel_2 = new JLabel(
				"_________________________________________________________________________________");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(-19, 36, 492, 22);
		contentPanel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Mateo Regalado");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(161, 113, 114, 19);
		contentPanel.add(lblNewLabel_3);

		lblNewLabel_3_1 = new JLabel("Ra\u00FAl Rosas");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(178, 142, 83, 13);
		contentPanel.add(lblNewLabel_3_1);

		lblNewLabel_3_1_1 = new JLabel("Gustavo Linares");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(161, 169, 106, 13);
		contentPanel.add(lblNewLabel_3_1_1);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setIcon(new ImageIcon(AcercaDeTienda.class.getResource("/imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCerrar.setBounds(161, 214, 109, 21);
		contentPanel.add(btnCerrar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	public void actionPerformedBtnCerrar(ActionEvent e) {
		this.setVisible(false);
	}

}