/**
 *
 * @author pirulo
 */
package appConsola;

import java.util.ArrayList;
import java.util.Scanner;



import app.Usuario;
import app.CredencialAlmacenada;
import database.ModeloUsuarios;
import database.ModeloCredenciales;
import app.HashSHA256;



public class AppConsola {
    
    Usuario usuario;
    ArrayList<CredencialAlmacenada> credenciales;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<CredencialAlmacenada> getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(ArrayList<CredencialAlmacenada> credenciales) {
        this.credenciales = credenciales;
    }
    
    public AppConsola(){}
    
    
    public void iniciar(){}
    
    private Usuario obtenerDatosUsuario(){
    
        Scanner escaner = new Scanner(System.in);
        String superContrasenia = null;
        
        Usuario esteUsuario = null;
        boolean usuarioConfirmado = false;
        
        
        
        ArrayList<Usuario> usuarios= ModeloUsuarios.obtenerTodosLosUsuarios();
        while(!usuarioConfirmado){
            String superHasheada = "nada";
            while(true){
                int contador = 1;
                int numCredencial;


                for(Usuario usuario : usuarios){
                    System.out.println("* ." + contador + " - " + usuario.getNombreUsuario());
                }
                System.out.println("ingrese el numero correspondiente a su usuario");
                try{
                    numCredencial = escaner.nextInt();
                }catch(Exception ex){
                    System.out.println("ERROR, ingrese el numero correspondiente a su usuario");
                    continue;
                }

                if(!(usuarios.size() - 1 >= numCredencial) || numCredencial < 0){
                    System.out.println("ERROR, ingrese el numero correspondiente a su usuario");
                    continue;
                }
                esteUsuario = usuarios.get(numCredencial);
                break;
            }
        
            while(!superHasheada.equals(esteUsuario.getSuperContrasenia())){
                HashSHA256 hasheador = new HashSHA256(); 
                
                System.out.println("Ingrese la contraseña de " + esteUsuario.getNombreUsuario() + " o X para salir");
                superContrasenia = escaner.next();
                
                superHasheada = hasheador.Cifrar(superContrasenia, esteUsuario.getSal(), esteUsuario.getRepeticiones());
                
                if(superContrasenia.toLowerCase().equals("x")){
                    System.out.println("Volviendo a seleccion de usuarios...");
                    break;
                }
                if(!superHasheada.equals(esteUsuario.getSuperContrasenia())){
                    System.out.println("Esa no es la contraseña, probá otra vez o poné X para cambiar de cuenta");
                    continue;
                }
                else{          
                    usuarioConfirmado = true;
                }
                
            }
    
        }
    
        return esteUsuario;
    }
    
    
    
    
    
    
    
    
    
}
