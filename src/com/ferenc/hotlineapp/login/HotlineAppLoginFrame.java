package com.ferenc.hotlineapp.login;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import com.ferenc.hotlineapp.datawindow.DataChangingWindow;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class HotlineAppLoginFrame extends JDialog {
	
	private JTextField txtStaffName;
	private String staffName;

	public String getStaffName() {
		return staffName;
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public HotlineAppLoginFrame() {
		getContentPane().setBackground(new Color(70, 130, 180));
		setBackground(new Color(70, 130, 180));
		setTitle("Üdvözlet!");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setModal(true);
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e)
			  {
			    System.exit(0);
			  }
		});
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(DataChangingWindow.class.getResource("/images/phone.png")));
		
		JLabel lblGreeting = new JLabel("Add meg kérlek a teljes nevedet:");
		lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreeting.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblGreeting.setForeground(new Color(255, 250, 250));
		lblGreeting.setBounds(104, 27, 220, 25);
		getContentPane().add(lblGreeting);
		
		JLabel lblInfo = new JLabel("(így fog szerepelni a dokumentációkban is)");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(new Color(255, 250, 250));
		lblInfo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		lblInfo.setBounds(78, 63, 260, 25);
		getContentPane().add(lblInfo);
		
		txtStaffName = new JTextField();
		txtStaffName.setToolTipText("pl.: Ferenc Paronai");
		txtStaffName.setForeground(new Color(25, 25, 112));
		txtStaffName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		txtStaffName.setBounds(133, 111, 150, 30);
		getContentPane().add(txtStaffName);
		txtStaffName.setColumns(10);
		
		JButton btnOkay = new JButton("Rendben");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtStaffName.getText() != null && !txtStaffName.getText().isEmpty()) {
					staffName = txtStaffName.getText();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "A neved kelleni fog a táblázat adataihoz!", "Hiba", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnOkay.setBackground(new Color(224, 255, 255));
		btnOkay.setForeground(new Color(255, 0, 0));
		btnOkay.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 13));
		btnOkay.setBounds(73, 195, 100, 30);
		getContentPane().add(btnOkay);
		
		JButton btnCancel = new JButton("Mégsem");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				System.exit(0);
				
			}
		});
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 13));
		btnCancel.setBackground(new Color(224, 255, 255));
		btnCancel.setBounds(267, 195, 100, 30);
		getContentPane().add(btnCancel);

	}
}
