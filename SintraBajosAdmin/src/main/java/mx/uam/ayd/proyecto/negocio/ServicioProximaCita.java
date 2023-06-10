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
	    * Busca citas a traves de la fecha
	    * 
	    * @param fecha
	    * @return Lista <Citas> Retorna la lista de citas 
	*/

	public List<Cita> obtenerCitasPorFecha(LocalDate fecha) {
        return proximasCitasRepository.findByFecha(fecha);
    }
}
