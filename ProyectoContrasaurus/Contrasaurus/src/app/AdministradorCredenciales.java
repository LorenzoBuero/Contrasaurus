/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.ArrayList;
/**
 *
 * @author pirulo
 */
public class AdministradorCredenciales {
    private ArrayList<CifradorCredencial> cifradores;

    private ArrayList<CifradorCredencial> getCifradores() {
        return cifradores;
    }

    private void setCifradoresCredencial(ArrayList<CifradorCredencial> cifradores) {
        this.cifradores = cifradores;
    }

    public AdministradorCredenciales(ArrayList<CredencialAlmacenada> credenciales, String clave){
        
        for(CredencialAlmacenada cred : credenciales){
            CifradorCredencial cifrador = new CifradorCredencial(cred, clave, true, true);
            this.getCifradores().add(cifrador);
        }
        
        
    }
    
    private ArrayList<CredencialAlmacenada> cifrarODescifrarCredencialesIndicadas(String queHacer){
        ArrayList<CredencialAlmacenada> credenciales = new ArrayList<>();
        
        for(CifradorCredencial cifrador : this.getCifradores()){
            
            switch(queHacer){
                case "cifrar" -> cifrador.modoCifrado();
                case "descifrarDefaults" -> cifrador.modoDescifradoDefaults();
                case "descifrarOcultas" -> cifrador.modoDescifradoOcultos();
                default -> System.out.println("opcion inexistente en cifrarODescifrarCredencialesIndicadas() en CifrarTodasCredenciales");
            }
            
            Thread hilo = new Thread(cifrador);
            hilo.start();
            
            credenciales.add(cifrador.getCredencial());
        }
        return credenciales;
    }
    
    public ArrayList<CredencialAlmacenada> obtenerCredencialesCifradas(){
        
        ArrayList<CredencialAlmacenada> credenciales = cifrarODescifrarCredencialesIndicadas("cifrar");
        return credenciales;
    
    }
    
    public ArrayList<CredencialAlmacenada> obtenerCredencialesDefaultDescifradas(){
        
        ArrayList<CredencialAlmacenada> credenciales = cifrarODescifrarCredencialesIndicadas("descifrarDefaults");
        return credenciales;
    
    }
    public ArrayList<CredencialAlmacenada> obtenerCredencialesOcultasDescifradas(){
        
        ArrayList<CredencialAlmacenada> credenciales = cifrarODescifrarCredencialesIndicadas("descifrarOcultas");
        return credenciales;
    
    }
    
    
}
