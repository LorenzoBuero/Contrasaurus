/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lorenzo Buero
 */
public final class CifradorIntermediario {
    
    
    private CifradorIntermediario(){};
    
    
    public static String Cifrar(ETipoCifrado tipoDeCifrado, String textoACifrar)
    {
        String textoCifrado = "";
        
        ICifrador cifrado;
        
        switch (tipoDeCifrado)
        {
            case ETipoCifrado.SIN_CIFRAR -> cifrado = new SinCifrar();

            case ETipoCifrado.PERSONALIZADO -> cifrado = new Personalizado();
   
            case ETipoCifrado.UNIDIR_SHA256 -> cifrado = new HashUnidireccionalSHA256();               
        }
        
        textoCifrado = cifrado.Cifrar(textoACifrar);
        
        return textoCifrado;
    }
    
    
    public static String Descifrar(ETipoCifrado tipoDeCifrado, String textoACifrar)
    {
        String textoCifrado = "";
        
        
        ICifrador cifrado;
        
        switch (tipoDeCifrado)
        {
            case ETipoCifrado.SIN_CIFRAR -> cifrado = new SinCifrar();

            case ETipoCifrado.PERSONALIZADO -> cifrado = new Personalizado();
   
            default -> throw new IllegalArgumentException("Error, este tipo de descifrado no es posible");
        }
        
        textoCifrado = cifrado.Cifrar(textoACifrar);
        
        
        
        return textoCifrado;
    }
    
    
}
