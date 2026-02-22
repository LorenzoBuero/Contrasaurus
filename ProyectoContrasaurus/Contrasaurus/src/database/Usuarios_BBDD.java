package database;

/**
 *
 * @author pirulo
 */

import app.Usuario;
import java.sql.ResultSet;


public final class Usuarios_BBDD extends Tabla_BBDD{

    @Override
    protected String getNombreTabla(){return "usuarios";}
    
    @Override
    protected ResultSet obtenerTodos(){
        return obtenerTodos(getNombreTabla());
    }
   
    @Override
    protected ResultSet obtenerUno(String buscado){
        return obtenerUno(getNombreTabla(), buscado);
    }
            
                
    protected boolean agregarUno(Usuario usuario)
    {
        String query = "INSERT INTO usuarios "
                + "(ID, nombre_usuario, clave_hasheada, sal, repeticiones) VALUES (?, ?, ?, ?, ?)" ;
                
        return agregarUno(query, usuario);
    }
    
    protected boolean editarDatosUsuario(Usuario usuario){
        
        String query = "UPDATE usuarios SET nombre_usuario = ?, clave_hasheada = ? WHERE ID = ?";
        int[] alterados = {2, 3, 1};
        return editarUno(query, usuario, alterados);
    }
    
    @Override
    protected boolean eliminarUno(String ID){
    
        return eliminarUno(getNombreTabla(), ID);
    }   
}
