package app;

/**
 *
 * @author Lorenzo Buero
 */
public interface IHasheador {

public abstract String Cifrar(String datosACifrar, byte[] sal, int repeticiones);

}
