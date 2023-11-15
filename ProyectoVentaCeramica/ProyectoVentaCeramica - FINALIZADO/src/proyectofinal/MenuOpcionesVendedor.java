package proyectofinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class MenuOpcionesVendedor extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenuItem mntmSalir;
	private JMenuItem mntmListarCeramico;
	private JMenuItem mntmModificarCeramico;
	private JMenuItem mntmConsultarCeramico;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenuItem mntmAcercaDeTienda;
	private JMenu mnAyuda;

	//Primer Producto
	public static String modelo0 = "Cinza Plus";
	public static double precio0 = 92.56;
	public static double ancho0 = 62.0;
	public static double largo0 = 62.0;
	public static double espesor0 = 8;
	public static int contenido0 = 6;
	
	//Segundo Producto
	public static String modelo1 = "Luxury";
	public static double precio1 = 42.77;
	public static double ancho1 = 60;
	public static double largo1 = 60;
	public static double espesor1 = 8.5;
	public static int contenido1 = 4;
	
	//Tercer Producto
	public static String modelo2 = "Austria";
	public static double precio2 = 52.45;
	public static double ancho2 = 45;
	public static double largo2 = 45;
	public static double espesor2 = 6.5;
	public static int contenido2 = 12;

	//Cuarto Producto
	public static String modelo3 = "Yungay Mix";
	public static double precio3 = 55.89;
	public static double ancho3 = 80;
	public static double largo3 = 120;
	public static double espesor3 = 6.8;
	public static int contenido3 = 9;
	
	//Quinto Producto
	public static String modelo4 = "Thalía";
	public static double precio4 = 45;
	public static double ancho4 = 45;
	public static double largo4 = 11.8;
	public static double espesor4 = 7.2;
	public static int contenido4 = 10;
	
	//Porcentaje de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	//Obsequio
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	
	//Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;
	
	//Cuota Diaria
	public static double cuotaDiaria = 30000;
	private JMenuBar menuBar;
	private JLabel lblNewLabel;
	private JMenuItem mntmCerrarSesion;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOpcionesVendedor frame = new MenuOpcionesVendedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuOpcionesVendedor() {
		setBackground(new Color(0, 0, 0));
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuOpciones.class.getResource("/imagenes/Logo.png")));
		setTitle("TIENDA DE CER\u00C1MICOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 440);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBorder(UIManager.getBorder("TitledBorder.border"));
		menuBar.setMinimumSize(new Dimension(12, 4));
		menuBar.setMaximumSize(new Dimension(12, 4));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		mnArchivo.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen1.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmSalir.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen2.png")));
		mntmSalir.addActionListener(this);
		
		mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesion.addActionListener(this);
		mntmCerrarSesion.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmCerrarSesion.setIcon(new ImageIcon(MenuOpcionesVendedor.class.getResource("/imagenes/Imagen2.png")));
		mnArchivo.add(mntmCerrarSesion);
		mnArchivo.add(mntmSalir);
		
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		mnMantenimiento.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen3.png")));
		menuBar.add(mnMantenimiento);
		
		mntmConsultarCeramico = new JMenuItem("Consultar ceramico");
		mntmConsultarCeramico.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmConsultarCeramico.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen4.png")));
		mntmConsultarCeramico.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCeramico);
		
		mntmModificarCeramico = new JMenuItem("Modificar ceramico");
		mntmModificarCeramico.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmModificarCeramico.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen5.png")));
		mntmModificarCeramico.addActionListener(this);
		mnMantenimiento.add(mntmModificarCeramico);
		mntmModificarCeramico.setEnabled(false);
		
		mntmListarCeramico = new JMenuItem("Listar ceramicos");
		mntmListarCeramico.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmListarCeramico.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen6.png")));
		mntmListarCeramico.addActionListener(this);
		mnMantenimiento.add(mntmListarCeramico);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		mnVentas.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen7.png")));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmVender.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen8.png")));
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmGenerarReportes.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen9.png")));
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		mntmGenerarReportes.setEnabled(false);
		
		mnConfiguracion = new JMenu("Configuracion");
		mnConfiguracion.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		mnConfiguracion.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen10.png")));
		menuBar.add(mnConfiguracion);
		mnConfiguracion.setEnabled(false);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmConfigurarDescuentos.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen11.png")));
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmConfigurarObsequios.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen12.png")));
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad optima");
		mntmConfigurarCantidadOptima.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmConfigurarCantidadOptima.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen13.png")));
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmConfigurarCuotaDiaria.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen13.png")));
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		mnAyuda.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen14.png")));
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		mntmAcercaDeTienda.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Imagen15.png")));
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuOpciones.class.getResource("/imagenes/Fondopantalla.png")));
		lblNewLabel.setBounds(0, 0, 653, 374);
		
		ImageIcon ico = new ImageIcon(getClass().getResource("/imagenes/Fondopantalla.png"));
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
		
		contentPane.add(lblNewLabel);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmConsultarCeramico) {
			actionPerformedConsultarCeramico(e);
		}
		if(e.getSource() == mntmModificarCeramico) {
			actionPerformedModificarCeramico(e);
		}
		if(e.getSource() == mntmListarCeramico) {
			actionPerformedListarCeramico(e);
		}
		if(e.getSource() == mntmVender) {
			actionPerformedVender(e);
		}
		if(e.getSource() == mntmGenerarReportes) {
			actionPerformedGenerarReportes(e);
		}
		if(e.getSource() == mntmSalir) {
			actionPerformedSalir(e);
		}
		if(e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedConfigurarPorcentajesDescuento(e);
		}
		if(e.getSource() == mntmConfigurarObsequios) {
			actionPerformedConfigurarObsequios(e);
		}
		if(e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedConfigurarCantidadOptima(e);
		}
		if(e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedConfigurarCuotaDiaria(e);
		}
		if(e.getSource() == mntmAcercaDeTienda) {
			actionPerformedAcercaDeTienda(e);
		}
		if(e.getSource() == mntmCerrarSesion) {
			actionPerformedMenuOpcionCerrarSesion(e);
		}
	}
	
	public void actionPerformedMenuOpcionCerrarSesion(ActionEvent e) {
		int eleccion = JOptionPane.showConfirmDialog(null, "¿QUIERE CERRAR SESIÓN?", "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
		
		if(eleccion==JOptionPane.YES_OPTION) {
			VentanaLogin a = new VentanaLogin ();
		a.setVisible(true);
		this.setVisible(false);
		}
	}
	
	public void actionPerformedSalir(ActionEvent e) {
		int eleccion = JOptionPane.showConfirmDialog(null, "¿QUIERE CERRAR EL PROGRAMA?", "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
		if(eleccion==JOptionPane.YES_OPTION) {
		this.setVisible(false);
		}
	}
	public void actionPerformedConsultarCeramico(ActionEvent e) {
		ConsultarCeramico a = new ConsultarCeramico();
		a.setVisible(true);
	}
	public void actionPerformedModificarCeramico(ActionEvent e) {
		ModificarCeramico a = new ModificarCeramico();
		a.setVisible(true);
	}
	public void actionPerformedListarCeramico(ActionEvent e) {
		ListadoCeramicos a = new ListadoCeramicos();
		a.setVisible(true);
	}
	public void actionPerformedVender(ActionEvent e) {
		Vender a = new Vender();
		a.setVisible(true);
	}
	public void actionPerformedGenerarReportes(ActionEvent e) {
		GenerarReportes a = new GenerarReportes();
		a.setVisible(true);
	}
	public void actionPerformedConfigurarPorcentajesDescuento(ActionEvent e) {
		ConfigurarPorcentajesDescuento a = new ConfigurarPorcentajesDescuento ();
		a.setVisible(true);
	}
	public void actionPerformedConfigurarObsequios(ActionEvent e) {
		ConfigurarObsequios a = new ConfigurarObsequios ();
		a.setVisible(true);
	}
	public void actionPerformedConfigurarCantidadOptima(ActionEvent e) {
		ConfigurarCantidadOptima a = new ConfigurarCantidadOptima();
		a.setVisible(true);
	}
	
	public void actionPerformedConfigurarCuotaDiaria(ActionEvent e) {
		ConfigurarCuotaDiaria a = new ConfigurarCuotaDiaria();
		a.setVisible(true);
	}

	public void actionPerformedAcercaDeTienda(ActionEvent e) {
		AcercaDeTienda a = new AcercaDeTienda();
		a.setVisible(true);
	}
}