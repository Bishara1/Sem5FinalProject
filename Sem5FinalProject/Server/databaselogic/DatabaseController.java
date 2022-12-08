package databaselogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Subscriber;

//This Class is built using Singleton design pattern
public class DatabaseController {
	  private Connection conn;
	  private static DatabaseController DBFunctionsInstance = null;  // only one instance (singleton)
	
	  private DatabaseController(String dbpassword) {
		  ConnectToDB(dbpassword);
	  }
	
	  public void ConnectToDB(String dbPassword) {
		  try {
		      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		      System.out.println("Driver definition succeeded");
		  } catch (Exception ex) {
			  /* handle the error*/
			  System.out.println("Driver definition failed");
	      }
	      
	      try {
	          conn = DriverManager.getConnection("jdbc:mysql://localhost/prototype?serverTimezone=IST", "root", dbPassword);
	          System.out.println("SQL connection succeeded");
	   	  } catch (SQLException ex)  { /* handle any errors*/
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
	   	  }
	  }
	  
	  @SuppressWarnings("unchecked")
	  public void SaveToDB(Object message) throws SQLException {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO subscriber "
					+ "(first_name, last_name, id, phone_number, email_address,"
					+ " credit_card_number, subscriber_number) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ArrayList<String> data = (ArrayList<String>) message;
			
			try {
				for (int i = 1; i < 8; i++)
					ps.setString(i, data.get(i-1));
				
				ps.executeQuery();
			} catch (SQLException e) { e.printStackTrace(); }
		}
	 
	  public void UpdateToDB(String[] details) throws SQLException {
		  // data = {command id credit_card subscriber_num}
			PreparedStatement ps = conn.prepareStatement("UPDATE subscriber "
					+ "Set credit_card_number = ?, subscriber_number = ? "
					+ "Where id = ?");
			
			try {
				ps.setString(1, details[2]);  // credit_card
				ps.setString(2, details[3]);  // subscriber_number
				ps.setString(3, details[1]);  // id
				
				ps.executeUpdate();
			} catch (SQLException e) { e.printStackTrace(); }
		}
	  
	  
	  public ArrayList<Subscriber> ReadFromDB() throws SQLException {
			Statement stmt;
			Subscriber tempSub = new Subscriber(null, null, null, null, null, null, null);
			ArrayList<Subscriber> alldatabase = new ArrayList<>();
			try 
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM subscriber");
		 		while(rs.next())
		 		{
		 			// get details from database
		 			tempSub.setFname(rs.getString(1));
		 			tempSub.setLName(rs.getString(2));
		 			tempSub.setId(rs.getString(3));
		 			tempSub.setPhoneNum(rs.getString(4));
		 			tempSub.setEmail(rs.getString(5));
		 			tempSub.setVisa(rs.getString(6));
		 			tempSub.setSubNum(rs.getString(7));
		 			
		 			//add it to the database arraylist
		 			alldatabase.add(tempSub);
		 			
		 			// create new object
		 			tempSub = new Subscriber(null, null, null, null, null, null, null);
				}
		 		
				rs.close();
			} catch (SQLException e) { e.printStackTrace(); }
			
			return alldatabase;
		}
	  
	  public static synchronized DatabaseController GetFunctionsInstance(String databasePassword) {
		  return ( DBFunctionsInstance == null ) ? new DatabaseController(databasePassword) : DBFunctionsInstance;
	  }
}