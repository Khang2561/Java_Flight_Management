package CustomUI.Table;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TablePanelAction extends JPanel {

    private static final long serialVersionUID = 1L;

    private TableActionButton cmdEdit;
    private TableActionButton cmdDelete;

    public TablePanelAction() {
        initComponents();
    }

    public void initEvent(TableActionEvent event, int row) {
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onEdit(row);
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onDelete(row);
            }
        });
    }

    private void initComponents() {
        cmdEdit = new TableActionButton();
        cmdDelete = new TableActionButton();

        // Make sure the resource path is correct
        cmdEdit.setIcon(new ImageIcon(getClass().getResource("/Resource/edit.png")));
        cmdDelete.setIcon(new ImageIcon(getClass().getResource("/Resource/delete.png")));

        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(cmdEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(cmdDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(cmdDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(cmdEdit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }
}
