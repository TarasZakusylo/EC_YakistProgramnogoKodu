package EC_YakistProgramnogoKodu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

class Analiz_Obcuslenna extends JFrame {

	private static final long serialVersionUID = 1L;

	JFrame analiz_Obcuslenna = new JFrame("Якість коду");

	JButton Analiz = new JButton("Аналіз коду");
	JButton Zavantajutu = new JButton("Завантажити");
	JButton b_ocustutu = new JButton("Очистити");
	JButton b_zberegtu = new JButton("Зберегти");

	JLabel Pusto, l_Text, l_Instrukcia;
	private JLabel l_Text_1;

	JTextArea textArea = new JTextArea();
	String TEXT;
	JPanel panel = new JPanel();
	JPanel mainPanel = new JPanel();

	Scanner sc_k;
	String s, st = "";

	String hlah;

	static Scanner scn;
	String Reading1 = "";
	String Reading2;

	public Formatter x;

	eHandler handler = new eHandler();
	private final JButton button = new JButton("Правила покращення коду");

	public Analiz_Obcuslenna(String s) {
		super(s);

		analiz_Obcuslenna.setVisible(true);
		analiz_Obcuslenna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		analiz_Obcuslenna.setSize(750, 500);
		analiz_Obcuslenna.setResizable(false);
		analiz_Obcuslenna.setLocationRelativeTo(null);

		Pusto = new JLabel("");
		Pusto.setIcon(new ImageIcon("res/fon_White.PNG"));
		Pusto.setBounds(0, 0, 744, 465);
		analiz_Obcuslenna.getContentPane().setLayout(null);
		Analiz.setFont(new Font("Sitka Text", Font.BOLD, 20));

		Analiz.setBounds(32, 103, 175, 30);
		analiz_Obcuslenna.getContentPane().add(Analiz);
		Zavantajutu.setFont(new Font("Sitka Text", Font.BOLD, 20));
		Zavantajutu.setBounds(366, 103, 175, 30);
		analiz_Obcuslenna.getContentPane().add(Zavantajutu);
		b_ocustutu.setFont(new Font("Sitka Text", Font.BOLD, 20));
		b_ocustutu.setBounds(200, 103, 169, 30);
		analiz_Obcuslenna.getContentPane().add(b_ocustutu);
		b_zberegtu.setFont(new Font("Sitka Text", Font.BOLD, 20));
		b_zberegtu.setBounds(540, 103, 175, 30);
		analiz_Obcuslenna.getContentPane().add(b_zberegtu);

		// //////// поле

		mainPanel.setLayout(new BorderLayout());
		textArea.setFont(new Font("Sitka Text", Font.PLAIN, 18));

		textArea.setText(TEXT);
		// textArea.setCaretPosition(0);
		JScrollPane scrollPane = new JScrollPane(textArea);
		mainPanel.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainPanel.setBounds(0, 176, 744, 289);

		analiz_Obcuslenna.getContentPane().add(mainPanel);
		
		// //////////

		l_Text = new JLabel("Аналіз коду");
		l_Text.setHorizontalAlignment(SwingConstants.CENTER);
		l_Text.setFont(new Font("Sitka Text", Font.BOLD, 55));
		l_Text.setBounds(32, 13, 683, 57);
		analiz_Obcuslenna.getContentPane().add(l_Text);

		l_Text_1 = new JLabel("Впишіть код для аназізу в поле або завантажте його.");
		l_Text_1.setFont(new Font("Sitka Text", Font.BOLD, 20));
		l_Text_1.setHorizontalAlignment(SwingConstants.CENTER);
		l_Text_1.setBounds(32, 70, 683, 20);
		analiz_Obcuslenna.getContentPane().add(l_Text_1);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PokracrennaKodu ();
			}
		});
		button.setFont(new Font("Sitka Text", Font.BOLD, 20));
		button.setBounds(32, 134, 683, 30);
		
		analiz_Obcuslenna.getContentPane().add(button);

		analiz_Obcuslenna.getContentPane().add(Pusto);

		Analiz.addActionListener(handler);
		Zavantajutu.addActionListener(handler);
		b_ocustutu.addActionListener(handler);
		b_zberegtu.addActionListener(handler);
	}

	void zakrutu(int t) {

		if (t == 1) {
			analiz_Obcuslenna.setVisible(false);
		}
	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == Analiz) {

					String s = textArea.getText();
					// JOptionPane.showMessageDialog(null, s);

					/////////////////// PohukSliv

					String searchWord = "var";
					String searchWord1 = "flash.display.Sprite";
					String searchWord2 = "flash.text.TextField";
					String searchWord3 = "trace";
					String searchWord4 = "function";

					int k = 0;
					int kk = 0;
					int kk1 = 0;

					String[] lines = new String(s).split("\n"); // кодировку указать нужную

					for (String line : lines) {
						String[] words = line.split(" ");
						for (String word : words) {
							if (word.equalsIgnoreCase(searchWord) || word.equalsIgnoreCase(searchWord1)
									|| word.equalsIgnoreCase(searchWord2) || word.equalsIgnoreCase(searchWord3)
									|| word.equalsIgnoreCase(searchWord4)) {
								// System.out.println("Найдено в " + i + "-й строке, " + j
								// + "-е слово");
								k++;
							}
						}

						////////////////////// дужки ( )

						char[] chars = line.toCharArray();

						for (int q = 0; q < chars.length; q++) {

							try {
								if (chars[q] == '(') {
									// System.out.println("Урa");
									kk++;

								}
							} catch (Exception ex) {
							}
						}
						for (int q1 = 0; q1 < chars.length; q1++) {
							try {
								if (chars[q1] == ')') {
									// System.out.println("Урa");
									kk--;
								}
							} catch (Exception ex) {
							}
						}
						////////////////////// дужки { }

						char[] chars1 = line.toCharArray();

						for (int q = 0; q < chars.length; q++) {

							try {
								if (chars1[q] == '{') {
									// System.out.println("Урa");
									kk1++;

								}
							} catch (Exception ex) {
							}
						}
						for (int q1 = 0; q1 < chars.length; q1++) {
							try {
								if (chars1[q1] == '}') {
									// System.out.println("Урa");
									kk1--;
								}
							} catch (Exception ex) {
							}
						}

					}
					if (kk != 0) {
						JOptionPane.showMessageDialog(null, " Невідповідність дужок типу ( ) ");
					}
					if (kk1 != 0) {
						JOptionPane.showMessageDialog(null, " Невідповідність дужок типу { } ");
					}

					if (k >= 1) {
						JOptionPane.showMessageDialog(null, "Знайдено шкідливе ПЗ! Адміністратор повідомлений.");
						new Avtor("");
						analiz_Obcuslenna.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null, "Безпечно");
					}

				}

				if (e.getSource() == Zavantajutu) {
					// new Analiz_Obc_Dopomignuy("");
					// analiz_Obcuslenna.setVisible(false);

					JFileChooser fileopen = new JFileChooser();

					FileFilter ft = new FileNameExtensionFilter("Text Files", "txt");
					fileopen.addChoosableFileFilter(ft);
					FileFilter ft1 = new FileNameExtensionFilter("Java Files", "java");
					fileopen.addChoosableFileFilter(ft1);
					FileFilter ft2 = new FileNameExtensionFilter("Folder", "null");
					fileopen.addChoosableFileFilter(ft2);
					
					int ret = fileopen.showDialog(null, "Открыть файл");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = fileopen.getSelectedFile();

						String st = "";

						String name = file.getAbsolutePath();

						try {

							try {
								scn = new Scanner(new File(name));
							} catch (Exception ez) {
								JOptionPane.showMessageDialog(null,
										"Невірно введено(не введено)" + " або такого файлу не існує.");
							}

							@SuppressWarnings("resource")
							BufferedReader reader = new BufferedReader(new FileReader(name));

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

						} catch (Exception ez) {
						}

						textArea.setText(st);

					}

				}
				if (e.getSource() == b_ocustutu) {
					textArea.setText(null);
				}
				if (e.getSource() == b_zberegtu) {
					String dofaylu = JOptionPane.showInputDialog("Вкажіть шлях до файла.");

					if (dofaylu != null) {
						String dofaylu1 = JOptionPane.showInputDialog("Вкажіть ім’я файла.");

						if (dofaylu != null) {
							String s = textArea.getText();

							dofaylu = dofaylu + "/" + dofaylu1 + ".java";
							// System.out.println(dofaylu);

							x = new Formatter(dofaylu);
							x.format(s);
							x.close();

							JOptionPane.showMessageDialog(null, "Збережено");
						}
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Некоректне введення");

			}
		}
	}
}
