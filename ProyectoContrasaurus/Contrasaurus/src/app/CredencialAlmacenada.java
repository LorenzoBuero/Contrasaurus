package app;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pirulo
 */
import java.util.UUID;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.PBEKeySpec;
//import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import java.security.SecureRandom;
//import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import java.security.AlgorithmParameters;
import java.util.Base64;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.spec.InvalidKeySpecException;
import java.security.InvalidKeyException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import java.security.spec.InvalidParameterSpecException;
import java.security.InvalidAlgorithmParameterException;

import excepciones.CredencialYaCifradaException;

public class CredencialAlmacenada{
    private String id;
    private DatosCredencial credencial;
    private ConfigCredencial config;
    private ParametrosDelCifrado parametros;
    private boolean estadoCifrado;
    private boolean estadoCifradoOculto;
    
    
    
    public String getId() {
        return id;
    }
    private static String newId() {
        
        return UUID.randomUUID().toString();
    }
    private void setId(String id)
    {
        this.id = id;
    }

    
    private void setConfig(ConfigCredencial tipoDeCifrado)
    {
        this.config = tipoDeCifrado;
    }
    public ConfigCredencial getConfig()
    {   
        return this.config;
    }
    
    
    private void setEstadoCifrado(boolean estado)
    {
        this.estadoCifrado = estado;
    }
    public boolean getEstadoCifrado()
    {
        return this.estadoCifrado;
    }
    
    private void setEstadoCifradoOculto(boolean estado)
    {
        this.estadoCifradoOculto = estado;
    }
    public boolean getEstadoCifradoOculto()
    {
        return this.estadoCifradoOculto;
    }

    
    private void setParametros(ParametrosDelCifrado parametros)
    {
        this.parametros = parametros;
    }
    public ParametrosDelCifrado getParametros()
    {
        return this.parametros;
    }
    protected void setCredencial(DatosCredencial cred)
    {
        this.credencial = cred;
    }
    public DatosCredencial getCredencial()
    {
        return this.credencial;
    }
    
    //---------------------------------Constructores--------------------------------------
    
    
    //Credencial ya existente, convertida a objeto, por ende necesita el ID original
    public CredencialAlmacenada(String id, DatosCredencial credencial, ConfigCredencial tipoDeCifrado, ParametrosDelCifrado parametros)
    {
        this.setId(id);
        this.setCredencial(credencial);
        this.setConfig(tipoDeCifrado);
        this.setParametros(parametros);
        this.setEstadoCifrado(true); 
    };
    
    //Credencial nueva, por ende crea un nuevo ID por su cuenta
    public CredencialAlmacenada(DatosCredencial credencial, ConfigCredencial tipoDeCifrado)
    {
        this(newId(), credencial, tipoDeCifrado, null);
        this.setEstadoCifrado(false);
    };
    
    
    
    //---------------------METODOS-------------------------
    
    
    protected void cifrarDatosCredencial(String claveDefault, String claveOculto) {//throws CredencialYaCifradaException{
        //tengo una claveDefault y una claveOculto distintas para que si alguien cambia la configuracion de cifrado en la bbdd, no deje de andar el descifrado de esa credencial en vez de simplemente descifrarse
        
        if(this.getEstadoCifrado())
        {
            System.out.println("LA CREDENCIAL YA ESTABA CIFRADA");
            //throw new CredencialYaCifradaException("ERROR, la credencial ya se encuentra cifrada");/////////////////
        }
        else
        {
            CifDefault cifrador = new CifDefault(claveDefault, this.getParametros().getIv(), this.getParametros().getSal(), this.getParametros().getRepeticiones());
            CifDefault cifradorOculto = new CifDefault(claveOculto, this.getParametros().getIv(), this.getParametros().getSal(), this.getParametros().getRepeticiones());
            
            //sitio
            String sitioPeroCifrado;
            if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT)){
                
                sitioPeroCifrado = cifrador.cifrar(this.getCredencial().getSitio());
                
            }else{
                
                sitioPeroCifrado = cifradorOculto.cifrar(this.getCredencial().getSitio()); 
            }
            this.getCredencial().setContra(sitioPeroCifrado);
            
            //nombre cuenta
            String nombreCuentaPeroCifrado;
            if(this.getConfig().getCifradoNombreCuenta().equals(ETipoCifrado.CIFRADO_DEFAULT)){
                
                nombreCuentaPeroCifrado = cifrador.cifrar(this.getCredencial().getNombreCuenta());    
            }else{  
                
                nombreCuentaPeroCifrado = cifradorOculto.cifrar(this.getCredencial().getNombreCuenta()); 
            }
            this.getCredencial().setNombreCuenta(nombreCuentaPeroCifrado); 
            
            //contra
            String contraPeroCifrada;
            if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT)){
                
                contraPeroCifrada = cifrador.cifrar(this.getCredencial().getContra());
            }else{

                contraPeroCifrada = cifrador.cifrar(this.getCredencial().getContra());   
            }
            this.getCredencial().setContra(contraPeroCifrada);

            
            this.setEstadoCifradoOculto(true);
            this.setEstadoCifrado(true);
        }
    }
    
    
    
    
    
    protected void cifrarDatosOcultosCredencial(String claveOculto){
    
        if(this.getEstadoCifrado())
        {
            System.out.println("LA CREDENCIAL YA ESTABA EN MODO OCULTO");
            //throw new CredencialYaCifradaException("ERROR, la credencial ya se encuentra cifrada");/////////////////
        }
        else
        {
            CifDefault cifrador = new CifDefault(claveOculto, this.getParametros().getIv(), this.getParametros().getSal(), this.getParametros().getRepeticiones());
            
            //sitio
            
            if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO)){
                
                String sitioPeroCifrado = cifrador.cifrar(this.getCredencial().getSitio());  
                this.getCredencial().setContra(sitioPeroCifrado);
            }
            
            
            //nombre cuenta
            
            if(this.getConfig().getCifradoNombreCuenta().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO)){
                
                String nombreCuentaPeroCifrado = cifrador.cifrar(this.getCredencial().getNombreCuenta()); 
                this.getCredencial().setNombreCuenta(nombreCuentaPeroCifrado);
            }
             
            
            //contra
            
            if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO)){  
                String contraPeroCifrada = cifrador.cifrar(this.getCredencial().getContra());
                this.getCredencial().setContra(contraPeroCifrada);
            }
                 
            this.setEstadoCifradoOculto(true);
        }
    }
        /*if(this.getEstadoCifrado())
        {
            throw new CredencialYaCifradaException("ERROR, la credencial ya se encuentra cifrada");/////////////////
        }
        else
        {
            //ALGORITMOS
            final String ALGORITMO_SECRET_KEY = "AES";
            final String ALGORITMO_CIPHER = "AES/GCM/PKCS5Padding";
            final String ALGORITMO_CONTRASENIA_PERSONALIZADA = "PBKDF2WithHmacSHA256";
            
            
            
            
            //preparo la sal aleatoria
            byte[] sal = new byte[32];
            SecureRandom random = new SecureRandom();
            random.nextBytes(sal);
            
            int repeticiones = random.nextInt(500, 100000);
            
            
            //fabrica de llaves
            final SecretKeyFactory keyGen = SecretKeyFactory.getInstance(ALGORITMO_CONTRASENIA_PERSONALIZADA);
            //cpnfiguracion de la llave
            final PBEKeySpec keySpecifs = new PBEKeySpec(clave.toCharArray(), sal, repeticiones, 256);
            //creo la llave con la fabrica de llaves
            final SecretKey tmp = keyGen.generateSecret(keySpecifs);
            final SecretKey llave = new SecretKeySpec(tmp.getEncoded(), ALGORITMO_SECRET_KEY);

            //cifrador
            final Cipher cifrador = Cipher.getInstance(ALGORITMO_CIPHER);
            
            
            
            //Logica cifrado
            cifrador.init(Cipher.ENCRYPT_MODE, llave);
            final byte[] iv = cifrador.getIV();
            
            
            if(this.getConfig().getCifradoContra().equals(ETipoCifrado.CIFRADO_DEFAULT))
            {
                String contraCifrada = this.cifrarString(this.getCredencial().getContra(), cifrador);
                this.getCredencial().setContra(contraCifrada);
            }
            
            if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT))
            {
                String sitioCifrado = this.cifrarString(this.getCredencial().getSitio(), cifrador);
                this.getCredencial().setSitio(sitioCifrado);
            }
            
            if(this.getConfig().getCifradoNombreCuenta().equals(ETipoCifrado.CIFRADO_DEFAULT))
            {
                String nombreCuentaCifrado = this.cifrarString(this.getCredencial().getNombreCuenta(), cifrador);
                this.getCredencial().setNombreCuenta(nombreCuentaCifrado);
            }

            
            this.setParametros(new ParametrosDelCifrado(iv, sal, repeticiones));
            this.setEstadoCifrado(true);
            
        }
    }
    
    private String cifrarString(String datoACifrar, Cipher cifrador) throws IllegalBlockSizeException, BadPaddingException{
        byte[] encriptado = cifrador.doFinal(datoACifrar.getBytes(StandardCharsets.UTF_8));
        String retorno = Base64.getEncoder().encodeToString(encriptado);
        
        return retorno;*/
        
    
    protected void descifrarCredencialDefault(String clave){// throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidParameterSpecException{
        
        if(!this.getEstadoCifrado())
        {
            System.out.println("LA CREDENCIAL YA ESTABA DESCIFRADA");
            //throw new CredencialYaDescifradaException("ERROR, la credencial ya se encuentra cifrada");/////////////////
        }
        else
        {
            CifDefault descifrador = new CifDefault(clave, this.getParametros().getIv(), this.getParametros().getSal(), this.getParametros().getRepeticiones());

            if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT)){
                String sitioPeroDescifrado = descifrador.descifrar(this.getCredencial().getSitio());
                this.getCredencial().setContra(sitioPeroDescifrado);
            }

            if(this.getConfig().getCifradoNombreCuenta().equals(ETipoCifrado.CIFRADO_DEFAULT)){
                String nombreCuentaPeroDescifrado = descifrador.descifrar(this.getCredencial().getNombreCuenta());
                this.getCredencial().setNombreCuenta(nombreCuentaPeroDescifrado);   
            }

            if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT)){
                String contraPeroDescifrada = descifrador.descifrar(this.getCredencial().getContra());
                this.getCredencial().setContra(contraPeroDescifrada);
            }



            this.setEstadoCifrado(false);
        }
        
    }
    
    
    
    
    protected void descifrarCredencialOculto(String claveOculto){// throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidParameterSpecException{

    if(!this.getEstadoCifrado())
    {
        System.out.println("LA CREDENCIAL YA ESTABA DESCIFRADA");
        //throw new CredencialYaDescifradaException("ERROR, la credencial ya se encuentra cifrada");/////////////////
    }
    else
    {
        CifDefault descifrador = new CifDefault(claveOculto, this.getParametros().getIv(), this.getParametros().getSal(), this.getParametros().getRepeticiones());

        if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO)){
            String sitioPeroDescifrado = descifrador.descifrar(this.getCredencial().getSitio());
            this.getCredencial().setContra(sitioPeroDescifrado);
        }

        if(this.getConfig().getCifradoNombreCuenta().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO)){
            String nombreCuentaPeroDescifrado = descifrador.descifrar(this.getCredencial().getNombreCuenta());
            this.getCredencial().setNombreCuenta(nombreCuentaPeroDescifrado);   
        }

        if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO)){
            String contraPeroDescifrada = descifrador.descifrar(this.getCredencial().getContra());
            this.getCredencial().setContra(contraPeroDescifrada);
        }
        this.setEstadoCifradoOculto(false);
    }
        
        
        /*final String ALGORITMO_SECRET_KEY = "AES";
        final String ALGORITMO_CIPHER = "AES/GCM/PKCS5Padding";//"AES/CBC/PKCS5Padding";
        final String ALGORITMO_CONTRASENIA_PERSONALIZADA = "PBKDF2WithHmacSHA256";
        final int CANTIDAD_BITS_AUTENTICACION = 16 * 8;
        
        final SecretKeyFactory keyGen = SecretKeyFactory.getInstance(ALGORITMO_CONTRASENIA_PERSONALIZADA);
        //cpnfiguracion de la llave
        final PBEKeySpec keySpecifs = new PBEKeySpec(clave.toCharArray(), this.getParametros().getSal(), this.getParametros().getRepeticiones(), 256);
        //creo la llave con la fabrica de llaves
        final SecretKey tmp = keyGen.generateSecret(keySpecifs);
        final SecretKey llave = new SecretKeySpec(tmp.getEncoded(), ALGORITMO_SECRET_KEY);
        
        
        final Cipher decifrador = Cipher.getInstance(ALGORITMO_CIPHER);
        decifrador.init(Cipher.DECRYPT_MODE, llave, new GCMParameterSpec(CANTIDAD_BITS_AUTENTICACION, this.getParametros().getIv())); 
        
        if(this.getConfig().getCifradoContra().equals(ETipoCifrado.CIFRADO_DEFAULT))
        {
            String contraDescifrada = this.decifrarString(this.getCredencial().getContra(), decifrador);
            this.getCredencial().setContra(contraDescifrada);
        }

        if(this.getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT))
        {
            String sitioDescifrado = this.decifrarString(this.getCredencial().getSitio(), decifrador);
            this.getCredencial().setSitio(sitioDescifrado);
        }

        if(this.getConfig().getCifradoNombreCuenta().equals(ETipoCifrado.CIFRADO_DEFAULT))
        {
            String nombreCuentaDescifrado = this.decifrarString(this.getCredencial().getNombreCuenta(), decifrador);
            this.getCredencial().setNombreCuenta(nombreCuentaDescifrado);
        }
    
        this.setEstadoCifrado(false);
    }
    
    private String decifrarString(String datoADescifrar, Cipher decifrador)throws BadPaddingException, IllegalBlockSizeException{
        String decifrado = new String(decifrador.doFinal(datoADescifrar.getBytes()), StandardCharsets.UTF_8);
        return decifrado;
    }*/
    
    
    
    //---------------------OVERRIDES---------------------------
    public boolean equals(CredencialAlmacenada credencialComparada)
    {
        boolean esIgual = this.credencial.equals(credencialComparada.credencial);
        
        
        
        return esIgual; 
    }
    
    public boolean exactlyEquals(CredencialAlmacenada credencialComparada)
    {
        boolean esExactamenteIgual = this.getId().equals(credencialComparada.getId()) && this.equals(credencialComparada);
        
        return esExactamenteIgual;
    }    
    
}
