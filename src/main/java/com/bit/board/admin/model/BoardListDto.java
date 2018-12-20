package com.bit.board.admin.model;

public class BoardListDto extends CategoryDto {
	// categoryDto는 독단적으로 쓰일 일이 거의 없기때문에 ccode는 상속해준다.
	private int bcode;
	private String bname;
	private int btype;
	private String control;
	//반드시 테이블하고 일치할 필요는 없다!!
	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

}
