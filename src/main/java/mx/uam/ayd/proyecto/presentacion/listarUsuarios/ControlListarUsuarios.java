package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Slf4j
@Component
public class ControlListarUsuarios {

  @Autowired
  private ServicioUsuario servicioUsuario;

  @Autowired
  private ventanaDiagnosticoAdmin ventana;

  @Autowired
  private ventanaListaUsuarios ventana2;

  public void inicia() {
    ventana2.muestra(this);
  }

  public void iniciaUsuarios() {
    List<Usuario> pacientes = servicioUsuario.recuperaUsuarios();
    for (Usuario paciente : pacientes) {
      log.info("paciente: " + paciente);
    }
  }

  ////////////////////////////////////////////////////////
  // el metodo esta dos veces descrito de forma diferente
  // una aquí y la otra en el control principla
  ////////////////////////////////////////////////////////
  public List<Usuario> obtenPacientes() {
    List<Usuario> pacientes = servicioUsuario.recuperaUsuarios();
    return pacientes;
  }

  // public List<Usuario> obtenPacientes() {
  // List<Usuario> pacientes;
  // pacientes = controlListarUsuarios.obtenPacientes();
  // return pacientes;
  // }

  public void pacienteActual(Usuario usuario) {
    ventana.muestra(this, usuario); // Muestra la ventana y muestra al paciente obtenido
  }
  // Cuidado aqui

  public void recuperaNuevo(Usuario usuario) {
    servicioUsuario.nuevo(usuario);
    ventana.muestraMensaje();
    ventana2.muestraNuevo();
  }

  ///////////////////////////////////////
  // Esta en el control principal
  ///////////////////////////////////////
  // Metodo para obtener al paciente
  public void recuperaUsuario(Usuario paciente) {
    ventana2.termina();
    // controlListarUsuarios.pacienteActual(paciente);
    pacienteActual(paciente);
    // Aqui debes mostrar la nueva Ventana.
  }


  /*
   *  Termina la historia de usuario
   */
  public void termina() {
    ventana2.setVisible(false);
  }
}
