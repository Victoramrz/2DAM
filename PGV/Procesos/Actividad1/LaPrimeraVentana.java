package PGV.Procesos.Actividad1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LaPrimeraVentana implements ActionListener{

	JFrame frame = new JFrame("Mi ventanita");
	JLabel label1 = new JLabel("Hello DAM1");
	JPanel panel = new JPanel(new FlowLayout());
	JTextField texto = new JTextField(20);
	JTextField respuesta= new JTextField(20);

	public LaPrimeraVentana() {
		
		frame.setBounds(0, 0, 400, 400);
		frame.setLocationRelativeTo(null);
		// frame.setResizable(false);
		// frame.setTitle("Mi ventana");

		panel.setBackground(Color.ORANGE);

	
		texto.addActionListener(this);

		panel.add(label1);
		panel.add(texto);
		panel.add(respuesta);
		frame.add(panel);
		// frame.pack();

		frame.setVisible(true);
	}

	public static void main(String[] args) {

		new LaPrimeraVentana();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		respuesta.setText(texto.getText());
		
		
	}

}
