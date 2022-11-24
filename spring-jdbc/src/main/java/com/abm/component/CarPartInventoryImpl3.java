package com.abm.component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("CarPartInv3")
public class CarPartInventoryImpl3 implements CarPartInventory {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addNewPart(CarPart carPart) {

		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "INSERT INTO TBL_CARPART(PART_NAME,CAR_MODEL,PRICE,QUANTITY) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, carPart.getPartName(), carPart.getCarModel(), carPart.getPrice(),
				carPart.getQuantity());

	}

	public List<CarPart> getAvailableParts() {

		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select * from TBL_CARPART";
		List<CarPart> list = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(CarPart.class));
		
		return list;
	}

}
