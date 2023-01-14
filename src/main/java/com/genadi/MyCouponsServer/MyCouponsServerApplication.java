package com.genadi.MyCouponsServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.genadi.MyCouponsServer")
public class MyCouponsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCouponsServerApplication.class, args);
	}

}
