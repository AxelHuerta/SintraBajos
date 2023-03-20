package mx.uam.ayd.proyecto;

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.CitaRepository;
import mx.uam.ayd.proyecto.datos.NotificacionRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
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
 *         Este cambio es en la rama de trabajo
 */
@SpringBootApplication
public class ProyectoApplication {

	@Autowired
	ControlPrincipal controlPrincipal;

	@Autowired
	CitaRepository citaRepository;

	@Autowired
	NotificacionRepository notificacionRepository;

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
		Notificacion n1 = new Notificacion();
		n1.setIdUsuario((long) 123);
		n1.setMessage("noti 1");
		notificacionRepository.save(n1);

		Notificacion n2 = new Notificacion();
		n2.setIdUsuario((long) 123);
		n2.setMessage("noti 2");
		notificacionRepository.save(n2);

		Usuario u1 = new Usuario();
		u1.setIdUsuario(123);
		u1.setNombre("fulano");
	}
}
