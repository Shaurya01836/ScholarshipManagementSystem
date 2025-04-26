package com.scholarship;

public class ApplicationRecord {
	
		private String studentName;
	    private String scholarshipName;
	    private double amount;
	    private String status;
	    private int studentId;

	public ApplicationRecord(String studentName, String scholarshipName, double amount, String status, int studentId) {
		 this.studentName = studentName;
	        this.scholarshipName = scholarshipName;
	        this.amount = amount;
	        this.status = status;
	        this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getScholarshipName() {
		return scholarshipName;
	}

	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public static void main(String[] args) {
		
	}

}
