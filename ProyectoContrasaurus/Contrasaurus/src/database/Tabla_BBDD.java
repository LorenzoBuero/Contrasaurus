/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.IAlmacenable;

/**
 *
 * @author pirulo
 */
public abstract sealed class Tabla_BBDD permits Credenciales_BBDD, Usuarios_BBDD{
    
    protected abstract String getNombreTabla(); 
    
    private static Connection getConeccion() throws SQLException
    {
        String URL_BD = "jdbc:sqlite:/home/pirulo/Mis programas/ContrasaurusJavaSpeedrun/ProyectoContrasaurus/Contrasaurus/DBs/Contrasaurus.db";
        Connection coneccion;
        
        coneccion = DriverManager.getConnection(URL_BD);
        
        
        return coneccion;
    }
    
    //OBTENER
    protected abstract ResultSet obtenerTodos();
    
    protected static ResultSet obtenerTodos(String tabla){
        
        String query = "SELECT * FROM " + tabla;
        ResultSet resultado = null;
        
        try {
            Connection coneccion = getConeccion();
            
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            
            resultado = pStatement.executeQuery(); 
            
            
            
        }
        catch (SQLException ex) {
            
            System.out.println("Error al conectar a SQLite");
            System.out.println(ex.getMessage());
        
        }
        
        return resultado;  
    
    
    }
    
    protected static ResultSet obtenerUno(String tabla, String buscado){
        String query = "SELECT * FROM " + tabla + " WHERE ID = ?";
        ResultSet resultado = null;
        
        try {
            Connection coneccion = getConeccion();
            
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            pStatement.setString(1, buscado);
            
            resultado = pStatement.executeQuery(); 
        }
        catch (SQLException ex) {
            
            System.out.println("Error al conectar a SQLite");
            System.out.println(ex.getMessage());
        
        }
        
        return resultado;
    }

    protected abstract ResultSet obtenerUno(String buscado);
    
    
    //AGREGAR
    protected static boolean agregarUno(String query, IAlmacenable almacenable)
    {       
        try{
            Connection coneccion = getConeccion();
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            
            int[] incluidos = {1, 2, 3, 4, 5, 6, 7, 8};
            pStatement = almacenable.prepararAlmacenado(pStatement, incluidos);
            
            int registrosAniadidos = pStatement.executeUpdate();
            System.out.println(registrosAniadidos);
            
            
            pStatement.close();
            coneccion.close();
            return true;
            
        }catch(SQLException ex){
            System.out.println("ERROR AL CONECTAR A SQLite");
            System.out.println(ex.getMessage());
            return false;
        }    
    }
    
    
    //EDITAR
    protected static boolean editarUno(String query, IAlmacenable almacenable, int[] alterados)
    {
        try{
            Connection coneccion = getConeccion();
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            
            pStatement = almacenable.prepararAlmacenado(pStatement, alterados);
            
            int exito = pStatement.executeUpdate();
            if(exito>0){System.out.println("Registro alterado");}
            else{System.out.println("No se alteró nada");}
            
            pStatement.close();
            coneccion.close();
            return true;
            
        }catch(SQLException ex){
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
            return false;
        }        
    }
    
    
    //ELIMINAR
    protected static boolean eliminarUno(String ID, String tabla){
        String query = "DELETE FROM " + tabla + " WHERE ID = ?";
        
        try{
            Connection coneccion = getConeccion();
            
            PreparedStatement pStatement = coneccion.prepareStatement(query);
            pStatement.setString(1, ID);
            
            pStatement.executeUpdate();
            
            coneccion.close();
            pStatement.close();
            
            return true;
        }catch(SQLException ex)
        {
            System.out.println("ERROR EN SQLite");
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    protected abstract boolean eliminarUno(String ID);
}
