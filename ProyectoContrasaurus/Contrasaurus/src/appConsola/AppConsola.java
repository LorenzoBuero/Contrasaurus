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
    
    
    public void iniciar(){
    
        Usuario usuarioActual = this.login();
        if(usuarioActual != null){
            
            this.setUsuario(usuarioActual);

            System.out.println("Hola " + this.getUsuario().getNombreUsuario() + "\n");
            boolean continuar = true;
            while(continuar){
                int eleccion = this.menuOpcionesUsuario();

                switch(eleccion){

                    case 1 -> this.mostrarCredenciales();
                    case 2 -> this.mostrarCredencialesOcultas();
                    case 3 -> this.agregarCredencial();
                    case 4 -> this.editarCredencial();
                    case 5 -> this.eliminarCredencial();
                    case 6 -> this.menuOpciones()
                    case 7 -> continuar=false;



                }






            }
            System.out.println("Chau " + usuario.getNombreUsuario());

        }else{System.out.println("Chau desconocido");}
        

    }
    
    private Usuario login(){
    
        Usuario esteUsuario = this.solicitarNombreYContrasenia();
        
        return esteUsuario;
    }
    
    private int menuOpcionesUsuario(){
        Scanner escaner = new Scanner(System.in);
        int eleccion = -1;
        boolean continuar = true;
        while(continuar){
            System.out.println("Ingrese el numero correspondiente a lo que quiera hacer\n" + 
                                "-1. Mostrar credenciales\n" +
                                "-2. Mostrar credenciales ocultas\n" +
                                "-3. Agregar credencial\n"+
                                "-4. Editar credencial\n"+
                                "-5. Borrar credencial\n"+
                                "-6. Opciones\n" +
                                "-7. Salir");
        
            
            
            try{
                eleccion = escaner.nextInt();
            }catch(Exception ex){
                System.out.println("ERROR, por favor ingrese un numero correspondiente a las opciones listadas");
                continue;
            }
            if(eleccion < 1 || eleccion > 7){
                System.out.println("ERROR, por favor ingrese una de las opciones listadas");
                continue;
            }
            continuar = false;
        }
        return eleccion;
    
    }
    
    
    
    
    
    private boolean verificarContrasenia(Usuario esteUsuario, String superContrasenia){
        boolean retorno = false;
        HashSHA256 hasheador = new HashSHA256(); 
        
        String superHasheada = hasheador.Cifrar(superContrasenia, esteUsuario.getSal(), esteUsuario.getRepeticiones());

        if(superHasheada.equals(esteUsuario.getSuperContrasenia())){
            retorno = true;
        }

        return retorno;
    }
     
    
    
    
    private String obtenerContraseniaValida(Usuario esteUsuario){
        Scanner escaner = new Scanner(System.in);
        String superContrasenia = escaner.next();
    
        if(superContrasenia.equals("x")){return "x";}
        else if(!this.verificarContrasenia(esteUsuario, superContrasenia)){
            return "valida";
        }
        else{
            return "invalida";
        }
        
        
    }
    
    private Usuario solicitarContraseniaYVerificar(Usuario esteUsuario){
        
        Usuario retorno = null;
        while(retorno == null){
            
            System.out.println("Ingrese la contraseña de " + esteUsuario.getNombreUsuario() + " o X para salir");
            String resultadoIngreso = this.obtenerContraseniaValida(esteUsuario);
            
            if(resultadoIngreso.equals("invalido")){
                System.out.println("ERROR, ingrese una contraseña valida");
                //continue;
            }else if(resultadoIngreso.equals("x")){
                
                System.out.println("Volviendo al menú de seleccion de usuario");
                retorno = solicitarNombreYContrasenia(); //es como si volviera para atras, a cuando solicita el nombre del usuario, esto es muy estilo programacion funcional
            
            }else{
                retorno = esteUsuario;
                
            }
        }
        return retorno;
        
    }
    
    private Usuario solicitarNombreYContrasenia(){
        ArrayList<Usuario> usuarios = ModeloUsuarios.obtenerTodosLosUsuarios();
        Usuario retorno = null;
        while(retorno == null){
            Scanner escaner = new Scanner(System.in);
            
            int contador = 1;
            int numCredencial;

            System.out.println("* .0 Salir");
            for(Usuario usuario : usuarios){
                System.out.println("* ." + contador + " - " + usuario.getNombreUsuario());
            }
            
            System.out.println("Ingrese el numero correspondiente a su usuario");
            try{
                numCredencial = escaner.nextInt() - 1;
            }catch(Exception ex){
                System.out.println("ERROR, ingrese el numero correspondiente a su usuario");
                continue;
            }
            
            if(!(usuarios.size() >= numCredencial) || numCredencial < -1){
                System.out.println("ERROR, ingrese el numero correspondiente a su usuario");
                continue;
            } else if(numCredencial == 0){
                break;//para que retorno null
            }
            Usuario esteUsuario = usuarios.get(numCredencial);
            retorno = solicitarContraseniaYVerificar(esteUsuario);
        }
        return retorno;
    }
    
}
