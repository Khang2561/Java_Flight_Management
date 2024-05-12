package View.Admin.Plane;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import View.Admin.FormAdmin;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class PlaneListUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//setting value default 
					
					/*
					Parameters settingValue = new Parameters();
					ResultSet rs = ParametersDAO.selectAll();
					settingValue.setMinimumFlightTime(rs.getInt("MinimunFlightTime"));
					settingValue.setMaxPreventiveAirports(rs.getInt("MaxPreventiveAirports"));
					settingValue.setMinimumStopoverTime(rs.getInt("MinimumStopoverTim"));
					settingValue.setMaximumStopoverTime(rs.getInt("MaximumStopoverTime"));
					settingValue.setEarliestBookingTime(rs.getInt("EarliestBookingTime"));
					settingValue.setLatestBookingCancellationTime(rs.getInt("LatestBookingCancellationTime"));
					*/
					//setting value default
					
					new PlaneListUC();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public PlaneListUC() {
		setLayout(null);
		table = new JTable();

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã máy bay", "Tên máy bay", "Số lượng ghế", "Thao tác"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 80, 1365, 440);
		add(scrollPane);
		
		textField = new JTextField();
		textField.setToolTipText("Mã máy bay hoặc tên máy bay");
		textField.setBounds(10, 45, 249, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhập mã máy bay hoặc tên máy bay");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 260, 25);
		add(lblNewLabel);
		


	}
}
