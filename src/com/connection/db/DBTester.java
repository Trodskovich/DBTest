package com.connection.db;

public class DBTester {
	
	 static Employee E1 = new Employee();
	 static DBConnection conn =new DBConnection();

	 public static void main(String[] args) {
		 
		 
		 
		//create a new Employee
		 E1.setID(9);
		 E1.setName("Vimal");

		 //connect to database and insert the employee to the database and confirm
		 	conn.connect("jdbc:sqlite://mnt/Extd//Projects//Database//starter.db");
		 	//conn.query("Select * from master;");
		 	addEmployee(E1);
		 	//conn.modify("update master set name = 'ramesh' where ID=2;");
		 	//conn.modify("delete from master where ID=3;");
		 	searchEmployee(E1);
		 	
		 	
		 conn.close();
		 
		 
		 
	    }
	
	 public static void addEmployee(Employee E) {
		 conn.modify("insert into master (id, name) VALUES ("+ E.getID()+", '"+ E.getName()+"');");
		 
	 }
	 
	 public static void searchEmployee(Employee E) {
		 conn.query("select * from master where id= " +E.getID()+";");
		 
	 }
	
}

