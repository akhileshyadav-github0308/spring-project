package com.abm.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Lifecycle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.Booking;
import com.abm.dto.Passanger;
import com.abm.dto.Passanger.Gender;
import com.abm.dto.Passanger.Status;

@RestController
public class PnrController {
	
	@RequestMapping("/pnr-status")
	public Booking checkPnrStatus(@RequestParam("pnrno") int pnrNo){
		
		Booking booking= new Booking();
		booking.setPnr(pnrNo);
		booking.setTrainNo(15017);
		booking.setTravelDate(LocalDate.of(2022, 11, 30));
		
		List<Passanger> passangers= new ArrayList<Passanger>();
		
		Passanger p1= new Passanger();
		p1.setName("Akhil");
		p1.setGender(Gender.MALE);
		p1.setStatus(Status.CONFIRMED);
		
		Passanger p2= new Passanger();
		p2.setName("Sanjay");
		p2.setGender(Gender.MALE);
		p2.setStatus(Status.RAC);
		
		passangers.add(p1);
		passangers.add(p2);
		
		booking.setPassangers(passangers);
		return booking;
	}

}
