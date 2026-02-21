package app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pirulo
 */

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
    
    public ParametrosDelCifrado(byte[] IV, byte[] sal, int repeticiones){
        this.setIv(IV);
        this.setSal(sal);
        this.setRepeticiones(repeticiones);
    }
}
