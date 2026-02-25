package database;


import java.util.ArrayList;
        
import app.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pirulo
 */

//PARA AMBOS MODELOS PODRÍA USAR UNA SUPERCLASE Y HEREDARLA, PERO NO VALE LA PENA, PRÁCTICAMENTE NO COMPARTEN CÓDIGO
public class ModeloUsuarios {
    
    
    
    public static void drop(){
    getBBDD().drop();
    }
    
    
    
    
    
    
    
    private static Usuarios_BBDD getBBDD(){return new Usuarios_BBDD();}
    
    public static void crearTabla(){
        getBBDD().crearTablaUsuarios();
    }
    
    private static Usuario mapeadorDeUsuario(ResultSet registro){
    
        Usuario usuarioRetorno = null;
        try{
            
            String id = registro.getString("ID");
            String nombreUsuario = registro.getString("nombre_usuario");
            String superContra = registro.getString("clave_hasheada");;
            byte[] sal = registro.getBytes("sal");
            int repeticiones = registro.getInt("repeticiones");

            usuarioRetorno = new Usuario(id, nombreUsuario, superContra, sal, repeticiones);
            
        }catch(SQLException ex){
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
        }
        return usuarioRetorno;
    }
    
    public static ArrayList<Usuario> obtenerTodosLosUsuarios(){
    
        ResultSet registros = getBBDD().obtenerTodos();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try{
            while(registros.next()){
                Usuario usuario = mapeadorDeUsuario(registros);
                usuarios.add(usuario);
            
            }
        }catch(SQLException ex){
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }
    
    public static Usuario obtenerUnUsuario(String IdUsuario){
        ResultSet registro = getBBDD().obtenerUnoPorID(IdUsuario);
        Usuario usuario = mapeadorDeUsuario(registro);
        
        return usuario;
    }
    
    public static boolean agregarUnUsuario(Usuario usuario){
        boolean retorno = getBBDD().agregarUno(usuario);
        return retorno;
    }
    
    public static boolean editarUnUsuario(Usuario usuario){
        Usuario usuarioAEditar = obtenerUnUsuario(usuario.getId());
        boolean exito = true;
        if(!usuario.getId().equals(usuarioAEditar.getId())){
            exito = getBBDD().editarDatosUsuario(usuario);
        }
        return exito;
    }
    
    public static boolean eliminarUnUsuario(String ID){
        boolean retorno = getBBDD().eliminarUno(ID);
        return retorno;
    }
}
