package database;

/**
 *
 * @author pirulo
 */

import app.CredencialAlmacenada;
import java.sql.ResultSet;

public final class Credenciales_BBDD extends Tabla_BBDD{
    
    String nombreUsuario;
    protected void drop(){
        dropa(getNombreTabla());
    }
    
    public Credenciales_BBDD(String nombre){
        this.nombreUsuario = nombre;
    }
    
    
    
    
    
    
    @Override
    protected String getNombreTabla(){return "credenciales";}
    
    protected void crearTablaCredenciales(String nombreUsuario){
        String query ="CREATE TABLE " + this.getNombreTabla() + " (ID TEXT PRIMARY KEY, sitio TEXT NOT NULL, nombre_cuenta TEXT NOT NULL, "
                + "contra TEXT NOT NULL, iv BLOB NOT NULL, sal BLOB NOT NULL, repeticiones INTEGER NOT NULL, "
                + "conf_cred TEXT NOT NULL);";
        
        crearTabla(query);
    }
    
    @Override
    protected ResultSet obtenerTodos()
    {
        return obtenerTodos(this.getNombreTabla());
        
    }
   
    @Override
    protected ResultSet obtenerUnoPorID(String buscado){
        return obtenerUnoPorID(this.getNombreTabla(), buscado);
    
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