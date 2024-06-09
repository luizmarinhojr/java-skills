package com.luizmarinho.vehicles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luizmarinho.vehicles.App.Main;

@SpringBootApplication
public class VehiclesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(VehiclesApplication.class, args);
	}

	@Override
	public void run(String... args){
		Main app = new Main();
		app.executeProgram();
	}

}
