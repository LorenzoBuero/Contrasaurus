/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author pirulo
 */
public class HashSHA3_256 implements IHasheador{
    
    public HashSHA3_256(){}
    
    @Override
    public String Cifrar(String ingreso, byte[] sal, int repeticiones){
        String retorno = "";
        final String ALGORITMO = "SHA3-256";
        final String CHARSET = "UTF8";
        
        try{
            MessageDigest cifrador = MessageDigest.getInstance(ALGORITMO);
            
            cifrador.update(sal);
            byte[] textoCifradoEnBytes = ingreso.getBytes(CHARSET);
            for(int i = 0; i < repeticiones; i++){
                textoCifradoEnBytes = cifrador.digest(textoCifradoEnBytes);
            }
            retorno = Base64.getEncoder().encodeToString(textoCifradoEnBytes);
        }catch (Exception e){
            //throw new Exception(e); //esto da error
            System.out.println("OCURRIO UN ERROR AL CREAR EL SHA-256");//volvería a tirar la excepcion, pero no me deja
        }
        return retorno;
    }
    
}
