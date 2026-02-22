package database;

/**
 *
 * @author pirulo
 */

import app.CredencialAlmacenada;
import java.sql.ResultSet;

public final class Credenciales_BBDD extends Tabla_BBDD{
    
    @Override
    protected String getNombreTabla(){return "credenciales";}
    
    
    
    @Override
    protected ResultSet obtenerTodos()
    {
        return obtenerTodos(this.getNombreTabla());
        
    }
   
    @Override
    protected ResultSet obtenerUno(String buscado){
        return obtenerUno(this.getNombreTabla(), buscado);
    
    }
            
            
    
    protected boolean agregarUno(CredencialAlmacenada cred)
    {
        String query = "INSERT INTO credenciales "
                + "(ID, sitio, nombre_cuenta, contra, iv, sal, repeticiones, conf_cred) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
                
        return agregarUno(query, cred);
    }
    
    
    protected boolean editarDatosCredencial(CredencialAlmacenada credAlterada){
        
        String query = "UPDATE credenciales SET sitio = ?, nombre_cuenta = ?, contra = ? WHERE ID = ?";
        int[] alterados = {2, 3, 4, 1};
        return editarUno(query, credAlterada, alterados);
    }
    
    protected boolean editarConfigCredencial(CredencialAlmacenada credAlterada){
        
        String query = "UPDATE credenciales SET conf_cred = ? WHERE ID = ?";
        int[] alterados = {8, 1};
        return editarUno(query, credAlterada, alterados);
        
    }
    
    @Override
    protected boolean eliminarUno(String ID){
        return eliminarUno(ID, this.getNombreTabla());
    }
}