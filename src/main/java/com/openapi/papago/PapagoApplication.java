package com.openapi.papago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PapagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PapagoApplication.class, args);
	}

}
