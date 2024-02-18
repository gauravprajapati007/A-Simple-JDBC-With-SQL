package com.pro;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Controller con = new Controller();
		try (Scanner sc = new Scanner(System.in)) {
			boolean flag = true;
			while (flag) {
				System.out.println("Enter 1 to insert\n 2 to update\n 3 to delete\n 4 to fetchbyid\n 5 to exit");
				int option = sc.nextInt();

				switch (option) {
				case 1: {
					System.out.println("Enter the id");
					int id = sc.nextInt();
					System.out.println("Enter the name");
					String name = sc.next();
					System.out.println("Enter the Description");
					String des = sc.next();
					System.out.println("Enter the price");
					int price = sc.nextInt();
					Product product = new Product(id, name, des, price);
					int count = con.Insert(product);
					if (count > 0) {
						System.out.println("Data Inserted Successfully");
					} else {
						System.out.println("Data Not Inserted");
					}
					break;
				}
				case 2: {
					System.out.println("Enter the id to be Updated");
					int id = sc.nextInt();
					System.out.println("Enter the  New name");
					String name = sc.next();
					int count = con.update(id, name);
					if (count > 0) {
						System.out.println("Data Updated Successfully");
					} else {
						System.out.println("Data not Updated");
					}
					break;
				}
				case 3: {
					System.out.println("Enter the id to be Deleted");
					int id = sc.nextInt();
					int count = con.deleteByID(id);
					if (count > 0) {
						System.out.println("Data Deleted Successfully");
					} else {
						System.out.println("Data Not Deleted");
					}
					break;
				}
				case 4: {
					System.out.println("Enter the id you want to fetch ");
					int id = sc.nextInt();
					Product product = con.fetchByID(id);
					System.out.println(product);
					break;
				}
				case 5:{
					flag = false;
					System.out.println("Thank You!!!");
					break;
				}
				default:
					break;
				}
			}
		}
	}
}
