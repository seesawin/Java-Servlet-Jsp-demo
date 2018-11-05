package com.seesawin.demo.ch10.nubmer.model;

import java.math.BigDecimal;

public class NumberBean {
	private Byte nTiny;
	private Short nSmall;
	private Integer nMediun;
	private Integer nInt;
	private Long nBig;
	private Float nFloat;
	private Double nDoble;
	private BigDecimal nDecimal;
	private BigDecimal nNumeric;

	public Byte getnTiny() {
		return nTiny;
	}

	public void setnTiny(Byte nTiny) {
		this.nTiny = nTiny;
	}

	public Short getnSmall() {
		return nSmall;
	}

	public void setnSmall(Short nSmall) {
		this.nSmall = nSmall;
	}

	public Integer getnMediun() {
		return nMediun;
	}

	public void setnMediun(Integer nMediun) {
		this.nMediun = nMediun;
	}

	public Integer getnInt() {
		return nInt;
	}

	public void setnInt(Integer nInt) {
		this.nInt = nInt;
	}

	public Long getnBig() {
		return nBig;
	}

	public void setnBig(Long nBig) {
		this.nBig = nBig;
	}

	public Float getnFloat() {
		return nFloat;
	}

	public void setnFloat(Float nFloat) {
		this.nFloat = nFloat;
	}

	public Double getnDoble() {
		return nDoble;
	}

	public void setnDoble(Double nDoble) {
		this.nDoble = nDoble;
	}

	public BigDecimal getnDecimal() {
		return nDecimal;
	}

	public void setnDecimal(BigDecimal nDecimal) {
		this.nDecimal = nDecimal;
	}

	public BigDecimal getnNumeric() {
		return nNumeric;
	}

	public void setnNumeric(BigDecimal nNumeric) {
		this.nNumeric = nNumeric;
	}

	@Override
	public String toString() {
		return "NumberBean [nTiny=" + nTiny + ", nSmall=" + nSmall + ", nMediun=" + nMediun + ", nInt=" + nInt + ", nBig=" + nBig + ", nFloat=" + nFloat + ", nDoble=" + nDoble + ", nDecimal=" + nDecimal + ", nNumeric=" + nNumeric + "]";
	}
}
