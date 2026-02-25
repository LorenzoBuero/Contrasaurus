package database;

import app.CredencialAlmacenada;
import app.DatosCredencial;
import app.ConfigCredencial;
import app.ParametrosDelCifrado;
import app.ETipoCifrado;
import excepciones.TipoCifradoInvalidoException;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Lorenzo Buero
 */
public abstract class ModeloCredenciales {
    
    
    public static void drop(){
        getBBDD().drop();
    }
    
    
    
    
    
    
    
    private static Credenciales_BBDD getBBDD(){ return new Credenciales_BBDD("pio");}
    
    
    public static void crearTablaCredencial(String nombreTabla){
        getBBDD().crearTablaCredenciales(nombreTabla);
    
    }
    
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
            char[] confs = {confCred.charAt(0), confCred.charAt(1), confCred.charAt(2)};
            ConfigCredencial configuracion = new ConfigCredencial(confs[0], confs[1], confs[2]);
            ParametrosDelCifrado parametros = new ParametrosDelCifrado(iv, sal, repeticiones);

            credencialRetorno = new CredencialAlmacenada(id, datosCredencial, configuracion, parametros);
            
        }catch(SQLException ex){
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
        }catch(TipoCifradoInvalidoException ex){
            System.out.println("ERROR, DATOS SOBRE EL CIFRADO DAÑADOS");
            System.out.println(ex.getMessage());
        }
        return credencialRetorno;
    
    
    }
    
    
    public static ArrayList<CredencialAlmacenada> obtenerTodasCredenciales(){
        
        
        ResultSet registros = getBBDD().obtenerTodos();
        ArrayList<CredencialAlmacenada> credenciales = new ArrayList<>();
        if(registros!=null){
         

            try{
                while(registros.next()){
                    CredencialAlmacenada credencial = mapeadorDeCredencialAlmacenada(registros);

                    credenciales.add(credencial);

                }
            }catch(SQLException ex){
                System.out.println("ERROR EN SQLite");
                System.out.println(ex.getMessage());
            }
        }
        return credenciales;
    }
    
    public static CredencialAlmacenada obtenerUnaCredencial(String ID){
        
        ResultSet registro = getBBDD().obtenerUnoPorID(ID);
        CredencialAlmacenada credencial = mapeadorDeCredencialAlmacenada(registro);
        
        return credencial;
    
    }
    
    public static boolean agregarUnaCredencial(CredencialAlmacenada cred){
        boolean retorno = getBBDD().agregarUno(cred);
        return retorno;
    }
    
    public static boolean editarUnaCredencial(CredencialAlmacenada cred){
        CredencialAlmacenada credAEditar = obtenerUnaCredencial(cred.getId());
        boolean exito1 = true;
        boolean exito2 = true;
        if(!cred.getConfig().equals(credAEditar.getConfig())){
            exito1 = getBBDD().editarConfigCredencial(cred);
        }
        if(!cred.getDatosCredencial().equals(credAEditar.getDatosCredencial())){
            exito2 = getBBDD().editarDatosCredencial(cred);
        }
        
        return exito1 && exito2;
    }
    
    public static boolean eliminarUnaCredencial(String ID){
        boolean retorno = getBBDD().eliminarUno(ID);
        return retorno;
    }
}
