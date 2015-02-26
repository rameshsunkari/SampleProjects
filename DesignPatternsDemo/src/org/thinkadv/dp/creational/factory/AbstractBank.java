package org.thinkadv.dp.creational.factory;

public class AbstractBank implements Bank {
	protected String bankName;
	
	public AbstractBank() {
	}

	public AbstractBank(String bankName) {
		super();
		this.bankName = bankName;
	}



	@Override
	public String getBankName() {
		return this.bankName;
	}

}
