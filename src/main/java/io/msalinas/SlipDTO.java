package io.msalinas;

import io.msalinas.Payslip;

public class SlipDTO {
	private Payslip payslip;

	public SlipDTO(Payslip payslip) {
		this.payslip = payslip;
	}

	public String getName() {
		return payslip.getFirst() + " " + payslip.getLast();
	}

	public String getPeriod() {
		return payslip.getDate();
	}

	public String getMonthlyIncomeGross() {
		return "" + payslip.getGrossMontlyIncome();
	}

	public String getMonthlyIncomeTax() {
		return "" + payslip.calculateTax();
	}
	
	public String getMonthlyIncomeNet() {
		return "" + payslip.totalNetIncome();
	}


	public String getMonthlySuper() {
		return "" + payslip.totalSuperAnnuation();
	}

}
