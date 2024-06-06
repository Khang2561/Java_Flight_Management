package CustomUI.Table;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent event;

    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        TablePanelAction action = new TablePanelAction();
        action.initEvent(event, row);
        action.setBackground(jtable.getBackground());
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