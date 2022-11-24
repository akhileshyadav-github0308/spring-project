package com.abm.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("CarPartInv4")
public class CarPartInventoryImpl4 implements CarPartInventory {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	//@Transactional
	public void addNewPart(CarPart carPart) {
		//entityManager.persist(carPart);
	}

	public List<CarPart> getAvailableParts() {
		Query query = entityManager.createQuery("select c from CarPart c");
		List<CarPart> list = query.getResultList();
		return list;
	}

}
