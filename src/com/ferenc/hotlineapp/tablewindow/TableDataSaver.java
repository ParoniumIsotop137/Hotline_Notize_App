package com.ferenc.hotlineapp.tablewindow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.ferenc.hotlineapp.mainwindow.HotlineData;

public class TableDataSaver {

	private String sep = ";";

	private String header = "Dátum;Jegyszám;Jegyet nyitotta;Technikus neve;Telefonszáma;Standort;Linie;Hibás eset;Jegyet zárta";

	public void SaveAllData(List<HotlineData> hotlineData, File fileName) {

		try (FileWriter fw = new FileWriter(fileName + ".csv")) {

			fw.write(header + "\n");

			for (HotlineData data : hotlineData) {
				
				String date = data.getDate()
						.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMANY));

				String text = date + sep + "SD" + String.valueOf(data.getSdNumber() + sep + data.getOpenedFrom() + sep
						+ data.getTechnicianName() + sep + data.getPhoneNumber() + sep + data.getLocalizationNumber()
						+ sep + String.valueOf(data.getLineNumber())+ sep + "" + sep + data.getClosedFrom());

				fw.write(text + "\n");
			}

			JOptionPane.showMessageDialog(null, "A táblázat " + fileName + ".csv néven sikeresen mentésre került!",
					"Mentés", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sikertelen mentés! " + e.getMessage(), "Hiba",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void SaveOwnData(List<HotlineData> hotlineData, File fileName, String staffName) {

		try (FileWriter fw = new FileWriter(fileName + ".csv")) {

			fw.write(header + "\n");

			for (HotlineData data : hotlineData) {
				if (data.getOpenedFrom().toLowerCase().equals(staffName.toLowerCase())
						|| data.getClosedFrom().toLowerCase().equals(staffName.toLowerCase())) {

					String date = data.getDate()
							.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMANY));

					String text = date + sep + "SD"
							+ String.valueOf(
									data.getSdNumber() + sep + data.getOpenedFrom() + sep + data.getTechnicianName()
											+ sep + data.getPhoneNumber() + sep + data.getLocalizationNumber() + sep
											+ String.valueOf(data.getLineNumber())+ sep + "" + sep + data.getClosedFrom());

					fw.write(text + "\n");

				}
			}

			JOptionPane.showMessageDialog(null, "A táblázat " + fileName + ".csv néven sikeresen mentésre került!",
					"Mentés", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sikertelen mentés! " + e.getMessage(), "Hiba",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
