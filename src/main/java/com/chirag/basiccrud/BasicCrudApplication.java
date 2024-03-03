package com.chirag.basiccrud;

import com.chirag.basiccrud.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicCrudApplication {

	@Autowired
	private CloudVendorService cloudVendorService;

	public static void main(String[] args) {
		SpringApplication.run(BasicCrudApplication.class, args);
	}


}
