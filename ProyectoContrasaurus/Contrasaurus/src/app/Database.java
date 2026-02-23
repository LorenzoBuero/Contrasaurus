package app;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;



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
    
    public static ResultSet obtenerTodasCredenciales()
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
   
    public static ResultSet obtenerUnaCredencial(String buscado){
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
            
            
            
    public static boolean aniadirCredencial(CredencialAlmacenada cred)
    {
        String query = "INSERT INTO credenciales "
                + "(ID, sitio, nombre_cuenta, contra, iv, sal, repeticiones, conf_cred) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
                
        try{
            Connection coneccion = getConeccion();
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            
            pStatement.setString(1, cred.getId());
            pStatement.setString(2, cred.getDatosCredencial().getSitio());
            pStatement.setString(3, cred.getDatosCredencial().getNombreCuenta());
            pStatement.setString(4, cred.getDatosCredencial().getContra());
            pStatement.setBytes(5, cred.getParametros().getIv());
            pStatement.setBytes(6, cred.getParametros().getSal());
            pStatement.setInt(7, cred.getParametros().getRepeticiones());
            pStatement.setString(8, "To Do");
            
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
    
    public static boolean editarDatosCredencial(CredencialAlmacenada credAlterada){
        
        String query = "UPDATE credenciales SET sitio = ?, nombre_cuenta = ?, contra = ? WHERE ID = ?";
        
        try{
            Connection coneccion = getConeccion();
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            
            pStatement.setString(1, credAlterada.getDatosCredencial().getSitio());
            pStatement.setString(2, credAlterada.getDatosCredencial().getNombreCuenta());
            pStatement.setString(3, credAlterada.getDatosCredencial().getContra());
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
    
    public static boolean editarConfigCredencial(){return false;}
    
    public static boolean eliminarCredencial(String ID){
    
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





/*

    /**
     * @param args the command line arguments
     
    
    
    static ResultSet obtenerTodos()
    {
        String query = "SELECT * FROM trucos";
        
        
        ResultSet trucos = ejecutarQuery(query);
        return trucos;
        
        
    }
    
    static boolean testSqlite(){
        
        if(obtenerTodos() == null){return false;}
        else{return true;}
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        ResultSet todos = null;
        todos = obtenerTodos();
        
        try {
     
            int acum = 0;
            while(todos.next())
            {
                acum += todos.getInt("puntos");
                
                System.out.println(todos.getString("nombre_truco") + " X " + todos.getInt("puntos"));
                System.out.println("---");
            
            }
            System.out.println("total de puntos = " + acum);
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error al conectar a SQLite");
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
*/