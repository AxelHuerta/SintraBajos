package mx.uam.ayd.proyecto.presentacion.EliminarCitas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ControlEliminarCita {

    @Autowired
    private VentanaEliminarCitas ventana;

    public void inicia(){
        ventana.muestraE(this);
    }

    public void termina(){
        ventana.setVisible(false);
  
    } 
}
