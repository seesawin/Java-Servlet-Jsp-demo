package com.seesawin.demo.ch10.string.model;

public class StringBean {
	private String sNbChar;
	private String sNbVarchar;
	private String sBChar;
	private String sBVarchar;

	public String getsNbChar() {
		return sNbChar;
	}

	public void setsNbChar(String sNbChar) {
		this.sNbChar = sNbChar;
	}

	public String getsNbVarchar() {
		return sNbVarchar;
	}

	public void setsNbVarchar(String sNbVarchar) {
		this.sNbVarchar = sNbVarchar;
	}

	public String getsBChar() {
		return sBChar;
	}

	public void setsBChar(String sBChar) {
		this.sBChar = sBChar;
	}

	public String getsBVarchar() {
		return sBVarchar;
	}

	public void setsBVarchar(String sBVarchar) {
		this.sBVarchar = sBVarchar;
	}

	@Override
	public String toString() {
		return "StringBean [sNbChar=" + sNbChar + ", sNbVarchar=" + sNbVarchar + ", sBChar=" + sBChar + ", sBVarchar=" + sBVarchar + "]";
	}
}
