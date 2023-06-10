package mx.uam.ayd.proyecto.negocio;

import static org.mockito.Mockito.when;

import java.util.Date;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ServicioUsuarioTest {

  @Mock
  private UsuarioRepository usuarioRepository;

  @InjectMocks
  private ServicioUsuario usuarioService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void AgregaUsuario() {
    String nombre = "John";
    String apellidoPaterno = "Doe";
    String apellidoMaterno = "Smith";
    String sexo = "M";
    Date fechaNa = new Date();
    String domicilio = "Calle Principal 123";
    long telefono = 1234567890L;
    String correo = "john.doe@example.com";
    String pass = "password";
    String diagnostico = "Sin diagnóstico";

    // Simulamos que no existe un usuario con el mismo correo
    when(usuarioRepository.findByCorreo(correo)).thenReturn(null);
  }
}
