package com.connection.db;

public class Employee {
	
	private int ID;
	private String Name;
	Private String Department;
	
	public Employee() {
		super();
	}
	public Employee(int iD, String name) {
		super();
		ID = iD;
		Name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", Name=" + Name + "]";
	}
	
	

}
