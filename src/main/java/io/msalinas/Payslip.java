package io.msalinas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.ResourceBundle;


public abstract class Payslip {
	
	protected final ResourceBundle myResources =
	  	      ResourceBundle.getBundle("ResourceBundle");
	
	private String first; 
	private String last; 
	private int salary; 
	private double superAnnuation; 
	private String date; 
	
	private int lowerLimit; 
	private int taxPerDollar; 
	
	
	public Payslip(String first, String last, int salary, double superAnnuation, String date) {
		this.first = first;
		this.last = last;
		this.salary = salary;
		this.date = date;
	}
	
	abstract BigDecimal calculateTax();
	abstract BigDecimal totalNetIncome();
	abstract BigDecimal totalSuperAnnuation();


	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getSuperAnnuation() {
		return superAnnuation;
	}

	public void setSuperAnnuation(double superAnnuation) {
		this.superAnnuation = superAnnuation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public int getTaxPerDollar() {
		return taxPerDollar;
	}

	public void setTaxPerDollar(int taxPerDollar) {
		this.taxPerDollar = taxPerDollar;
	}
	
	public BigDecimal getGrossMontlyIncome(){
		BigDecimal monthlyIncome= new BigDecimal (getSalary() /12);
		return monthlyIncome.setScale(0, RoundingMode.HALF_UP);
	}

}
