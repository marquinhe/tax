package io.msalinas;

import static org.junit.Assert.*;
import io.msalinas.TaxTier1;

import org.junit.Test;

public class TaxTier1Test {
	
	/**
	 * Basic test for tier 1, salary > 18200 
	 * No tax base
	 * 
	 */
	
	@Test
	public void testCalculateTax() {
		TaxTier1 payslip;
		payslip = new TaxTier1("First", "Name",  18201, 10.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 1);
	}
	
	@Test
	public void testCalculateTax2() {
		TaxTier1 payslip;
		payslip = new TaxTier1("First", "Name",  25000, 9.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 108);
	}
	
	@Test
	public void testCalculateTax3() {
		TaxTier1 payslip;
		payslip = new TaxTier1("First", "Name",  35000, 9.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 266);
	}
	

	@Test
	public void testCalculateIncome() {
		TaxTier1 payslip;
		payslip = new TaxTier1("First", "Name",  35000, 9.0, "01March-31March");
		assertEquals(payslip.totalNetIncome().intValue(), 2650);
	}
	
	@Test
	public void testName() {
		TaxTier1 payslip;
		payslip = new TaxTier1("First", "Name",  35000, 8.0, "01March-31March");
		assertEquals(payslip.getFirst() + " " + payslip.getLast(), "First Name");
	}
	
	@Test
	public void testSalaryinBounds() {
		TaxTier1 payslip;
		payslip = new TaxTier1("First", "Name",  35000, 4.0, "01March-31March");
		assertTrue(payslip.getSalary() <= payslip.getUpperLimit());
		assertTrue(payslip.getSalary() >= payslip.getLowerLimit());

	}
	
	@Test
	public void testSalaryNotInBounds() {
		TaxTier1 payslip;
		payslip = new TaxTier1("First", "Name",  18000, 4.0, "01March-31March");
		assertFalse(payslip.getSalary() >= payslip.getLowerLimit());

	}


}
