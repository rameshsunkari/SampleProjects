package org.thinkadv.dp.creational.abstractfactory;

import org.thinkadv.dp.creational.factory.Bank;
import org.thinkadv.dp.creational.factory.Loan;

public interface AbstractFactory {
	public abstract Bank getBank(String bank);

	public abstract Loan getLoan(String loan);
}
