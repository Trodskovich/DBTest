package com.connection.db;


public interface DBConnectionInterface {

	public void connect(String connectionString);
	public void query(String qString);
	public void modify(String qString);
	public void close();
}
