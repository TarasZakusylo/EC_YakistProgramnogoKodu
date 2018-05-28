package EC_YakistProgramnogoKodu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class PokracrennaKodu extends JFrame{

	private static final long serialVersionUID = 1L;

	static Scanner scn;
	
	public PokracrennaKodu() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 744, 465);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 744, 465);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		scrollPane.setViewportView(textArea);
		
		String st = "";

		try {

			try {
				scn = new Scanner(new File("res/PokraschennaKodu.txt"));
			} catch (Exception ez) {
				JOptionPane.showMessageDialog(null,
						"Невірно введено(не введено)" + " або такого файлу не існує.");
			}

			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("res/PokraschennaKodu.txt"));

			String line;
			List<String> lines = new ArrayList<String>();

			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			String[] linesAsArray = lines.toArray(new String[lines.size()]);

			for (int i = 0; i < linesAsArray.length; i++) {
				// System.out.println(linesAsArray[i]);
				st = st + linesAsArray[i] + "\n";
			}

			textArea.setText(st);
			
		} catch (Exception ez) {
		}
		
		setVisible(true);
	}
}
