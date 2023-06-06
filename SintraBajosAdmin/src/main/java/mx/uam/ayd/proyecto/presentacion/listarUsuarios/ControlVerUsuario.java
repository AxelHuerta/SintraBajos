package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlVerUsuario {

  @Autowired
  private VentanaVerUsaurio ventana;

  public void inicia(Usuario usuario) {
    ventana.muestra(this, usuario);
  }

  public void termina() {
    ventana.setVisible(false);
  }
}
