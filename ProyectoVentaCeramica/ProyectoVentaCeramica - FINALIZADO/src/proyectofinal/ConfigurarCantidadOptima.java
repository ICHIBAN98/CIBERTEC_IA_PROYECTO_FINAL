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

public class ConfigurarCantidadOptima extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantOpUnVendidas;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarCantidadOptima dialog = new ConfigurarCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarCantidadOptima() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCantidadOptima.class.getResource("/imagenes/Logo.png")));
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 474, 109);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblNewLabel.setBounds(10, 15, 220, 13);
		contentPanel.add(lblNewLabel);

		txtCantOpUnVendidas = new JTextField();
		txtCantOpUnVendidas.setColumns(10);
		txtCantOpUnVendidas.setBounds(239, 12, 52, 19);
		contentPanel.add(txtCantOpUnVendidas);
		txtCantOpUnVendidas.setText(Integer.toString(MenuOpciones.cantidadOptima));

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setIcon(new ImageIcon(ConfigurarCantidadOptima.class.getResource("/imagenes/grabar.png")));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(328, 12, 120, 21);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setIcon(new ImageIcon(ConfigurarCantidadOptima.class.getResource("/imagenes/cerrar.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(328, 39, 120, 21);
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
		if (txtCantOpUnVendidas.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Por favor rellene el espacio en blanco", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			int nuevaCantidadOptima = Integer.parseInt(txtCantOpUnVendidas.getText());
			if (nuevaCantidadOptima <= 0) {
				JOptionPane.showMessageDialog(null, "Operación inválida", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				MenuOpciones.cantidadOptima = nuevaCantidadOptima;
				JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
				this.setVisible(false);
			}
		}

	}

	public void actionPerformedBtnCancelar(ActionEvent e) {
		this.setVisible(false);
	}
}