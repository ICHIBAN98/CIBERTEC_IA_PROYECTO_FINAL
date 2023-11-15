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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnIngresar;
	
	public static String usuarioAdmin = "Administrador";
	public static String contraAdmin = "Admin";
	public static String usuarioVendedor = "Vendedor";
	public static String contraseñaVendedor = "Vende";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaLogin dialog = new VentanaLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public VentanaLogin() {
		setTitle("LOG-IN");
		setBounds(100, 100, 404, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("SISTEMA DE VENTAS DE CER\u00C1MICOS");
		lblNewLabel.setBounds(84, 10, 253, 31);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("USUARIO:");
		lblNewLabel_1.setBounds(95, 51, 59, 13);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("CONTRASE\u00D1A:");
		lblNewLabel_2.setBounds(95, 74, 88, 13);
		contentPanel.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(193, 51, 96, 19);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(193, 71, 96, 19);
		contentPanel.add(txtContrasenia);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(141, 111, 105, 21);
		contentPanel.add(btnIngresar);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String usuarioIn;
		char[] contraseniaIn;
		
		usuarioIn = txtUsuario.getText();
		contraseniaIn = txtContrasenia.getPassword();
		String contraseniaFinal = new String(contraseniaIn);
		
		if(usuarioIn.equals("Administrador") && contraseniaFinal.equals("Admin")) {
			JOptionPane.showMessageDialog(null, "Usted ha ingresado al sistema como Administrador.", "LOG-IN EXITOSO", JOptionPane.INFORMATION_MESSAGE);
			String nombre = JOptionPane.showInputDialog(null, "Por favor, ingrese su nombre:", "NOMBRE", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "¡Bienvenido, " + nombre + "!", "BIENVENIDO", JOptionPane.INFORMATION_MESSAGE);
			MenuOpciones logIn = new MenuOpciones();
			logIn.setVisible(true);
			this.setVisible(false);
		} else if (usuarioIn.equals("Vendedor") && contraseniaFinal.equals("Vende")){
			JOptionPane.showMessageDialog(null, "Usted ha ingresado al sistema como Vendedor.", "LOG-IN EXITOSO", JOptionPane.INFORMATION_MESSAGE);
			String nombre = JOptionPane.showInputDialog(null, "Por favor, ingrese su nombre:", "NOMBRE", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "¡Bienvenido, " + nombre + "!", "BIENVENIDO", JOptionPane.INFORMATION_MESSAGE);
			MenuOpcionesVendedor logIn = new MenuOpcionesVendedor();
			logIn.setVisible(true);
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Por favor, vuelva a intentarlo.", "LOG-IN FALLIDO", JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			txtContrasenia.setText("");
			txtUsuario.requestFocus();
		}
		
	}
	
}