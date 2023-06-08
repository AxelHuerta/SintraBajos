package mx.uam.ayd.proyecto.presentacion.CitaAdministrador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;
import mx.uam.ayd.proyecto.presentacion.principalAdministrador.VentanaPrincipal;


@Component
public class ControlCitaAdmin {
	
	@Autowired
	private VentanaCitaAdmin ventana;
	
	@Autowired
	private ServicioUsuario recuperausuarios;
	
	@Autowired
	private ControlListarUsuarios Diagnostico;

  
  public void inicia() {
    ventana.muestra(this);
  }
  
  public List<Usuario> listausuarios() {
	  return recuperausuarios.recuperaUsuarios();
  }
  
  public void consultar(Usuario usuario) {
	  Diagnostico.pacienteActual(usuario);
  }

}
