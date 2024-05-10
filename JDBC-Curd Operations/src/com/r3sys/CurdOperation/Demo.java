package com.r3sys.CurdOperation;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int decision;
		do{
			Scanner s =new Scanner(System.in);
			
			InsertUser obj = new InsertUser();
			
			System.out.println("Do you want to insert the data : \n 1.Yes 2.No" );
			int ch = s.nextInt();
			
			switch(ch)
			{
			case 1 : obj.insert();
			}
			System.out.println("Do you want to insert the data Again : \n 1.Yes 2.No");
			decision = s.nextInt();
			}
		while(decision==1);
		
		display k = new display();
		k.disp();
		
		
		//update u = new update();
		//u.updateData();
		
		Delete d = new Delete();
		d.deleteData();
		
		display j = new display();
		j.disp();

	}

}
