package com.example.Clinica_Odontologica;




import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.apache.logging.log4j.Logger.*;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	final static Logger LOGGER = Logger.getLogger(ClinicaOdontologicaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		LOGGER.info("Aplicacion iniciada");
	}


}
