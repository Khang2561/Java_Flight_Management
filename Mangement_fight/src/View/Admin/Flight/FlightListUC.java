package View.Admin.Flight;

import java.awt.Color;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import javax.swing.JPanel;

public class FlightListUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public FlightListUC() {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 650);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1365, 568);
		add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Tìm kiến");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBounds(1259, 11, 106, 35);
		panel.add(btnNewButton);


		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(SystemColor.control);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Chuyến Bay", "Sân Bay Cất Cánh", "Nơi Cất Cánh", "Sân Bay Hạ Cánh", "Nơi Hạ Cánh", "Thời Gian", "Ghế Trống", "Ghế Đã Đặt", "Thao Tác"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(83);

		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 80, 1365, 430);
		panel.add(scrollPane);

		JComboBox comboBoxTo = new JComboBox();
		comboBoxTo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxTo.setBounds(391, 11, 173, 35);
		panel.add(comboBoxTo);

		JComboBox comboBoxFrom_1 = new JComboBox();
		comboBoxFrom_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxFrom_1.setBounds(208, 11, 173, 35);
		panel.add(comboBoxFrom_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(0, 11, 198, 35);
		panel.add(dateChooser);

	}

}
