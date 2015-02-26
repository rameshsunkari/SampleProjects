package org.thinkadv.dp.creational.factory;

import org.thinkadv.dp.creational.abstractfactory.AbstractFactory;

public class LoanFactory implements AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		if (loan == null) {
			return null;
		}
		if (loan.equalsIgnoreCase("Home")) {
			return new HomeLoan();
		} else if (loan.equalsIgnoreCase("Car")) {
			return new CarLoan();
		} else if (loan.equalsIgnoreCase("Personal")) {
			return new PersonalLoan();
		}
		return null;
	}

}
