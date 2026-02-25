package ManejadoresApp;

import app.Usuario;
import app.CredencialAlmacenada;
import java.util.ArrayList;
/**
 *
 * @author pirulo
 */
public interface Interactuable {

    public ArrayList<CredencialAlmacenada> obtenerCredenciales(boolean obtenerOcultas);
    
    public CredencialAlmacenada obtenerCredencial(String ID, boolean obtenerOculto);
    
    public boolean agregarCredencial(CredencialAlmacenada cred);
    
    public boolean editarCredencial(CredencialAlmacenada cred);
    
    public boolean eliminarCredencial(CredencialAlmacenada cred);
    
    public Usuario obtenerUsuarioPorNombre(String nombre);
    
    //public String solicitarContrasenia();
    
    public boolean verificarContrasenia(String usuarioSeleccionado, String contraseniaIngresada);
    
    public void login();//este sucede al haberse logueado y al iniciar la siguiente pestaña
    
    public void registrarUsuario(String nombre, String superContrasenia);
    
    public void registrarPrimerUsuario(String nombreUsuario, String contrasenia);
    
    public void actualizarCredenciales();
    
}
