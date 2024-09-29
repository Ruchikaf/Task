package com.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {
    int id;
    int age;
    String name;
    String dis;
    Scanner sc=new Scanner(System.in);
    public void insertData() throws Exception {
    	//load and register the driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//create connection
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    	//create statement
    	System.out.println("Enter id ,name,age,disease");
    	id=sc.nextInt();
    	name=sc.next();
    	age=sc.nextInt();
    	dis=sc.next();
    	
    	Statement s=c.createStatement();
    	String query="insert into patient values(" + id + ", '" + name + "', " + age + ", '" + dis + "')";
    	s.executeUpdate(query);
    	s.close();   		
    }
    public void updateData() throws Exception{
    	//load and register the driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//create connection
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    	//create statement
    	System.out.println("Enter id : ");
    	id=sc.nextInt();
    	System.out.println("Enter disease to update in table : ");
    	dis=sc.next();
    	String query="Update patient set disease='"+dis+"' where patient_id= "+id;
    	
    	Statement s=c.createStatement();
    	s.execute(query);
    	s.close();
    	
    }
    public void deleteData() throws Exception {
    	//load and register the driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//create connection
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    	//create statement
    	System.out.println("Enter the id :");
    	id=sc.nextInt();
    	String query="Delete from patient where patient_id="+id;
    	
    	Statement s=c.createStatement();
    	s.executeUpdate(query);
    	s.close();
    }
    public void showAll() throws Exception {
    	//load and register driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//create connection
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    	//create statement
    	String query="select * from patient";
    	Statement s=c.createStatement();
    	ResultSet rs=s.executeQuery(query);
    	while(rs.next()) {
    		System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3)+" | "+rs.getString(4));
    	}
    	s.close();
    }
}
