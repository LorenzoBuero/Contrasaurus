package app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lorenzo Buero
 */
public class DatosCredencial {
    
    
    private String sitio;
    private String nombreCuenta;
    private String contra;
    
    //--------------------GET/SET-----------------------------------------
   

    public String getSitio() {
        return sitio;
    }
    protected void setSitio(String sitio) {
        this.sitio = sitio;
    }

    
    public String getNombreCuenta() {
        return nombreCuenta;
    }
    protected void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    
    public String getContra() {
        return contra;
    }
    protected void setContra(String contra) {
        this.contra = contra;
    }
    
    
    //---------------------------------Constructores--------------------------------------
    
    
    
    public DatosCredencial(String sitio, String nombreCuenta, String contra)
    {   
        this.setSitio(sitio);
        this.setNombreCuenta(nombreCuenta);
        this.setContra(contra);
    }

    public boolean equals(DatosCredencial datosComparados){
        if(this.getContra().equals(datosComparados) && 
        this.getNombreCuenta().equals(datosComparados.getNombreCuenta()) && 
        this.getContra().equals(datosComparados.getContra())){
            
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
    
        String retorno = this.getSitio() + "   |   " + this.getNombreCuenta() + "   |   " + this.getContra();
        return retorno;
    } 




}


    
    //Credencial nueva, por ende crea un nuevo ID por su cuenta
    /*public void Credencial(String sitio, String nombreCuenta, String contra, ConfigCredencial tipoDeCifrado)
    {
        this.setSitio(sitio);
        this.setNombreCuenta(nombreCuenta);
        this.setContra(contra);
        //this.setConfig(tipoDeCifrado);
    };*/
    
    
    
    //---------------------METODOS-------------------------
    /*
    protected void CambiarSitio(String sitioNuevo)
    {
        //verificaciones???????
        //si verifico deberia hacerlo en el SETTER??
        
        //TIRAR ERRORES???????????????
        this.setSitio(sitioNuevo);
    }
    
    protected void CambiarNombreCuenta(String nombreCuentaNuevo)
    {
        //verificaciones???????
        //si verifico deberia hacerlo en el SETTER??
        this.setNombreCuenta(nombreCuentaNuevo);
    }
    
    protected void CambiarContra(String contraNueva)
    {
        //verificaciones???????
        //si verifico deberia hacerlo en el SETTER??
        this.setContra(contraNueva);
    }
    
    
    
    
    
    //----------Overrides
    //@Override
    //no me pide el override
    /*public boolean equals(Credencial credencialComparada)
    {
        boolean sitioIgual = this.getSitio().equals(credencialComparada.getSitio());
        boolean nombreCuentaIgual = this.getNombreCuenta().equals(credencialComparada.getNombreCuenta());
        boolean contraIgual = this.getContra().equals(credencialComparada.getContra());
        //boolean tipoDeCifradoIgual = this.getConfig().equals(credencialComparada.getConfig());
        
        boolean esIgual = sitioIgual && nombreCuentaIgual && contraIgual && tipoDeCifradoIgual;
        
        return esIgual; 
    }
    
    public boolean exactlyEquals(Credencial credencialComparada)
    {
        boolean esExactamenteIgual = this.getId().equals(credencialComparada.getId()) && this.equals(credencialComparada);
        
        return esExactamenteIgual;
    }
    */
  
    

