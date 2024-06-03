package View.Admin.TicketPlane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import CustomUI.BtnCS;
import CustomUI.JtfCS;
import DAO.FlightDAO;
import DAO.SeatDAO;
import DAO.TicketDAO;
import Model.TicketClass;
import View.Admin.Admin_header;
import View.Admin.Flight.FlightUC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CreateFlightTicket extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table_1;
    private JtfCS tfGiaVe;
    private JtfCS tfHoVaTen;
    private JtfCS tfCCCD;
    private JtfCS tfSDT;
    private JtfCS tfEmail;
    private DefaultTableModel modelTicketLevel;
    private JComboBox<String> comboBoxFlight;
    private JPanel panel_2;
	private static JPanel panelSeatMap;
	private JPanel panelSeatNumer;
	private BtnCS btnHangVe;
	public static TicketClass[] arrayticket = new TicketClass[6];
	private JButton[] seatButtons;
	private String tmp;
	private JButton selectedSeat = null;// tmp save selected seat
	private String selectedSeatName ;
	private Map<JButton, Color> seatOriginalColors = new HashMap<>();
	private TicketClass currentTicketClass = null;
	private BtnCS btnMaGhe;
	String var ;
	private BtnCS btnTao;
	private BtnCS btnHuy;




	//------------------------
	
	
    public CreateFlightTicket(String var1) {
        setBackground(new Color(240, 240, 240));
        setBounds(0, 0, 1500, 560);
        setLayout(null);
        if (var1 == null || var1.isEmpty()) {
        	var = "FL0001";
        }
        else {
        	var = var1;
        	
        }
        
        // Initialize UI components
        initializeComponents(var);
        
    }
    
    
    //-------------------------------------------------
    private void initializeComponents(String var) {
    	//--------------------------------------
    	 /// Left panel setup
        JPanel panelLeft = new JPanel();
        panelLeft.setBounds(22, 10, 524, 527);
        add(panelLeft);
        panelLeft.setLayout(new GridLayout(0, 2, 40, 0));

        JPanel panel = new JPanel();
        panelLeft.add(panel);
        panel.setLayout(null);

        // Labels and text fields
        JLabel lblTitle = new JLabel("THÔNG TIN MÁY BAY ");
        lblTitle.setForeground(new Color(3, 4, 128));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 10, 242, 29);
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 19));
        panel.add(lblTitle);

        JLabel lblFlightID = new JLabel("Mã chuyến bay ");
        lblFlightID.setBounds(0, 49, 126, 19);
        lblFlightID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lblFlightID);

        JLabel lblPrice = new JLabel("Giá vé ");
        lblPrice.setBounds(0, 107, 90, 19);
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lblPrice);

        JLabel lblName = new JLabel("Họ và tên ");
        lblName.setBounds(0, 165, 126, 19);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lblName);

        JLabel lblCCCD = new JLabel("CMND/CCCD ");
        lblCCCD.setBounds(0, 223, 126, 19);
        lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lblCCCD);

        JLabel lblPhone = new JLabel("Số điện thoại ");
        lblPhone.setBounds(0, 281, 126, 19);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lblPhone);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(3, 339, 126, 19);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lblEmail);
        
        //-----------------------------------------------
        tfGiaVe = new JtfCS();
        tfGiaVe.setFont(new Font("Times New Roman", Font.BOLD, 16));
        tfGiaVe.setEditable(false);
        tfGiaVe.setEnabled(false);
        tfGiaVe.setBounds(0, 125, 207, 41);
        panel.add(tfGiaVe);

        tfHoVaTen = new JtfCS();
        tfHoVaTen.setFont(new Font("Times New Roman", Font.BOLD, 16));
        tfHoVaTen.setBounds(0, 183, 207, 41);
        panel.add(tfHoVaTen);

        tfCCCD = new JtfCS();
        tfCCCD.setFont(new Font("Times New Roman", Font.BOLD, 16));
        tfCCCD.setBounds(0, 241, 207, 41);
        panel.add(tfCCCD);

        tfSDT = new JtfCS();
        tfSDT.setFont(new Font("Times New Roman", Font.BOLD, 16));
        tfSDT.setBounds(0, 299, 207, 41);
        panel.add(tfSDT);

        tfEmail = new JtfCS();
        tfEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
        tfEmail.setBounds(0, 357, 207, 41);
        panel.add(tfEmail);

        // Buttons
        panel_2 = new JPanel();
        panel_2.setBounds(0, 419, 197, 41);
        panel.add(panel_2);
        panel_2.setLayout(null);

        btnTao = new BtnCS();
        btnTao.setRadius(20);
        btnTao.setForeground(new Color(255, 255, 255));
        btnTao.setColor(new Color(3, 4, 94));
        btnTao.setBorderColor(new Color(3, 4, 94));
        btnTao.setBackground(new Color(3, 4, 94));
        btnTao.setText("Tạo");
        btnTao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String FlightTicketID = generateUniqueFlightId();
                    String FlightID = (String) comboBoxFlight.getSelectedItem();  // sửa từ cmboBoxFlight.getSelecttionIndex();
                    String TicketClassID = arrayticket[table_1.getSelectedRow()].getTicketClassID();  // lấy ID của hạng vé từ bảng
                    String Price = tfGiaVe.getText();
                    String FullName = tfHoVaTen.getText();
                    String IDCard = tfCCCD.getText();
                    String PhoneNumber = tfSDT.getText();
                    String Email = tfEmail.getText();
                    String SeatID = btnMaGhe.getText();  // lấy mã ghế đã chọn
                    int i = TicketDAO.insert(FlightTicketID, FlightID, TicketClassID, Price, FullName, IDCard, PhoneNumber, Email, SeatID);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "Tạo vé máy bay thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        Admin_header.clearAndShow(new FlightUC());
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Tạo vé máy bay thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi tạo vé máy bay!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnTao.setBounds(0, 0, 78, 41);
        btnTao.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_2.add(btnTao);

        btnHuy = new BtnCS();
        btnHuy.setRadius(20);
        btnHuy.setColorOver(new Color(192, 192, 192));
        btnHuy.setColorClick(new Color(192, 192, 192));
        btnHuy.setForeground(new Color(255, 255, 255));
        btnHuy.setColor(new Color(128, 128, 128));
        btnHuy.setBorderColor(new Color(128, 128, 128));
        btnHuy.setBackground(new Color(128, 128, 128));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    Admin_header.clearAndShow(new FlightUC());
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
        	}
        });
        btnHuy.setBounds(99, 0, 78, 41);
        btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_2.add(btnHuy);

        ;
        
        //----------------------------------------------
        // Ticket class panel setup
        JPanel panel_1 = new JPanel();
        panelLeft.add(panel_1);
        panel_1.setLayout(null);

        JPanel panelHangve = new JPanel();
        panelHangve.setBorder(new LineBorder(Color.BLACK));
        panelHangve.setBounds(30, 56, 197, 177);
        panel_1.add(panelHangve);
        panelHangve.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 197, 175);
        panelHangve.add(scrollPane);

        table_1 = new JTable();
        table_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        modelTicketLevel = new DefaultTableModel();
        modelTicketLevel.setColumnIdentifiers(new Object[] {"Tên hạng vé", "Số lượng"});
        table_1.setModel(modelTicketLevel);
        scrollPane.setViewportView(table_1);
        table_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table_1.getSelectedRow();
                if (row != -1 && arrayticket[row] != null) {
                    ((AbstractButton) btnHangVe).setText(arrayticket[row].getTicketClassName());
                    btnHangVe.setBackground(arrayticket[row].getColorTicketClass());
                    tmp = arrayticket[row].getTicketClassName();
                    try {
                        // Convert the price percentage to double
                        double pricePercentage = Double.parseDouble(arrayticket[row].getPricePercentage());
                        // Get the ticket money and multiply by the price percentage
                        long ticketMoney = SeatDAO.TicketMoney((String) comboBoxFlight.getSelectedItem());
                        double totalPrice = ticketMoney * pricePercentage;

                        // Format the price in VND
                        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                        tfGiaVe.setText(vndFormat.format(totalPrice));
                        // Highlight corresponding seats
                        highlightSeats(arrayticket[row]);
                        selectedSeat = null;
                    } catch (ClassNotFoundException | SQLException | NumberFormatException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });


        btnHangVe = new BtnCS();
        btnHangVe.setForeground(new Color(255, 255, 255));
        btnHangVe.setBorderColor(new Color(255, 255, 255));
        btnHangVe.setText("Chưa có hạng vé");
        btnHangVe.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnHangVe.setBounds(30, 479, 197, 41);
        panel_1.add(btnHangVe);

        JLabel lblHngV = new JLabel("HẠNG VÉ ");
        lblHngV.setForeground(new Color(3, 4, 128));
        lblHngV.setHorizontalAlignment(SwingConstants.CENTER);
        lblHngV.setFont(new Font("Times New Roman", Font.BOLD, 19));
        lblHngV.setBounds(0, 10, 242, 19);
        panel_1.add(lblHngV);
        
        btnMaGhe = new BtnCS();
        btnMaGhe.setForeground(new Color(255, 255, 255));
        btnMaGhe.setBackground(new Color(0, 0, 0));
        btnMaGhe.setText("Chưa chọn");
        btnMaGhe.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnMaGhe.setBounds(30, 428, 197, 41);
        panel_1.add(btnMaGhe);
        
        
        //------------------------------------------------------
        // Seat panel setup
        JPanel seatPanel = new JPanel();
        seatPanel.setBorder(new LineBorder(Color.BLACK));
        seatPanel.setBounds(661, 35, 756, 469);
        seatPanel.setLayout(null);
        add(seatPanel);

        panelSeatNumer = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelSeatNumer.getLayout();
		flowLayout.setVgap(6);
		flowLayout.setHgap(0);
        panelSeatNumer.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        panelSeatNumer.setBounds(0, 0, 110, 469);
        seatPanel.add(panelSeatNumer);

        panelSeatMap = new JPanel();
        panelSeatMap.setBorder(new LineBorder(SystemColor.desktop));
        panelSeatMap.setPreferredSize(new Dimension(647, 454));
        panelSeatMap.setBounds(109, 0, 647, 469);
        seatPanel.add(panelSeatMap);

        // Seat map headers
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(770, 10, 647, 26);
        add(panel_3);
        panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 0));

        String[] seatHeaders = {"A", "B", "C", "D", "E", "F"};
        for (String header : seatHeaders) {
            JLabel lbl = new JLabel(header, SwingConstants.CENTER);
            lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
            lbl.setBorder(new LineBorder(Color.BLACK));
            lbl.setPreferredSize(new Dimension(90, 26));
            panel_3.add(lbl);
        }
        
     // Flight comboBox
        setupFlightComboBox(panel);
        
    }

    
    //-----------------------------------------------------------------------------
    private void setupFlightComboBox(JPanel panel) {
        try {
            ResultSet rs = FlightDAO.selectAll();
            DefaultComboBoxModel<String> flightModel = new DefaultComboBoxModel<>();
            String selectedFlightID = null;

            while (rs.next()) {
                String flightID = rs.getString("FlightID");
                flightModel.addElement(flightID);
                if (flightID.equals(var)) {
                    selectedFlightID = flightID;
                }
            }

            comboBoxFlight = new JComboBox<>(flightModel);
            if (selectedFlightID != null) {
                comboBoxFlight.setSelectedItem(selectedFlightID);
            }
            //-----------------------------------------
            String selectedFlight1 = (String) comboBoxFlight.getSelectedItem();
            ResultSet rs1 = SeatDAO.sellectTicketClass(selectedFlight1);
            loadRsToTableTicketLevel(rs1);
            CreateSeat(selectedFlight1);
            //----------------------------------

            comboBoxFlight.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedFlight = (String) comboBoxFlight.getSelectedItem();
                    try {
                        ResultSet rs = SeatDAO.sellectTicketClass(selectedFlight);
                        loadRsToTableTicketLevel(rs);
                        CreateSeat(selectedFlight); // Call CreateSeat with the selected flight
                    } catch (ClassNotFoundException | SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            JScrollPane scrollPaneFlight = new JScrollPane(comboBoxFlight);
            scrollPaneFlight.setBounds(0, 67, 200, 30);
            panel.add(scrollPaneFlight);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    
    //--------------------------------------------------------------------------------
    public void loadRsToTableTicketLevel(ResultSet rs) throws SQLException {
        DefaultTableModel modelTicketLevel = (DefaultTableModel) table_1.getModel();
        modelTicketLevel.setRowCount(0);  // Xóa các hàng hiện có

        // Mảng màu sắc tương ứng cho các hạng vé
        Color[] ticketClassColors = {new Color(0, 102, 204), new Color(51, 153, 255), new Color(102, 204, 255), new Color(153, 204, 255), new Color(204, 229, 255)};

        int colorIndex = 0;  // Chỉ số của mảng màu
        int i = 0;
        while (rs.next()) {
            String ticketClassID = rs.getString("TicketClassID");
            String ticketClassName = rs.getString("TicketClassName");
            String pricePercentage = rs.getString("PricePercentage");

            // Tạo một đối tượng TicketClass từ thông tin lấy được và màu sắc tương ứng
            TicketClass ticketClass = new TicketClass(ticketClassName, pricePercentage, ticketClassID, ticketClassColors[colorIndex]);

            // Thêm đối tượng TicketClass vào bảng
            modelTicketLevel.addRow(new Object[] { ticketClass.getTicketClassName(), ticketClass.getPricePercentage() });
            arrayticket[i] = ticketClass;

            // Tăng chỉ số của mảng màu, nếu vượt quá số lượng màu, quay lại màu đầu tiên
            colorIndex = (colorIndex + 1) % ticketClassColors.length;
            i++;
        }
    }
    
    //---------------------------------------------------------------------------------
    
    
    private void CreateSeat(String planeID) {
        try {
            int numButtons = SeatDAO.countSeatByPlaneID(planeID);
            panelSeatMap.removeAll();
            panelSeatNumer.removeAll();

            seatButtons = new JButton[numButtons];

            for (int i = 0; i < numButtons; i++) {
                seatButtons[i] = new JButton();
                seatButtons[i].setPreferredSize(new Dimension(100, 40));
                seatButtons[i].setName("");

                // Set the seat ID
                panelSeatMap.add(seatButtons[i]);
                String seatID = getSeatID(seatButtons[i]);

                // Check if the seat is booked
                boolean isBooked = SeatDAO.isSeatBooked(planeID, seatID);
                if (isBooked) {
                    seatButtons[i].setBackground(Color.RED);
                    seatButtons[i].setEnabled(false);
                }

                // Store the original color of the seat
                seatOriginalColors.put(seatButtons[i], seatButtons[i].getBackground());

                // Add ActionListener to seat button
                seatButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();
                        try {
                            String selectedFlight = (String) comboBoxFlight.getSelectedItem();
                            String seatID = getSeatID(clickedButton);
                            String seatClass = SeatDAO.nameTicketClass(selectedFlight, seatID);

                            if (currentTicketClass == null || !seatClass.equals(currentTicketClass.getTicketClassName())) {
                                // Show warning message
                                JOptionPane.showMessageDialog(null, "Bạn đã chọn ghế không đúng hạng vé!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                                return;
                            }

                            if (selectedSeat != null && selectedSeat != clickedButton) {
                                // Reset màu ghế đã chọn trước đó về màu ban đầu
                                selectedSeat.setBackground(seatOriginalColors.get(selectedSeat));
                            }

                            clickedButton.setBackground(Color.BLACK); // Đổi màu ghế hiện tại sang đen
                            selectedSeat = clickedButton; // Lưu lại ghế hiện tại
                            selectedSeatName = getSeatID(selectedSeat); // Lấy vị trí ghế

                            // Update btnMaGhe with the selected seat ID
                            btnMaGhe.setText(selectedSeatName);

                        } catch (ClassNotFoundException | SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

            }

            for (int i = 0; i < (numButtons / 6); i++) {
                JButton seatNumberButton = new JButton("" + (i + 1));
                seatNumberButton.setPreferredSize(new Dimension(90, 40));
                panelSeatNumer.add(seatNumberButton);
            }

            panelSeatMap.revalidate();
            panelSeatMap.repaint();
            panelSeatNumer.revalidate();
            panelSeatNumer.repaint();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    //----------------------------------------------------------------------------
    

    private void highlightSeats(TicketClass ticketClass) throws ClassNotFoundException, SQLException {
        // Reset the background color for all seats
        for (Component comp : panelSeatMap.getComponents()) {
            if (comp instanceof JButton) {
                JButton seatButton = (JButton) comp;
                if (!seatButton.getBackground().equals(Color.RED)) {
                    seatButton.setBackground(Color.white); // Reset to original color
                }
            }
        }

        // Highlight seats for the selected ticket class
        Color color = ticketClass.getColorTicketClass();
        String selectedFlight = (String) comboBoxFlight.getSelectedItem();
        for (Component comp : panelSeatMap.getComponents()) {
            if (comp instanceof JButton) {
                JButton seatButton = (JButton) comp;
                String seatID = getSeatID(seatButton);
                if (SeatDAO.nameTicketClass(selectedFlight, seatID).equals(ticketClass.getTicketClassName())) {
                    // Check if the seat is not booked
                    if (!seatButton.getBackground().equals(Color.RED)) {
                        seatButton.setBackground(color);
                        seatOriginalColors.put(seatButton, color); // Update the color in the map
                    }
                }
            }
        }
        currentTicketClass = ticketClass; // Update the current ticket class
    }

    //--------------------------------------------------------
    private static String getSeatID(JButton button) {
	    int seatIndex = panelSeatMap.getComponentZOrder(button);
	    String row = String.valueOf((seatIndex / 6) + 1); // Số nằm ngang
	    String column = String.valueOf((char) ('A' + seatIndex % 6)); // Chữ nằm dọc
	    return column + row;
	}
    //--------------------------------------------------------
    private String generateUniqueFlightId() throws ClassNotFoundException, SQLException {
    	String accountIdPrefix = "FL"; // Tiền tố của mã tài khoản
        int accountIdDigits = 4; // Số chữ số sau tiền tố
        int accountCount = TicketDAO.countAccount(); // Get the current count of accounts
        int newAccountId = accountCount + 1; // Generate a new ID by incrementing the current count
        String FlightId = accountIdPrefix + String.format("%0" + accountIdDigits + "d", newAccountId); // Format the ID with leading zeros
		// Kiểm tra xem mã tài khoản mới đã tồn tại hay chưa   
		return FlightId;
    }
    
}
