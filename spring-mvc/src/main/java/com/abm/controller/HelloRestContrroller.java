package com.abm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.Response;

@RestController
public class HelloRestContrroller {
	
	
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	
	@GetMapping("/getfiledata")
	  public String getContentFromFile() throws IOException {

	    Resource resource = resourceLoader.getResource("classpath:data.txt");

	    InputStream inputStream = resource.getInputStream();

	    byte[] dataAsBytes = FileCopyUtils.copyToByteArray(inputStream);

	    String data = new String(dataAsBytes, StandardCharsets.UTF_8);

	    return data;

	  }
	
	
	@RequestMapping("restHello")
	public String hello(@RequestParam("name") String name) {
		return "hello "+name+" from rest";
	}
	
	
	@GetMapping("response")
	public Response response() {
		
		Response response= new Response();
		response.setId(101);
		response.setName("Akhilesh Yadav");
		response.setAddress("Mulund Mumbai");
		response.setJob("Software Developer");
		
		return response;
	}

}
