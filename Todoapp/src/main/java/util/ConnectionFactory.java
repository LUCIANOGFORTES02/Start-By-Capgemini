/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luciano
 */
public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";//Conexão com o banco de dados
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";//Onde nosso banco de dado está localizado
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);//Carregar o driver JDBC
            //Estabelecer a conexão com o banco de dados
            return DriverManager.getConnection(URL,USER,PASS);        
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("Erro na conexão com o banco de dados",e);
        }
        
    }
    public static void closeConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
        }
            
        } catch (SQLException e) {
            //Uma exceção não verificada. É frequentemente usado para lidar com erros inesperados ou fatais
            throw new RuntimeException("Erro ao fechar a conexão");
        }
    }
    public static void closeConnection(Connection connection, Statement statement){
        try {
            if(connection != null){
                connection.close();
        }
            if(statement != null){
                statement.close();
                
            }
               
            
        } catch (SQLException e) {
            //Uma exceção não verificada. É frequentemente usado para lidar com erros inesperados ou fatais
            throw new RuntimeException("Erro ao fechar a conexão");
        }
    
    }
    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();              
            }
            if(resultSet != null){
                resultSet.close();
            }
            
        } catch (SQLException e) {
            //Uma exceção não verificada. É frequentemente usado para lidar com erros inesperados ou fatais
            throw new RuntimeException("Erro ao fechar a conexão");
        }
    }
}
