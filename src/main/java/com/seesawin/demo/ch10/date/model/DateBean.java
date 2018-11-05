package com.seesawin.demo.ch10.date.model;

import java.util.Date;

public class DateBean {
	private String dYear4;
	private Date dDate;
	private Date dTime;
	private Date dDatetime;
	private Date dTimestamp;

	public String getdYear4() {
		return dYear4;
	}

	public void setdYear4(String dYear4) {
		this.dYear4 = dYear4;
	}

	public Date getdDate() {
		return dDate;
	}

	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}

	public Date getdTime() {
		return dTime;
	}

	public void setdTime(Date dTime) {
		this.dTime = dTime;
	}

	public Date getdDatetime() {
		return dDatetime;
	}

	public void setdDatetime(Date dDatetime) {
		this.dDatetime = dDatetime;
	}

	public Date getdTimestamp() {
		return dTimestamp;
	}

	public void setdTimestamp(Date dTimestamp) {
		this.dTimestamp = dTimestamp;
	}

	@Override
	public String toString() {
		return "DateBeam [dYear4=" + dYear4 + ", dDate=" + dDate + ", dTime=" + dTime + ", dDatetime=" + dDatetime + ", dTimestamp=" + dTimestamp + "]";
	}
}
