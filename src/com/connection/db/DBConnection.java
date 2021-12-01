package com.connection.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnection implements DBConnectionInterface{
     
	  private static Connection conn = null;
      private static Statement stmt = null;
      private static ResultSet rs=null;
      
    @Override  
    public  void connect(String connectionString) {
      
        try {
            // db parameters
            String url = connectionString;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
 
            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } 
           
        }
    
    
        @Override
    	public  void query(String qString) {
    		
    		try {
                // db parameters
                
                stmt = conn.createStatement();
                rs = stmt.executeQuery(qString);
                Object rsArray =new Object[rs.getFetchSize()];
                while ( rs.next() ) {
                  int id = rs.getInt("id");
                  String  name = rs.getString("name");
                  System.out.println( "ID = " + id );
                  System.out.println( "NAME = " + name );          
                  System.out.println();
                
                }
            } 
    		catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
    		
    		try {
                // db parameters
               //rs.close();
                stmt.close();
                }
    		catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
    		
    		
    	}


		public void modify(String qString) {
			try {
                // db parameters
				conn.setAutoCommit(false);
                stmt = conn.createStatement();
                
                
                stmt.executeUpdate(qString);
                conn.commit();
            } 
    		catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
    		
    		try {
                // db parameters
               //rs.close();
                stmt.close();
                }
    		catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
    		
			
		}



		
		@Override
    	public  void close() {
    		
    		
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }



		
    	
}