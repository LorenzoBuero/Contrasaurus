package app;

/**
 *
 * @author Lorenzo Buero
 */

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.GCMParameterSpec;

import java.util.Base64;
import java.nio.charset.StandardCharsets;


public class CifDefault {
    
    private String clave;
    private byte[] iv;
    private byte[] sal;
    private int repeticiones;

    private String getClave() {
        return clave;
    }

    private void setClave(String clave) {
        this.clave = clave;
    }

    private byte[] getIv() {
        return iv;
    }

    private void setIv(byte[] iv) {
        this.iv = iv;
    }

    private byte[] getSal() {
        return sal;
    }

    private void setSal(byte[] sal) {
        this.sal = sal;
    }

    private int getRepeticiones() {
        return repeticiones;
    }

    private void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    
    
    
    
    protected CifDefault(String clave, ParametrosDelCifrado params){
    
        this.setClave(clave);
        this.setIv(params.getIv());
        this.setSal(params.getSal());
        this.setRepeticiones(params.getRepeticiones());
    }
    
    protected String cifrar(String datoACifrar){//throws CredencialYaCifradaException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidParameterSpecException{
    {
        
            //ALGORITMOS
            final String ALGORITMO_SECRET_KEY = "AES";
            final String ALGORITMO_CIPHER = "AES/GCM/PKCS5Padding";
            final String ALGORITMO_CONTRASENIA_PERSONALIZADA = "PBKDF2WithHmacSHA256";
            final int CANTIDAD_BITS_AUTENTICACION = 16 * 8;
            
            
            try{    
                //fabrica de llaves
                final SecretKeyFactory keyGen = SecretKeyFactory.getInstance(ALGORITMO_CONTRASENIA_PERSONALIZADA);
                //cpnfiguracion de la llave
                final PBEKeySpec keySpecifs = new PBEKeySpec(clave.toCharArray(), this.getSal(), this.getRepeticiones(), 256);
                //creo la llave con la fabrica de llaves
                final SecretKey tmp = keyGen.generateSecret(keySpecifs);
                final SecretKey llave = new SecretKeySpec(tmp.getEncoded(), ALGORITMO_SECRET_KEY);
                

                //cifrador
                final Cipher cifrador = Cipher.getInstance(ALGORITMO_CIPHER);

                 //Logica cifrado
                cifrador.init(Cipher.ENCRYPT_MODE, llave, new GCMParameterSpec(CANTIDAD_BITS_AUTENTICACION, this.getIv()));

                byte[] encriptado = cifrador.doFinal(datoACifrar.getBytes(StandardCharsets.UTF_8));
                String retorno = Base64.getEncoder().encodeToString(encriptado);


                return retorno;
            }catch(Exception ex){
                System.out.println("OCURRIÓ UN ERROR INESPERADO");
                System.out.println(ex.getMessage());
                return null;
            }
        }
    }
    

    
    protected String descifrar(String datoADescifrar){
        
        try{
            final String ALGORITMO_SECRET_KEY = "AES";
            final String ALGORITMO_CIPHER = "AES/GCM/PKCS5Padding";//"AES/CBC/PKCS5Padding";
            final String ALGORITMO_CONTRASENIA_PERSONALIZADA = "PBKDF2WithHmacSHA256";
            final int CANTIDAD_BITS_AUTENTICACION = 16 * 8;

            final SecretKeyFactory keyGen = SecretKeyFactory.getInstance(ALGORITMO_CONTRASENIA_PERSONALIZADA);
            //cpnfiguracion de la llave
            final PBEKeySpec keySpecifs = new PBEKeySpec(this.getClave().toCharArray(), this.getSal(), this.getRepeticiones(), 256);
            //creo la llave con la fabrica de llaves
            final SecretKey tmp = keyGen.generateSecret(keySpecifs);
            final SecretKey llave = new SecretKeySpec(tmp.getEncoded(), ALGORITMO_SECRET_KEY);


            final Cipher decifrador = Cipher.getInstance(ALGORITMO_CIPHER);
            decifrador.init(Cipher.DECRYPT_MODE, llave, new GCMParameterSpec(CANTIDAD_BITS_AUTENTICACION, this.getIv())); 

            String decifrado = new String(decifrador.doFinal(datoADescifrar.getBytes()), StandardCharsets.UTF_8);
            
            return decifrado;
            
        }catch(Exception ex){
            System.out.println("OCURRIÓ UN ERROR INESPERADO");
            System.out.println(ex.getMessage());
            return null;
        }
    
        
    }
    








}














/*INGRESO DE DATOS*/
       /* 
        ///////////////////////////////////////////////////////
        
        
        
        
        ////Variables estaticas
        //strings
        final String CLAVE = "patitos";
        final String ALGORITMO_AES = "AES";
        final String ALGORITMO = "AES/CBC/PKCS5Padding";
        final String ALGORITMO_CONTRASENIA_PERSONALIZADA = "PBKDF2WithHmacSHA256";
        
        //Generar SAL
        byte[] cloruroDeSodio = new byte[32];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(cloruroDeSodio);
        /////////////////////////////////////////////////////
        
        //fabrica de llaves
        final SecretKeyFactory keyGen = SecretKeyFactory.getInstance(ALGORITMO_CONTRASENIA_PERSONALIZADA);// = SecretKeyFactory.getInstance();
        //cpnfiguracion de la llave
        final PBEKeySpec keySpecifs = new PBEKeySpec(CLAVE.toCharArray(), cloruroDeSodio, 65536, 256);
        //creo la llave con la fabrica de llaves
        final SecretKey tmp = keyGen.generateSecret(keySpecifs);
        final SecretKey llave = new SecretKeySpec(tmp.getEncoded(), ALGORITMO_AES);
        
        //cifrador
        final Cipher cifrador = Cipher.getInstance(ALGORITMO);
        
        
        /////////////////////////////////////////////////////////////////
        
        
        //Logica cifrado
        cifrador.init(Cipher.ENCRYPT_MODE, llave);
        AlgorithmParameters params = cifrador.getParameters();
        final byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
        
        byte [] encriptado = cifrador.doFinal(textoSecreto.getBytes(StandardCharsets.UTF_8));
        
        
        String encriptadoTexto = Base64.getEncoder().encodeToString(encriptado);//new String(encriptado, StandardCharsets.UTF_8);
        System.out.println("\n encriptado:");
        System.out.println(encriptadoTexto);
        /////////////////////////////////
       
        
        
        
        
        
        
        
        
        
        
        
        //logica descifrado
        final Cipher decifrador = Cipher.getInstance(ALGORITMO);
        decifrador.init(Cipher.DECRYPT_MODE, llave, new IvParameterSpec(iv));
        
        String decifrado = new String(decifrador.doFinal(encriptado), StandardCharsets.UTF_8);
        System.out.println(decifrado);
        /////////////////////////////////////////*/