package ManejadoresApp;
import java.util.ArrayList;

import app.Usuario;
import app.CredencialAlmacenada;
import app.AdministradorCredenciales;
import app.CifradorCredencial;
import database.ModeloCredenciales;
import database.ModeloUsuarios;

/**
 *
 * @author Lorenzo Buero
 */
public class ControladorApp implements Interactuable {
    
    private String estado = "0";
    private Usuario usuarioActivo;
    private AdministradorCredenciales adminCreds;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    private void setUsuarioActivo(Usuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    protected AdministradorCredenciales getAdminCreds() {
        return adminCreds;
    }

    protected void setAdminCreds(AdministradorCredenciales adminCreds) {
        this.adminCreds = adminCreds;
    }
    
    protected String getClave(){
    
        return this.getUsuarioActivo().getClaveParaCifrados();
    }
    
    public ControladorApp(String estado){
        this.setEstado(estado);
    }
    
    @Override
    public void registrarPrimerUsuario(String nombre, String superContrasenia){
        ModeloUsuarios.crearTabla();
        this.registrarUsuario(nombre, superContrasenia);
    }
    
    @Override
    public void registrarUsuario(String nombre, String superContrasenia){
        
        ModeloCredenciales.crearTablaCredencial(nombre);
        Usuario usuario = new Usuario(nombre, superContrasenia);
        ModeloUsuarios.agregarUnUsuario(usuario);
    }
    
    @Override
    public Usuario obtenerUsuarioPorNombre(String nombre){
        
        ArrayList<Usuario> usuarios = ModeloUsuarios.obtenerTodosLosUsuarios();
        Usuario usuarioRetorno = null;
        for(Usuario usuario : usuarios){
            if(usuario.getNombreUsuario().equals(nombre)){
                usuarioRetorno = usuario;
            }
        }
        return usuarioRetorno;
    }
    public ArrayList<Usuario> obtenerTodosLosUsuarios(){
        ArrayList<Usuario> usuarios = ModeloUsuarios.obtenerTodosLosUsuarios();
        return usuarios;
    }
    
    
    @Override
    public boolean verificarContrasenia(String nombreSeleccionado, String contraseniaIngresada){
        Usuario usuarioActual = obtenerUsuarioPorNombre(nombreSeleccionado);
        
        Usuario usuarioEnDB = ModeloUsuarios.obtenerUnUsuario(usuarioActual.getId());
        if(usuarioActual.obtenerSuperContraseniaSHA256().equals(usuarioEnDB.getSuperContrasenia())){
            return false;
        }else{
            if(this.getEstado().equals("02")){
                this.setUsuarioActivo(usuarioActual);
            }
            return true;
        }
    }
    
    @Override
    public void login(){
        
        //ArrayList<CredencialAlmacenada> creds = ModeloCredenciales.obtenerTodasCredenciales();
        //AdministradorCredenciales admCreds = new AdministradorCredenciales(creds, this.getUsuarioActivo().getClaveParaCifrados());
        //this.setAdminCreds(admCreds);
    }
    
    @Override
    public ArrayList<CredencialAlmacenada> obtenerCredenciales(boolean obtenerOcultas){
    
        ArrayList<CredencialAlmacenada> creds;
        if(obtenerOcultas){
            creds = this.getAdminCreds().obtenerCredencialesOcultasDescifradas();
        }
        else{
            creds = this.getAdminCreds().obtenerCredencialesDefaultDescifradas();
        }
        return creds;
    }
    
    @Override
    public CredencialAlmacenada obtenerCredencial(String ID, boolean decifrarOculto){
        
        CredencialAlmacenada cred = ModeloCredenciales.obtenerUnaCredencial(ID);
        
        CifradorCredencial cifrador = new CifradorCredencial(cred, this.getClave(), false, !decifrarOculto);
        cifrador.sincronizarEstados();
        cred = cifrador.getCredencial();
        
        return cred;
    }
    
    @Override
    public boolean agregarCredencial(CredencialAlmacenada cred){
        CifradorCredencial cifrador = new CifradorCredencial(cred, this.getClave(), true, true);
        cifrador.sincronizarEstados();
        cred = cifrador.getCredencial();
        boolean retorno = ModeloCredenciales.agregarUnaCredencial(cred);
        return retorno;
    }
    
    @Override
    public boolean editarCredencial(CredencialAlmacenada cred){
        CifradorCredencial cifrador = new CifradorCredencial(cred, this.getClave(), true, true);
        cifrador.sincronizarEstados();
        cred = cifrador.getCredencial();
        boolean retorno = ModeloCredenciales.editarUnaCredencial(cred);
        return retorno;
    }
    
    @Override
    public boolean eliminarCredencial(CredencialAlmacenada cred){
        boolean retorno = ModeloCredenciales.eliminarUnaCredencial(cred.getId());
        return retorno;
    }  
    
    @Override
    public void actualizarCredenciales(){
        ArrayList<CredencialAlmacenada> creds = ModeloCredenciales.obtenerTodasCredenciales();
        AdministradorCredenciales admCreds = new AdministradorCredenciales(creds, this.getUsuarioActivo().getClaveParaCifrados());
        this.setAdminCreds(admCreds);
    }
}
