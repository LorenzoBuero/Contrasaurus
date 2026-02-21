/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contrasaurus;
//import java.util.UUID;
//import java.security.MessageDigest;

import app.CredencialAlmacenada;
import app.DatosCredencial;
import app.ETipoCifrado;
import app.ConfigCredencial;
import app.Database;

//import java.util.Base64;


/**
 *
 * @author Lorenzo Buero
 */
public class Contrasaurus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        DatosCredencial cuentaRoblox = new DatosCredencial("Youtube", "Crimsondeath", "pancho321");
        ConfigCredencial conf= new ConfigCredencial(ETipoCifrado.SIN_CIFRAR, ETipoCifrado.SIN_CIFRAR, ETipoCifrado.SIN_CIFRAR);
        
        CredencialAlmacenada cosita = new CredencialAlmacenada(cuentaRoblox, conf);
        try{
            cosita.cifrarCredencial("cosoflan");
        }
        catch(Exception ex){System.out.println("lol, reventó todo");}
        Database.aniadirCredencial(cosita);
        
        
        
        
        
        
        //Database.eliminarCredencial("fb631182-6ba6-4318-81fb-d0c2490d6e5d");
        
        /*
        var coso = Database.obtenerTodasCredenciales();
        try{
        while(coso.next()){System.out.println(coso.getString("ID") + " :  " + coso.getString("sitio"));}
        }catch (Exception ex){System.out.println("ERROR EN SQL, " + ex.getMessage());}
        */
        
        /*
        var coso = Database.obtenerUnaCredencial("a4dee8a1-d12c-4baa-afb3-78da50724ef8");
        try{
        while(coso.next()){System.out.println(coso.getString("ID") + " :  " + coso.getString("sitio"));}
        }catch (Exception ex){System.out.println("ERROR EN SQL, " + ex.getMessage());}
        */
        
        /*
        Credencial cuentaRoblox = new Credencial("Youtube", "CumToDeath", "pancho321");
        ConfigCredencial conf= new ConfigCredencial(ETipoCifrado.SIN_CIFRAR, ETipoCifrado.SIN_CIFRAR, ETipoCifrado.SIN_CIFRAR);
        
        CredencialAlmacenada cosita = new CredencialAlmacenada("a4dee8a1-d12c-4baa-afb3-78da50724ef8", cuentaRoblox, conf);
        
        
        Database.editarDatosCredencial(cosita);*/
        
    }

}
