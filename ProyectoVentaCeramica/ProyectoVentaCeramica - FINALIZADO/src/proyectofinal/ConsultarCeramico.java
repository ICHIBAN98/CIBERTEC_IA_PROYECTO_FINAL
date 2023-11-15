package proyectofinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class ConsultarCeramico extends JDialog implements ActionListener {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultarCeramico dialog = new ConsultarCeramico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarCeramico() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarCeramico.class.getResource("/imagenes/Logo.png")));
		setTitle("Consultar Cer\u00E1mico");
		setBounds(100, 100, 513, 225);
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
		cmbModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		cmbModelo.setBounds(104, 11, 256, 22);
		contentPanel.add(cmbModelo);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBackground(SystemColor.menu);
		txtPrecio.setBounds(104, 42, 256, 22);
		contentPanel.add(txtPrecio);
		String precio = Double.toString(MenuOpciones.precio0);
		txtPrecio.setText(precio);
		txtPrecio.setEditable(false);

		txtLargo = new JTextField();
		txtLargo.setColumns(10);
		txtLargo.setBackground(SystemColor.menu);
		txtLargo.setBounds(104, 93, 256, 22);
		contentPanel.add(txtLargo);
		String largo = Double.toString(MenuOpciones.largo0);
		txtLargo.setText(largo);
		txtLargo.setEditable(false);

		txtEspesor = new JTextField();
		txtEspesor.setColumns(10);
		txtEspesor.setBackground(SystemColor.menu);
		txtEspesor.setBounds(104, 120, 256, 22);
		contentPanel.add(txtEspesor);
		String espesor = Double.toString(MenuOpciones.espesor0);
		txtEspesor.setText(espesor);
		txtEspesor.setEditable(false);

		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBackground(SystemColor.menu);
		txtAncho.setBounds(104, 67, 256, 22);
		contentPanel.add(txtAncho);
		String ancho = Double.toString(MenuOpciones.ancho0);
		txtAncho.setText(ancho);
		txtAncho.setEditable(false);

		txtContenido = new JTextField();
		txtContenido.setColumns(10);
		txtContenido.setBackground(SystemColor.menu);
		txtContenido.setBounds(104, 148, 256, 22);
		contentPanel.add(txtContenido);
		String contenido = Integer.toString(MenuOpciones.contenido0);
		txtContenido.setText(contenido);
		txtContenido.setEditable(false); 

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setIcon(new ImageIcon(ConsultarCeramico.class.getResource("/imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(386, 11, 100, 23);
		contentPanel.add(btnCerrar);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		String modelo = cmbModelo.getSelectedItem().toString();
		
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		
		if(modelo.equals("Cinza Plus")) {
			actionPerformedCmbCinzaPlus(e);
		}
		if(modelo.equals("Luxury")) {
			actionPerformedCmbLuxury(e);
		}
		if(modelo.equals("Austria")) {
			actionPerformedCmbAustria(e);
		}
		if(modelo.equals("Yungay Mix")) {
			actionPerformedCmbYungayMix(e);
		}
		if(modelo.equals("Thalía")) {
			actionPerformedCmbThalía(e);
		}
		
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		cmbModelo.setSelectedIndex(0);
		this.setVisible(false);
	}
	
	public void actionPerformedCmbCinzaPlus(ActionEvent e) {
		
		
		String precio = Double.toString(MenuOpciones.precio0);
		txtPrecio.setText(precio);
		txtPrecio.setEditable(false); //Hacer que el JTextField no sea editable
		
		String ancho = Double.toString(MenuOpciones.ancho0);
		txtAncho.setText(ancho);
		txtAncho.setEditable(false); //Hacer que el JTextField no sea editable
		
		String largo = Double.toString(MenuOpciones.largo0);
		txtLargo.setText(largo);
		txtLargo.setEditable(false); //Hacer que el JTextField no sea editable
		
		String espesor = Double.toString(MenuOpciones.espesor0);
		txtEspesor.setText(espesor);
		txtEspesor.setEditable(false); //Hacer que el JTextField no sea editable
		
		String contenido = Integer.toString(MenuOpciones.contenido0);
		txtContenido.setText(contenido);
		txtContenido.setEditable(false); //Hacer que el JTextField no sea editable
	}
	public void actionPerformedCmbLuxury(ActionEvent e) {
		String precio = Double.toString(MenuOpciones.precio1);
		txtPrecio.setText(precio);
		txtPrecio.setEditable(false); //Hacer que el JTextField no sea editable
		
		String ancho = Double.toString(MenuOpciones.ancho1);
		txtAncho.setText(ancho);
		txtAncho.setEditable(false); //Hacer que el JTextField no sea editable
		
		String largo = Double.toString(MenuOpciones.largo1);
		txtLargo.setText(largo);
		txtLargo.setEditable(false); //Hacer que el JTextField no sea editable
		
		String espesor = Double.toString(MenuOpciones.espesor1);
		txtEspesor.setText(espesor);
		txtEspesor.setEditable(false); //Hacer que el JTextField no sea editable
		
		String contenido = Integer.toString(MenuOpciones.contenido1);
		txtContenido.setText(contenido);
		txtContenido.setEditable(false); //Hacer que el JTextField no sea editable
	}
	public void actionPerformedCmbAustria(ActionEvent e) {
		String precio = Double.toString(MenuOpciones.precio2);
		txtPrecio.setText(precio);
		txtPrecio.setEditable(false); //Hacer que el JTextField no sea editable
		
		String ancho = Double.toString(MenuOpciones.ancho2);
		txtAncho.setText(ancho);
		txtAncho.setEditable(false); //Hacer que el JTextField no sea editable
		
		String largo = Double.toString(MenuOpciones.largo2);
		txtLargo.setText(largo);
		txtLargo.setEditable(false); //Hacer que el JTextField no sea editable
		
		String espesor = Double.toString(MenuOpciones.espesor2);
		txtEspesor.setText(espesor);
		txtEspesor.setEditable(false); //Hacer que el JTextField no sea editable
		
		String contenido = Integer.toString(MenuOpciones.contenido2);
		txtContenido.setText(contenido);
		txtContenido.setEditable(false); //Hacer que el JTextField no sea editable

	}
	public void actionPerformedCmbYungayMix(ActionEvent e) {
		String precio = Double.toString(MenuOpciones.precio3);
		txtPrecio.setText(precio);
		txtPrecio.setEditable(false); //Hacer que el JTextField no sea editable
		
		String ancho = Double.toString(MenuOpciones.ancho3);
		txtAncho.setText(ancho);
		txtAncho.setEditable(false); //Hacer que el JTextField no sea editable
		
		String largo = Double.toString(MenuOpciones.largo3);
		txtLargo.setText(largo);
		txtLargo.setEditable(false); //Hacer que el JTextField no sea editable
		
		String espesor = Double.toString(MenuOpciones.espesor3);
		txtEspesor.setText(espesor);
		txtEspesor.setEditable(false); //Hacer que el JTextField no sea editable
		
		String contenido = Integer.toString(MenuOpciones.contenido3);
		txtContenido.setText(contenido);
		txtContenido.setEditable(false); //Hacer que el JTextField no sea editable

	}
	public void actionPerformedCmbThalía(ActionEvent e) {
		String precio = Double.toString(MenuOpciones.precio4);
		txtPrecio.setText(precio);
		txtPrecio.setEditable(false); //Hacer que el JTextField no sea editable
		
		String ancho = Double.toString(MenuOpciones.ancho4);
		txtAncho.setText(ancho);
		txtAncho.setEditable(false); //Hacer que el JTextField no sea editable
		
		String largo = Double.toString(MenuOpciones.largo4);
		txtLargo.setText(largo);
		txtLargo.setEditable(false); //Hacer que el JTextField no sea editable
		
		String espesor = Double.toString(MenuOpciones.espesor4);
		txtEspesor.setText(espesor);
		txtEspesor.setEditable(false); //Hacer que el JTextField no sea editable
		
		String contenido = Integer.toString(MenuOpciones.contenido4);
		txtContenido.setText(contenido);
		txtContenido.setEditable(false); //Hacer que el JTextField no sea editable

	}
	
}