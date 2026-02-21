package database;

import app.CredencialAlmacenada;
import app.DatosCredencial;
import app.ConfigCredencial;
import app.ParametrosDelCifrado;
import app.ETipoCifrado;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Lorenzo Buero
 */
public abstract class API_DB {
    
    private static CredencialAlmacenada mapeadorDeCredencialAlmacenada(ResultSet registro){
    
        CredencialAlmacenada credencialRetorno = null;
        try{
            
            String id = registro.getString("ID");
            String sitio = registro.getString("sitio");
            String nombreCuenta = registro.getString("nombre_cuenta");
            String contra = registro.getString("contra");
            byte[] iv = registro.getBytes("iv");
            byte[] sal = registro.getBytes("sal");
            int repeticiones = registro.getInt("repeticiones");
            String confCred = registro.getString("conf_cred");

            DatosCredencial datosCredencial = new DatosCredencial(sitio, nombreCuenta, contra);
            ConfigCredencial configuracion = new ConfigCredencial(ETipoCifrado.SIN_CIFRAR, ETipoCifrado.CIFRADO_DEFAULT, ETipoCifrado.CIFRADO_DEFAULT);
            ParametrosDelCifrado parametros = new ParametrosDelCifrado(iv, sal, repeticiones);

            credencialRetorno = new CredencialAlmacenada(id, datosCredencial, configuracion, parametros);
            
        }catch(SQLException ex){
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
        }
        return credencialRetorno;
    
    
    }
    
    
    public static ArrayList<CredencialAlmacenada> obtenerTodasCredenciales(){
        
        ResultSet registros = Database.obtenerTodasCredenciales();
        ArrayList<CredencialAlmacenada> credenciales = new ArrayList<>(); 
        
        try{
            while(registros.next()){
                CredencialAlmacenada credencial = mapeadorDeCredencialAlmacenada(registros);
                
                credenciales.add(credencial);
        
            }
        }catch(SQLException ex){
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
        }
        return credenciales;
    }
    
    public static CredencialAlmacenada obtenerUnaCredencial(String ID){
        
        ResultSet registro = Database.obtenerUnaCredencial(ID);
        CredencialAlmacenada credencial = mapeadorDeCredencialAlmacenada(registro);
        
        return credencial;
    
    }
    
    public static boolean agregarUnaCredencial(CredencialAlmacenada cred){
        boolean retorno = Database.agregarUnaCredencial(cred);
        return retorno;
    }
    
    public static boolean editarUnaCredencial(CredencialAlmacenada cred){
        CredencialAlmacenada credAEditar = obtenerUnaCredencial(cred.getId());
        boolean exito1 = true;
        boolean exito2 = true;
        if(!cred.getConfig().equals(credAEditar.getConfig())){
            //exito1 = Database.editarConfigCredencial();
        }
        if(!cred.getCredencial().equals(credAEditar.getCredencial())){
            exito2 = Database.editarDatosCredencial(cred);
        }
        
        return exito1 && exito2;
    }
    
    public static boolean eliminarUnaCredencual(String ID){
        boolean retorno = Database.eliminarCredencial(ID);
        return retorno;
    }
}
