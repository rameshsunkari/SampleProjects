package org.thinkadv.dp.abstractfactory;

import org.thinkadv.dp.factory.Bank;
import org.thinkadv.dp.factory.Loan;

public interface AbstractFactory {
	public abstract Bank getBank(String bank);

	public abstract Loan getLoan(String loan);
}
