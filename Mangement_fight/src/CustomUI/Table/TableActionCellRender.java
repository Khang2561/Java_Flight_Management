package CustomUI.Table;


import java.awt.Color;
import java.awt.Component;


import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;




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
            
            if ("SearchFlightTicket".equals(table.getParentClassName())) {
            	action.getCmdEdit().setVisible(false);
            	action.getCmdDelete().setVisible(false);
            	action.getCmdCancel().setVisible(true);
            } else {
            	action.getCmdEdit().setVisible(true);
            	action.getCmdDelete().setVisible(true);
            	action.getCmdCancel().setVisible(false);
            }
        }
        
        return action;
    }
    
}
