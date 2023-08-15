package com.ferenc.hotlineapp.tablewindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.ferenc.hotlineapp.datawindow.DataChangingWindow;
import com.ferenc.hotlineapp.mainwindow.HotlineData;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.awt.event.ActionEvent;

public class HotlineAppHotlineTable extends JDialog {

	private JFrame frmTableWindow;
	private JTable tblHotlineData;
	private DefaultTableModel model;
	private List<HotlineData> hotlineData;
	private String staffName;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public HotlineAppHotlineTable(String staffName) {
		initialize(staffName);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param staffName 
	 */
	private void initialize(String staffName) {

		this.setModal(true);
		frmTableWindow = new JFrame();
		frmTableWindow.setBackground(new Color(0, 0, 139));
		frmTableWindow.setBounds(700, 100, 800, 500);
		frmTableWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmTableWindow.getContentPane().setLayout(null);
		this.staffName = staffName;
		
		frmTableWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(DataChangingWindow.class.getResource("/images/phone.png")));

		hotlineData = new ArrayList<HotlineData>();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 786, 495);
		frmTableWindow.getContentPane().add(scrollPane);

		tblHotlineData = new JTable();
		tblHotlineData.setForeground(new Color(0, 0, 139));
		tblHotlineData.setBackground(new Color(255, 255, 224));
		tblHotlineData.setFont(new Font("Segoe Print", Font.PLAIN, 13));

		scrollPane.setViewportView(tblHotlineData);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(173, 216, 230));
		frmTableWindow.setJMenuBar(menuBar);

		JMenu mnTable = new JMenu("Táblázat szerkesztése");
		menuBar.add(mnTable);

		JMenuItem mtmAddData = new JMenuItem("Új sor hozzáfűzése");
		mtmAddData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddNewRow();

			}
		});
		mtmAddData.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mtmAddData.setBackground(new Color(240, 255, 255));
		mtmAddData.setForeground(new Color(0, 0, 128));
		mnTable.add(mtmAddData);

		JMenuItem mtmEdit = new JMenuItem("Szerkesztés");
		mtmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tblHotlineData.getSelectedRow() != -1) {
					EditSelectedRow();
				} else {
					JOptionPane.showMessageDialog(frmTableWindow, "Jelölj ki egy sort a táblázatoból a módosításhoz!",
							"Nincsen kijelölt sor", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		mtmEdit.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mtmEdit.setForeground(new Color(0, 0, 128));
		mtmEdit.setBackground(new Color(240, 255, 255));
		mnTable.add(mtmEdit);

		JMenuItem mtmDelete = new JMenuItem("Sor törlése");
		mtmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tblHotlineData.getSelectedRow() != -1) {

					Object[] option = new Object[] { "Igen", "Mégsem" };

					if (JOptionPane.showOptionDialog(frmTableWindow, "Biztosan törölni akarod a kijelölt sort?",
							"Törlés", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option,
							option[1]) == JOptionPane.YES_OPTION)

						DeleteSelectedRow();

				} else if (tblHotlineData.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frmTableWindow, "Jelölj ki egy sort a táblázatoból a törléshez!",
							"Nincsen kijelölt sor", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		mtmDelete.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mtmDelete.setForeground(new Color(0, 0, 128));
		mtmDelete.setBackground(new Color(240, 255, 255));
		mnTable.add(mtmDelete);

		JMenu mnFileHandling = new JMenu("Mentés Excell-be");
		menuBar.add(mnFileHandling);

		JMenuItem mtmSaveAll = new JMenuItem("Összes mentése");
		mtmSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SaveAllDataToFile();
				
			}
		});
		mtmSaveAll.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mtmSaveAll.setBackground(new Color(240, 255, 255));
		mtmSaveAll.setForeground(new Color(0, 0, 128));
		mnFileHandling.add(mtmSaveAll);

		JMenuItem mtmSaveOwnData = new JMenuItem("Saját hívások mentése");
		mtmSaveOwnData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SaveOwnDataToFile();
				
			}
		});
		mtmSaveOwnData.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mtmSaveOwnData.setBackground(new Color(240, 255, 255));
		mtmSaveOwnData.setForeground(new Color(0, 0, 128));
		mnFileHandling.add(mtmSaveOwnData);

	}

	protected void SaveOwnDataToFile() {
		// TODO Auto-generated method stub
		
	}

	protected void SaveAllDataToFile() {
		// TODO Auto-generated method stub
		
	}

	protected void DeleteSelectedRow() {
		// TODO Auto-generated method stub

	}

	protected void EditSelectedRow() {
		// TODO Auto-generated method stub

	}

	public List<HotlineData> getHotlineData() {
		return hotlineData;
	}

	public void setHotlineData(HotlineData hotlineData) {
		this.hotlineData.add(hotlineData);
	}

	public void FillTable() {

		SetTableColumns();

		if (this.hotlineData != null) {

			for (HotlineData data : hotlineData) {
				
				String date = data.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMANY));

				Object[] line = new Object[] { date, ("SD"+data.getSdNumber()), data.getOpenedFrom(),
						data.getTechnicianName(), data.getPhoneNumber(), data.getLocalizationNumber(),
						data.getLineNumber(), data.getClosedFrom() };

				model.addRow(line);

			}

		}

	}

	private void SetTableColumns() {

		String[] columns = { "Dátum:", "Jegyszám:", "Jegyet nyitotta:", "Technikus neve:", "Telefonszáma:", "Standort:",
				"Linie:", "Jegyet zárta:" };

		model = new DefaultTableModel(null, columns);
		tblHotlineData.setModel(model);
		DefaultTableCellRenderer crenderer = new DefaultTableCellRenderer();
		crenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < model.getColumnCount(); i++) {

			tblHotlineData.getColumnModel().getColumn(i).setCellRenderer(crenderer);

		}

	}

	public JFrame getFrmTableWindow() {
		return frmTableWindow;
	}

	private void AddNewRow() {
		
		DataChangingWindow dataWindow = new DataChangingWindow();
		dataWindow.setVisible(true);
		
		if(dataWindow.isResult()) {
			
			HotlineData data = dataWindow.getData();
		
			String date = data.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMANY));
			
			Object[] line = new Object[] { date, ("SD"+data.getSdNumber()), data.getOpenedFrom(),
					data.getTechnicianName(), data.getPhoneNumber(), data.getLocalizationNumber(),
					data.getLineNumber(), data.getClosedFrom() };
			
			model.addRow(line);
			
			hotlineData.add(data);
			
			JOptionPane.showMessageDialog(frmTableWindow, "Az új hívás sikeresen rögzítésre került!", "Mentés", JOptionPane.INFORMATION_MESSAGE);
			
		}

	}

}