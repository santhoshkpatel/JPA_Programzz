package com.xworkz.jpa_jewellery.enums;

public enum JewelleryType {
	CARATA("24carat"), CARATB("18carat");

	private String evalue;

	private JewelleryType(String evalue) {
		this.evalue = evalue;
	}

	public String getEvalue() {
		return evalue;
	}

}
