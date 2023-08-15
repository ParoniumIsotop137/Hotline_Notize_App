package com.ferenc.hotlineapp.mainwindow;

import java.time.LocalDate;

public class HotlineData {
	
	
	private LocalDate date;
	private int sdNumber;
	private String openedFrom;
	private String technicianName;
	private String phoneNumber;
	private String localizationNumber;
	private int lineNumber;
	private String closedFrom;
	
	
	

	public HotlineData(LocalDate date, int sdNumber, String openedFrom, String technicianName,
			String phoneNumber, String localizationNumber, int lineNumber, String closedFrom) {
		this.date = date;
		this.sdNumber = sdNumber;
		setOpenedFrom(openedFrom);
		setTechnicianName(technicianName);
		setPhoneNumber(phoneNumber);
		setLocalizationNumber(localizationNumber);
		this.lineNumber = lineNumber;
		setClosedFrom(closedFrom);
	}
	
	

	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		
		this.date = date;
	}



	public String getOpenedFrom() {
		return openedFrom;
	}



	public void setOpenedFrom(String openedFrom) {
		
		if(openedFrom == null || openedFrom.isEmpty()) {
			this.openedFrom = "";
		}
		else {
			this.openedFrom = openedFrom;	
		}
		
		
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		
		if(phoneNumber == null || phoneNumber.isEmpty()) {
			this.phoneNumber = "";
		}
		else {
			this.phoneNumber = phoneNumber;
		}
		
		
	}



	public String getClosedFrom() {
		return closedFrom;
	}



	public void setClosedFrom(String closedFrom) {
		
		if(closedFrom == null || closedFrom.isEmpty()) {
			this.closedFrom = "";
		}
		else {
			this.closedFrom = closedFrom;
		}
		
		
	}


	public String getTechnicianName() {
		return technicianName;
	}

	public void setTechnicianName(String technicianName) {
		
		if(technicianName == null || technicianName.isEmpty()) {
			this.technicianName = "";
		}
		else {
			this.technicianName = technicianName;
		}
		
		
	}

	public String getLocalizationNumber() {
		return localizationNumber;
	}

	public void setLocalizationNumber(String localizationNumber) {
		
		if(localizationNumber == null || localizationNumber.isEmpty()) {
			this.localizationNumber = "";
		}
		else {
			this.localizationNumber = localizationNumber;
		}
		
		
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getSdNumber() {
		return sdNumber;
	}

	public void setSdNumber(int sdNumber) {
		
		this.sdNumber = sdNumber;
		
		
	}



	@Override
	public String toString() {
		return "HotlineData, date=" + date + ", sdNumber=" + sdNumber + ", openedFrom=" + openedFrom
				+ ", technicianName=" + technicianName + ", phoneNumber=" + phoneNumber + ", localizationNumber="
				+ localizationNumber + ", lineNumber=" + lineNumber + ", closedFrom=" + closedFrom + "]";
	}
	
	
	
	
	

}
