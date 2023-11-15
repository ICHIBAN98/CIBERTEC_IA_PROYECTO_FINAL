package proyectofinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class GenerarReportes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTipoReporte;
	private JComboBox cmbReporte;
	private JTextArea txtArea;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	
	public static double porcentajeCuotaDiaria0, porcentajeCuotaDiaria1, porcentajeCuotaDiaria2, porcentajeCuotaDiaria3, porcentajeCuotaDiaria4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenerarReportes dialog = new GenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GenerarReportes() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarReportes.class.getResource("/imagenes/Logo.png")));
		setTitle("Generar Reportes");
		setBounds(100, 100, 700, 303);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblTipoReporte = new JLabel("Tipo de reporte");
		lblTipoReporte.setBounds(10, 15, 97, 13);
		contentPanel.add(lblTipoReporte);

		cmbReporte = new JComboBox();
		cmbReporte.addActionListener(this);
		cmbReporte.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar tipo de reporte", "Ventas por modelo", "Comparaci\u00F3n de precios con el precio promedio", "Comparaci\u00F3n de cajas vendidas con la cantidad \u00F3ptima", "Estad\u00EDsticas sobre el precio"}));
		cmbReporte.setToolTipText("");
		cmbReporte.setBounds(105, 11, 440, 21);
		contentPanel.add(cmbReporte);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setIcon(new ImageIcon(GenerarReportes.class.getResource("/imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(580, 11, 97, 21);
		contentPanel.add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 667, 216);
		contentPanel.add(scrollPane);

		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		txtArea.setEditable(false);
		}
	public void actionPerformed(ActionEvent e) {
		
		String reporte = cmbReporte.getSelectedItem().toString();
		
		if(e.getSource() == btnCerrar) { 
			actionPerformedBtnCerrar(e);
		}

		if(reporte.equals("Ventas por modelo")) {
			actionPerformedBtnVentas(e);
		}
		
		if(reporte.equals("Comparación de precios con el precio promedio")) {
			actionPerformedBtnComparacion(e);
		}

		if(reporte.equals("Comparación de cajas vendidas con la cantidad óptima")) {
			actionPerformedBtnComparacionCajas(e);
		}
		
		if(reporte.equals("Estadísticas sobre el precio")) {
			actionPerformedBtnEstadisticas(e);
		}
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		this.setVisible(false);
	}
	public void actionPerformedBtnVentas(ActionEvent e) {
		
		DecimalFormat dosDecimales = new DecimalFormat ("#.00"); 
		
		porcentajeCuotaDiaria0 = 100 * Vender.acumuladorImporte0 / MenuOpciones.cuotaDiaria;
		porcentajeCuotaDiaria1 = 100 * Vender.acumuladorImporte1 / MenuOpciones.cuotaDiaria;
		porcentajeCuotaDiaria2 = 100 * Vender.acumuladorImporte2 / MenuOpciones.cuotaDiaria;
		porcentajeCuotaDiaria3 = 100 * Vender.acumuladorImporte3 / MenuOpciones.cuotaDiaria;
		porcentajeCuotaDiaria4 = 100 * Vender.acumuladorImporte4 / MenuOpciones.cuotaDiaria;
		
		txtArea.setText("VENTAS POR MODELO" + "\n" + "\n");
		txtArea.append("Modelo                                            : " + MenuOpciones.modelo0 + "\n");
		txtArea.append("Cantidad de ventas                      : " + Vender.contadorVentas0 + "\n");
		txtArea.append("Cantidad de cajas vendidas      : " + Vender.acumuladorCajas0 + "\n");
		txtArea.append("Importe total vendido                   : " + "S/. "+ dosDecimales.format(Vender.acumuladorImporte0) + "\n");
		txtArea.append("Aporte a la cuota diaria               : " + dosDecimales.format(porcentajeCuotaDiaria0) + " % " + "\n" );
		txtArea.append("" + "\n");
		txtArea.append("Modelo                                            : " + MenuOpciones.modelo1 + "\n");
		txtArea.append("Cantidad de ventas                      : " + Vender.contadorVentas1 + "\n");
		txtArea.append("Cantidad de cajas vendidas      : " + Vender.acumuladorCajas1 + "\n");
		txtArea.append("Importe total vendido                   : " + "S/. "+ dosDecimales.format(Vender.acumuladorImporte1) + "\n");
		txtArea.append("Aporte a la cuota diaria               : " + dosDecimales.format(porcentajeCuotaDiaria1) + " % " + "\n" );
		txtArea.append("" + "\n");
		txtArea.append("Modelo                                            : " + MenuOpciones.modelo2 + "\n");
		txtArea.append("Cantidad de ventas                      : " + Vender.contadorVentas2 + "\n");
		txtArea.append("Cantidad de cajas vendidas      : " + Vender.acumuladorCajas2 + "\n");
		txtArea.append("Importe total vendido                   : " + "S/. "+ dosDecimales.format(Vender.acumuladorImporte2) + "\n");
		txtArea.append("Aporte a la cuota diaria               : " + dosDecimales.format(porcentajeCuotaDiaria2) + " % " + "\n" );
		txtArea.append("" + "\n");
		txtArea.append("Modelo                                            : " + MenuOpciones.modelo3 + "\n");
		txtArea.append("Cantidad de ventas                      : " + Vender.contadorVentas3 + "\n");
		txtArea.append("Cantidad de cajas vendidas      : " + Vender.acumuladorCajas3 + "\n");
		txtArea.append("Importe total vendido                   : " + "S/. "+ dosDecimales.format(Vender.acumuladorImporte3) + "\n");
		txtArea.append("Aporte a la cuota diaria               : " + dosDecimales.format(porcentajeCuotaDiaria3) + " % " + "\n" );
		txtArea.append("" + "\n");
		txtArea.append("Modelo                                            : " + MenuOpciones.modelo4 + "\n");
		txtArea.append("Cantidad de ventas                      : " + Vender.contadorVentas4 + "\n");
		txtArea.append("Cantidad de cajas vendidas      : " + Vender.acumuladorCajas4 + "\n");
		txtArea.append("Importe total vendido                   : " + "S/. "+ dosDecimales.format(Vender.acumuladorImporte4) + "\n");
		txtArea.append("Aporte a la cuota diaria               : " + dosDecimales.format(porcentajeCuotaDiaria4) + " % " + "\n" );
		txtArea.setCaretPosition(0);
	}
	public void actionPerformedBtnComparacion(ActionEvent e) {
		
		DecimalFormat dosDecimales = new DecimalFormat ("#.00"); 

		double promedio, comparacion0 = 0, comparacion1 = 0, comparacion2 = 0, comparacion3 = 0, comparacion4 = 0;
		String textoComparacion0 = null, textoComparacion1 = null, textoComparacion2 = null, textoComparacion3 = null, textoComparacion4 = null;
		
		promedio = (MenuOpciones.precio0 + MenuOpciones.precio1 + MenuOpciones.precio2 + MenuOpciones.precio3 + MenuOpciones.precio4) / 5;
		
		
		if(MenuOpciones.precio0 > promedio) {
			comparacion0 = MenuOpciones.precio0 - promedio;
			textoComparacion0 = " más que el promedio";
		}
		if(MenuOpciones.precio1 > promedio) {
			comparacion1 = MenuOpciones.precio1 - promedio;
			textoComparacion1 = " más que el promedio";
		}
		if(MenuOpciones.precio2 > promedio) {
			comparacion2 = MenuOpciones.precio2 - promedio;
			textoComparacion2 = " más que el promedio";
		}
		if(MenuOpciones.precio3 > promedio) {
			comparacion3 = MenuOpciones.precio3 - promedio;
			textoComparacion3 = " más que el promedio";
		}
		if(MenuOpciones.precio4 > promedio) {
			comparacion4 = MenuOpciones.precio4 - promedio;
			textoComparacion4 = " más que el promedio";
		}
		
		if(MenuOpciones.precio0 < promedio) {
			comparacion0 = promedio - MenuOpciones.precio0;
			textoComparacion0 = " menos que el promedio";
		}
		if(MenuOpciones.precio1 < promedio) {
			comparacion1 = promedio - MenuOpciones.precio1;
			textoComparacion1 = " menos que el promedio";
		}
		if(MenuOpciones.precio2 < promedio) {
			comparacion2 = promedio - MenuOpciones.precio2;
			textoComparacion2 = " menos que el promedio";
		}
		if(MenuOpciones.precio3 < promedio) {
			comparacion3 = promedio - MenuOpciones.precio3;
			textoComparacion3 = " menos que el promedio";
		}
		if(MenuOpciones.precio4 < promedio) {
			comparacion4 = promedio - MenuOpciones.precio4;
			textoComparacion4 = " menos que el promedio";
		}
		
		txtArea.setText("COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO" + "\n" + "\n");
		txtArea.append("Modelo                    : " + MenuOpciones.modelo0 + "\n");
		txtArea.append("Precio                      : " + "S/. "+ dosDecimales.format(MenuOpciones.precio0) + "\n");
		txtArea.append("Precio promedio   : " + "S/. "+ dosDecimales.format(promedio) + "\n");
		txtArea.append("Comparación        : " + "S/. " + dosDecimales.format(comparacion0) + textoComparacion0 + "\n");
		txtArea.append("" + "\n");
		txtArea.append("Modelo                    : " + MenuOpciones.modelo1 + "\n");
		txtArea.append("Precio                      : " + "S/. "+ dosDecimales.format(MenuOpciones.precio1) + "\n");
		txtArea.append("Precio promedio   : " + "S/. "+ dosDecimales.format(promedio) + "\n");
		txtArea.append("Comparación        : " + "S/. " + dosDecimales.format(comparacion1) + textoComparacion1 + "\n");
		txtArea.append("" + "\n");
		txtArea.append("Modelo                    : " + MenuOpciones.modelo2 + "\n");
		txtArea.append("Precio                      : " + "S/. "+ dosDecimales.format(MenuOpciones.precio2) + "\n");
		txtArea.append("Precio promedio   : " + "S/. "+ dosDecimales.format(promedio) + "\n");
		txtArea.append("Comparación        : " + "S/. " + dosDecimales.format(comparacion2) + textoComparacion2 + "\n");
		txtArea.append("" + "\n");
		txtArea.append("Modelo                    : " + MenuOpciones.modelo3 + "\n");
		txtArea.append("Precio                      : " + "S/. "+ dosDecimales.format(MenuOpciones.precio3) + "\n");
		txtArea.append("Precio promedio   : " + "S/. "+ dosDecimales.format(promedio) + "\n");
		txtArea.append("Comparación        : " + "S/. " + dosDecimales.format(comparacion3) + textoComparacion3 + "\n");
		txtArea.append("" + "\n");
		txtArea.append("Modelo                    : " + MenuOpciones.modelo4 + "\n");
		txtArea.append("Precio                      : " + "S/. "+ dosDecimales.format(MenuOpciones.precio4) + "\n");
		txtArea.append("Precio promedio   : " + "S/. "+ dosDecimales.format(promedio) + "\n");
		txtArea.append("Comparación        : " + "S/. " + dosDecimales.format(comparacion4) + textoComparacion4 + "\n");
		txtArea.setCaretPosition(0);
	}
public void actionPerformedBtnComparacionCajas(ActionEvent e) {
		
		DecimalFormat sinDecimales = new DecimalFormat ("#"); 

		double comparacion0 = 0, comparacion1 = 0, comparacion2 = 0, comparacion3 = 0, comparacion4 = 0;
		String textoComparacion0 = null, textoComparacion1 = null, textoComparacion2 = null, textoComparacion3 = null, textoComparacion4 = null;
		
		if(Vender.acumuladorCajas0 > MenuOpciones.cantidadOptima) {
			comparacion0 = Vender.acumuladorCajas0 - MenuOpciones.cantidadOptima;
			textoComparacion0 = " más que la cantidad óptima";
		}
		if(Vender.acumuladorCajas1 > MenuOpciones.cantidadOptima) {
			comparacion1 = Vender.acumuladorCajas1 - MenuOpciones.cantidadOptima;
			textoComparacion1 = " más que la cantidad óptima";
		}
		if(Vender.acumuladorCajas2 > MenuOpciones.cantidadOptima) {
			comparacion2 = Vender.acumuladorCajas2 - MenuOpciones.cantidadOptima;
			textoComparacion2 = " más que la cantidad óptima";
		}
		if(Vender.acumuladorCajas3 > MenuOpciones.cantidadOptima) {
			comparacion3 = Vender.acumuladorCajas3 - MenuOpciones.cantidadOptima;
			textoComparacion3 = " más que la cantidad óptima";
		}
		if(Vender.acumuladorCajas4 > MenuOpciones.cantidadOptima) {
			comparacion4 = Vender.acumuladorCajas4 - MenuOpciones.cantidadOptima;
			textoComparacion4 = " más que la cantidad óptima";
		}
		
		if(Vender.acumuladorCajas0 < MenuOpciones.cantidadOptima) {
			comparacion0 = MenuOpciones.cantidadOptima - Vender.acumuladorCajas0;
			textoComparacion0 = " menos que la cantidad óptima";
		}
		if(Vender.acumuladorCajas1 < MenuOpciones.cantidadOptima) {
			comparacion1 = MenuOpciones.cantidadOptima - Vender.acumuladorCajas1;
			textoComparacion1 = " menos que la cantidad óptima";
		}
		if(Vender.acumuladorCajas2 < MenuOpciones.cantidadOptima) {
			comparacion2 = MenuOpciones.cantidadOptima - Vender.acumuladorCajas2;
			textoComparacion2 = " menos que la cantidad óptima";
		}
		if(Vender.acumuladorCajas3 < MenuOpciones.cantidadOptima) {
			comparacion3 = MenuOpciones.cantidadOptima - Vender.acumuladorCajas3;
			textoComparacion3 = " menos que la cantidad óptima";
		}
		if(Vender.acumuladorCajas4 < MenuOpciones.cantidadOptima) {
			comparacion4 = MenuOpciones.cantidadOptima - Vender.acumuladorCajas4;
			textoComparacion4 = " menos que la cantidad óptima";
		}
		
		if(Vender.acumuladorCajas0 == MenuOpciones.cantidadOptima) {
			textoComparacion0 = " igual que la cantidad óptima";
		}
		if(Vender.acumuladorCajas1 == MenuOpciones.cantidadOptima) {
			textoComparacion1 = " igual que la cantidad óptima";
		}
		if(Vender.acumuladorCajas2 == MenuOpciones.cantidadOptima) {
			textoComparacion2 = " igual que la cantidad óptima";
		}
		if(Vender.acumuladorCajas3 == MenuOpciones.cantidadOptima) {
			textoComparacion3 = " igual que la cantidad óptima";
		}
		if(Vender.acumuladorCajas4 == MenuOpciones.cantidadOptima) {
			textoComparacion4 = " igual que la cantidad óptima";
		}
		
		txtArea.setText("COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA" + "\n" + "\n");
		txtArea.append("Modelo                                         : " + MenuOpciones.modelo0 + "\n");
		txtArea.append("Cantidad de cajas vendidas   : " + Vender.acumuladorCajas0 + "\n");
		txtArea.append("Cantidad óptima                        : " + MenuOpciones.cantidadOptima + "\n");
		if(Vender.acumuladorCajas0 == MenuOpciones.cantidadOptima) {
		txtArea.append("Comparación                             : " + textoComparacion0 + "\n");
		} else
			txtArea.append("Comparación                             : " + sinDecimales.format(comparacion0) + textoComparacion0 + "\n");
		txtArea.append("" + "\n");
		txtArea.append("Modelo                                         : " + MenuOpciones.modelo1 + "\n");
		txtArea.append("Cantidad de cajas vendidas   : " + Vender.acumuladorCajas1 + "\n");
		txtArea.append("Cantidad óptima                        : " + MenuOpciones.cantidadOptima + "\n");
		if(Vender.acumuladorCajas1 == MenuOpciones.cantidadOptima) {
			txtArea.append("Comparación                             : " + textoComparacion1 + "\n");
			} else
				txtArea.append("Comparación                             : " + sinDecimales.format(comparacion1) + textoComparacion1 + "\n");		
		txtArea.append("" + "\n");
		txtArea.append("Modelo                                         : " + MenuOpciones.modelo2 + "\n");
		txtArea.append("Cantidad de cajas vendidas   : " + Vender.acumuladorCajas2 + "\n");
		txtArea.append("Cantidad óptima                        : " + MenuOpciones.cantidadOptima + "\n");
		if(Vender.acumuladorCajas2 == MenuOpciones.cantidadOptima) {
			txtArea.append("Comparación                             : " + textoComparacion2 + "\n");
			} else
				txtArea.append("Comparación                             : " + sinDecimales.format(comparacion2) + textoComparacion2 + "\n");		
		txtArea.append("" + "\n");
		txtArea.append("Modelo                                         : " + MenuOpciones.modelo3 + "\n");
		txtArea.append("Cantidad de cajas vendidas   : " + Vender.acumuladorCajas3 + "\n");
		txtArea.append("Cantidad óptima                        : " + MenuOpciones.cantidadOptima + "\n");
		if(Vender.acumuladorCajas3 == MenuOpciones.cantidadOptima) {
			txtArea.append("Comparación                             : " + textoComparacion3 + "\n");
			} else
				txtArea.append("Comparación                             : " + sinDecimales.format(comparacion3) + textoComparacion3 + "\n");		
		txtArea.append("" + "\n");
		txtArea.append("Modelo                                         : " + MenuOpciones.modelo4 + "\n");
		txtArea.append("Cantidad de cajas vendidas   : " + Vender.acumuladorCajas4 + "\n");
		txtArea.append("Cantidad óptima                        : " + MenuOpciones.cantidadOptima + "\n");
		if(Vender.acumuladorCajas4 == MenuOpciones.cantidadOptima) {
			txtArea.append("Comparación                             : " + textoComparacion4 + "\n");
			} else
				txtArea.append("Comparación                             : " + sinDecimales.format(comparacion4) + textoComparacion4 + "\n");		
		txtArea.setCaretPosition(0);
	}
	public void actionPerformedBtnEstadisticas(ActionEvent e) {
		
		DecimalFormat dosDecimales = new DecimalFormat ("#.00"); 
		
		double promedio;
		
		promedio = (MenuOpciones.precio0 + MenuOpciones.precio1 + MenuOpciones.precio2 + MenuOpciones.precio3 + MenuOpciones.precio4) / 5;
		
		double mayor = MenuOpciones.precio0;
		
		if(MenuOpciones.precio1 > mayor) { 
			mayor = MenuOpciones.precio1;
		}
		if(MenuOpciones.precio2 > mayor) { 
			mayor = MenuOpciones.precio2;
		}
		if(MenuOpciones.precio3 > mayor) { 
			mayor = MenuOpciones.precio3;
		}
		if(MenuOpciones.precio4 > mayor) { 
			mayor = MenuOpciones.precio4;
		}
		
		double menor = MenuOpciones.precio0;
		
		if(MenuOpciones.precio1 < menor) { 
			menor = MenuOpciones.precio1;
		}
		if(MenuOpciones.precio2 < menor) { 
			menor = MenuOpciones.precio2;
		}
		if(MenuOpciones.precio3 < menor) { 
			menor = MenuOpciones.precio3;
		}
		if(MenuOpciones.precio4 < menor) { 
			menor = MenuOpciones.precio4;
		}

		txtArea.setText("ESTADÍSTICA SOBRE EL PRECIO" + "\n" + "\n");
		txtArea.append("Precio promedio   :  " + "S/  " + dosDecimales.format(promedio) + "\n");
		txtArea.append("Precio mayor         :  " + "S/  " + dosDecimales.format(mayor) + "\n");
		txtArea.append("Precio menor        :  " + "S/  " + dosDecimales.format(menor) + "\n");
	}
}