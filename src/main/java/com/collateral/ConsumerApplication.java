package com.collateral;

import com.collateral.entity.Collateral;
import com.collateral.repository.CollateralRepository;
import com.collateral.service.impl.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {
	@Autowired
	private CollateralService service;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);

	}
}
