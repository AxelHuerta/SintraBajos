package mx.uam.ayd.proyecto.presentacion.menuAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;

@Component
public class ControlAdmin {
  @Autowired
  private ventanaAdmin ventana;

  @Autowired
  private ControlListarUsuarios controlListarUsuarios;

  public void inicia() {
    ventana.muestra(this);
  }

  public void listarUsuarios() {
    controlListarUsuarios.inicia();
  }
}
