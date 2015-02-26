package org.thinkadv.dp.creational.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryPatternExample {
	public static void main(String[] args) throws IOException {

		BankFactory bankFactory = new BankFactory();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out
				.print("Enter the name of Bank from where you want to take loan amount: ");
		String bankName = br.readLine();
		
		Bank b = bankFactory.getBank(bankName);
		System.out.print("\n");  
		System.out.println("you are taking the loan from "+ b.getBankName());  
	}
}
