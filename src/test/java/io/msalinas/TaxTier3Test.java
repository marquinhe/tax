package io.msalinas;

import static org.junit.Assert.*;
import io.msalinas.TaxTier3;

import org.junit.Test;

public class TaxTier3Test {
	
	/**
	 * Basic test for tier 1, salary > 80,000 and lower than 180,000 
	 * Taxbase 
	 * 
	 */
	
	@Test
	public void testCalculateTax() {
		TaxTier3 payslip;
		payslip = new TaxTier3("First", "Name",  85000, 10.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 1617);
	}
	

	@Test
	public void testCalculateNetIncome() {
		TaxTier3 payslip;
		payslip = new TaxTier3("First", "Name",  85000, 9.0, "01March-31March");
		assertEquals(payslip.totalNetIncome().intValue(), 5466);
	}
	
	@Test
	public void testName() {
		TaxTier3 payslip;
		payslip = new TaxTier3("First", "Name",  85000, 8.0, "01March-31March");
		assertEquals(payslip.getFirst() + " " + payslip.getLast(), "First Name");
	}
	
	@Test
	public void testSalaryinBounds() {
		TaxTier3 payslip;
		payslip = new TaxTier3("First", "Name",  80001, 9.0, "01March-31March");
		assertTrue(payslip.getSalary() <= payslip.getUpperLimit());
		assertTrue(payslip.getSalary() > payslip.getLowerLimit());

	}
	
	@Test
	public void testSalaryNotInBounds() {
		TaxTier3 payslip;
		payslip = new TaxTier3("First", "Name",  75000, 9.0, "01March-31March");
		assertFalse(payslip.getSalary() >= payslip.getLowerLimit());

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void superTest() {
		TaxTier3 payslip;
		payslip = new TaxTier3("First", "Name",  80050, 9.0, "01March-31March");
		assertEquals(payslip.totalSuperAnnuation().intValue(), 600);

	}
	
	


}
