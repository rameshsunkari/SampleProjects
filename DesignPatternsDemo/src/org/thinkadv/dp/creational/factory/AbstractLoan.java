package org.thinkadv.dp.creational.factory;

public class AbstractLoan implements Loan {
	
	private double rate;
	
	public AbstractLoan() {
	}
	
	public AbstractLoan(double rate) {
		this.rate = rate;
	}

	@Override
	public void setInterestRate(double rate) {
		this.rate = rate;

	}

	@Override
	public void calculateLoanPayment(double loanamount, int years) {
		double EMI;
		int n;

		n = years * 12;
		rate = rate / 1200;
		EMI = ((rate * Math.pow((1 + rate), n)) / ((Math.pow((1 + rate), n)) - 1))
				* loanamount;

		System.out.println("your monthly EMI is " + EMI + " for the amount"
				+ loanamount + " you have borrowed");

	}

	@Override
	public double getInterestRate() {
		return rate;

	}

}
