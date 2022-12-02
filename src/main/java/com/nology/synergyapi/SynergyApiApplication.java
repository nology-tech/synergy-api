package com.nology.synergyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Timestamp;
import java.util.Date;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan({"com.nology.synergyapi"})
public class SynergyApiApplication {

	public static void main(String[] args) {
		System.out.println(new Timestamp(new Date().getTime()));

		SpringApplication.run(SynergyApiApplication.class, args);

	}

}
