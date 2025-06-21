/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lorenzo Buero
 */
import java.security.MessageDigest;
import java.util.Base64;


//me gustaría hacer estas clases estáticas
public class HashUnidireccionalSHA256 implements ICifrador{
    
    @Override
    public ETipoCifrado getTipoCifrado()
    {
        return ETipoCifrado.UNIDIR_SHA256;
    }
    
    
    //me gustaría hacer estas clases estáticas, osea:
    //clase final, constructor privado, metodos static
    public HashUnidireccionalSHA256(){}
    
    
    @Override
    public String Cifrar(String ingreso)
    {
        String retorno = "";
        final String ALGORITMO = "SHA256";
        final String CHARSET = "UTF8";
        
        try{
            MessageDigest cifrador = MessageDigest.getInstance(ALGORITMO);
            byte[] textoCifradoEnBytes = cifrador.digest(ingreso.getBytes(CHARSET));
            retorno = Base64.getEncoder().encodeToString(textoCifradoEnBytes);
        }catch (Exception e)
        {
            //throw new Exception(e); //esto da error
            System.out.println("OCURRIO UN ERROR AL CREAR EL SHA-256");//volvería a tirar la excepcion, pero no me deja
        }
   
        return retorno;
        
        
    }
    
    @Override
    public String Descifrar(String sha256)
    {
        System.out.println("JAJAJ, SUERTE DESCIFRANDO SHA256");
        
        return sha256;
    }
    
}
