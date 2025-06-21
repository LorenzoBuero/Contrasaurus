/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lorenzo Buero
 */
public class SinCifrar implements ICifrador{
    
    
    
    @Override
    public ETipoCifrado getTipoCifrado()
    {
        return ETipoCifrado.SIN_CIFRAR;
    }
    
    
    //me gustaría hacer estas clases estáticas, osea:
    //clase final, constructor privado, metodos static
    public SinCifrar(){}
    
    
    
    @Override
    public String Cifrar(String datosACifrar)
    {
        return datosACifrar;
    }
    
    @Override
    public String Descifrar(String datosADescifrar)
    {
        return datosADescifrar;
    }
}
