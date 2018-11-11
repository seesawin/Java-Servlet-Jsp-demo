package com.seesawin.demo.ch08.model;

public class UserBean {
	private String acct;
	private String pwd;

	public String getAcct() {
		return acct;
	}

	public void setAcct(String acct) {
		this.acct = acct;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UserBean [acct=" + acct + ", pwd=" + pwd + "]";
	}
}
