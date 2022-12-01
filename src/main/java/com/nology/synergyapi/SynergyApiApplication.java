package com.nology.synergyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.nology.synergyapi"})
public class SynergyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynergyApiApplication.class, args);
	}

}
