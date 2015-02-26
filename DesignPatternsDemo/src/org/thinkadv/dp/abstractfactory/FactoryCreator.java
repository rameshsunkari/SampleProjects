package org.thinkadv.dp.abstractfactory;

import org.thinkadv.dp.factory.BankFactory;
import org.thinkadv.dp.factory.LoanFactory;

public class FactoryCreator {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("Bank")) {
			return new BankFactory();
		} else if (choice.equalsIgnoreCase("Loan")) {
			return new LoanFactory();
		}
		return null;
	}
}
