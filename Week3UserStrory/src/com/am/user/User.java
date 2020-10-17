package com.am.user;


import java.util.List;


import java.util.Scanner;

import com.am.DTO.Complaint;
import com.am.DTO.Customer;
import com.am.DTO.Person;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Customer per=new Person();
Scanner sc=new Scanner(System.in);
char c;
do {
	System.out.println("press 1 for view all customer id");
	System.out.println("press 2 to select customer id and view complaints");
	System.out.println("press 3 to select a complaint to view status");
	System.out.println("press 4 to register new complaint with new user");
	System.out.println("press 5 to  register a new complaint with existing user");
	int choice=sc.nextInt();
	switch (choice) {
	case 1:
		List<Customer> clist=per.viewAllCustomer();
		for(Customer c1: clist) {
		System.out.println(((Person)c1).id);
		System.out.println(((Person)c1).name);
		}
		break;
	case 2:
		System.out.println("enter id");
	  int id=sc.nextInt();
	  List<Complaint> list=per.viewComplaintById(id);
	  for(Complaint c2:list) {
		  System.out.println(c2.cid+""+c2.title+""+c2.description+""+c2.status+""+c2.customer_id);
	  }
	break;
	case 3:
		System.out.println("enter complaint id");
	int cid=sc.nextInt();
	Complaint c2=per.ViewCoomplaintStatus(cid);
	if(c2.status==0) {
		System.out.println("complaint title:"+c2.title+"complaint status:"+c2.status);
	}else
	{
		System.out.println("no complaintis registered on this id number");
	}
	break;
	case 4:
		System.out.println("Welcome.....!!!! to new user ....please register your complaint to get service ");
		System.out.println("enter id");
		int i_d=sc.nextInt();
		System.out.println("enter customer name");
		String name=sc.next();
		System.out.println("enter complaint id");
		int c_id=sc.nextInt();
		System.out.println("enter title");
		String title=sc.next();
		System.out.println("enter description");
		sc.nextLine();
		String description=sc.next();
		Complaint c3=new Complaint(c_id,title,description,1,i_d);
		Person p=new Person(i_d,name,c3);
		boolean b=per.LunchComplaintWithExistingUser(p);
		if(b) {
			System.out.println("your complaint got Registered.....!!!!");
		}
		else
		{
			System.out.println("some problem occured...please register again....");
		}
		break;
	case 5:
		System.out.println("enter id");
		int old_id=sc.nextInt();
		System.out.println("enter customer name");
		String old_name=sc.next();
		System.out.println("enter complaint id");
		int old_Id=sc.nextInt();
		System.out.println("enter title");
		int old_title=sc.nextInt();
		System.out.println("enter description");
		sc.nextLine();
		String old_description=sc.next();
		Complaint old_c=new Complaint(old_id,old_name,old_description,old_title,old_Id);
		
		Person old_p=new Person(old_id,old_name,old_c);
		boolean b1=per.lunchComplaintWithOldUser(old_p);
		if(b1) {
			System.out.println("complaint registered successfully...");
		}
		
		else
		{
			System.out.println("some Problem occured...register again...");
		}
		
		break;
		default:
		break;
	}
		System.out.println("press ");
		
		
		System.out.println("press A/a to get main menu");
		c=sc.next().charAt(0);
	}while(c=='A'||c=='a');
	

	}

}
