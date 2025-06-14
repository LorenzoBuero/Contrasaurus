/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lorenzo Buero
 */
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
    
    
    //---------------------------CONSTRUCTORES-------------------
    protected void ConfigCredencial(ETipoCifrado cifradoSitio, ETipoCifrado cifradoNombreCuenta, ETipoCifrado cifradoContra)
    {
        this.setCifradoSitio(cifradoSitio);
        this.setCifradoNombreCuenta(cifradoNombreCuenta);
        this.setCifradoContra(cifradoContra);
    }
    
    //-------------------------METODOS---------------------------
    
    
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
