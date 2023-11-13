/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Luciano
 */
public class ButtonColumnCelRederer extends DefaultTableCellRenderer {
    
    private String buttoType;

    public ButtonColumnCelRederer(String buttoType) {
        this.buttoType = buttoType;
    }
    

    public String getButtoType() {
        return buttoType;
    }

    public void setButtoType(String buttoType) {
        this.buttoType = buttoType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column){
        
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(JLabel.CENTER);
    
        label.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/"+buttoType+".png")));
        
        return label;
    }
}
