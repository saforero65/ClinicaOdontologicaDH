package com.example.Clinica_Odontologica;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	private static Logger LOGGER= LogManager.getLogger();
	public static void main(String[] args) {

		LOGGER.info("Iniciando la aplicación");
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		//BasicConfigurator.configure();
	}

}
