package com.r3sys.bankManagement.db;

import java.util.Scanner;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose option : 1.CreateAccount 2.Deposite 3.Withdrawl 4.CheakBalance 5.Transfer");
		int ch = sc.nextInt();
		
		switch(ch)
		{
		case 1 : CreateAccount c = new CreateAccount();
				 c.userInput();
				 break;
				 
		case 2 : Deposite d = new Deposite();
				 d.AddMoney();
				 break;
				 
		case 3 : Withdrawl w = new Withdrawl();
				 w.WidrawMoney();
				 break;
				 
		case 4 : CheakBalance b = new CheakBalance();
				 b.cheakBal();
				 break;
				 
		case 5 : TransferMoney t = new TransferMoney();
				 t.Transfer();
				 break;
		}
	}

}
