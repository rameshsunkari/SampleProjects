package org.thinkadv.dp.factory;

public interface Loan {
	public void setInterestRate(double rate);
	
	public double getInterestRate();

	public void calculateLoanPayment(double loanamount, int years);

}
