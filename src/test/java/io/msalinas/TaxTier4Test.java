package io.msalinas;

import static org.junit.Assert.*;
import io.msalinas.TaxTier4;

import org.junit.Test;

public class TaxTier4Test {
	
	/**
	 * Basic test for tier 1, salary > 180000 
	 * Taxbase 
	 * 
	 */
	
	@Test
	public void testCalculateTax() {
		TaxTier4 payslip;
		payslip = new TaxTier4("First", "Name",  200000, 10.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 5296,1);
	}
	
	@Test
	public void testCalculateTax2() {
		TaxTier4 payslip;
		payslip = new TaxTier4("First", "Name",  200000, 9.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 5296);
	}
	

	@Test
	public void testCalculateNetIncome() {
		TaxTier4 payslip;
		payslip = new TaxTier4("First", "Name",  200000, 9.0, "01March-31March");
		assertEquals(payslip.totalNetIncome().intValue(), 11370);
	}
	
	@Test
	public void testName() {
		TaxTier4 payslip;
		payslip = new TaxTier4("First", "Name",  200000, 8.0, "01March-31March");
		assertEquals(payslip.getFirst() + " " + payslip.getLast(), "First Name");
	}
	
	@Test
	public void testSalaryinBounds() {
		TaxTier4 payslip;
		payslip = new TaxTier4("First", "Name",  200000, 9.0, "01March-31March");
		assertTrue(payslip.getSalary() > payslip.getLowerLimit());

	}
	
	@Test
	public void testSalaryNotInBounds() {
		TaxTier4 payslip;
		payslip = new TaxTier4("First", "Name",  35000, 9.0, "01March-31March");
		assertFalse(payslip.getSalary() >= payslip.getLowerLimit());

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void superTest() {
		TaxTier4 payslip;
		payslip = new TaxTier4("First", "Name",  200000, 9.0, "01March-31March");
		assertEquals(payslip.totalSuperAnnuation().intValue(), 1499);

	}
	
	


}
