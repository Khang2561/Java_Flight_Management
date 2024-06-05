package CustomUI.Table;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import View.Admin.Flight.FlightListUC;



public class TableActionCellRender extends DefaultTableCellRenderer {
	
	private TablePanelAction action;

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        action = new TablePanelAction();
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(com.getBackground());
        }
        
        if (jtable instanceof JTblCS) {
            JTblCS table = (JTblCS) jtable;
            if ("FlightListUC".equals(table.getParentClassName())) {
                action.getBtnBook().setVisible(true);
            } else {
                action.getBtnBook().setVisible(false);
            }
        }
        
        return action;
    }
    
}
