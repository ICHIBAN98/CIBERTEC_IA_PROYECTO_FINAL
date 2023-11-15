package proyectofinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class ListadoCeramicos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtAreaResultado;
	private JButton btnCerrar;
	private JButton btnListar;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoCeramicos dialog = new ListadoCeramicos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoCeramicos() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoCeramicos.class.getResource("/imagenes/Logo.png")));
		setTitle("Listado de Cer\u00E1micos");
		setBounds(100, 100, 450, 324);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPanel.add(scrollPane);

		txtAreaResultado = new JTextArea();
		scrollPane.setViewportView(txtAreaResultado);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setIcon(new ImageIcon(ListadoCeramicos.class.getResource("/imagenes/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(104, 255, 101, 23);
		contentPanel.add(btnCerrar);

		btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(255, 255, 255));
		btnListar.setIcon(new ImageIcon(ListadoCeramicos.class.getResource("/imagenes/listar.png")));
		btnListar.addActionListener(this);
		btnListar.setBounds(215, 255, 101, 23);
		contentPanel.add(btnListar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	public void actionPerformedBtnListar(ActionEvent e) {
		txtAreaResultado.setText("LISTADO DE CERÁMICOS" + "\n" + "\n");
		txtAreaResultado.append("Modelo                :  " + MenuOpciones.modelo0 + "\n");
		txtAreaResultado.append("Pecio                   :  " + "S/ " + MenuOpciones.precio0 + "\n");
		txtAreaResultado.append("Ancho (cm)         :  " + MenuOpciones.ancho0 + " cm" + "\n");
		txtAreaResultado.append("Largo (cm)          :  " + MenuOpciones.largo0 + " cm" + "\n");
		txtAreaResultado.append("Espesor (mm)   :  " + MenuOpciones.espesor0 + " mm" + "\n");
		txtAreaResultado.append("Contenido           :  " + MenuOpciones.contenido0 + " unidades" + "\n");
		txtAreaResultado.append("" + "\n");
		txtAreaResultado.append("Modelo                :  " + MenuOpciones.modelo1 + "\n");
		txtAreaResultado.append("Pecio                   :  " + "S/ " + MenuOpciones.precio1 + "\n");
		txtAreaResultado.append("Ancho (cm)         :  " + MenuOpciones.ancho1 + " cm" + "\n");
		txtAreaResultado.append("Largo (cm)          :  " + MenuOpciones.largo1 + " cm" + "\n");
		txtAreaResultado.append("Espesor (mm)   :  " + MenuOpciones.espesor1 + " mm" + "\n");
		txtAreaResultado.append("Contenido           :  " + MenuOpciones.contenido1 + " unidades" + "\n");
		txtAreaResultado.append("" + "\n");
		txtAreaResultado.append("Modelo                :  " + MenuOpciones.modelo2 + "\n");
		txtAreaResultado.append("Pecio                   :  " + "S/ " + MenuOpciones.precio2 + "\n");
		txtAreaResultado.append("Ancho (cm)         :  " + MenuOpciones.ancho2 + " cm" + "\n");
		txtAreaResultado.append("Largo (cm)          :  " + MenuOpciones.largo2 + " cm" + "\n");
		txtAreaResultado.append("Espesor (mm)   :  " + MenuOpciones.espesor2 + " mm" + "\n");
		txtAreaResultado.append("Contenido           :  " + MenuOpciones.contenido2 + " unidades" + "\n");
		txtAreaResultado.append("" + "\n");
		txtAreaResultado.append("Modelo                :  " + MenuOpciones.modelo3 + "\n");
		txtAreaResultado.append("Pecio                   :  " + "S/ " + MenuOpciones.precio3 + "\n");
		txtAreaResultado.append("Ancho (cm)         :  " + MenuOpciones.ancho3 + " cm" + "\n");
		txtAreaResultado.append("Largo (cm)          :  " + MenuOpciones.largo3 + " cm" + "\n");
		txtAreaResultado.append("Espesor (mm)   :  " + MenuOpciones.espesor3 + " mm" + "\n");
		txtAreaResultado.append("Contenido           :  " + MenuOpciones.contenido3 + " unidades" + "\n");
		txtAreaResultado.append("" + "\n");
		txtAreaResultado.append("Modelo                :  " + MenuOpciones.modelo4 + "\n");
		txtAreaResultado.append("Pecio                   :  " + "S/ " + MenuOpciones.precio4 + "\n");
		txtAreaResultado.append("Ancho (cm)         :  " + MenuOpciones.ancho4 + " cm" + "\n");
		txtAreaResultado.append("Largo (cm)          :  " + MenuOpciones.largo4 + " cm" + "\n");
		txtAreaResultado.append("Espesor (mm)   :  " + MenuOpciones.espesor4 + " mm" + "\n");
		txtAreaResultado.append("Contenido           :  " + MenuOpciones.contenido4 + " unidades" + "\n");
		txtAreaResultado.setEditable(false);
		txtAreaResultado.setCaretPosition(0);
	}

	public void actionPerformedBtnCerrar(ActionEvent e) {
		this.setVisible(false);
	}
}
