package com.abm.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("CarPartInv1")
public class CarPartInventoryImpl1 implements CarPartInventory {

		public void addNewPart(CarPart carPart) {

		String DB_URL = "jdbc:derby://localhost:1527/training";
		String USER = "derby";
		String PASS = "derby";
		Connection conn = null;

		// Open a connection
		try {
		    Class.forName("org.apache.derby.jdbc.ClientDriver");
		    long start=System.currentTimeMillis();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 long end=System.currentTimeMillis();
			 System.out.println("Time taken for connection : "+(end-start)+ " ms");

			// Execute a query
			System.out.println("Inserting records into the table...");
			String sql = "INSERT INTO TBL_CARPART(PART_NAME,CAR_MODEL,PRICE,QUANTITY) VALUES (?,?,?,?)";

			start=System.currentTimeMillis();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, carPart.getPartName());
			stmt.setString(2, carPart.getCarModel());
			stmt.setDouble(3, carPart.getPrice());
			stmt.setInt(4, carPart.getQuantity());

			stmt.executeUpdate();
			end=System.currentTimeMillis();
			System.out.println("Time taken fro Query : "+(end-start)+ " ms");

			System.out.println("Inserted records into the table...");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<CarPart> getAvailableParts() {
		
		String DB_URL = "jdbc:derby://localhost:1527/training";
		String USER = "derby";
		String PASS = "derby";
		Connection conn = null;
		List<CarPart> list= new ArrayList<CarPart>();

		// Open a connection
		try {
		    Class.forName("org.apache.derby.jdbc.ClientDriver");
		    long start=System.currentTimeMillis();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 long end=System.currentTimeMillis();
			// Execute a query
			 System.out.println("Time taken for connection : "+(end-start)+ " ms");
			String query = "select * from TBL_CARPART";
			start=System.currentTimeMillis();
			PreparedStatement prepareStatement = conn.prepareStatement(query);
			ResultSet rs = prepareStatement.executeQuery();
			
//			Statement stmt = conn.createStatement();
//	        ResultSet rs = stmt.executeQuery(query);
	        
	        
	        CarPart carPart=null;

	        while(rs.next()){
	            //Display values
	           
	            carPart=new CarPart();
	            carPart.setPartNo(rs.getInt("PART_NO"));
	            carPart.setPartName(rs.getString("PART_NAME"));
	            carPart.setCarModel(rs.getString("CAR_MODEL"));
	            carPart.setPrice(rs.getDouble("PRICE"));
	            carPart.setQuantity(rs.getInt("QUANTITY"));
	            
	            list.add(carPart);
	            
	         }
	        end=System.currentTimeMillis();
			System.out.println("Time taken fro Query : "+(end-start)+ " ms");

			
			System.out.println("Inserted records into the table...");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return list;
	}

}
