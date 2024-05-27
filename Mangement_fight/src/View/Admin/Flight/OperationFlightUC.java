package View.Admin.Flight;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import libData.JDBCUtil;

public class OperationFlightUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPlaneID;
	private JTextField txtFlightMinus;
	private JTextField txtFlightHour;
	private JTextField txtFlightTime;
	private JTextField txtFlightCost;
	private JTable tableIntermediateFlight;
	private DefaultTableModel tableModel;
	private JLabel lblTicketClass1;
	private JLabel lblTicketClass2;

	public OperationFlightUC() throws ClassNotFoundException, SQLException {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 71, 1500, 610);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1500, 610);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(37, 0, 378, 610);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông Tin Chuyến Bay");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 16, 252, 36);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		JComboBox<String> comboBoxFlightFrom = new JComboBox<>();
		comboBoxFlightFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxFlightFrom.setModel(new DefaultComboBoxModel(new String[] {"", "Sân bay Cam Ranh (Khánh Hoà)", "Sân bay Cần Thơ (Cần Thơ)", "Sân bay Cát Bi (Hải Phòng)", "Sân bay Điện Biên (Điện Biên Phủ)", "Sân bay Phú Quốc (Phú Quốc)", "Sân bay Quốc tế Đà Năng (Đà Nẵng)", "Sân bay Quốc tế Nội Bài (Hà Nội)", "Sân bay Quốc tế Tân Sơn Nhất (Hồ Chí Minh)"}));
		comboBoxFlightFrom.setBounds(121, 100, 252, 40);
		panel_1.add(comboBoxFlightFrom);

		JComboBox<String> comboBoxFlightTo = new JComboBox<>();
		comboBoxFlightTo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxFlightTo.setModel(new DefaultComboBoxModel(new String[] {"", "Sân bay Cam Ranh (Khánh Hoà)", "Sân bay Cần Thơ (Cần Thơ)", "Sân bay Cát Bi (Hải Phòng)", "Sân bay Điện Biên (Điện Biên Phủ)", "Sân bay Phú Quốc (Phú Quốc)", "Sân bay Quốc tế Đà Năng (Đà Nẵng)", "Sân bay Quốc tế Nội Bài (Hà Nội)", "Sân bay Quốc tế Tân Sơn Nhất (Hồ Chí Minh)"}));
		comboBoxFlightTo.setBounds(121, 155, 252, 40);
		panel_1.add(comboBoxFlightTo);

		txtPlaneID = new JTextField();
		txtPlaneID.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtPlaneID.setBounds(121, 212, 252, 36);
		panel_1.add(txtPlaneID);
		txtPlaneID.setColumns(10);
		txtPlaneID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					updateTicketClassCounts();
				} catch (ClassNotFoundException | SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		JDateChooser dateFlightDate = new JDateChooser();
		dateFlightDate.setDateFormatString("yyyy-MM-dd");
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
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSave.setBounds(50, 516, 106, 45);
		panel_1.add(btnSave);

		JButton btnCancel = new JButton("Huỷ");
		btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCancel.setBounds(225, 516, 106, 45);
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

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Giờ khởi hành:");
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
		panel_2.setBounds(446, 16, 204, 480);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Thương gia");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(16, 5, 104, 32);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Phổ thông");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(16, 56, 104, 32);
		panel_2.add(lblNewLabel_2_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(0, 40, 204, 12);
		panel_2.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBounds(0, 90, 204, 12);
		panel_2.add(separator_1);

		lblTicketClass1 = new JLabel("30");
		lblTicketClass1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketClass1.setBounds(121, 57, 63, 32);
		panel_2.add(lblTicketClass1);

		lblTicketClass2 = new JLabel("30");
		lblTicketClass2.setBounds(121, 6, 63, 32);
		panel_2.add(lblTicketClass2);
		lblTicketClass2.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnAddIntermediateFlight = new JButton("+");
		btnAddIntermediateFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnAddIntermediateFlight.setBounds(691, 16, 106, 45);
		panel.add(btnAddIntermediateFlight);
		btnAddIntermediateFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowCount = tableModel.getRowCount();
				Object[] rowData = new Object[] { rowCount + 1, "", "", "" };
				tableModel.addRow(rowData);
			}
		});

		JButton btnRemoveIntermediateFlight = new JButton("-");
		btnRemoveIntermediateFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 17));

		btnRemoveIntermediateFlight.setBounds(827, 16, 106, 45);
		panel.add(btnRemoveIntermediateFlight);
		btnRemoveIntermediateFlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableIntermediateFlight.getSelectedRow();
				if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy lựa chọn sân bay cần xoá.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sân bay trung gian không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
					tableModel.removeRow(selectedRow);
					updateRowNumbers();
				}
			}
		});
		JLabel lblSnBayTrung = new JLabel("Sân Bay Trung Gian");
		lblSnBayTrung.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnBayTrung.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSnBayTrung.setBounds(978, 38, 220, 25);
		panel.add(lblSnBayTrung);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(690, 73, 767, 486);
		panel.add(scrollPane);

		tableIntermediateFlight = new JTable();
		tableIntermediateFlight.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		tableIntermediateFlight.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableIntermediateFlight.setBackground(SystemColor.window);
		tableIntermediateFlight.setRowHeight(30);
		setJTableColumnsWidth(tableIntermediateFlight,767,10,40,25,25);
		scrollPane.setViewportView(tableIntermediateFlight);

		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Tên Sân Bay", "Thời Gian Dừng", "Ghi chú" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, true, true, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tableIntermediateFlight.setModel(tableModel);

		TableColumn airportColumn = tableIntermediateFlight.getColumnModel().getColumn(1);
		JComboBox<String> airportComboBox = new JComboBox<>();
		airportComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Sân bay Cam Ranh (Khánh Hoà)",
				"Sân bay Cần Thơ (Cần Thơ)", "Sân bay Cát Bi (Hải Phòng)", "Sân bay Điện Biên (Điện Biên Phủ)",
				"Sân bay Phú Quốc (Phú Quốc)", "Sân bay Quốc tế Đà Năng (Đà Nẵng)", "Sân bay Quốc tế Nội Bài (Hà Nội)",
				"Sân bay Quốc tế Tân Sơn Nhất (Hồ Chí Minh)" }));
		airportColumn.setCellEditor(new DefaultCellEditor(airportComboBox));




	}

	public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth, double... percentages) {
		double total = 0;
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			total += percentages[i];
		}

		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
		}
	}

	private void updateRowNumbers() {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.setValueAt(i + 1, i, 0);
		}
	}

	private void updateTicketClassCounts() throws ClassNotFoundException, SQLException {
		String planeID = txtPlaneID.getText();
		if (!planeID.isEmpty()) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.createStatement();

				String query = "SELECT COUNT(*) AS ticket_count, TicketClassID " + "FROM SEAT " + "WHERE PlaneID = '"
						+ planeID + "' " + "GROUP BY TicketClassID " + "UNION ALL "
						+ "SELECT 0 AS ticket_count, 'UNKNOWN' AS TicketClassID";
				rs = stmt.executeQuery(query);

				while (rs.next()) {
					String ticketClassID = rs.getString("TicketClassID");
					int ticketCount = rs.getInt("ticket_count");
					if (ticketClassID.equals("TC0001")) {
						lblTicketClass1.setText(String.valueOf(ticketCount));
					} else if (ticketClassID.equals("TC0002")) {
						lblTicketClass2.setText(String.valueOf(ticketCount));
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
		}
	}
}