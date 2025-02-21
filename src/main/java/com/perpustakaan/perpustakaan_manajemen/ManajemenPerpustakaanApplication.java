package com.perpustakaan.perpustakaan_manajemen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.perpustakaan.perpustakaan_manajemen.Repository")
@ComponentScan("com.perpustakaan.perpustakaan_manajemen")
@EntityScan("com.perpustakaan.perpustakaan_manajemen.Model")
public class ManajemenPerpustakaanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManajemenPerpustakaanApplication.class, args);
	}

}
