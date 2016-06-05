package io.msalinas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxTier0 extends Payslip {
	
	
	public TaxTier0(String first, String last, int salary, double superAnnuation, String date) {
		super(first, last, salary, superAnnuation, date);
		super.setUpperLimit(Integer.valueOf(myResources.getString("tier.0.upperLimit")));
		super.setLowerLimit(Integer.valueOf(myResources.getString("tier.0.lowerLimit")));
		super.setTaxPerDollar(Integer.valueOf(myResources.getString("tier.0.tax.dollar")));
	}
	

	@Override
	BigDecimal calculateTax() {
		return new BigDecimal(0);
	}

	@Override
	BigDecimal totalNetIncome() {
		
		return new BigDecimal (super.getSalary());
	}

	@Override
	BigDecimal totalSuperAnnuation() {
		
		BigDecimal totalSuperAnnuation = super.getGrossMontlyIncome().multiply(new BigDecimal(super.getSuperAnnuation()));
		return totalSuperAnnuation.setScale(0, RoundingMode.DOWN);
		
	}


}
