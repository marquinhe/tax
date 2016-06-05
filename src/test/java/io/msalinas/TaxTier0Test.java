package io.msalinas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.msalinas.TaxTier0Test;

import org.junit.Test;

public class TaxTier0Test {
	
	/**
	 * Basic test for tier 0, salary <=18200 
	 * Tax must be zero
	 * 
	 */
	
	@Test
	public void testCalculateTax() {
		TaxTier0 payslip;
		payslip = new TaxTier0("First", "Name",  100, 10.0, "01March-31March");
		assertEquals(payslip.calculateTax().intValue(), 0);
	}
	
	@Test
	public void testCalculateIncome() {
		TaxTier0 payslip;
		payslip = new TaxTier0("First", "Name",  50, 9.0, "01March-31March");
		assertEquals(payslip.totalNetIncome().intValue(), payslip.getSalary());
	}
	
	@Test
	public void testName() {
		TaxTier0 payslip;
		payslip = new TaxTier0("First", "Name",  20, 8.0, "01March-31March");
		assertEquals(payslip.getFirst() + " " + payslip.getLast(), "First Name");
	}
	
	@Test
	public void testSalaryinBounds() {
		TaxTier0 payslip;
		payslip = new TaxTier0("First", "Name",  10, 4.0, "01March-31March");
		assertTrue(payslip.getSalary() <= payslip.getUpperLimit());
		assertTrue(payslip.getSalary() >= payslip.getLowerLimit());

	}
	

}
