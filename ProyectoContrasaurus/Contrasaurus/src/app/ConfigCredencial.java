package app;

/**
 *
 * @author pirulo
 */
import java.lang.Character;

import excepciones.TipoCifradoInvalidoException;


public class ConfigCredencial {
    
    //---------------------ATRIBUTOS----------------------------------
    private ETipoCifrado cifradoSitio;
    private ETipoCifrado cifradoNombreCuenta;
    private ETipoCifrado cifradoContra;

    
    
    //-------------------GET/SET----------------------------------------
    protected ETipoCifrado getCifradoSitio() {
        return cifradoSitio;
    }

    protected void setCifradoSitio(ETipoCifrado cifradoSitio) {
        this.cifradoSitio = cifradoSitio;
    }

    protected ETipoCifrado getCifradoNombreCuenta() {
        return cifradoNombreCuenta;
    }

    protected void setCifradoNombreCuenta(ETipoCifrado cifradoNombreCuenta) {
        this.cifradoNombreCuenta = cifradoNombreCuenta;
    }

    protected ETipoCifrado getCifradoContra() {
        return cifradoContra;
    }

    protected void setCifradoContra(ETipoCifrado cifradoContra) {
        this.cifradoContra = cifradoContra;
    }
    public boolean contraseniaOculta(){
        return this.getCifradoContra().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO);
    }
    public boolean sitioOculto(){
        return this.getCifradoNombreCuenta().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO);
    }
    public boolean nombreCuentaOculto(){
        return this.getCifradoSitio().equals(ETipoCifrado.CIFRADO_DEFAULT_OCULTO);
    }
    protected boolean tieneDatosOcultos(){
    
        boolean retorno = false;
        if(this.contraseniaOculta() || this.nombreCuentaOculto() || this.nombreCuentaOculto()){
            retorno = true; 
        }
        return retorno;
    
    }
    
    
    
    //---------------------------CONSTRUCTORES-------------------
    public ConfigCredencial(ETipoCifrado cifradoSitio, ETipoCifrado cifradoNombreCuenta, ETipoCifrado cifradoContra){
        this.setCifradoSitio(cifradoSitio);
        this.setCifradoNombreCuenta(cifradoNombreCuenta);
        this.setCifradoContra(cifradoContra);
    }
    public ConfigCredencial(char cifradoSitio, char cifradoNombreCuenta, char cifradoContra) throws TipoCifradoInvalidoException{
        try{
            this.setCifradoSitio(mapearConfCifrado(cifradoSitio));
            this.setCifradoNombreCuenta(mapearConfCifrado(cifradoNombreCuenta));
            this.setCifradoContra(mapearConfCifrado(cifradoContra));
        }catch(TipoCifradoInvalidoException ex){
            throw new TipoCifradoInvalidoException(ex.getMessage());
        }
    
    }
    public ConfigCredencial(boolean sitioOculto, boolean nombreCuentaOculto, boolean contraOculto){
        
            char cifradoSitio = 'd';
            char cifradoNombreCuenta = 'd';
            char cifradoContra = 'd';

            if(sitioOculto){cifradoSitio = 'o';}
            if(nombreCuentaOculto){cifradoNombreCuenta = 'o';}
            if(contraOculto){cifradoContra = 'o';}
        try{
            this.setCifradoSitio(mapearConfCifrado(cifradoSitio));
            this.setCifradoNombreCuenta(mapearConfCifrado(cifradoNombreCuenta));
            this.setCifradoContra(mapearConfCifrado(cifradoContra));
        }catch(TipoCifradoInvalidoException ex){
            System.out.println("Imposible");
        }
    }
    //-------------------------METODOS---------------------------
    
    private static ETipoCifrado mapearConfCifrado(char conf) throws TipoCifradoInvalidoException{
        
        conf = Character.toLowerCase(conf);
        ETipoCifrado retorno;
     
        switch(conf){
            case 'd'-> retorno = ETipoCifrado.CIFRADO_DEFAULT;
            
            case 'o'-> retorno = ETipoCifrado.CIFRADO_DEFAULT_OCULTO;
            
            default -> throw new TipoCifradoInvalidoException("ERROR, tipo de cifrado inexistente");    
        }

        return retorno;
    }
    
    
    
    
    //------------------------OVERRIDES----------------------------
    @Override
    public String toString()
    {
        String conf = "";
        conf = conf + this.getCifradoSitio().valor;
        conf = conf + this.getCifradoNombreCuenta().valor;
        conf = conf + this.getCifradoContra().valor;
        
        return conf;
    }
}