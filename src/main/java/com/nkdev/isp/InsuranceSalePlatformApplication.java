package com.nkdev.isp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@ComponentScan("com.nkdev.isp.repo")
public class InsuranceSalePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceSalePlatformApplication.class, args);
	}

}
