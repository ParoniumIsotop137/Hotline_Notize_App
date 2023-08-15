package com.ferenc.hotlineapp.datawindow;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import com.ferenc.hotlineapp.mainwindow.HotlineData;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class DataChangingWindow extends JDialog {
	private JTextField txtSDNumber;
	private JTextField txtOpener;
	private JTextField txtNameOfTechnician;
	private JLabel lblPhoneNumber;
	private JTextField txtPhoneNumber;
	private JLabel lblLocationNumber;
	private JTextField txtLocationNumber;
	private JLabel lblLineNumber;
	private JComboBox cmbLineNumber;
	private JLabel lblClosedFrom;
	private JTextField txtClosedFrom;
	private JButton bntOk;
	private HotlineData data;
	private boolean result = false;

	/**
	 * Launch the application.
	 *
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { DataChangingWindow dialog = new
	 * DataChangingWindow();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 * 
	 * /** Create the dialog.
	 */
	public DataChangingWindow() {
		setTitle("Hívás adatai");
		getContentPane().setBackground(new Color(176, 196, 222));
		setBounds(100, 100, 350, 480);
		getContentPane().setLayout(null);
		setModal(true);

		setIconImage(Toolkit.getDefaultToolkit().getImage(DataChangingWindow.class.getResource("/images/phone.png")));

		JLabel lblSDNumber = new JLabel("SD-Nummer:");
		lblSDNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSDNumber.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblSDNumber.setForeground(new Color(255, 140, 0));
		lblSDNumber.setBounds(29, 43, 100, 25);
		getContentPane().add(lblSDNumber);

		txtSDNumber = new JTextField();
		txtSDNumber.setForeground(new Color(0, 0, 128));
		txtSDNumber.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
		txtSDNumber.setBounds(165, 43, 100, 25);
		getContentPane().add(txtSDNumber);
		txtSDNumber.setColumns(10);

		JLabel lblOpener = new JLabel("Jegyet nyitotta:");
		lblOpener.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpener.setForeground(new Color(255, 140, 0));
		lblOpener.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblOpener.setBounds(29, 89, 100, 25);
		getContentPane().add(lblOpener);

		txtOpener = new JTextField();
		txtOpener.setForeground(new Color(0, 0, 128));
		txtOpener.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
		txtOpener.setColumns(10);
		txtOpener.setBounds(165, 89, 130, 25);
		getContentPane().add(txtOpener);

		JLabel lblTechnicianName = new JLabel("Technikus neve:");
		lblTechnicianName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTechnicianName.setForeground(new Color(255, 140, 0));
		lblTechnicianName.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblTechnicianName.setBounds(10, 135, 130, 25);
		getContentPane().add(lblTechnicianName);

		txtNameOfTechnician = new JTextField();
		txtNameOfTechnician.setForeground(new Color(0, 0, 128));
		txtNameOfTechnician.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
		txtNameOfTechnician.setColumns(10);
		txtNameOfTechnician.setBounds(165, 135, 130, 25);
		getContentPane().add(txtNameOfTechnician);

		lblPhoneNumber = new JLabel("Telefonszáma:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setForeground(new Color(255, 140, 0));
		lblPhoneNumber.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblPhoneNumber.setBounds(10, 189, 130, 25);
		getContentPane().add(lblPhoneNumber);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setForeground(new Color(0, 0, 128));
		txtPhoneNumber.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(165, 189, 130, 25);
		getContentPane().add(txtPhoneNumber);

		lblLocationNumber = new JLabel("Standortnummer:");
		lblLocationNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocationNumber.setForeground(new Color(255, 140, 0));
		lblLocationNumber.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblLocationNumber.setBounds(10, 236, 130, 25);
		getContentPane().add(lblLocationNumber);

		txtLocationNumber = new JTextField();
		txtLocationNumber.setForeground(new Color(0, 0, 128));
		txtLocationNumber.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
		txtLocationNumber.setColumns(10);
		txtLocationNumber.setBounds(165, 236, 100, 25);
		getContentPane().add(txtLocationNumber);

		lblLineNumber = new JLabel("Linie:");
		lblLineNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineNumber.setForeground(new Color(255, 140, 0));
		lblLineNumber.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblLineNumber.setBounds(39, 283, 90, 25);
		getContentPane().add(lblLineNumber);

		cmbLineNumber = new JComboBox();
		cmbLineNumber.setBackground(new Color(255, 255, 224));
		cmbLineNumber.setForeground(new Color(0, 0, 139));
		cmbLineNumber.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
		cmbLineNumber.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
		cmbLineNumber.setBounds(165, 280, 45, 30);
		getContentPane().add(cmbLineNumber);

		lblClosedFrom = new JLabel("Jegyet zárta:");
		lblClosedFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblClosedFrom.setForeground(new Color(255, 140, 0));
		lblClosedFrom.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblClosedFrom.setBounds(10, 331, 130, 25);
		getContentPane().add(lblClosedFrom);

		txtClosedFrom = new JTextField();
		txtClosedFrom.setForeground(new Color(0, 0, 128));
		txtClosedFrom.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
		txtClosedFrom.setColumns(10);
		txtClosedFrom.setBounds(165, 331, 130, 25);
		getContentPane().add(txtClosedFrom);

		JButton btnCancel = new JButton("Mégsem");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnCancel.setBackground(new Color(100, 149, 237));
		btnCancel.setForeground(new Color(255, 250, 250));
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		btnCancel.setBounds(40, 386, 100, 30);
		getContentPane().add(btnCancel);

		bntOk = new JButton("Rendben");
		bntOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtSDNumber.getText().isEmpty() && !txtOpener.getText().isEmpty()
						&& !txtNameOfTechnician.getText().isEmpty() && !txtPhoneNumber.getText().isEmpty()
						&& !txtLocationNumber.getText().isEmpty() && !txtClosedFrom.getText().isEmpty()) {

					CheckData();

				} else {
					JOptionPane.showMessageDialog(null, "Nem került minden meyő kitöltésre!", "Hiánzyó adatok",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		bntOk.setForeground(new Color(255, 250, 250));
		bntOk.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		bntOk.setBackground(new Color(100, 149, 237));
		bntOk.setBounds(192, 386, 100, 30);
		getContentPane().add(bntOk);

	}

	public DataChangingWindow(HotlineData data) {

		this();

		this.data = data;
		txtSDNumber.setText(String.valueOf(data.getSdNumber()));
		txtOpener.setText(data.getOpenedFrom());
		txtNameOfTechnician.setText(data.getTechnicianName());
		txtPhoneNumber.setText(data.getPhoneNumber());
		txtLocationNumber.setText(data.getLocalizationNumber());
		cmbLineNumber.setSelectedItem(data.getLineNumber());
		txtClosedFrom.setText(data.getClosedFrom());

	}

	public HotlineData getData() {
		return data;
	}

	public boolean isResult() {
		return result;
	}

	private void CheckData() {

		try {
			if (this.data == null) {

				data = new HotlineData(LocalDate.now(), Integer.parseInt(txtSDNumber.getText()), txtOpener.getText(),
						txtNameOfTechnician.getText(), txtPhoneNumber.getText(), txtLocationNumber.getText(),
						(Integer.parseInt(cmbLineNumber.getSelectedItem().toString())), txtClosedFrom.getText());

				result = true;
				dispose();

			} else {

				data.setSdNumber(Integer.parseInt(txtSDNumber.getText()));
				data.setOpenedFrom(txtOpener.getText());
				data.setTechnicianName(txtNameOfTechnician.getText());
				data.setPhoneNumber(txtPhoneNumber.getText());
				data.setLocalizationNumber(txtLocationNumber.getText());
				data.setLineNumber(Integer.parseInt(cmbLineNumber.getSelectedItem().toString()));
				data.setClosedFrom(txtClosedFrom.getText());

				result = true;
				dispose();

			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Helytelen számformátum!", "Hiba", JOptionPane.ERROR_MESSAGE);
		}

	}
}
