package app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pirulo
 */

import java.security.SecureRandom;

public class ParametrosDelCifrado {
    
    private byte[] Iv;
    private byte[] sal;
    private int repeticiones;

    /**
     * @return the Iv
     */
    public byte[] getIv() {
        return Iv;
    }

    /**
     * @param Iv the Iv to set
     */
    private void setIv(byte[] Iv) {
        this.Iv = Iv;
    }

    private void setNewIv(){
        byte[] iv = new byte[16];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(iv);
        
        this.Iv = iv;
    }
    
    /**
     * @return the sal
     */
    public byte[] getSal() {
        return sal;
    }

    /**
     * @param sal the sal to set
     */
    private void setSal(byte[] sal) {
        this.sal = sal;
    }

    private void setNewSal(){
        byte[] cloruroDeSodio = new byte[32];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(cloruroDeSodio);
        
        this.sal = cloruroDeSodio;
    }
    
    /**
     * @return the repeticiones
     */
    public int getRepeticiones() {
        return repeticiones;
    }

    /**
     * @param repeticiones the repeticiones to set
     */
    private void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    
    private void setNewRepeticiones(){
        SecureRandom random = new SecureRandom();
        this.repeticiones = random.nextInt(200000, 300000);
    }
    
    public ParametrosDelCifrado(byte[] IV, byte[] sal, int repeticiones){
        this.setIv(IV);
        this.setSal(sal);
        this.setRepeticiones(repeticiones);
    }
    
    public ParametrosDelCifrado(){
        this.setNewIv();
        this.setNewSal();
        this.setNewRepeticiones();
    }
}
