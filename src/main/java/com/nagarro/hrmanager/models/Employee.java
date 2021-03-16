package com.nagarro.hrmanager.models;

/**
 * This class provides details of Employees
 */
public class Employee {

	private Long emp_code;
	private String emp_name;
	private String loc;
	private String email;
	private String dob;

	public Employee() {
	}

	public Long getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(final Long emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(final String emp_name) {
		this.emp_name = emp_name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(final String loc) {
		this.loc = loc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(final String dob) {
		this.dob = dob;
	}

}
