/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author Lorenzo Buero
 */
public class Credencial {
    
    private long id;
    private String sitio;
    private String nombreCuenta;
    private String contra;
    ConfigCredencial config;

    
    
    
    //--------------------GET/SET-----------------------------------------
    
    
    
    protected long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }


    protected String getSitio() {
        return sitio;
    }

    private void setSitio(String sitio) {
        this.sitio = sitio;
    }

    
    protected String getNombreCuenta() {
        return nombreCuenta;
    }

    private void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    
    protected String getContra() {
        return contra;
    }

    private void setContra(String contra) {
        this.contra = contra;
    }
    
    
    private void setConfig(ConfigCredencial tipoDeCifrado)
    {
        this.config = tipoDeCifrado;
    }
    
    protected ConfigCredencial getConfig()
    {   
        return this.config;
    }
    
    protected String[] getPropiedadesArrayString()
    {
        ArrayList<String> atributos = new ArrayList<String>();
        
        atributos.add(this.getId().toString());
        atributos.add(this.getSitio());
        atributos.add(this.getNombreCuenta());
        atributos.add(this.getContra());
        atributos.add(this.getConfig().toString());
        
        
        return atributos.toArray();
    }
    
    protected String getCredencialCifradaJSON ()
    {
        Credencial credencialCifrada = this.ObtenerEstaCredencialCifrada();
        String[] CredencialCifradaEnArrayString = credencialCifrada.ObtenerEnArrayString();
        String credencialJSON = this.ConvertirAJSON(credencialCifradaEnArrayString);
        
        return credencialJSON;
    }
    
    
    
    
    //---------------------------------Constructores--------------------------------------
    
    //DEBERIA CREAR LA CONFIG ANTES O DEBERIA CREARLA ACÁ, YO CREO QUE ACÁ
    
    //Credencial ya existente, convertida a objeto, por ende necesita el ID original
    public void Credencial(int id, String sitio, String nombreCuenta, String contra, ConfigCredencial tipoDeCifrado)
    {
        this.setId(id);
        this.Credencial(sitio, nombreCuenta, contra, tipoDeCifrado);
        
        this.DescifrarEstaCredencialAlCrear();
    };
    
    //Credencial nueva, por ende crea un nuevo ID por su cuenta
    public void Credencial(String sitio, String nombreCuenta, String contra, ConfigCredencial tipoDeCifrado)
    {
        this.setSitio(sitio);
        this.setNombreCuenta(nombreCuenta);
        this.setContra(contra);
        this.setConfig(tipoDeCifrado);
    };
    
    //este metodo es usado para descifrar los datos de la credencial al crearla
    private void DescifrarEstaCredencialAlCrear()
    {
        //REVISAR PRONTO, HACER DISTINTO??
        {
            //ESTE CODIGO DEPENDE DE TENER EL CODIGO DFEL CIFRADOR LISTO
            Cifrador cifradorSitio = FabricaCifrador(this.getConfig().getCifradoSitio());
            String sitioDescifrado = cifradorSitio.Descifrar(this.sitio);
            this.setSitio(sitioDescifrado);
        }
        {
            //ESTE CODIGO DEPENDE DE TENER EL CODIGO DFEL CIFRADOR LISTO
            Cifrador cifradorNombreCuenta = FabricaCifrador(this.getConfig().getCifradoNombreCuenta());
            String nombreCuentaDescifrado = cifradorNombreCuenta.Descifrar(this.getNombreCuenta());
            this.setNombreCuenta(nombreCuentaDescifrado);
        }
        {
            //ESTE CODIGO DEPENDE DE TENER EL CODIGO DFEL CIFRADOR LISTO
            Cifrador cifradorContra = FabricaCifrador(this.getConfig().getCifradoContra());
            String contraDescifrada = cifradorContra.Descifrar(this.getContra());
            this.setContra(contraDescifrada);
        }
    
    }
    
    
    //---------------------METODOS-------------------------
    private Credencial ObtenerEstaCredencialCifrada()
    {
        /*ESTO DEBERIA 
        HACERLO EL CIFRADOR,
        NO LA CLASE
        CREDENCIAL*/
        
        
        //ArrayList<String> datosCredencial = new ArrayList<String>();
        
        Credencial credencialCifrada = CifradorIntermediario.Cifrar(this);
        
        return credencialCifrada;
        /*
        {
            datosCredencial.add((String)this.getId());
        }
        
        {
            //ESTE CODIGO DEPENDE DE TENER EL CODIGO DFEL CIFRADOR LISTO
            Cifrador cifradorSitio = FabricaCifrador(this.getConfig().getCifradoSitio());
            String sitioCifrado = cifradorSitio.Cifrar(this.sitio) ;
            datosCredencial.add(sitioCifrado);
        }
        {
            //ESTE CODIGO DEPENDE DE TENER EL CODIGO DFEL CIFRADOR LISTO
            Cifrador cifradorNombreCuenta = FabricaCifrador(this.getConfig().getCifradoNombreCuenta());
            String nombreCuentaCifrado = cifradorNombreCuenta.Cifrar(this.getNombreCuenta()) ;
            datosCredencial.add(nombreCuentaCifrado);
        }
        {
            //ESTE CODIGO DEPENDE DE TENER EL CODIGO DFEL CIFRADOR LISTO
            Cifrador cifradorContra = FabricaCifrador(this.getConfig().getCifradoContra());
            String contraCifrada = cifradorContra.Cifrar(this.getContra()) ;
            datosCredencial.add(contraCifrada);
        }
        {
            datosCredencial.add(this.getConfig().toString());
        }*/
        
        
        //return datosCredencial.toString[].class(); //??
    }
    
    
    
    private String ConvertirAJSON(String[] atributos)
    {
        //*lo convierte a json
    }
    
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
        this.setNombreCuenta(contraNueva);
    }
    
    protected void CambiarConfig(ConfigCredencial configNueva)
    {
        //verificaciones???????
        //si verifico deberia hacerlo en el SETTER??
        /*if(this.getConfig().getCifradoSitio() != configNueva.getCifradoSitio())
        {
            this.getConfig().setCifradoSitio(configNueva.getCifradoSitio());
        }*/
        //deberia hacer esto para cada atributo de config o simplemente pisar el objeto??
        
        this.setConfig(configNueva);
    }
    
    
    
    //----------Overrides
    //@Override
    //no me pide el override
    public boolean equals(Credencial credencialComparada)
    {
        boolean sitioIgual = this.getSitio().equals(credencialComparada.getSitio());
        boolean nombreCuentaIgual = this.getNombreCuenta().equals(credencialComparada.getNombreCuenta());
        boolean contraIgual = this.getContra().equals(credencialComparada.getContra());
        boolean tipoDeCifradoIgual = this.getConfig().equals(credencialComparada.getConfig());
        
        boolean esIgual = sitioIgual && nombreCuentaIgual && contraIgual && tipoDeCifradoIgual;
        
        return esIgual; 
    }
    
    public boolean exactlyEquals(Credencial credencialComparada)
    {
        boolean esExactamenteIgual = this.getId() == credencialComparada.getId() && this.equals(credencialComparada);
        
        return esExactamenteIgual;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
