package com.task;

import java.util.Scanner;

public class MainDemo {

	public static void main(String[] args) throws Exception {
		Demo d=new Demo();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\nSelect the option from below:\n");
			System.out.println("1.Insert Data");
			System.out.println("2.Update Data");
			System.out.println("3.Delete Data");
			System.out.println("4.Show all the Data");
			System.out.println("5.Exit\n");
			int op=sc.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("Enter the data to be inserted :");
				d.insertData();
				System.out.println("Data inserted...");
				break;
			case 2:
				System.out.println("Enter the field you want to update :");
				d.updateData();
				System.out.println("Data updated succesfully...");
				break;
			case 3:
				d.deleteData();
				System.out.println("Data deleted successfullyy...");
				break;
			case 4:
				System.out.println("Showing all details .....");
				d.showAll();
				break;
			case 5:
				System.out.println("Exiting program.....");
				sc.close();
				return ;
				
			default:
				System.out.println("Enter the correct option");
				break;
			}
			
		}

	}

}
