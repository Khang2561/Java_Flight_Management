package View.Admin.Plane;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CustomUI.JtfCS;
import CustomUI.Table.JTblCS;
import CustomUI.Table.TableActionCellEditor;
import CustomUI.Table.TableActionCellRender;
import CustomUI.Table.TableActionEvent;
import DAO.AirportDAO;
import View.Admin.Admin_header;
import View.Admin.FormAdmin;
import libData.JDBCUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaneListUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTblCS table;
	private JTextField textFieldSearch;
	static Connection c = JDBCUtil.getConnection();
	public PlaneListUC() {
		setLayout(null);
		setBounds(0, 0, 1365, 520);
		table = new JTblCS("PlaneListUC");

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã máy bay", "Tên máy bay", "Số lượng ghế", "Thao tác"
			}
			
		)
		{
      	  @Override
          public boolean isCellEditable(int row, int column) {
              if (column == 3)
              {
            	  return true;
              }
              return false;
    	  }
      	});
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(40);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		//load db
		
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * from PLANE";
			ResultSet rs = st.executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			while(rs.next()) {
				model.addRow(new Object[] { rs.getString("PlaneID"), rs.getString("PlaneName"), rs.getString("SeatCount")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 80, 1365, 430);
		add(scrollPane);
		table.fixTable(scrollPane);
		
		table.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(new TableActionEvent() {
            @Override
            public void onEdit(int row) {
            	//thong bao neu chua chon may bay
				int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn một máy bay để điều chỉnh.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
				OperationPlaneUC ope = new OperationPlaneUC(table.getValueAt(selectedRow, 0).toString());
				clearAndShow(ope);
            }

			@Override
			public void onDelete(int row) {
				int selectedRow = table.getSelectedRow();
				String sql = "DELETE FROM PLANE WHERE PlaneID = ?";
				PreparedStatement pstmt;
				try {
					pstmt = c.prepareStatement(sql);
                    pstmt.setString(1, table.getValueAt(selectedRow, 0).toString());
                    pstmt.executeUpdate();
                    showAndReloadTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void onBookTicket(int row) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCancelTicket(int row) {
				// TODO Auto-generated method stub
				
			}


        }));
		
		textFieldSearch = new JtfCS();
		textFieldSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textFieldSearch.setToolTipText("Mã máy bay hoặc tên máy bay");
		textFieldSearch.setBounds(0, 35, 249, 35);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		textFieldSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
				if(textFieldSearch.getText().equals("")) {
					showAndReloadTable();
				}else {
					try {
						PreparedStatement stmt = null;
						ResultSet rs = null;
						String sql = "SELECT * from PLANE WHERE PlaneID = ? OR PlaneName = ?";
						stmt = c.prepareStatement(sql);
				    	stmt.setString(1, textFieldSearch.getText());
				    	stmt.setString(2, textFieldSearch.getText());
				    	rs = stmt.executeQuery();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int rowCount = model.getRowCount();
						if(rowCount>0) {
							for (int i = rowCount - 1; i >= 0; i--) {
								  model.removeRow(i);
								}
						}			
						while(rs.next()) {
							model.addRow(new Object[] { rs.getString("PlaneID"), rs.getString("PlaneName"), rs.getString("SeatCount")});
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});

		
		JLabel lblNewLabel = new JLabel("Nhập mã máy bay hoặc tên máy bay");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 260, 25);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(1116, 45, 249, 25);
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 30, 0));
		
		/*JButton btnThongTin = new JButton("Điều chỉnh");


		btnThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnThongTin);
		btnThongTin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//thong bao neu chua chon may bay
				int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn một máy bay để điều chỉnh.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
				OperationPlaneUC ope = new OperationPlaneUC(table.getValueAt(selectedRow, 0).toString());
				clearAndShow(ope);

				
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnXoa);

		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String sql = "DELETE FROM PLANE WHERE PlaneID = ?";
				PreparedStatement pstmt;
				try {
					pstmt = c.prepareStatement(sql);
                    pstmt.setString(1, table.getValueAt(selectedRow, 0).toString());
                    pstmt.executeUpdate();
                    showAndReloadTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});*/


	}
	public void showAndReloadTable() {
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * from PLANE";
			ResultSet rs = st.executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int rowCount = model.getRowCount();
			if(rowCount>0) {
				for (int i = rowCount - 1; i >= 0; i--) {
					  model.removeRow(i);
					}
			}			
			while(rs.next()) {
				model.addRow(new Object[] { rs.getString("PlaneID"), rs.getString("PlaneName"), rs.getString("SeatCount")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void clearAndShow(JPanel newPanel) {
        PlaneUC.contentPanel.removeAll(); 
        PlaneUC.setOpeButtonEnable(true);// Remove all components from contentPane
        PlaneUC.highlightButton(PlaneUC.btnPlaneOperation);
        PlaneUC.contentPanel.add(newPanel);// Add the new panel to contentPane
        newPanel.setSize(1365, 520);
        newPanel.setLocation(0, 0);
        PlaneUC.contentPanel.revalidate(); // Refresh the contentPane
        PlaneUC.contentPanel.repaint(); // Repaint the contentPane
    }
}
