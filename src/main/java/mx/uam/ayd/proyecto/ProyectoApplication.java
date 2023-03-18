package mx.uam.ayd.proyecto;

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.CitaRepository;
// import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

/**
 * 
 * Clase principal que arranca la aplicación 
 * construida usando el principio de 
 * inversión de control
 * 
 * 
 * @author Humberto Cervantes (c) 21 Nov 2022
 * Este cambio es en la rama de trabajo
 */
@SpringBootApplication
public class ProyectoApplication {

	@Autowired
	ControlPrincipal controlPrincipal;
	
	@Autowired
	CitaRepository citaRepository;
	
	/**
	 * 
	 * Método principal
	 *
	 * @params args argumentos de la línea de comando
	 * 
	 */
	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
	}

	/**
	 * Metodo que arranca la aplicacion
	 * inicializa la bd y arranca el controlador
	 * otro comentario
	 */
	@PostConstruct
	public void inicia() {
		
		inicializaBD();
		
		controlPrincipal.inicia();
	}
	
	
	/**
	 * 
	 * Inicializa la BD con datos
	 * 
	 */
	public void inicializaBD() {
		
		// Vamos a crear los dos grupos de usuarios
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

		// Cita cita1 = new Cita();
		// cita1.setFecha(LocalDate.parse("2023-03-20"));
		// cita1.setHora(LocalTime.parse("08:00", formatter));
		// citaRepository.save(cita1);
	
		// Cita cita2 = new Cita();
		// cita2.setFecha(LocalDate.parse("2023-03-20"));
		// cita2.setHora(LocalTime.parse("09:00", formatter));
		// citaRepository.save(cita2);
		
		// Cita cita3 = new Cita();
		// cita3.setFecha(LocalDate.parse("2023-03-20"));
		// cita3.setHora(LocalTime.parse("10:00", formatter));
		// citaRepository.save(cita3);
			
		// Cita cita4 = new Cita();
		// cita4.setFecha(LocalDate.parse("2023-03-20"));
		// cita4.setHora(LocalTime.parse("11:00", formatter));
		// citaRepository.save(cita4);
	
		// Cita cita5 = new Cita();
		// cita5.setFecha(LocalDate.parse("2023-03-20"));
		// cita5.setHora(LocalTime.parse("12:00", formatter));
		// citaRepository.save(cita5);
	
		// Cita cita6 = new Cita();
		// cita6.setFecha(LocalDate.parse("2023-03-20"));
		// cita6.setHora(LocalTime.parse("13:00", formatter));
		// citaRepository.save(cita6);
	
		// Cita cita7 = new Cita();
		// cita7.setFecha(LocalDate.parse("2023-03-20"));
		// cita7.setHora(LocalTime.parse("14:00", formatter));
		// citaRepository.save(cita7);
	}
}
