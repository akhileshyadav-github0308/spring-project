package com.abm.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tbl_carpart")
public class CarPart {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "part_no")
	private int partNo;
	
	@Column(name="part_name")
	private String partName;
	
	@Column(name = "car_model")
	private String carModel;
	
	@Column(name="price")
	private double price;
	
	@Column(name = "quantity")
	private int quantity;
	
	
	
	public int getPartNo() {
		return partNo;
	}
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
