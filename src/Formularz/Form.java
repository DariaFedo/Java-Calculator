package Formularz;

	import java.awt.Color;
	import java.awt.Component;

	import javax.swing.BorderFactory;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JTextField;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JButton;
	import java.awt.event.FocusListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import javax.swing.JTextPane;

	public class Form extends JFrame {

		//private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		static boolean plec, imiebool = false, nazwiskobool = false, peselbool = false;
		static int rokurodzenia;
		static int currentyear = 2019;
		static int miesiac;
		static int dzien;
		static String pesel,imie,nazwisko;
		static int wiek;

		public Form() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 350, 403);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			setTitle("Formularz");

			JTextField textPane = new JTextField();
			textPane.setText("Imie");
			textPane.addFocusListener(imieFocusListener);
			textPane.setBounds(93, 30, 230, 20);
			contentPane.add(textPane);

			JTextField textPane_1 = new JTextField();
			textPane_1.setText("Nazwisko");
			textPane_1.addFocusListener(nazwiskoFocusListener);
			textPane_1.setBounds(93, 61, 230, 20);
			contentPane.add(textPane_1);

			JTextField textPane_2 = new JTextField();
			textPane_2.setText("Pesel");
			textPane_2.setToolTipText("11 cyfr numeru Pesel, jak nie wiesz, to masz na dowodzie osobistym");
			textPane_2.addFocusListener(peselFocusListener);
			textPane_2.setBounds(93, 92, 230, 20);
			contentPane.add(textPane_2);

			JLabel lblImi = new JLabel("Imi\u0119");
			lblImi.setBounds(10, 30, 71, 20);
			contentPane.add(lblImi);

			JLabel lblNazwisko = new JLabel("Nazwisko");
			lblNazwisko.setBounds(10, 61, 73, 20);
			contentPane.add(lblNazwisko);

			JLabel lblPesel = new JLabel("Pesel");
			lblPesel.setBounds(10, 92, 71, 20);
			contentPane.add(lblPesel);
			
			
			JTextPane textPane_3 = new JTextPane();
			textPane_3.setBounds(10, 157, 315, 196);
			contentPane.add(textPane_3);

			JButton btnConfirm = new JButton("Confirm");
			btnConfirm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Component frame = null;
					if (imiebool && nazwiskobool && peselbool) {
						if (pesel.charAt(9) % 2 == 0)
							plec = false;
						else
							plec = true;
						rokurodzenia = 1900 + Integer.parseInt(pesel.substring(0, 2));
						miesiac = Integer.parseInt(pesel.substring(2, 4));
						dzien = Integer.parseInt(pesel.substring(4, 6));
						wiek = currentyear - rokurodzenia;
						String splec;
						if(plec)
							splec=("Plec mezczyzna");
						else
							splec=("Plec kobieta");
						textPane_3.setText("Pierwsze "+imie+"\n"+"Nazwisko "+nazwisko+"\n"+"Rok urodzenia "+rokurodzenia+"\n"+"Miesiac "+miesiac+"\n"+"Dzien "+dzien+"\n"+"Wiek "+wiek+"\n"+splec);
					} else
						JOptionPane.showMessageDialog(frame, "B³¹d");
				}
			});
			btnConfirm.setBounds(93, 123, 89, 23);
			contentPane.add(btnConfirm);
			
			
		}

		FocusListener imieFocusListener = new FocusListener() {
			public void focusGained(java.awt.event.FocusEvent focusEvent) {

				JTextField src = (JTextField) focusEvent.getSource();
				src.setBorder(BorderFactory.createLineBorder(Color.black));
				if (src.getText().equals("Imie")) {
					src.setText("");
				}
			}

			public void focusLost(java.awt.event.FocusEvent focusEvent) {

				JTextField src = (JTextField) focusEvent.getSource();
				if (src.getText().equals("")) {
					src.setText("Imie");
					imiebool = false;				
					src.setBorder(BorderFactory.createLineBorder(Color.red));
				} else if (!(src.getText().contains("\\d+"))) {
					imiebool = true;
				imie=src.getText();}

			}};

		FocusListener nazwiskoFocusListener = new FocusListener() {
				public void focusGained(java.awt.event.FocusEvent focusEvent) {

					JTextField src = (JTextField) focusEvent.getSource();
					src.setBorder(BorderFactory.createLineBorder(Color.black));
					if (src.getText().equals("Nazwisko"))
						src.setText("");
				}

				public void focusLost(java.awt.event.FocusEvent focusEvent) {

					JTextField src = (JTextField) focusEvent.getSource();
					if (src.getText().equals("")) {
						src.setText("Nazwisko");
						nazwiskobool = false;
						src.setBorder(BorderFactory.createLineBorder(Color.red));
					} else if (!(src.getText().contains("\\d+"))) {
						nazwiskobool = true;
						nazwisko=src.getText();}

				}};

		FocusListener peselFocusListener = new FocusListener() {
					public void focusGained(java.awt.event.FocusEvent focusEvent) {

						JTextField src = (JTextField) focusEvent.getSource();
						if (src.getText().equals("Pesel"))
							src.setText("");
					}

					public void focusLost(java.awt.event.FocusEvent focusEvent) {

						JTextField src = (JTextField) focusEvent.getSource();
						if (src.getText().equals(""))
							src.setText("Pesel");
						src.setBorder(BorderFactory.createLineBorder(Color.black));
						boolean numeric = true;
						if (src.getText().length() != 11)
							numeric = false;
						else {
							try {
								Double num = Double.parseDouble(src.getText());
								peselbool = true;
								pesel = src.getText();
							} catch (NumberFormatException e) {
								numeric = false;
								peselbool = false;
							}
						}
						if (!numeric) {
							src.setBorder(BorderFactory.createLineBorder(Color.red));
						}

					};
				};
	}


