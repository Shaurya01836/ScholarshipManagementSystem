package com.scholarship;

public class ScholarshipRecord {
	
	private int id ;
	private String scholarship_name ;
	private String description ; 
	private String eligibility_criteria ;
	private double amount ;
	private String status;

	public ScholarshipRecord() {
		super();
	}
	
	public ScholarshipRecord(int id , String scholarship_name, String description, String eligibility_criteria, double amount , String status) {
		super();
		this.id = id;
		this.scholarship_name = scholarship_name;
		this.description = description;
		this.eligibility_criteria = eligibility_criteria;
		this.amount = amount;
		this.status = status;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScholarship_name() {
		return scholarship_name;
	}

	public void setScholarship_name(String scholarship_name) {
		this.scholarship_name = scholarship_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEligibility_criteria() {
		return eligibility_criteria;
	}

	public void setEligibility_criteria(String eligibility_criteria) {
		this.eligibility_criteria = eligibility_criteria;
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

	@Override
	public String toString() {
		return "ScholarshipRecord [id=" + id + ",scholarship_name=" + scholarship_name + ", description=" + description + ", eligibility_criteria=" + eligibility_criteria
		        + ", amount=" + amount + ",status=" + status +"]";

	}

	public static void main(String[] args) {
		

	}

}
