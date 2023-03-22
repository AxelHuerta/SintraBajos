package mx.uam.ayd.proyecto.presentacion.menuUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.Notificacion.ControlNotificacion;
import mx.uam.ayd.proyecto.presentacion.agendarCita.ControlAgendarCita;
import mx.uam.ayd.proyecto.presentacion.reagendarCita.ControlReagendarCita;

@Component
public class ControlUsuario {
   @Autowired
   private VentanaUsuario ventana;

   @Autowired
   private ControlAgendarCita controlAgendarCita;

   @Autowired
   private ControlNotificacion controlNotificacion;

   @Autowired
   private ControlReagendarCita controlReagendarCita;

   public void inicia() {
      ventana.muestra(this);
   }

   /**
    * Método que arranca la historia de usuario "agendar citas"
    * 
    */
   public void agendarCitas() {
      controlAgendarCita.inicia();
   }

   /**
    * Método que arranca la historia de usuario "agendar citas"
    * 
    */
   public void verNitificaciones() {
      controlNotificacion.inicia();
   }

   /**
    * Método que arranca la historia de usuario "agendar citas"
    * 
    */
   public void reagendarCita() {
      controlReagendarCita.inicia();
   }

}
