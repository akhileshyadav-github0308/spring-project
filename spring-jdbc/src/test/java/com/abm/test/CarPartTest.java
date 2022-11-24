package com.abm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abm.component.CarPart;
import com.abm.component.CarPartInventory;
import com.abm.component.CarPartInventoryImpl1;
import com.abm.component.CarPartInventoryImpl2;
import com.abm.component.CarPartInventoryImpl3;
import com.abm.component.CarPartInventoryImpl4;

public class CarPartTest {
	
	@Test
	public void test_get_available_parts4() {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartInventory carPartInv = (CarPartInventoryImpl4)context.getBean("CarPartInv4");
		List<CarPart> availableParts = carPartInv.getAvailableParts();
		
		for (CarPart carPart : availableParts) {
			System.out.print(carPart.getPartNo()+" ");
			System.out.print(carPart.getPartName()+" ");
			System.out.print(carPart.getQuantity()+" ");
			System.out.println();
		}
	}
	
	
	@Test
	public void test_get_available_parts3() {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartInventory carPartInv = (CarPartInventoryImpl3)context.getBean("CarPartInv3");
		List<CarPart> availableParts = carPartInv.getAvailableParts();
		
		for (CarPart carPart : availableParts) {
			System.out.print(carPart.getPartNo()+" ");
			System.out.print(carPart.getPartName()+" ");
			System.out.print(carPart.getQuantity()+" ");
			System.out.println();
		}
	}
	
	@Test
	public void test_get_available_parts2() {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartInventory carPartInv1 = (CarPartInventoryImpl2)context.getBean("CarPartInv2");
		List<CarPart> availableParts = carPartInv1.getAvailableParts();
		
		for (CarPart carPart : availableParts) {
			System.out.print(carPart.getPartNo()+" ");
			System.out.print(carPart.getPartName()+" ");
			System.out.print(carPart.getQuantity()+" ");
			System.out.println();
		}
	}
	
	@Test
	public void test_get_available_parts() {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartInventory carPartInv1 = (CarPartInventoryImpl1)context.getBean("CarPartInv1");
		List<CarPart> availableParts = carPartInv1.getAvailableParts();
		
		for (CarPart carPart : availableParts) {
			System.out.print(carPart.getPartNo()+" ");
			System.out.print(carPart.getPartName()+" ");
			System.out.print(carPart.getQuantity()+" ");
			System.out.println();
		}
	}

	@Test
	public void test_adding_CartPart() {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartInventory carPartInv1 = (CarPartInventoryImpl3)context.getBean("CarPartInv3");
		
		
		// Entity   / MOdel classes are not instantiated using spring
		CarPart carPart= new CarPart();
		carPart.setPartName("MG1");
		carPart.setCarModel("Bolero");
		carPart.setPrice(67790000);
		carPart.setQuantity(1);
		carPartInv1.addNewPart(carPart);
		
	}

}
