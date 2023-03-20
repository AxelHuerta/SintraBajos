package mx.uam.ayd.proyecto.presentacion.agregarUsuario;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioUsuario;

/**
 * 
 * Módulo de control para la historia de usuario AgregarUsuario
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlAgregarUsuario {

  @Autowired
  private ServicioUsuario servicioUsuario;

  @Autowired
  private VentanaAgregarUsuario ventana;

  /**
   * Inicia la historia de usuario
   * 
   */
  public void inicia() {

    ventana.muestra(this);

  }

  public void agregaUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, String Sexo,
      Date fechaNa, String Domicilio, long Telefono, String Correo, String Pass) {

    try {
      servicioUsuario.agregaUsuario(nombre, apellidoPaterno, apellidoMaterno, Sexo, fechaNa, Domicilio, Telefono,
          Correo, Pass);
      ventana.muestraDialogoConMensaje("Usuario agregado exitosamente");
      termina();
    } catch (Exception ex) {
      // ventana.muestraDialogoConMensaje("Ocurrio un error: ");
      // System.out.println("Ocurrio un error");
    }

  }

  public void validar(String Correo, String Password) { // Este controlador ya retorna un Usuario desde el servicio si
                                                        // esta registrado
    servicioUsuario.ValidarUsuario(Correo, Password);
  }

  /**
   * Termina la historia de usuario
   * 
   */
  public void termina() {
    ventana.dispose(); // aqui hace terminar el programa, comentar en caso de ser necesario
    System.exit(0);
    // ventana.setVisible(false);
  }

}