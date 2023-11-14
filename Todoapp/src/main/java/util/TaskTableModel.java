/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;


//Model interligado com o jtable
public class TaskTableModel extends AbstractTableModel{
String[] columns = {"Nome","Descrição","Prazo","Tarefa Concluída","Editar","Excluir"};
List<Task> tasks = new ArrayList<>();
    @Override//Quantas linhas 
    public int getRowCount() {
        return tasks.size();
    }

    @Override //Quantas colunas
    public int getColumnCount() {
        return columns.length;
                
    }
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }

    public boolean isCellEditable(int rowIndex,int columnIndex){
        return columnIndex == 3;
    }
    
    @Override
    public Class<?> getColumnClass (int columnIndex){//Qual classe do componente que está em determinada coluna
        if(tasks.isEmpty()){
            return Object.class;//Se estiver vazia retorna tipo object         
        }//Chama o método getValueAt da primeira linha e a coluna varia
        return this.getValueAt(0, columnIndex).getClass();
   
    }
    
    @Override//Valor Correspondente
    public Object getValueAt(int rowIndex, int columnIndex){
        
        switch(columnIndex){
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).isIsCompleted();
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrado";           
        }
    }
    @Override
    //Recebe um object valor a qual foi setado o campo
    public void setValueAt(Object aValue, int rowIndex , int columnIndex){
        tasks.get(rowIndex).setIsCompleted((boolean)aValue);
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
}
