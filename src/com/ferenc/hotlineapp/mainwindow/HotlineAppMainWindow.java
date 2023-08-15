package com.ferenc.hotlineapp.mainwindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultEditorKit;

import com.ferenc.hotlineapp.datawindow.DataChangingWindow;
import com.ferenc.hotlineapp.login.HotlineAppLoginFrame;
import com.ferenc.hotlineapp.mainwindow.function.MainWindowFunctions;
import com.ferenc.hotlineapp.tablewindow.HotlineAppHotlineTable;

public class HotlineAppMainWindow implements ActionListener {

	private JFrame mainFrame;
	private JTextField txtStandortNummer;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblBackground;
	private JButton btnNumber_1;
	private JButton btnNumber_2;
	private JButton btnNumber_3;
	private JButton btnNumber_6;
	private JButton btnNumber_4;
	private JButton btnNumber_5;
	private JButton btnNumber_7;
	private JButton btnNumber_8;
	private JButton btnNumber_9;
	private JButton btnSlash;
	private JButton btnNumber_0;
	private JLabel lblDavin;
	private JTextField txtDavinNumber;
	private JLabel lblIcinga;
	private JTextField txtIcingaNumber;
	private JLabel lblTicket;
	private JTextField txtSDNumber;
	private JLabel lblLinie;
	private JLabel lblStandort;
	private JLabel lblPhoneNr;
	private JComboBox cmbLinie;
	private JButton btnSaveAllInTheTable;
	private JButton btnShowTableWindow;
	private JButton btnClear;
	private MainWindowFunctions functions;
	private JButton btnShowNumbers;
	private JButton btnDelete;
	private HotlineData hotlineData;
	private HotlineAppHotlineTable tableWindow;
	private JTextField txtPhoneNr;
	private JPopupMenu menuIcinga;
	private JPopupMenu menuDavin;
	private String staffName;

	public String getStaffName() {
		return staffName;
	}

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { HotlineAppMainWindow window = new
	 * HotlineAppMainWindow(); window.mainFrame.setVisible(true); } catch (Exception
	 * e) { e.printStackTrace(); } } }); }
	 * 
	 * /** Create the application.
	 */
	public HotlineAppMainWindow() {

		HotlineAppLoginFrame loginFRame = new HotlineAppLoginFrame();
		loginFRame.setVisible(true);

		if (loginFRame.getName() != null && !loginFRame.getName().isEmpty() && !loginFRame.getName().isBlank()) {

			initialize();
			staffName = loginFRame.getStaffName();
			mainFrame.setTitle(mainFrame.getTitle() + " Üdv.: " + staffName);
			
		} else {
			System.exit(0);
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		mainFrame = new JFrame();
		mainFrame.setTitle("Hotline segéd");
		mainFrame.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mainFrame.setBounds(100, 100, 600, 680);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(null);

		mainFrame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(DataChangingWindow.class.getResource("/images/phone.png")));

		functions = new MainWindowFunctions();

		btnShowTableWindow = new JButton("Táblázat mutatása");
		btnShowTableWindow.setForeground(new Color(255, 69, 0));
		btnShowTableWindow.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnShowTableWindow.setBackground(new Color(245, 222, 179));
		btnShowTableWindow.setBounds(353, 502, 200, 35);
		btnShowTableWindow.addActionListener(this);

		btnDelete = new JButton("Törlés");
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnDelete.setBackground(new Color(60, 179, 113));
		btnDelete.setBounds(305, 296, 90, 50);
		btnDelete.addActionListener(this);

		btnClear = new JButton("Mezők törlése");
		btnClear.setForeground(new Color(255, 69, 0));
		btnClear.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnClear.setBackground(new Color(245, 222, 179));
		btnClear.setBounds(206, 575, 150, 30);
		btnClear.addActionListener(this);
		mainFrame.getContentPane().add(btnClear);

		JPopupMenu menuIcinga = new JPopupMenu();
		txtIcingaNumber = new JTextField();
		txtIcingaNumber.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtIcingaNumber.setColumns(10);
		txtIcingaNumber.setBounds(422, 203, 100, 30);
		Action copyIcinga = new DefaultEditorKit.CopyAction();
		copyIcinga.putValue(Action.NAME, "Másolás Icinga-ba");
		copyIcinga.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Control+C"));
		menuIcinga.add(copyIcinga);
		txtIcingaNumber.setComponentPopupMenu(menuIcinga);
		mainFrame.getContentPane().add(txtIcingaNumber);

		JPopupMenu menuDavin = new JPopupMenu();
		txtDavinNumber = new JTextField();
		txtDavinNumber.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtDavinNumber.setColumns(10);
		txtDavinNumber.setBounds(61, 203, 100, 30);

		Action copyDavin = new DefaultEditorKit.CopyAction();
		copyDavin.putValue(Action.NAME, "Másolás Davin-ba");
		copyDavin.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("Control+C"));
		menuDavin.add(copyDavin);
		txtDavinNumber.setComponentPopupMenu(menuDavin);
		txtIcingaNumber.setComponentPopupMenu(menuIcinga);

		mainFrame.getContentPane().add(txtDavinNumber);

		txtPhoneNr = new JTextField();
		txtPhoneNr.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtPhoneNr.setColumns(10);
		txtPhoneNr.setBounds(225, 377, 200, 30);
		mainFrame.getContentPane().add(txtPhoneNr);

		lblPhoneNr = new JLabel("Telefonnummer:");
		lblPhoneNr.setOpaque(true);
		lblPhoneNr.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNr.setForeground(new Color(255, 99, 71));
		lblPhoneNr.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhoneNr.setBackground(new Color(240, 248, 255));
		lblPhoneNr.setBounds(15, 377, 200, 30);
		mainFrame.getContentPane().add(lblPhoneNr);
		mainFrame.getContentPane().add(btnDelete);
		mainFrame.getContentPane().add(btnShowTableWindow);

		btnSaveAllInTheTable = new JButton("Mentés táblázatba");
		btnSaveAllInTheTable.setForeground(new Color(255, 69, 0));
		btnSaveAllInTheTable.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnSaveAllInTheTable.setBackground(new Color(245, 222, 179));
		btnSaveAllInTheTable.setBounds(353, 432, 200, 35);
		btnSaveAllInTheTable.addActionListener(this);
		mainFrame.getContentPane().add(btnSaveAllInTheTable);

		cmbLinie = new JComboBox();
		cmbLinie.setBackground(new Color(240, 255, 255));
		cmbLinie.setForeground(new Color(255, 0, 0));
		cmbLinie.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		cmbLinie.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
		cmbLinie.setBounds(174, 440, 60, 30);
		mainFrame.getContentPane().add(cmbLinie);

		lblLinie = new JLabel("Linie:");
		lblLinie.setOpaque(true);
		lblLinie.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinie.setForeground(new Color(255, 99, 71));
		lblLinie.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLinie.setBackground(new Color(240, 248, 255));
		lblLinie.setBounds(15, 434, 100, 30);
		mainFrame.getContentPane().add(lblLinie);

		txtSDNumber = new JTextField();
		txtSDNumber.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtSDNumber.setColumns(10);
		txtSDNumber.setBounds(146, 505, 100, 30);
		mainFrame.getContentPane().add(txtSDNumber);

		lblTicket = new JLabel("SD Nummer:");
		lblTicket.setOpaque(true);
		lblTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicket.setForeground(new Color(255, 99, 71));
		lblTicket.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTicket.setBackground(new Color(240, 248, 255));
		lblTicket.setBounds(15, 504, 100, 30);
		mainFrame.getContentPane().add(lblTicket);

		lblIcinga = new JLabel("Icinga:");
		lblIcinga.setOpaque(true);
		lblIcinga.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcinga.setForeground(new Color(255, 99, 71));
		lblIcinga.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblIcinga.setBackground(new Color(240, 248, 255));
		lblIcinga.setBounds(422, 162, 100, 30);
		mainFrame.getContentPane().add(lblIcinga);

		lblDavin = new JLabel("Davin:");
		lblDavin.setOpaque(true);
		lblDavin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDavin.setForeground(new Color(255, 99, 71));
		lblDavin.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDavin.setBackground(new Color(240, 248, 255));
		lblDavin.setBounds(61, 162, 100, 30);
		mainFrame.getContentPane().add(lblDavin);

		btnNumber_0 = new JButton("0");
		btnNumber_0.setForeground(new Color(0, 0, 128));
		btnNumber_0.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_0.setBackground(new Color(60, 179, 113));
		btnNumber_0.setBounds(256, 296, 50, 50);
		btnNumber_0.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_0);

		btnSlash = new JButton("/");
		btnSlash.setForeground(new Color(0, 0, 128));
		btnSlash.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnSlash.setBackground(new Color(60, 179, 113));
		btnSlash.setBounds(206, 296, 50, 50);
		btnSlash.addActionListener(this);
		mainFrame.getContentPane().add(btnSlash);

		btnNumber_9 = new JButton("9");
		btnNumber_9.setForeground(new Color(0, 0, 128));
		btnNumber_9.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_9.setBackground(new Color(60, 179, 113));
		btnNumber_9.setBounds(305, 249, 50, 50);
		btnNumber_9.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_9);

		btnNumber_8 = new JButton("8");
		btnNumber_8.setForeground(new Color(0, 0, 128));
		btnNumber_8.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_8.setBackground(new Color(60, 179, 113));
		btnNumber_8.setBounds(256, 249, 50, 50);
		btnNumber_8.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_8);

		btnNumber_7 = new JButton("7");
		btnNumber_7.setForeground(new Color(0, 0, 128));
		btnNumber_7.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_7.setBackground(new Color(60, 179, 113));
		btnNumber_7.setBounds(206, 249, 50, 50);
		btnNumber_7.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_7);

		btnNumber_6 = new JButton("6");
		btnNumber_6.setForeground(new Color(0, 0, 128));
		btnNumber_6.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_6.setBackground(new Color(60, 179, 113));
		btnNumber_6.setBounds(305, 201, 50, 50);
		btnNumber_6.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_6);

		btnNumber_5 = new JButton("5");
		btnNumber_5.setForeground(new Color(0, 0, 128));
		btnNumber_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_5.setBackground(new Color(60, 179, 113));
		btnNumber_5.setBounds(256, 201, 50, 50);
		btnNumber_5.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_5);

		btnNumber_4 = new JButton("4");
		btnNumber_4.setForeground(new Color(0, 0, 128));
		btnNumber_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_4.setBackground(new Color(60, 179, 113));
		btnNumber_4.setBounds(206, 201, 50, 50);
		btnNumber_4.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_4);

		btnNumber_3 = new JButton("3");
		btnNumber_3.setForeground(new Color(0, 0, 128));
		btnNumber_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_3.setBackground(new Color(60, 179, 113));
		btnNumber_3.setBounds(305, 151, 50, 50);
		btnNumber_3.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_3);

		btnNumber_2 = new JButton("2");
		btnNumber_2.setForeground(new Color(0, 0, 128));
		btnNumber_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_2.setBackground(new Color(60, 179, 113));
		btnNumber_2.setBounds(256, 151, 50, 50);
		btnNumber_2.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_2);

		btnNumber_1 = new JButton("1");
		btnNumber_1.setForeground(new Color(0, 0, 128));
		btnNumber_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNumber_1.setBackground(new Color(60, 179, 113));
		btnNumber_1.setBounds(206, 151, 50, 50);
		btnNumber_1.addActionListener(this);
		mainFrame.getContentPane().add(btnNumber_1);

		txtStandortNummer = new JTextField();
		txtStandortNummer.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtStandortNummer.setBounds(262, 96, 150, 25);
		txtStandortNummer.setColumns(10);
		mainFrame.getContentPane().add(txtStandortNummer);

		btnShowNumbers = new JButton("Davin/Icinga");
		btnShowNumbers.setBackground(new Color(245, 222, 179));
		btnShowNumbers.setForeground(new Color(255, 69, 0));
		btnShowNumbers.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnShowNumbers.setBounds(422, 97, 150, 30);
		btnShowNumbers.addActionListener(this);
		mainFrame.getContentPane().add(btnShowNumbers);

		txtName = new JTextField();
		txtName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtName.setColumns(10);
		txtName.setBounds(225, 40, 200, 25);
		mainFrame.getContentPane().add(txtName);

		lblName = new JLabel("Techniker:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(255, 99, 71));
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setOpaque(true);
		lblName.setBackground(new Color(240, 248, 255));
		lblName.setBounds(15, 40, 200, 30);
		mainFrame.getContentPane().add(lblName);

		lblStandort = new JLabel("Standort oder VPSZ Nummer: 49/");
		lblStandort.setForeground(new Color(255, 99, 71));
		lblStandort.setBackground(new Color(240, 248, 255));
		lblStandort.setHorizontalAlignment(SwingConstants.CENTER);
		lblStandort.setOpaque(true);
		lblStandort.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblStandort.setBounds(15, 95, 235, 30);

		mainFrame.getContentPane().add(lblStandort);

		lblBackground = new JLabel("");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(HotlineAppMainWindow.class.getResource("/images/schrank_b.jpg")));
		lblBackground.setBounds(0, 0, 585, 670);
		mainFrame.getContentPane().add(lblBackground);

		hotlineData = null;
		tableWindow = new HotlineAppHotlineTable(staffName);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnNumber_0) {
			functions.Button0(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_1) {
			functions.Button1(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_2) {
			functions.Button2(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_3) {
			functions.Button3(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_4) {
			functions.Button4(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_5) {
			functions.Button5(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_6) {
			functions.Button6(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_7) {
			functions.Button7(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_8) {
			functions.Button8(txtStandortNummer);
		}

		else if (e.getSource() == btnNumber_9) {
			functions.Button9(txtStandortNummer);
		}

		else if (e.getSource() == btnSlash) {
			functions.ButtonSlash(txtStandortNummer);
		}

		else if (e.getSource() == btnSaveAllInTheTable) {

			CheckContent();
		}

		else if (e.getSource() == btnShowTableWindow) {
			if (!tableWindow.isVisible()) {

				tableWindow.FillTable();
				tableWindow.getFrmTableWindow().setVisible(true);
			}
		}

		else if (e.getSource() == btnShowNumbers) {

			functions.ShowNumbers(txtDavinNumber, txtIcingaNumber, txtStandortNummer);

		}

		else if (e.getSource() == btnDelete) {

			functions.ButtonDelete(txtStandortNummer);

		}

		else if (e.getSource() == btnClear) {

			ClearFields();

		}

	}

	private void ClearFields() {

		txtStandortNummer.setText("");
		txtDavinNumber.setText("");
		txtIcingaNumber.setText("");
		txtSDNumber.setText("");
		txtPhoneNr.setText("");
		txtName.setText("");
		cmbLinie.setSelectedIndex(0);

	}

	private void CheckContent() {

		if (txtStandortNummer.getText() != null && !txtStandortNummer.getText().isEmpty()) {

			int sdNr = 0;
			try {
				if (txtSDNumber.getText() == null || txtSDNumber.getText().isEmpty()) {
					sdNr = 0;
				} else {
					sdNr = Integer.parseInt(txtSDNumber.getText());
				}

				hotlineData = new HotlineData((LocalDate.now()), sdNr, staffName, txtName.getText(),
						txtPhoneNr.getText(), txtStandortNummer.getText(),
						Integer.parseInt((String) cmbLinie.getModel().getSelectedItem()), staffName);

				tableWindow.setHotlineData(hotlineData);

				JOptionPane.showMessageDialog(mainFrame, "Mentve a táblázatba!", "Sikeres mentés",
						JOptionPane.INFORMATION_MESSAGE);
				hotlineData = null;
			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(mainFrame, "A jegyszám csak számokból állhat!!", "Hibás jegszám!",
						JOptionPane.ERROR_MESSAGE);
				hotlineData = null;
			}

		} else {
			JOptionPane.showMessageDialog(mainFrame, "Add meg kérlek legalább a Standort számát először!",
					"Sikertelen mentés", JOptionPane.WARNING_MESSAGE);
		}

	}

	public JFrame getMainFrame() {
		return mainFrame;
	}
}
