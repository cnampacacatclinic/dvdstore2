package com.simplon.dvdstore.dvdstore;

import com.simplon.dvdstore.dvdstore.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@Import(Config.class)
@SpringBootApplication
@EnableFeignClients("com.simplon.dvdstore.dvdstore")
public class DvdStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdStoreApplication.class);
	}
}
