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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class Vender extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidad;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox cmbModelo;
	private JTextField txtPrecio;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtAreaResultado;

	public static int contadorClicks = 0;
	public static int contadorVentas0 = 0, contadorVentas1 = 0, contadorVentas2 = 0, contadorVentas3 = 0, contadorVentas4 = 0;
	public static double acumuladorImporte0 = 0, acumuladorImporte1 = 0, acumuladorImporte2 = 0, acumuladorImporte3 = 0, acumuladorImporte4 = 0, acumuladorImporteTotal = 0;
	public static int acumuladorCajas0 = 0, acumuladorCajas1 = 0, acumuladorCajas2 = 0, acumuladorCajas3 = 0, acumuladorCajas4 = 0;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vender dialog = new Vender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vender() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vender.class.getResource("/imagenes/Logo.png")));
		setTitle("Vender");
		setBounds(100, 100, 451, 317);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBounds(0, 0, 436, 292);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 15, 45, 13);
		contentPanel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setBounds(10, 45, 75, 13);
		contentPanel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setBounds(10, 72, 75, 13);
		contentPanel.add(lblNewLabel_2);

		cmbModelo = new JComboBox();
		cmbModelo.addActionListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccionar modelo", "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa" }));
		cmbModelo.setBounds(95, 11, 175, 21);
		contentPanel.add(cmbModelo);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBackground(SystemColor.menu);
		txtPrecio.setBounds(95, 42, 175, 19);
		contentPanel.add(txtPrecio);
		txtPrecio.setEditable(false);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(95, 69, 175, 19);
		contentPanel.add(txtCantidad);

		btnVender = new JButton("Vender");
		btnVender.setBackground(new Color(255, 255, 255));
		btnVender.setIcon(new ImageIcon(Vender.class.getResource("/imagenes/vender.png")));
		btnVender.addActionListener(this);
		btnVender.setBounds(323, 11, 103, 21);
		contentPanel.add(btnVender);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setIcon(new ImageIcon(Vender.class.getResource("/imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(323, 68, 103, 21);
		contentPanel.add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.menu);
		scrollPane.setBounds(10, 100, 416, 174);
		contentPanel.add(scrollPane);

		txtAreaResultado = new JTextArea();
		scrollPane.setViewportView(txtAreaResultado);
		txtAreaResultado.setEditable(false);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setIcon(new ImageIcon(Vender.class.getResource("/imagenes/borrar.png")));
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setBounds(323, 40, 103, 21);
		contentPanel.add(btnBorrar);
	}

	// RUTEO DE MÉTODOS
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		}
		if (e.getSource() == btnVender) {
			contadorClicks++;
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}

	// SELECCION EN EL CMB
	public void actionPerformedCmbModelo(ActionEvent e) {

		String modelo = cmbModelo.getSelectedItem().toString();

		if (modelo.equals("Cinza Plus")) {
			String precio = Double.toString(MenuOpciones.precio0);
			txtPrecio.setText(precio);
		}

		if (modelo.equals("Luxury")) {
			String precio = Double.toString(MenuOpciones.precio1);
			txtPrecio.setText(precio);
		}

		if (modelo.equals("Austria")) {
			String precio = Double.toString(MenuOpciones.precio2);
			txtPrecio.setText(precio);
		}

		if (modelo.equals("Yungay Mix")) {
			String precio = Double.toString(MenuOpciones.precio3);
			txtPrecio.setText(precio);
		}

		if (modelo.equals("Thalía")) {
			String precio = Double.toString(MenuOpciones.precio4);
			txtPrecio.setText(precio);
		}

	}

	// BOTÓN VENDER
	public void actionPerformedBtnVender(ActionEvent e) {

		DecimalFormat dosDecimales = new DecimalFormat ("#.00"); 
		
		String modelo = null, tipoObsequio;
		int cantidad = 0, unidadesObsequio = 0;
		double precio = 0.0, impCompra, impPagar, descuento = 0.0, porcentajeCuotaDiaria = 0.0, importeDescuento;
		
		if(txtCantidad.getText().length() <= 0) {
			
			JOptionPane.showMessageDialog(null,"Por favor rellene el espacio en blanco", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {

		cantidad = Integer.parseInt(txtCantidad.getText());

		if(cantidad <= 0) {
			JOptionPane.showMessageDialog(null,"Operación inválida", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
		
		modelo = cmbModelo.getSelectedItem().toString();

		if (modelo.equals("Cinza Plus")) {
			contadorVentas0++;
			precio = MenuOpciones.precio0;
		}

		if (modelo.equals("Luxury")) {
			contadorVentas1++;
			precio = MenuOpciones.precio1;
		}

		if (modelo.equals("Austria")) {
			contadorVentas2++;
			precio = MenuOpciones.precio2;
		}

		if (modelo.equals("Yungay Mix")) {
			contadorVentas3++;
			precio = MenuOpciones.precio3;
		}

		if (modelo.equals("Thalía")) {
			contadorVentas4++;
			precio = MenuOpciones.precio4;
		}

		impCompra = precio * cantidad;

		if (cantidad >= 1 && cantidad <= 5) {
			descuento = MenuOpciones.porcentaje1 / 100;
		}
		if (cantidad >= 6 && cantidad <= 10) {
			descuento = MenuOpciones.porcentaje2 / 100;
		}
		if (cantidad >= 11 && cantidad <= 15) {
			descuento = MenuOpciones.porcentaje3 / 100;
		}
		if (cantidad > 15) {
			descuento = MenuOpciones.porcentaje4 / 100;
		}
		
		importeDescuento = impCompra * descuento;
		
		tipoObsequio = MenuOpciones.tipoObsequio;

		if (cantidad >= 1 && cantidad <= 5) {
			unidadesObsequio = MenuOpciones.obsequioCantidad1;
		}
		if (cantidad >= 6 && cantidad <= 10) {
			unidadesObsequio = MenuOpciones.obsequioCantidad2;
		}
		if (cantidad > 10) {
			unidadesObsequio = MenuOpciones.obsequioCantidad3;
		}

		impPagar = impCompra - importeDescuento;
	
		txtAreaResultado.setText("BOLETA DE VENTA" + "\n" + "\n");
		txtAreaResultado.append("Modelo                              : " + modelo + "\n");
		txtAreaResultado.append("Precio                                : S/." + dosDecimales.format(precio) + "\n");
		txtAreaResultado.append("Cantidad adquirida         : " + cantidad + "\n");
		txtAreaResultado.append("Importe compra               : S/." + dosDecimales.format(impCompra) + "\n");
		txtAreaResultado.append("Importe descuento          : S/." + importeDescuento + "\n");
		txtAreaResultado.append("Importe pagar                   : S/." + dosDecimales.format(impPagar) + "\n");
		txtAreaResultado.append("Tipo de obsequio             : " + tipoObsequio + "\n");
		txtAreaResultado.append("Unidades obsequiadas  : " + unidadesObsequio);
		
		if (modelo.equals("Cinza Plus")) {
			acumuladorCajas0 += cantidad;
			acumuladorImporte0 += impPagar;
		}

		if (modelo.equals("Luxury")) {
			acumuladorCajas1 += cantidad;
			acumuladorImporte1 += impPagar;
		}

		if (modelo.equals("Austria")) {
			acumuladorCajas2 += cantidad;
			acumuladorImporte2 += impPagar;
		}

		if (modelo.equals("Yungay Mix")) {
			acumuladorCajas3 += cantidad;
			acumuladorImporte3 += impPagar;
		}

		if (modelo.equals("Thalía")) {
			acumuladorCajas4 += cantidad;
			acumuladorImporte4 += impPagar;
		}
		
		acumuladorImporteTotal += impPagar; 
		
		porcentajeCuotaDiaria = 100 * acumuladorImporteTotal / MenuOpciones.cuotaDiaria;

		if (contadorClicks % 5 == 0) {
						
			JOptionPane.showMessageDialog(this,
					"Venta Nro. " + contadorClicks + "\n" + "Importe total general acumulado: S/." + dosDecimales.format(acumuladorImporteTotal) + "\n"
							+ "Porcentaje de la cuota diaria: " + dosDecimales.format(porcentajeCuotaDiaria) + " %",
					"Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	// BOTÓN CERRAR
	public void actionPerformedBtnCerrar(ActionEvent e) {
		this.setVisible(false);
	}
	
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtAreaResultado.setText("");
		txtCantidad.setText("");
		txtCantidad.requestFocus();
	}
}