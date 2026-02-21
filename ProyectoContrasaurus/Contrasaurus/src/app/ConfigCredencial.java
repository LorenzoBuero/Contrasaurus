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
    
    public String getCaracteresConfig(){
        String conf = "";
        conf = conf + this.getCifradoSitio().valor;
        conf = conf + this.getCifradoNombreCuenta().valor;
        conf = conf + this.getCifradoContra().valor;
        
        return conf;
    }
    
    
    //---------------------------CONSTRUCTORES-------------------
    public ConfigCredencial(ETipoCifrado cifradoSitio, ETipoCifrado cifradoNombreCuenta, ETipoCifrado cifradoContra){
        this.setCifradoSitio(cifradoSitio);
        this.setCifradoNombreCuenta(cifradoNombreCuenta);
        this.setCifradoContra(cifradoContra);
    }
    public ConfigCredencial(char cifradoSitio, char cifradoNombreCuenta, char cifradoContra) throws InstantiationException{
        try{
            this.setCifradoSitio(mapearConfCifrado(cifradoSitio));
            this.setCifradoNombreCuenta(mapearConfCifrado(cifradoNombreCuenta));
            this.setCifradoContra(mapearConfCifrado(cifradoContra));
        }catch(TipoCifradoInvalidoException ex){
            throw new InstantiationException(ex.getMessage());
        }
    
    }
    //-------------------------METODOS---------------------------
    
    private static ETipoCifrado mapearConfCifrado(char conf) throws TipoCifradoInvalidoException{//crear excepcion personalizada
        
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
        //DEBO TESTEAR
        String retorno = "";
        
        retorno += this.getCifradoSitio().toString();
        retorno += this.getCifradoNombreCuenta().toString();
        retorno += this.getCifradoContra().toString();
    
        return retorno;
    }
}