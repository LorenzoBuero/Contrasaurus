package app;


/**
 *
 * @author Lorenzo Buero
 */
//import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;


//me gustaría hacer estas clases estáticas
public class HashSHA256 implements IHasheador{
    
    
    
    //me gustaría hacer estas clases estáticas, osea:
    //clase final, constructor privado, metodos static
    public HashSHA256(){}
    
    
    @Override
    public String Cifrar(String ingreso, byte[] sal, int repeticiones)
    {
        String retorno = null;
        final String ALGORITMO = "PBKDF2WithHmacSHA256";
        
        PBEKeySpec spec = new PBEKeySpec(ingreso.toCharArray(), sal, repeticiones);
        try{
            SecretKeyFactory keyGen = SecretKeyFactory.getInstance(ALGORITMO);

            byte[] byteHash = keyGen.generateSecret(spec).getEncoded();
            retorno = Base64.getEncoder().encodeToString(byteHash);
        
        }catch (Exception ex){
            System.out.println("ERROR AL ENCRIPTAR LA CONTRASEÑA DEL USUARIO");
            System.out.println(ex.getMessage());
            
        }finally{
            spec.clearPassword();
            return retorno;
        }
    }
        


    
}
