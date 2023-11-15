package proyectofinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class ModificarCeramico extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtAncho;
	private JTextField txtContenido;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblLargocm;
	private JLabel lblEspesormm;
	private JLabel lblAnchocm;
	private JLabel lblContenido;
	private JComboBox cmbModelo;
	private JButton btnCerrar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarCeramico dialog = new ModificarCeramico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarCeramico() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarCeramico.class.getResource("/imagenes/Logo.png")));
		setTitle("Modificar Cer\u00E1mico");
		setBounds(100, 100, 517, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPanel.add(lblNewLabel);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 46, 84, 14);
		contentPanel.add(lblPrecio);

		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setBounds(10, 97, 84, 14);
		contentPanel.add(lblLargocm);

		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setBounds(10, 124, 84, 14);
		contentPanel.add(lblEspesormm);

		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setBounds(10, 71, 84, 14);
		contentPanel.add(lblAnchocm);

		lblContenido = new JLabel("Contenido");
		lblContenido.setBounds(10, 152, 84, 14);
		contentPanel.add(lblContenido);

		cmbModelo = new JComboBox();
		cmbModelo.addActionListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel(
				new String[] { "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa" }));
		cmbModelo.setBounds(104, 11, 256, 22);
		contentPanel.add(cmbModelo);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBackground(SystemColor.menu);
		txtPrecio.setBounds(104, 42, 256, 22);
		contentPanel.add(txtPrecio);
		String precio = Double.toString(MenuOpciones.precio0);
		txtPrecio.setText(precio);

		txtLargo = new JTextField();
		txtLargo.setColumns(10);
		txtLargo.setBackground(SystemColor.menu);
		txtLargo.setBounds(104, 93, 256, 22);
		contentPanel.add(txtLargo);
		String largo = Double.toString(MenuOpciones.largo0);
		txtLargo.setText(largo);

		txtEspesor = new JTextField();
		txtEspesor.setColumns(10);
		txtEspesor.setBackground(SystemColor.menu);
		txtEspesor.setBounds(104, 120, 256, 22);
		contentPanel.add(txtEspesor);
		String espesor = Double.toString(MenuOpciones.espesor0);
		txtEspesor.setText(espesor);

		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBackground(SystemColor.menu);
		txtAncho.setBounds(104, 67, 256, 22);
		contentPanel.add(txtAncho);
		String ancho = Double.toString(MenuOpciones.ancho0);
		txtAncho.setText(ancho);

		txtContenido = new JTextField();
		txtContenido.setColumns(10);
		txtContenido.setBackground(SystemColor.menu);
		txtContenido.setBounds(104, 148, 256, 22);
		contentPanel.add(txtContenido);
		String contenido = Integer.toString(MenuOpciones.contenido0);
		txtContenido.setText(contenido);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setIcon(new ImageIcon(ModificarCeramico.class.getResource("/imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(384, 11, 107, 23);
		contentPanel.add(btnCerrar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.setBackground(new Color(255, 255, 255));
		btnGrabar.setIcon(new ImageIcon(ModificarCeramico.class.getResource("/imagenes/grabar.png")));
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(384, 42, 107, 23);
		contentPanel.add(btnGrabar);

	}

	// ZONA DE RUTEO DE actionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	// PROGRAMAR LO QUE SE MUESTRA AL SELECCIONAR EN EL CMB
	public void actionPerformedCmbModelo(ActionEvent e) {

		int modelo = cmbModelo.getSelectedIndex();

		if (modelo == 0) {
			String precio = Double.toString(MenuOpciones.precio0);
			txtPrecio.setText(precio);
			String ancho = Double.toString(MenuOpciones.ancho0);
			txtAncho.setText(ancho);
			String largo = Double.toString(MenuOpciones.largo0);
			txtLargo.setText(largo);
			String espesor = Double.toString(MenuOpciones.espesor0);
			txtEspesor.setText(espesor);
			String contenido = Integer.toString(MenuOpciones.contenido0);
			txtContenido.setText(contenido);
		}

		if (modelo == 1) {
			String precio = Double.toString(MenuOpciones.precio1);
			txtPrecio.setText(precio);
			String ancho = Double.toString(MenuOpciones.ancho1);
			txtAncho.setText(ancho);
			String largo = Double.toString(MenuOpciones.largo1);
			txtLargo.setText(largo);
			String espesor = Double.toString(MenuOpciones.espesor1);
			txtEspesor.setText(espesor);
			String contenido = Integer.toString(MenuOpciones.contenido1);
			txtContenido.setText(contenido);
		}

		if (modelo == 2) {
			String precio = Double.toString(MenuOpciones.precio2);
			txtPrecio.setText(precio);
			String ancho = Double.toString(MenuOpciones.ancho2);
			txtAncho.setText(ancho);
			String largo = Double.toString(MenuOpciones.largo2);
			txtLargo.setText(largo);
			String espesor = Double.toString(MenuOpciones.espesor2);
			txtEspesor.setText(espesor);
			String contenido = Integer.toString(MenuOpciones.contenido2);
			txtContenido.setText(contenido);
		}

		if (modelo == 3) {
			String precio = Double.toString(MenuOpciones.precio3);
			txtPrecio.setText(precio);
			String ancho = Double.toString(MenuOpciones.ancho3);
			txtAncho.setText(ancho);
			String largo = Double.toString(MenuOpciones.largo3);
			txtLargo.setText(largo);
			String espesor = Double.toString(MenuOpciones.espesor3);
			txtEspesor.setText(espesor);
			String contenido = Integer.toString(MenuOpciones.contenido3);
			txtContenido.setText(contenido);
		}

		if (modelo == 4) {
			String precio = Double.toString(MenuOpciones.precio4);
			txtPrecio.setText(precio);
			String ancho = Double.toString(MenuOpciones.ancho4);
			txtAncho.setText(ancho);
			String largo = Double.toString(MenuOpciones.largo4);
			txtLargo.setText(largo);
			String espesor = Double.toString(MenuOpciones.espesor4);
			txtEspesor.setText(espesor);
			String contenido = Integer.toString(MenuOpciones.contenido4);
			txtContenido.setText(contenido);
		}
	}

	// PROGRAMAR BOTÓN GRABAR
	public void actionPerformedBtnGrabar(ActionEvent e) {

		String modelo = cmbModelo.getSelectedItem().toString();

		if (txtPrecio.getText().length() <= 0 || txtAncho.getText().length() <= 0 || txtLargo.getText().length() <= 0
				|| txtEspesor.getText().length() <= 0 || txtContenido.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Por favor rellene el espacio en blanco", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {

			double nPrecio = Double.parseDouble(txtPrecio.getText());
			double nAncho = Double.parseDouble(txtAncho.getText());
			double nLargo = Double.parseDouble(txtLargo.getText());
			double nEspesor = Double.parseDouble(txtEspesor.getText());
			int nContenido = Integer.parseInt(txtContenido.getText());

			if (nPrecio <= 0 || nAncho <= 0 || nLargo <= 0 || nEspesor <= 0 || nContenido <= 0) {
				JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a cero", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (modelo.equals("Cinza Plus")) {
					double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
					MenuOpciones.precio0 = nuevoPrecio;
					double nuevoAncho = Double.parseDouble(txtAncho.getText());
					MenuOpciones.ancho0 = nuevoAncho;
					double nuevoLargo = Double.parseDouble(txtLargo.getText());
					MenuOpciones.largo0 = nuevoLargo;
					double nuevoEspesor = Double.parseDouble(txtEspesor.getText());
					MenuOpciones.espesor0 = nuevoEspesor;
					int nuevoContenido = Integer.parseInt(txtContenido.getText());
					MenuOpciones.contenido0 = nuevoContenido;
					JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
					this.setVisible(false);

				}

				if (modelo.equals("Luxury")) {
					double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
					MenuOpciones.precio1 = nuevoPrecio;
					double nuevoAncho = Double.parseDouble(txtAncho.getText());
					MenuOpciones.ancho1 = nuevoAncho;
					double nuevoLargo = Double.parseDouble(txtLargo.getText());
					MenuOpciones.largo1 = nuevoLargo;
					double nuevoEspesor = Double.parseDouble(txtEspesor.getText());
					MenuOpciones.espesor1 = nuevoEspesor;
					int nuevoContenido = Integer.parseInt(txtContenido.getText());
					MenuOpciones.contenido1 = nuevoContenido;
					JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
					this.setVisible(false);
				}

				if (modelo.equals("Austria")) {
					double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
					MenuOpciones.precio2 = nuevoPrecio;
					double nuevoAncho = Double.parseDouble(txtAncho.getText());
					MenuOpciones.ancho2 = nuevoAncho;
					double nuevoLargo = Double.parseDouble(txtLargo.getText());
					MenuOpciones.largo2 = nuevoLargo;
					double nuevoEspesor = Double.parseDouble(txtEspesor.getText());
					MenuOpciones.espesor2 = nuevoEspesor;
					int nuevoContenido = Integer.parseInt(txtContenido.getText());
					MenuOpciones.contenido2 = nuevoContenido;
					JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
					this.setVisible(false);
				}

				if (modelo.equals("Yungay Mix")) {
					double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
					MenuOpciones.precio3 = nuevoPrecio;
					double nuevoAncho = Double.parseDouble(txtAncho.getText());
					MenuOpciones.ancho3 = nuevoAncho;
					double nuevoLargo = Double.parseDouble(txtLargo.getText());
					MenuOpciones.largo3 = nuevoLargo;
					double nuevoEspesor = Double.parseDouble(txtEspesor.getText());
					MenuOpciones.espesor3 = nuevoEspesor;
					int nuevoContenido = Integer.parseInt(txtContenido.getText());
					MenuOpciones.contenido3 = nuevoContenido;
					JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
					this.setVisible(false);
				}

				if (modelo.equals("Thalía")) {
					double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
					MenuOpciones.precio4 = nuevoPrecio;
					double nuevoAncho = Double.parseDouble(txtAncho.getText());
					MenuOpciones.ancho4 = nuevoAncho;
					double nuevoLargo = Double.parseDouble(txtLargo.getText());
					MenuOpciones.largo4 = nuevoLargo;
					double nuevoEspesor = Double.parseDouble(txtEspesor.getText());
					MenuOpciones.espesor4 = nuevoEspesor;
					int nuevoContenido = Integer.parseInt(txtContenido.getText());
					MenuOpciones.contenido4 = nuevoContenido;
					JOptionPane.showMessageDialog(null, "Modificación realizada con éxito");
					this.setVisible(false);
				}
			}
		}
	}

	// PROGRAMAR BOTÓN CERRAR
	public void actionPerformedBtnCerrar(ActionEvent e) {
		this.setVisible(false);
	}
}