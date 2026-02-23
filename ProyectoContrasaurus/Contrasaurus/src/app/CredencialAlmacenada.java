package app;

/**
 *
 * @author pirulo
 */
import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class CredencialAlmacenada implements IAlmacenable{
    
    private String id;
    private DatosCredencial datosCredencial;
    private ConfigCredencial config;
    private ParametrosDelCifrado parametros;
    
    
    public String getId() {
        return id;
    }
    
    private static String newId() {
        
        return UUID.randomUUID().toString();
    }
    
    private void setId(String id) {
        this.id = id;
    }
    
    private void setConfig(ConfigCredencial tipoDeCifrado) {
        this.config = tipoDeCifrado;
    }
    
    public ConfigCredencial getConfig() {
        return this.config;
    }
    
    private void setParametros(ParametrosDelCifrado parametros) {
        this.parametros = parametros;
    }
    
    public ParametrosDelCifrado getParametros() {
        return this.parametros;
    }
    
    protected void setDatosCredencial(DatosCredencial cred) {
        this.datosCredencial = cred;
    }
    
    public DatosCredencial getDatosCredencial() {
        return this.datosCredencial;
    }
    
    public boolean tieneDatosOcultos() {
        
        return this.getConfig().tieneDatosOcultos();
        
    }
   

    
    
    //---------------------------------Constructores--------------------------------------
    //Credencial ya existente, convertida a objeto, por ende necesita el ID original
    public CredencialAlmacenada(String id, DatosCredencial credencial, ConfigCredencial tipoDeCifrado, ParametrosDelCifrado parametros) {
        this.setId(id);
        this.setDatosCredencial(credencial);
        this.setConfig(tipoDeCifrado);
        this.setParametros(parametros);
        
    }
    
    //Credencial nueva, por ende crea un nuevo ID por su cuenta
    public CredencialAlmacenada(DatosCredencial credencial, ConfigCredencial configCifrado) {
        this(newId(), credencial, configCifrado, new ParametrosDelCifrado());
    }

    
    //---------------------METODOS-------------------------
    


    //---------------------OVERRIDES---------------------------
    public boolean equals(CredencialAlmacenada credencialComparada) {
        boolean esIgual = this.getDatosCredencial().equals(credencialComparada.datosCredencial);
        
        return esIgual;
    }
    //un exactly equals compararía todos los campos, no solo los datos de la datosCredencial (no hace falta chequear los estados de cifrado)
    public boolean exactlyEquals(CredencialAlmacenada credencialComparada) {
        boolean esExactamenteIgual = this.getId().equals(credencialComparada.getId()) && this.equals(credencialComparada);
        
        return esExactamenteIgual;
    }
    
    
    @Override
    public PreparedStatement prepararAlmacenado(PreparedStatement pStatement, int[] incluidos) throws SQLException {
        int i = 1;
        for (int incluido : incluidos) {
            switch (incluido) {
                case 1 ->
                    pStatement.setString(i, this.getId());
                
                case 2 ->
                    pStatement.setString(i, this.getDatosCredencial().getSitio());
                
                case 3 ->
                    pStatement.setString(i, this.getDatosCredencial().getNombreCuenta());
                
                case 4 ->
                    pStatement.setString(i, this.getDatosCredencial().getContra());
                
                case 5 ->
                    pStatement.setBytes(i, this.getParametros().getIv());
                
                case 6 ->
                    pStatement.setBytes(i, this.getParametros().getSal());
                
                case 7 ->
                    pStatement.setInt(i, this.getParametros().getRepeticiones());
                
                case 8 ->
                    pStatement.setString(i, this.getConfig().toString());
            }
            i++;
        }
        return pStatement;
        
    }
    
    
    
}
