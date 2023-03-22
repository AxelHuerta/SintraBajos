package mx.uam.ayd.proyecto.presentacion.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ventanaListaUsuarios;
import mx.uam.ayd.proyecto.presentacion.menuAdmin.ControlAdmin;
import mx.uam.ayd.proyecto.presentacion.menuUsuario.ControlUsuario;

/**
 * Esta clase lleva el flujo de control de la ventana principal
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlPrincipal {
  @Autowired
  private ControlAgregarUsuario controlAgregarUsuario;

  @Autowired
  ControlListarUsuarios controlListarUsuarios;

  @Autowired
  ventanaListaUsuarios ventanaLista;

  @Autowired
  private VentanaPrincipal ventana;

  @Autowired
  private ControlAdmin controlVentanaAdmin;

  @Autowired
  private ControlUsuario controlVentanaUsuario;

  /**
   * Inicia el flujo de control de la ventana principal
   * 
   */
  public void inicia() {
    ventana.muestra(this);
  }

  /**
   * Método que arranca la historia de usuario "agregar usuarios"
   * 
   */
  public void agregarUsuario() {
    controlAgregarUsuario.inicia();
  }

  public void abrirVentanaAdmin() {
    controlVentanaAdmin.inicia();
  }

  public void abrirVentanaUser() {
    controlVentanaUsuario.inicia();
  }
}
