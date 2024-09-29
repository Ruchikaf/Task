package com.taskPrepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepStatement {
	int id;
    int age;
    String name;
    String dis;
    Scanner sc=new Scanner(System.in);
    public void insertData() throws Exception {
    	//load and register the driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//get connection
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    	//create statement
    	System.out.println("Enter id ,name,age,disease");
    	id=sc.nextInt();
    	name=sc.next();
    	age=sc.nextInt();
    	dis=sc.next();
    	
    	PreparedStatement ps=c.prepareStatement("insert into patient values(?,?,?,?)");
    	ps.setInt(1, id);
    	ps.setString(2, name);
    	ps.setInt(3,age);
    	ps.setString(4, dis);
    	ps.executeUpdate();
    	
    	ps.close();
    		
    }
    public void updateData() throws Exception {
    	//load and register the driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//get connection
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    	//taking input
    	String query="Update patient set name =?,age=?,disease=? where patient_id=?";
		System.out.println("Enter id to update :");
		id=sc.nextInt();
		System.out.println("Enter name,age and disease to update :");
		name=sc.next();
		age=sc.nextInt();
		dis=sc.next();
		
		PreparedStatement ps=c.prepareStatement(query);
		 
		   ps.setInt(4, this.id);
		   ps.setString(1, this.name);
		   ps.setInt(2, this.age);
		   ps.setString(3, this.dis);
		   
		  ps.executeUpdate();
		  ps.close();
	
     
     
    }
    public void deleteData() throws Exception {
    	//load and register the driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//get connection 
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    	//create statement
    	System.out.println("Enter id to delete data :");
    	id=sc.nextInt();
    	PreparedStatement ps=c.prepareStatement("delete from patient where patient_id=?");
    	ps.setInt(1, id);
    	ps.executeUpdate();
    	ps.close();
    	}
    public void showAll() throws Exception{
    	//load and register driver
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	//get connection 
    	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    	//create statement
    	String query="select * from patient";
    	PreparedStatement ps= c.prepareStatement(query);
    	ResultSet rs=ps.executeQuery(query);
    	while(rs.next()) {
    		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
    	}
    	ps.close();
    	
    	
    	
    }
}
