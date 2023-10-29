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

public class ConfigurarCuotaDiaria extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuotaDiaria;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarCuotaDiaria dialog = new ConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarCuotaDiaria() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigurarCuotaDiaria.class.getResource("/imagenes/Logo.png")));
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 450, 113);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setBounds(10, 15, 150, 13);
		contentPanel.add(lblNewLabel);

		txtCuotaDiaria = new JTextField();
		txtCuotaDiaria.setColumns(10);
		txtCuotaDiaria.setBounds(170, 12, 69, 19);
		contentPanel.add(txtCuotaDiaria);
		String cuota = Double.toString((MenuOpciones.cuotaDiaria));
		txtCuotaDiaria.setText(cuota);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.setIcon(new ImageIcon(ConfigurarCuotaDiaria.class.getResource("/imagenes/grabar.png")));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(305, 11, 121, 21);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setIcon(new ImageIcon(ConfigurarCuotaDiaria.class.getResource("/imagenes/cerrar.png")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(305, 42, 121, 21);
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

	public void actionPerformedBtnCancelar(ActionEvent e) {
		this.setVisible(false);
	}

	public void actionPerformedBtnAceptar(ActionEvent e) {
		if(txtCuotaDiaria.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null,"Por favor rellene el espacio en blanco", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
		double nuevaCuota = Double.parseDouble(txtCuotaDiaria.getText());
		if (nuevaCuota <= 0.0) {
			JOptionPane.showMessageDialog(null, "Operación inválida", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
		MenuOpciones.cuotaDiaria = nuevaCuota;
		JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
		this.setVisible(false);
			}
		}
	}
}
