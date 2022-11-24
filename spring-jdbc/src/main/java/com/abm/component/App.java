package com.abm.component;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class App {
	
	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate= null;
		
		DriverManagerDataSource dmds= new DriverManagerDataSource();
		
		dmds.setUrl("");
		
		
		
//		DriverManagerDataSource.class

		CarPart carPart= new CarPart();
		carPart.setPartName("Maruti");
		carPart.setCarModel("Baleno");
		carPart.setPrice(13344);
		carPart.setQuantity(2);
		new CarPartInventoryImpl1().addNewPart(carPart);
	}



}
