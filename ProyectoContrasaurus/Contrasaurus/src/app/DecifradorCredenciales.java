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
public class DecifradorCredenciales implements Runnable{
    
    private ArrayList<CredencialAlmacenada> credenciales;
    private String clave;

    protected ArrayList<CredencialAlmacenada> getCredenciales() {
        return credenciales;
    }

    private void setCredenciales(ArrayList<CredencialAlmacenada> credenciales) {
        this.credenciales = credenciales;
    }

    private String getClave() {
        return clave;
    }

    private void setClave(String clave) {
        this.clave = clave;
    }

    
    public DecifradorCredenciales(ArrayList<CredencialAlmacenada> credenciales, String clave) {
        this.setCredenciales(credenciales);
        this.setClave(clave);
    }
    
    
    
    private ArrayList<CredencialAlmacenada> decifrarCredencialesDefault(){
        for(CredencialAlmacenada cred : this.getCredenciales()){
            Thread hilo = new Thread(this);
            
        
        }
    
    
    }
    
    private CredencialAlmacenada decifrarUnaCredencial(CredencialAlmacenada cred){
        if(cred.getEstadoCifrado()){
            cred.obtenerEstaCredencialDescifrada(this.getClave());
        }
    
        
        return cred;
    }
    
    @Override
    public void run(){
        Thread hilo = new Thread(this);
        hilo.start();
    
    }
    
    
}
