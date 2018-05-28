package EC_YakistProgramnogoKodu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pruvitanna extends JFrame {

	private static final long serialVersionUID = 1L;

	public Pruvitanna(String s) {
		super(s);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("ПРОГРАМНОГО  КОДУ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sitka Text", Font.BOLD, 35));
		label.setForeground(Color.YELLOW);
		label.setBounds(280, 144, 452, 55);
		getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("Оцінка  якості");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(280, 76, 452, 55);
		getContentPane().add(lblNewLabel);

		JButton button = new JButton("ПОЧАТИ  РОБОТУ");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Avtor("Оцінка програмного коду");
				setVisible(false);
			}
		});
		button.setFont(new Font("Sitka Small", Font.BOLD, 25));
		button.setBounds(293, 302, 439, 55);
		getContentPane().add(button);

		JLabel l_fonLogo = new JLabel("");
//		l_fonLogo.setIcon(new ImageIcon("C:\\Users\\ZakkZakk\\Desktop\\fon_Pruvatanna.jpg"));
		l_fonLogo.setIcon(new ImageIcon("res/fon_Pruvatanna.jpg"));
		l_fonLogo.setBounds(0, 0, 744, 465);
		getContentPane().add(l_fonLogo);

		setVisible(true);
	}
}
