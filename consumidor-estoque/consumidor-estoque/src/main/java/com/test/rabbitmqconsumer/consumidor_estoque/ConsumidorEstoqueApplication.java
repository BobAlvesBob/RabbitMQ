package com.test.rabbitmqconsumer.consumidor_estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.microsservico.consumidorestoque")
public class ConsumidorEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumidorEstoqueApplication.class, args);
	}

}
