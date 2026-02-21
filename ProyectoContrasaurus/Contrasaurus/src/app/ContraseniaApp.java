/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.security.SecureRandom;
import java.util.UUID;

/**
 *
 * @author pirulo
 */
public class ContraseniaApp {
    
    private String id;
    private String nombreUsuario;
    private String superContrasenia;
    private byte[] sal;
    private int repeticiones;
    private String claveParaCifrados;

    protected String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }
    
    private static String newId() {
        
        return UUID.randomUUID().toString();
    }

    protected String getNombreUsuario() {
        return nombreUsuario;
    }

    private void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    protected String getSuperContrasenia() {
        return superContrasenia;
    }

    private void setSuperContrasenia(String superContrasenia) {
        this.superContrasenia = superContrasenia;
    }

    protected byte[] getSal() {
        return sal;
    }

    private void setSal(byte[] sal) {
        this.sal = sal;
    }
    
    private static byte[] newSal(){
        byte[] sal = new byte[32];
        SecureRandom random = new SecureRandom();
        random.nextBytes(sal);
        return sal;
    }

    protected int getRepeticiones() {
        return repeticiones;
    }

    private void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    
    private static int newRepeticiones(){
        SecureRandom random = new SecureRandom();
        int repeticiones = random.nextInt(400000, 500000);
  
        return repeticiones;
    }
    
    private void setClaveParaCifrados(String claveParaCifrados){
        this.claveParaCifrados = claveParaCifrados;
    }
    
    protected String getClaveParaCifrados(){
        return this.claveParaCifrados;
    }

    private String newClaveParaCifrados(){
        HashSHA3_256 hasheador = new HashSHA3_256();
        String retorno = hasheador.Cifrar(this.getSuperContrasenia(), this.getSal(), this.getRepeticiones());
        return retorno;
    }
    
    
    
    
    
    protected ContraseniaApp(String nombreUsuario, String superContrasenia){
        this(newId(), nombreUsuario, superContrasenia, newSal(), newRepeticiones());
    }
    
    protected ContraseniaApp(String id, String nombreUsuario, String superContrasenia, byte[] sal, int repeticiones){
        this.setId(id);
        this.setNombreUsuario(nombreUsuario);
        this.setSuperContrasenia(superContrasenia);
        this.setRepeticiones(repeticiones);
        this.setSal(sal);
        this.setClaveParaCifrados(this.newClaveParaCifrados());
    }
    
    protected String obtenerSuperContraseniaSHA256(){
        HashSHA256 hasheador = new HashSHA256();
        String retorno = hasheador.Cifrar(this.getSuperContrasenia(), this.getSal(), this.getRepeticiones());
        return retorno;
    } 
}
