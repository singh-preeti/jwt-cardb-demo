package com.example.cardatabase;

import com.example.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private AppUserRepository appUserRepository;
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner = ownerRepository.save(new Owner("John", "Johnson"));
		Owner owner1 = ownerRepository.save(new Owner("Mary", "Robinson"));

		Car mustang = carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner));
		Car leaf = carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3001", 2019, 29000, owner1));
		Car prius = carRepository.save(new Car("Toyota", "Prius", "Silver", "EE0-0212", 2020, 39000, owner1));

		appUserRepository.save(new AppUser("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "USER"));
		appUserRepository.save(new AppUser("admin", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "ADMIN"));

		carRepository.findAll().forEach(c -> LOG.info(c.toString()));
	}
}
