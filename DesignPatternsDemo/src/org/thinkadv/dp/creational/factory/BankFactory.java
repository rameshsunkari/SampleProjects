package org.thinkadv.dp.creational.factory;

import org.thinkadv.dp.creational.abstractfactory.AbstractFactory;

public class BankFactory implements AbstractFactory {

	@Override
	public Bank getBank(String bank){  
	      if(bank == null){  
	         return null;  
	      }  
	      if(bank.equalsIgnoreCase("HDFC")){  
	         return new HDFCBank();  
	      } else if(bank.equalsIgnoreCase("ICICI")){  
	         return new ICICIBank();  
	      } else if(bank.equalsIgnoreCase("Axis")){  
	         return new AxisBank();  
	      }  
	      return null;  
	   }  

	@Override
	public Loan getLoan(String loan) {
		// TODO Auto-generated method stub
		return null;
	}

}
