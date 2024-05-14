package View.Admin.Flight;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.TextField;

public class OperationFlightUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFlightID;
	private JTextField txtFlightMinus;
	private JTextField txtFlightHour;
	private JTextField txtFlightTime;
	private JTextField txtFlightCost;
	private JTable tableIntermediateFlight;

	/**
	 * Create the panel.
	 */
	public OperationFlightUC() throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 650);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1500, 650);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(37, 0, 378, 647);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Chuyến Bay");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 23, 252, 36);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JComboBox comboBoxFlightFrom = new JComboBox();
		comboBoxFlightFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxFlightFrom.setModel(new DefaultComboBoxModel(new String[] {"Nội Bài", "Cát Bi", "Osaka"}));
		comboBoxFlightFrom.setBounds(121, 100, 252, 40);
		panel_1.add(comboBoxFlightFrom);
		
		JComboBox comboBoxFlightTo = new JComboBox();
		comboBoxFlightTo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxFlightTo.setModel(new DefaultComboBoxModel(new String[] {"Đà Nẵng", "Quy Nhơn ", "Long Thành"}));
		comboBoxFlightTo.setBounds(121, 155, 252, 40);
		panel_1.add(comboBoxFlightTo);
		
		txtFlightID = new JTextField();
		txtFlightID.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightID.setBounds(121, 212, 252, 36);
		panel_1.add(txtFlightID);
		txtFlightID.setColumns(10);
		
		JDateChooser dateFlightDate = new JDateChooser();
		dateFlightDate.setBounds(127, 272, 246, 30);
		panel_1.add(dateFlightDate);
		
		txtFlightMinus = new JTextField();
		txtFlightMinus.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightMinus.setBounds(257, 327, 116, 36);
		panel_1.add(txtFlightMinus);
		txtFlightMinus.setColumns(10);
		
		txtFlightHour = new JTextField();
		txtFlightHour.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightHour.setColumns(10);
		txtFlightHour.setBounds(121, 327, 116, 36);
		panel_1.add(txtFlightHour);
		
		txtFlightTime = new JTextField();
		txtFlightTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightTime.setBounds(121, 392, 252, 36);
		panel_1.add(txtFlightTime);
		txtFlightTime.setColumns(10);
		
		txtFlightCost = new JTextField();
		txtFlightCost.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightCost.setBounds(121, 455, 252, 36);
		panel_1.add(txtFlightCost);
		txtFlightCost.setColumns(10);
		
		JButton btnSave = new JButton("Lưu");
		btnSave.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(51, 577, 106, 45);
		panel_1.add(btnSave);
		
		JButton btnCancel = new JButton("Huỷ");
		btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCancel.setBounds(226, 577, 106, 45);
		panel_1.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Sân bay đi:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(6, 111, 120, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sân bay đến:");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(6, 166, 120, 16);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã máy bay:");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(6, 221, 120, 16);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày khởi hành:");
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(6, 276, 120, 16);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Giời khởi hành:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(6, 331, 120, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Thời gian bay:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(6, 396, 120, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Giá tiền: ");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(6, 461, 120, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(463, 27, 204, 480);
		panel.add(panel_2);
		
		JButton btnAddIntermediateFlight = new JButton("+");
		btnAddIntermediateFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnAddIntermediateFlight.setBounds(691, 16, 106, 45);
		panel.add(btnAddIntermediateFlight);
		
		JButton btnRemoveIntermediateFlight = new JButton("-");
		btnRemoveIntermediateFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnRemoveIntermediateFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveIntermediateFlight.setBounds(827, 16, 106, 45);
		panel.add(btnRemoveIntermediateFlight);
		
		JLabel lblSnBayTrung = new JLabel("Sân Bay Trung Gian");
		lblSnBayTrung.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnBayTrung.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSnBayTrung.setBounds(991, 53, 220, 25);
		panel.add(lblSnBayTrung);
		
		
		tableIntermediateFlight = new JTable();
		tableIntermediateFlight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableIntermediateFlight.setBackground(SystemColor.control);
		tableIntermediateFlight.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên Sân Bay", "Thời Gian Dừng", "Ghi chú"
			}
		));
		tableIntermediateFlight.getColumnModel().getColumn(1).setPreferredWidth(83);
		
		tableIntermediateFlight.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane(tableIntermediateFlight);
		scrollPane.setBounds(691, 90, 767, 546);
		panel.add(scrollPane);
	}
}
