package proyectofinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class ConfigurarObsequios extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtObsequioCantidad3;
	private JTextField txtObsequioCantidad2;
	private JTextField txtObsequioCantidad1;
	private JTextField txtTipoObsequio;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarObsequios dialog = new ConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarObsequios() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarObsequios.class.getResource("/imagenes/Logo.png")));
		setTitle("Configurar obsequios");
		setBounds(100, 100, 450, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("Tipo de obsequio");
		lblNewLabel.setBounds(10, 15, 107, 13);
		contentPanel.add(lblNewLabel);

		lblNewLabel1 = new JLabel("1 a 5 unidades");
		lblNewLabel1.setBounds(10, 38, 96, 13);
		contentPanel.add(lblNewLabel1);

		lblNewLabel2 = new JLabel("6 a 10 unidades");
		lblNewLabel2.setBounds(10, 61, 96, 13);
		contentPanel.add(lblNewLabel2);

		lblNewLabel3 = new JLabel("11 a m\u00E1s unidades");
		lblNewLabel3.setBounds(10, 84, 107, 13);
		contentPanel.add(lblNewLabel3);

		txtObsequioCantidad3 = new JTextField();
		txtObsequioCantidad3.setColumns(10);
		txtObsequioCantidad3.setBounds(126, 81, 96, 19);
		contentPanel.add(txtObsequioCantidad3);
		txtObsequioCantidad3.setText(Integer.toString(MenuOpciones.obsequioCantidad3));

		txtObsequioCantidad2 = new JTextField();
		txtObsequioCantidad2.setColumns(10);
		txtObsequioCantidad2.setBounds(126, 58, 96, 19);
		contentPanel.add(txtObsequioCantidad2);
		txtObsequioCantidad2.setText(Integer.toString(MenuOpciones.obsequioCantidad2));

		txtObsequioCantidad1 = new JTextField();
		txtObsequioCantidad1.setColumns(10);
		txtObsequioCantidad1.setBounds(126, 35, 96, 19);
		contentPanel.add(txtObsequioCantidad1);
		txtObsequioCantidad1.setText(Integer.toString(MenuOpciones.obsequioCantidad1));

		txtTipoObsequio = new JTextField();
		txtTipoObsequio.setColumns(10);
		txtTipoObsequio.setBounds(126, 12, 96, 19);
		contentPanel.add(txtTipoObsequio);
		txtTipoObsequio.setText(MenuOpciones.tipoObsequio);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setIcon(new ImageIcon(ConfigurarObsequios.class.getResource("/imagenes/grabar.png")));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(309, 11, 117, 21);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setIcon(new ImageIcon(ConfigurarObsequios.class.getResource("/imagenes/cerrar.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(309, 34, 117, 21);
		contentPanel.add(btnCancelar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}

	public void actionPerformedBtnAceptar(ActionEvent e) {

		if (txtTipoObsequio.getText().length() <= 0 || txtObsequioCantidad1.getText().length() <= 0
				|| txtObsequioCantidad2.getText().length() <= 0 || txtObsequioCantidad3.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Por favor rellene el espacio en blanco", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			int obsequioCantidad1 = Integer.parseInt(txtObsequioCantidad1.getText());
			int obsequioCantidad2 = Integer.parseInt(txtObsequioCantidad2.getText());
			int obsequioCantidad3 = Integer.parseInt(txtObsequioCantidad3.getText());
			
			String nuevoTipoObsequio = txtTipoObsequio.getText();
			MenuOpciones.tipoObsequio = nuevoTipoObsequio;

			if (obsequioCantidad1 < 0 || obsequioCantidad2 < 0 || obsequioCantidad3 < 0) {
				JOptionPane.showMessageDialog(null, "Ingrese una cantidad de cero a más", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int nuevoObsequioCantidad1 = Integer.parseInt(txtObsequioCantidad1.getText());
				MenuOpciones.obsequioCantidad1 = nuevoObsequioCantidad1;

				int nuevoObsequioCantidad2 = Integer.parseInt(txtObsequioCantidad2.getText());
				MenuOpciones.obsequioCantidad2 = nuevoObsequioCantidad2;

				int nuevoObsequioCantidad3 = Integer.parseInt(txtObsequioCantidad3.getText());
				MenuOpciones.obsequioCantidad3 = nuevoObsequioCantidad3;
				JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
				this.setVisible(false);
			}
		}
	}

	public void actionPerformedBtnCancelar(ActionEvent e) {
		this.setVisible(false);
	}
}