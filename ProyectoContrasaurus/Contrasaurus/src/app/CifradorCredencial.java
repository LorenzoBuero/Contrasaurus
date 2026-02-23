/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author pirulo
 */
public class CifradorCredencial implements Runnable{
    
    private CredencialAlmacenada credencial;
    private String clave;
    private boolean quieroCifrarDefault;
    private boolean quieroCifrarOculto;

    protected CredencialAlmacenada getCredencial() {
        return credencial;
    }

    private void setCredencial(CredencialAlmacenada credencial) {
        this.credencial = credencial;
    }

    private String getClave() {
        return clave;
    }

    private void setClave(String clave) {
        this.clave = clave;
    }
    
    
    protected void modoCifrado(){
        this.quieroCifrarDefault = true;
        this.quieroCifrarOculto = true;
    }
    public void modoDescifradoDefaults(){
        this.quieroCifrarDefault = false;
        this.quieroCifrarOculto = true;
    }
    public void modoDescifradoOcultos(){
        this.quieroCifrarDefault = false;
        this.quieroCifrarOculto = false;
    }
    
    public CifradorCredencial(CredencialAlmacenada credencial, String clave, boolean estadoCifrado, boolean estadoCifOculto) {
        this.setCredencial(credencial);
        this.setClave(clave);
        this.quieroCifrarDefault = estadoCifrado;
        if(estadoCifrado){
            estadoCifOculto = true;
        }
        this.quieroCifrarOculto = estadoCifOculto;
    }
    
    private String getNCuenta(){
        return this.getCredencial().getDatosCredencial().getNombreCuenta();
    }
    private String getSitio(){
        return this.getCredencial().getDatosCredencial().getSitio();
    }
    private String getContra(){
        return this.getCredencial().getDatosCredencial().getContra();
    }
    
    protected CredencialAlmacenada cifrarCredencial() {//throws CredencialYaCifradaException{

        if (this.quieroCifrarDefault) {
            System.out.println("LA CREDENCIAL YA ESTABA CIFRADA");
            return null;
            //throw new CredencialYaCifradaException("ERROR, la credencial ya se encuentra cifrada");/////////////////
        } else {
            CifDefault cifrador = new CifDefault(this.getClave(), this.getCredencial().getParametros());

            //sitio
            String sitioPeroCifrado = cifrador.cifrar(this.getSitio());

            //nombre cuenta
            String nombreCuentaPeroCifrado = cifrador.cifrar(this.getNCuenta());

            //contra
            String contraPeroCifrada = cifrador.cifrar(this.getContra());
            
            DatosCredencial datos = new DatosCredencial(sitioPeroCifrado, nombreCuentaPeroCifrado, contraPeroCifrada);
            
            CredencialAlmacenada retorno = new CredencialAlmacenada(this.getCredencial().getId(), datos, this.getCredencial().getConfig(), this.getCredencial().getParametros());
            return retorno;
        }
    }
    
    
    
    protected CredencialAlmacenada descifrarCredencial() {//throws CredencialYaCifradaException{

        if (!this.quieroCifrarDefault) {
            System.out.println("LA CREDENCIAL YA ESTABA DESCIFRADA");
            return null;
        } else {
            CifDefault descifrador = new CifDefault(this.getClave(), this.getCredencial().getParametros());
            
            
            String sitio = this.getSitio();
            if (this.quieroCifrarOculto || this.getCredencial().getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT)) {
                sitio = descifrador.descifrar(this.getSitio());
            }
            
            
            String nombreCuenta = this.getNCuenta();
            if (this.quieroCifrarOculto || this.getCredencial().getConfig().getCifradoNombreCuenta().equals(ETipoCifrado.CIFRADO_DEFAULT)) {
                nombreCuenta = descifrador.descifrar(this.getNCuenta());
            }
            
            
            String contra = this.getContra();
            if (this.quieroCifrarOculto || this.getCredencial().getConfig().getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT)) {   
                contra = descifrador.descifrar(this.getContra());
            }
            
            DatosCredencial datos = new DatosCredencial(sitio, nombreCuenta, contra);
            
            CredencialAlmacenada retorno = new CredencialAlmacenada(this.getCredencial().getId(), datos, this.getCredencial().getConfig(), this.getCredencial().getParametros());
            
            return retorno;
        }
        
    }
    
    public void sincronizarEstados(){
        //si quiero que este cifrada
        CredencialAlmacenada cred;
        if(this.quieroCifrarDefault || this.quieroCifrarOculto){
            cred = this.cifrarCredencial();
            
        }else{
            cred = this.descifrarCredencial();
        }
        
        if(!(cred == null) ){
            this.credencial = cred;
        }
        
    }
    
    
    @Override
    public void run(){
        this.sincronizarEstados(); 
    }
}
