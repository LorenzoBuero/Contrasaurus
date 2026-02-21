/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package app;

/**
 *
 * @author pirulo
 */
public enum ETipoCifrado {
    //PERSONALIZADO('p'),
    //UNIDIR_SHA256('u');
    SIN_CIFRAR('s'),
    CIFRADO_DEFAULT('d'),   
    CIFRADO_DEFAULT_OCULTO('o');
    
    public final char valor;
    
    private ETipoCifrado(char valor){
        this.valor = valor;
    }
}
