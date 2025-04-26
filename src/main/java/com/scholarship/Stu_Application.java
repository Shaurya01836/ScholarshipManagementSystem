package com.scholarship;

public class Stu_Application {
		private int scholarshipId;
	    private String scholarshipName;
	    private int amount;
	    private String status;

	    public Stu_Application(int scholarshipId, String scholarshipName, int amount, String status) {
	        this.scholarshipId = scholarshipId;
	        this.scholarshipName = scholarshipName;
	        this.amount = amount;
	        this.status = status;
	    }

	    
	    public int getScholarshipId() { return scholarshipId; }
	    public String getScholarshipName() { return scholarshipName; }
	    public int getAmount() { return amount; }
	    public String getStatus() { return status; }
	    
	public static void main(String[] args) {
		

	}

}
