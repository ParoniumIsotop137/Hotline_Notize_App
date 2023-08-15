package com.ferenc.hotlineapp.mainwindow.function;

import javax.swing.JTextField;

public class MainWindowFunctions {

	public void Button0(JTextField txtStandortNummer) {
		
		txtStandortNummer.setText((txtStandortNummer.getText()+"0"));
		
	}

	public void Button1(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"1"));
		
	}

	public void Button2(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"2"));
		
	}

	public void Button3(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"3"));
		
	}

	public void Button4(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"4"));
		
	}

	public void Button5(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"5"));
		
	}

	public void Button6(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"6"));
		
	}

	public void Button7(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"7"));
		
	}

	public void Button8(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"8"));
		
	}

	public void Button9(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"9"));
		
	}

	public void ButtonSlash(JTextField txtStandortNummer) {
		txtStandortNummer.setText((txtStandortNummer.getText()+"/"));
		
	}

	public void ShowNumbers(JTextField txtDavinNumber, JTextField txtIcingaNumber, JTextField txtStandortNummer) {
		
		String standort = txtStandortNummer.getText();
		txtDavinNumber.setText(standort);
		
		String icinga = standort.replaceAll("/", "-");
		txtIcingaNumber.setText("-"+icinga+"-");
		
		
		
	}

	public void ButtonDelete(JTextField txtStandortNummer) {
		
		if(txtStandortNummer.getText().length() != 0) {
			
			String text = txtStandortNummer.getText().replaceAll(String.valueOf(txtStandortNummer.getText().charAt(txtStandortNummer.getText().length()-1)), "");
			
			txtStandortNummer.setText(text);
			
			
			
		}
		
		
	}

	

}
