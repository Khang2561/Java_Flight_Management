package View.Admin.Flight;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import DAO.AirportDAO;
import DAO.FlightDAO;
import DAO.PlaneDAO;
import DAO.TicketClassDAO;
import View.Admin.Admin_header;
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
	private JTable table_1;
	private DefaultTableModel modelTicketLevel;
	private JComboBox<String> comboBoxFlight;

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
		
		//-----------------------------------------------------------------
		try {
		    ResultSet rs = AirportDAO.selectAll();

		    DefaultComboBoxModel<String> airportModelFrom = new DefaultComboBoxModel<>();
		    DefaultComboBoxModel<String> airportModelTo = new DefaultComboBoxModel<>();
		    
		    while (rs.next()) {
		        String airportName = rs.getString("AirportName");
		        airportModelFrom.addElement(airportName);
		        airportModelTo.addElement(airportName);
		    }

		    JComboBox<String> comboBoxFlightFrom = new JComboBox<>(airportModelFrom);
		    JComboBox<String> comboBoxFlightTo = new JComboBox<>(airportModelTo);

		    JScrollPane scrollPaneFlightFrom = new JScrollPane(comboBoxFlightFrom);
		    JScrollPane scrollPaneFlightTo = new JScrollPane(comboBoxFlightTo);
		    
		    // Đặt vị trí và kích thước cho JScrollPane
		    scrollPaneFlightFrom.setBounds(121, 100, 252, 40);
		    scrollPaneFlightTo.setBounds(121, 155, 252, 40);
		    
		    // Thêm JScrollPane vào panel
		    panel_1.add(scrollPaneFlightFrom);
		    panel_1.add(scrollPaneFlightTo);

		} catch (ClassNotFoundException | SQLException ex) {
		    ex.printStackTrace();
		}

	    
		//---------------------------------------------------------------------------------
		

		try {
		    ResultSet rs = PlaneDAO.selectAll();
		    DefaultComboBoxModel<String> flightModel = new DefaultComboBoxModel<>();
		    while (rs.next()) {
		        String flightID = rs.getString("PlaneID");
		        flightModel.addElement(flightID);
		    }
		    // Khởi tạo comboBoxFlight và đặt vào model đã tạo
		    comboBoxFlight = new JComboBox<>(flightModel);
		    JScrollPane scrollPaneFlight = new JScrollPane(comboBoxFlight);
		    // Đặt vị trí và kích thước cho JScrollPane
		    scrollPaneFlight.setBounds(121, 212, 252, 36);
		    // Thêm JScrollPane vào panel
		    panel_1.add(scrollPaneFlight);

		    // Thêm bộ lắng nghe sự kiện cho comboBoxFlight
		    comboBoxFlight.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            // Lấy giá trị mới của combobox khi thay đổi
		            String selectedFlight = (String) comboBoxFlight.getSelectedItem();
		            ResultSet rs;
					try {
						rs = PlaneDAO.numberTicketClass(selectedFlight);
						loadRsToTableTicketLevel(rs);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		            // Thực hiện xử lý dữ liệu ở đây...
		        }
		    });

		} catch (ClassNotFoundException | SQLException ex) {
		    ex.printStackTrace();
		}
		//----------------------------------------------------------------------------------
		JDateChooser dateFlightDate = new JDateChooser();
		dateFlightDate.setDateFormatString("yyyy-MM-dd");
		dateFlightDate.setBounds(121, 266, 252, 36);
		panel_1.add(dateFlightDate);
		
		/*
		txtFlightMinus = new JTextField();
		txtFlightMinus.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightMinus.setBounds(238, 327, 63, 36);
		panel_1.add(txtFlightMinus);
		txtFlightMinus.setColumns(10);

		txtFlightHour = new JTextField();
		txtFlightHour.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightHour.setColumns(10);
		txtFlightHour.setBounds(121, 327, 63, 36);
		panel_1.add(txtFlightHour);
		*/
		
		JSpinner spinnerHour = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        spinnerHour.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        spinnerHour.setBounds(121, 327, 63, 36);
        panel_1.add(spinnerHour);
		
        JSpinner spinnerMinute = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        spinnerMinute.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        spinnerMinute.setBounds(238, 327, 63, 36);
        panel_1.add(spinnerMinute);
		//-----------------------------------------------------------------------------------
		txtFlightTime = new JTextField();
		txtFlightTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightTime.setBounds(121, 392, 200, 36);
		panel_1.add(txtFlightTime);
		txtFlightTime.setColumns(10);

		txtFlightCost = new JTextField();
		txtFlightCost.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFlightCost.setBounds(121, 455, 200, 36);
		panel_1.add(txtFlightCost);
		txtFlightCost.setColumns(10);

		JButton btnSave = new JButton("Lưu");
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(0, 0, 160));
		btnSave.setFont(new Font("Arial", Font.BOLD, 20));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSave.setBounds(6, 516, 162, 45);
		panel_1.add(btnSave);

		JButton btnCancel = new JButton("Huỷ");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Admin_header.clearAndShow(new FlightUC());
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
			}
		});
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setBounds(206, 516, 162, 45);
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
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Giờ ");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2.setBounds(194, 332, 34, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("Phút");
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2_1.setBounds(311, 332, 34, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1 = new JLabel("Phút");
		lblNewLabel_1_1_1_1_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2_1_1.setBounds(331, 396, 34, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1_1_1 = new JLabel("VND");
		lblNewLabel_1_1_1_1_1_2_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2_1_1_1.setBounds(331, 460, 34, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1_2_1_1_1);
		
		//--------------------------------------------------------------------
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(446, 16, 204, 76);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(0, 0, 204, 76);
		panel_2.add(scrollPane_1);
		
		//table ticket class
		table_1 = new JTable();
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Thiết lập font cho bảng
		
		Object [] column1 = {"Tên hạng vé","Số lượng"};
		modelTicketLevel = new DefaultTableModel();
		modelTicketLevel.setColumnIdentifiers(column1);
		table_1.setModel(modelTicketLevel);
		//upload data
		try {
			ResultSet rs = PlaneDAO.numberTicketClass("PE0001");
			loadRsToTableTicketLevel(rs);
		}catch(SQLException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		scrollPane_1.setViewportView(table_1);
		
		
		
		//---------------------------------------------------------------------
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
	/*
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
	}*/
	// Phương thức để load dữ liệu lên bảng hạng vé
		public void loadRsToTableTicketLevel(ResultSet rs) throws SQLException {
		    DefaultTableModel modelTicketLevel = (DefaultTableModel) table_1.getModel();
		    modelTicketLevel.setRowCount(0);
		    while (rs.next()) {
		        modelTicketLevel.addRow(new Object[] {
		            rs.getString("TicketClassName"), // Use getString instead of getInt
		            rs.getString("TicketCount"), // Assuming PricePercentage is also a string
		        });
		    }
		}
}