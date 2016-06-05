package io.msalinas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ResourceBundle;

public abstract class Payslip {

	protected final ResourceBundle myResources = ResourceBundle
			.getBundle("ResourceBundle");

	private String first;
	private String last;
	private int salary;
	private double superAnnuation;
	private String date;

	private int lowerLimit;
	private int upperLimit;
	private int taxBase;
	private double taxPerDollar;

	public Payslip(String first, String last, int salary,
			double superAnnuation, String date) {
		this.first = first;
		this.last = last;
		this.salary = salary;
		this.date = date;
		this.superAnnuation = superAnnuation;
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

	public double getTaxPerDollar() {
		return taxPerDollar;
	}

	public void setTaxPerDollar(double double1) {
		this.taxPerDollar = double1;
	}

	public BigDecimal getGrossMontlyIncome() {
		BigDecimal monthlyIncome = new BigDecimal(getSalary() / 12);
		return monthlyIncome.setScale(0, RoundingMode.DOWN);
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	public int getTaxBase() {
		return taxBase;
	}

	public void setTaxBase(int taxBase) {
		this.taxBase = taxBase;
	}

}
