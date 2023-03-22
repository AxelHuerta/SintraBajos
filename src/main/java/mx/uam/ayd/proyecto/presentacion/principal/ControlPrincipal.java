package mx.uam.ayd.proyecto.presentacion.principal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.Notificacion.ControlNotificacion;
import mx.uam.ayd.proyecto.presentacion.agendarCita.ControlAgendarCita;
import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ventanaListaUsuarios;
import mx.uam.ayd.proyecto.presentacion.reagendarCita.ControlReagendarCita;

/**
 * Esta clase lleva el flujo de control de la ventana principal
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlPrincipal {

  @Autowired
  private ControlAgendarCita controlAgendarCita;

  @Autowired
  private ControlNotificacion controlNotificacion;

  @Autowired
  private ControlReagendarCita controlReagendarCita;

  @Autowired
  private ControlAgregarUsuario controlAgregarUsuario;

  @Autowired
  ControlListarUsuarios controlListarUsuarios;

  @Autowired
  ventanaListaUsuarios ventanaLista;

  @Autowired
  private VentanaPrincipal ventana;

  @Autowired
  private ventanaAdmin ventanaAdmin;

  @Autowired
  private ventanaPaciente ventanaPaciente;

  /**
   * Inicia el flujo de control de la ventana principal
   * 
   */
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

  /**
   * Método que arranca la historia de usuario "agregar usuarios"
   * 
   */
  public void agregarUsuario() {
    controlAgregarUsuario.inicia();
  }

  public void abrirVentanaAdmin() {
    ventanaAdmin.muestra(this);
  }

  public void abrirVentanaUser() {
    ventanaPaciente.muestra(this);
  }

  /////////////////////////////////////////////////////////////
  // Los metodos a continuaciob deben de estar en su control
  /////////////////////////////////////////////////////////////
  // public List<Usuario> obtenPacientes() {
  // List<Usuario> pacientes;
  // pacientes = controlListarUsuarios.obtenPacientes();
  // return pacientes;
  // }

  // // Metodo para obtener al paciente
  // public void recuperaUsuario(Usuario paciente) {
  // ventanaLista.termina();
  // controlListarUsuarios.pacienteActual(paciente);
  // // Aqui debes mostrar la nueva Ventana.
  // }

  public void listarUsuarios() {
    controlListarUsuarios.inicia();
  }
}
