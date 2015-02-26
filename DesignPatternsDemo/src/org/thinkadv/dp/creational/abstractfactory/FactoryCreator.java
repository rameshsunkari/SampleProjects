package org.thinkadv.dp.creational.abstractfactory;

import org.thinkadv.dp.creational.factory.BankFactory;
import org.thinkadv.dp.creational.factory.LoanFactory;

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
