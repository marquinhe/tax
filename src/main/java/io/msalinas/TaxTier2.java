package io.msalinas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxTier2 extends Payslip {
	
	
	public TaxTier2(String first, String last, int salary, double superAnnuation, String date) {
		super(first, last, salary, superAnnuation, date);
		super.setUpperLimit(Integer.valueOf(myResources.getString("tier.2.upperLimit")));
		super.setLowerLimit(Integer.valueOf(myResources.getString("tier.2.lowerLimit")));
		super.setTaxPerDollar(Double.valueOf(myResources.getString("tier.2.tax.dollar")));
		super.setTaxBase(Integer.valueOf(myResources.getString("tier.2.base")));
	}

	@Override
	BigDecimal calculateTax() {
		
		//Following recipe as 
		//income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12  = 921.9375 (round up) = 922
		
		double incomeTax = (super.getTaxBase() + ((super.getSalary() - super.getLowerLimit())* super.getTaxPerDollar()))/12;
		BigDecimal monthlyIncomeTax = new BigDecimal(incomeTax);
		
		//System.out.println("income tax3>" +monthlyIncomeTax.setScale(0, RoundingMode.UP));
		
		return monthlyIncomeTax.setScale(0, RoundingMode.UP);

	}

	@Override
	BigDecimal totalNetIncome() {
		double net = super.getGrossMontlyIncome().doubleValue() - calculateTax().doubleValue();
		return new BigDecimal(net);
	}

	@Override
	BigDecimal totalSuperAnnuation() {
		BigDecimal net = super.getGrossMontlyIncome().multiply(new BigDecimal(super.getSuperAnnuation()/100));
		//System.out.println("super tax3>" +net.setScale(0, RoundingMode.DOWN));
		return net.setScale(0, RoundingMode.DOWN);

	}

}
