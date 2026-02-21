package database;

/**
 *
 * @author pirulo
 */



import app.CredencialAlmacenada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author pirulo
 */
public abstract class Database {
    
    
    
    
    private static Connection getConeccion() throws SQLException
    {
        String URL_BD = "jdbc:sqlite:/home/pirulo/Mis programas/ContrasaurusJavaSpeedrun/ProyectoContrasaurus/Contrasaurus/DBs/Contrasaurus.db";
        Connection coneccion;
        
        coneccion = DriverManager.getConnection(URL_BD);
        
        
        return coneccion;
    }
    
    protected static ResultSet obtenerTodasCredenciales()
    {
        
        String query = "SELECT * FROM credenciales";
        ResultSet resultado = null;
        
        try {
            Connection coneccion = getConeccion();
            
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            
            resultado = pStatement.executeQuery(); 
            
            
            
        }
        catch (SQLException ex) {
            
            System.out.println("Error al conectar a SQLite");
            System.out.println(ex.getMessage());
        
        }
        
        return resultado;  
    }
   
    protected static ResultSet obtenerUnaCredencial(String buscado){
        String query = "SELECT * FROM credenciales WHERE ID = ?";
        ResultSet resultado = null;
        
        try {
            Connection coneccion = getConeccion();
            
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            pStatement.setString(1, buscado);
            
            resultado = pStatement.executeQuery(); 
            
            
            
            
        }
        catch (SQLException ex) {
            
            System.out.println("Error al conectar a SQLite");
            System.out.println(ex.getMessage());
        
        }
        
        return resultado;
    
    }
            
            
            
    protected static boolean agregarUnaCredencial(CredencialAlmacenada cred)
    {
        String query = "INSERT INTO credenciales "
                + "(ID, sitio, nombre_cuenta, contra, iv, sal, repeticiones, conf_cred) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
                
        try{
            Connection coneccion = getConeccion();
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            
            pStatement.setString(1, cred.getId());
            pStatement.setString(2, cred.getCredencial().getSitio());
            pStatement.setString(3, cred.getCredencial().getNombreCuenta());
            pStatement.setString(4, cred.getCredencial().getContra());
            pStatement.setBytes(5, cred.getParametros().getIv());
            pStatement.setBytes(6, cred.getParametros().getSal());
            pStatement.setInt(7, cred.getParametros().getRepeticiones());
            pStatement.setString(8, cred.getConfig().getCaracteresConfig());
            
            int registrosAniadidos = pStatement.executeUpdate();
            System.out.println(registrosAniadidos);
            
            
            pStatement.close();
            coneccion.close();
            return true;
            
        }catch(SQLException ex){
            System.out.println("ERROR AL CONECTAR A SQLite");
            System.out.println(ex.getMessage());
            return false;
        }    
    }
    
    protected static boolean editarDatosCredencial(CredencialAlmacenada credAlterada){
        
        String query = "UPDATE credenciales SET sitio = ?, nombre_cuenta = ?, contra = ? WHERE ID = ?";
        
        try{
            Connection coneccion = getConeccion();
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            
            pStatement.setString(1, credAlterada.getCredencial().getSitio());
            pStatement.setString(2, credAlterada.getCredencial().getNombreCuenta());
            pStatement.setString(3, credAlterada.getCredencial().getContra());
            pStatement.setString(4, credAlterada.getId());
            
            int exito = pStatement.executeUpdate();
            if(exito>0){System.out.println("Registro alterado");}
            else{System.out.println("No se alteró nada");}
            
            pStatement.close();
            coneccion.close();
            return true;
            
        }catch(SQLException ex){
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
            return false;
        }        
    }
    
    protected static boolean editarConfigCredencial(){return false;}
    
    protected static boolean eliminarCredencial(String ID){
    
        String query = "DELETE FROM credenciales WHERE ID = ?";
        
        try{
            Connection coneccion = getConeccion();
            
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            pStatement.setString(1, ID);
            
            pStatement.executeUpdate();
            
            coneccion.close();
            pStatement.close();
            
            return true;
        }catch(SQLException ex)
        {
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
            return false;
        }
    }
}



