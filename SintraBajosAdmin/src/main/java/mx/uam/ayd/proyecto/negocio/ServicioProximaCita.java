package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ProximasCitasRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;

@Service
public class ServicioProximaCita {
	@Autowired
	   ProximasCitasRepository proximasCitasRepository;
	/**
	    * 
	    * Permite agregar una cita
	    * 
	    * @param fecha
	    * @return
	*/

	public List<Cita> obtenerCitasPorFecha(LocalDate fecha) {
        return proximasCitasRepository.findByFecha(fecha);
    }
}
