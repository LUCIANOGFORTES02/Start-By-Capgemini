/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author Luciano
 */
public class ProjectController {
    
    public void save (Project project){
        String sql ="INSERT INTO projects( name,"
                +"description, "
                +"createdAt, "
                +"updatedAt ) "
                + "VALUES (?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
       
        
        try {
         connection = ConnectionFactory.getConnection();
         statement = connection.prepareStatement(sql);
         
         statement.setString(1, project.getName());
         statement.setString(2, project.getDescription());
         statement.setDate(3, new Date(project.getCreatedAt().getTime()));
         statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
        
         
         statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException ("Erro ao salvar o projeto", e);
            
            
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    public void update(Project project){
        String sql ="UPDATE projects set "
                +"name = ?,"
                +"description = ?,"
                +"createdAt = ?,"
                +"updatedAt = ?"
                +"WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
       
        
        try {
         connection = ConnectionFactory.getConnection();
         statement = connection.prepareStatement(sql);
         
         statement.setString(1, project.getName());
         statement.setString(2, project.getDescription());
         statement.setDate(3, new Date(project.getCreatedAt().getTime()));
         statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
         statement.setInt(5, project.getId());

         statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException ("Erro ao atualizar o projeto", e);

        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    public void removeById(int idProject){
        String sql ="DELETE from projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
       
        
        try {
         connection = ConnectionFactory.getConnection();
         statement = connection.prepareStatement(sql);
         statement.setInt(1, idProject);
         
         statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException ("Erro ao remover o projeto", e);

        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    public List<Project> getAll(){
        String sql ="SELECT * FROM projects";
        
        List <Project > projects = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultset = null;
       
        
        try {
         connection = ConnectionFactory.getConnection();
         statement = connection.prepareStatement(sql);
         resultset = statement.executeQuery();

         //Enquanto existir dodos no banco de dados, faça
         while(resultset.next()){
             Project project = new Project();
             
             project.setId(resultset.getInt("id"));
             project.setName(resultset.getString("name"));
             project.setDescription(resultset.getString("description"));
             project.setCreatedAt(resultset.getDate("createdAt"));
             project.setUpdatedAt(resultset.getDate("updatedAt"));

             projects.add(project);
             
         }
         
         
            
        } catch (Exception e) {
            throw new RuntimeException ("Erro ao buscar o projeto", e);

            
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultset);
        }
        
        return projects;
        
    }
    
}
