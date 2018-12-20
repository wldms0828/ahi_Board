package com.bit.board.admin.model;

public class CategoryDto {
	// dto 객체는 private으로 정한다.
	private int ccode;
	private String cname;

	public int getCcode() {
		return ccode;
	}

	public void setCcode(int ccode) {
		this.ccode = ccode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
