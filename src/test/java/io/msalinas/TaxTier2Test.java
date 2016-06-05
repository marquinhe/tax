package io.msalinas;

import static org.junit.Assert.*;
import io.msalinas.TaxTier2;

import org.junit.Test;

public class TaxTier2Test {
	
	/**
	 * Basic test for tier 1, salary > 37000 and lower than 80,000 
	 * Taxbase 
	 * 
	 */
	
	@Test
	public void testCalculateTax() {
		TaxTier2 payslip;
		payslip = new TaxTier2("First", "Name",  75000, 10.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 1327,1);
	}
	
	@Test
	public void testCalculateTax2() {
		TaxTier2 payslip;
		payslip = new TaxTier2("First", "Name",  60050, 9.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 922);
	}
	

	@Test
	public void testCalculateNetIncome() {
		TaxTier2 payslip;
		payslip = new TaxTier2("First", "Name",  60050, 9.0, "01March-31March");
		assertEquals(payslip.totalNetIncome().intValue(), 4082);
	}
	
	@Test
	public void testName() {
		TaxTier2 payslip;
		payslip = new TaxTier2("First", "Name",  35000, 8.0, "01March-31March");
		assertEquals(payslip.getFirst() + " " + payslip.getLast(), "First Name");
	}
	
	@Test
	public void testSalaryinBounds() {
		TaxTier2 payslip;
		payslip = new TaxTier2("First", "Name",  40000, 9.0, "01March-31March");
		assertTrue(payslip.getSalary() <= payslip.getUpperLimit());
		assertTrue(payslip.getSalary() >= payslip.getLowerLimit());

	}
	
	@Test
	public void testSalaryNotInBounds() {
		TaxTier2 payslip;
		payslip = new TaxTier2("First", "Name",  35000, 9.0, "01March-31March");
		assertFalse(payslip.getSalary() >= payslip.getLowerLimit());

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void superTest() {
		TaxTier2 payslip;
		payslip = new TaxTier2("First", "Name",  60050, 9.0, "01March-31March");
		assertEquals(payslip.totalSuperAnnuation().intValue(), 450);

	}
	
	


}
