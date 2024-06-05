package CustomUI.Table;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.awt.Font;

import CustomUI.BtnCS;
import View.Admin.Flight.FlightListUC;

public class TablePanelAction extends JPanel {

    private static final long serialVersionUID = 1L;

    private TableActionButton cmdEdit;
    private TableActionButton cmdDelete;
    private BtnCS btnBook;
           
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
        btnBook.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent ae) {
                event.onBookTicket(row);
            }
        });
    }

    private void initComponents() {
        cmdEdit = new TableActionButton();
        cmdDelete = new TableActionButton();

        // Make sure the resource path is correct
        cmdEdit.setIcon(new ImageIcon(getClass().getResource("/Resource/edit.png")));
        cmdDelete.setIcon(new ImageIcon(getClass().getResource("/Resource/delete.png")));
        
        btnBook = new BtnCS();
        btnBook.setText("Đặt vé");
        btnBook.setForeground(Color.WHITE);
        btnBook.setFont(new Font("Times New Roman", Font.BOLD, 15));
        //btnBook.setVisible();
        
        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(cmdEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(cmdDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnBook, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(cmdDelete, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(btnBook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addGap(260))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(cmdEdit, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(260, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }
    
    public BtnCS getBtnBook() {
        return btnBook;
    }
}

