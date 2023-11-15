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

public class ConfigurarPorcentajesDescuento extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMasQuinceUnidades;
	private JTextField txtOnceQuinceUnidades;
	private JTextField txtSeisDiezUnidades;
	private JTextField txtUnCincoUnidades;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblUnoCincoUnidades;
	private JLabel lblSeisDiezUnidades;
	private JLabel lblOnceQuinceUnidades;
	private JLabel lblMasQuinceUnidades;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarPorcentajesDescuento dialog = new ConfigurarPorcentajesDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarPorcentajesDescuento() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarPorcentajesDescuento.class.getResource("/imagenes/Logo.png")));
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 447, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblUnoCincoUnidades = new JLabel("1 a 5 unidades");
		lblUnoCincoUnidades.setBounds(10, 15, 118, 13);
		contentPanel.add(lblUnoCincoUnidades);

		lblSeisDiezUnidades = new JLabel("6 a 10 unidades");
		lblSeisDiezUnidades.setBounds(10, 38, 118, 13);
		contentPanel.add(lblSeisDiezUnidades);

		lblOnceQuinceUnidades = new JLabel("11 a 15 unidades");
		lblOnceQuinceUnidades.setBounds(10, 61, 118, 13);
		contentPanel.add(lblOnceQuinceUnidades);

		lblMasQuinceUnidades = new JLabel("M\u00E1s de 15 unidades");
		lblMasQuinceUnidades.setBounds(10, 84, 118, 13);
		contentPanel.add(lblMasQuinceUnidades);

		txtMasQuinceUnidades = new JTextField();
		txtMasQuinceUnidades.setColumns(10);
		txtMasQuinceUnidades.setBounds(133, 81, 96, 19);
		contentPanel.add(txtMasQuinceUnidades);
		String porcentaje4 = Double.toString(MenuOpciones.porcentaje4);
		txtMasQuinceUnidades.setText(porcentaje4);

		txtOnceQuinceUnidades = new JTextField();
		txtOnceQuinceUnidades.setColumns(10);
		txtOnceQuinceUnidades.setBounds(133, 58, 96, 19);
		contentPanel.add(txtOnceQuinceUnidades);
		String porcentaje3 = Double.toString(MenuOpciones.porcentaje3);
		txtOnceQuinceUnidades.setText(porcentaje3);

		txtSeisDiezUnidades = new JTextField();
		txtSeisDiezUnidades.setColumns(10);
		txtSeisDiezUnidades.setBounds(133, 35, 96, 19);
		contentPanel.add(txtSeisDiezUnidades);
		String porcentaje2 = Double.toString(MenuOpciones.porcentaje2);
		txtSeisDiezUnidades.setText(porcentaje2);

		txtUnCincoUnidades = new JTextField();
		txtUnCincoUnidades.setColumns(10);
		txtUnCincoUnidades.setBounds(133, 12, 96, 19);
		contentPanel.add(txtUnCincoUnidades);
		String porcentaje1 = Double.toString(MenuOpciones.porcentaje1);
		txtUnCincoUnidades.setText(porcentaje1);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setIcon(new ImageIcon(ConfigurarPorcentajesDescuento.class.getResource("/imagenes/grabar.png")));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(314, 11, 112, 21);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setIcon(new ImageIcon(ConfigurarPorcentajesDescuento.class.getResource("/imagenes/cerrar.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(314, 34, 112, 21);
		contentPanel.add(btnCancelar);

		lblNewLabel = new JLabel("%");
		lblNewLabel.setBounds(239, 15, 45, 13);
		contentPanel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(239, 38, 45, 13);
		contentPanel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setBounds(239, 61, 45, 13);
		contentPanel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setBounds(239, 84, 45, 13);
		contentPanel.add(lblNewLabel_3);

	}

	// ZONA DE RUTEO DE ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}

	// PROGRAMAR BOTON ACEPTAR
	public void actionPerformedBtnAceptar(ActionEvent e) {

		if (txtUnCincoUnidades.getText().length() <= 0 || txtSeisDiezUnidades.getText().length() <= 0
				|| txtOnceQuinceUnidades.getText().length() <= 0 || txtMasQuinceUnidades.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Por favor rellene el espacio en blanco", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {

			double descuento1 = Double.parseDouble(txtUnCincoUnidades.getText());
			double descuento2 = Double.parseDouble(txtUnCincoUnidades.getText());
			double descuento3 = Double.parseDouble(txtUnCincoUnidades.getText());
			double descuento4 = Double.parseDouble(txtUnCincoUnidades.getText());

			if (descuento1 < 0 || descuento2 < 0 || descuento3 < 0 || descuento4 < 0) {
				JOptionPane.showMessageDialog(null, "Ingrese una cantidad de cero a más", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				double nuevoPorcentaje1 = Double.parseDouble(txtUnCincoUnidades.getText());
				MenuOpciones.porcentaje1 = nuevoPorcentaje1;

				double nuevoPorcentaje2 = Double.parseDouble(txtSeisDiezUnidades.getText());
				MenuOpciones.porcentaje2 = nuevoPorcentaje2;

				double nuevoPorcentaje3 = Double.parseDouble(txtOnceQuinceUnidades.getText());
				MenuOpciones.porcentaje3 = nuevoPorcentaje3;

				double nuevoPorcentaje4 = Double.parseDouble(txtMasQuinceUnidades.getText());
				MenuOpciones.porcentaje4 = nuevoPorcentaje4;
				JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
				this.setVisible(false);
			}
		}
	}

	// PROGRAMAR BOTON CANCELAR
	public void actionPerformedBtnCancelar(ActionEvent e) {
		this.setVisible(false);
	}
}