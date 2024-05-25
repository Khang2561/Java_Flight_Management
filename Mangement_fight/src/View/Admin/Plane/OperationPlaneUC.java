package View.Admin.Plane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperationPlaneUC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textfieldPlaneName;
	private static JTextField textFieldChairCount;
	private JPanel seatPanel;
	private JPanel panelSeatNumer;
	private static JPanel panelSeatMap;

	/**
	 * Create the panel.
	 */
	public OperationPlaneUC() {
		setLayout(null);
		setBounds(62, 73, 1365, 520);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 500, 520);
		add(panelLeft);
		panelLeft.setLayout(new GridLayout(0, 2, 40, 0));
		
		JPanel panel = new JPanel();
		panelLeft.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin máy bay");
		lblNewLabel.setBounds(29, 20, 171, 19);
		lblNewLabel.setLabelFor(panel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblNewLabel);
		
		textfieldPlaneName = new JTextField();
		textfieldPlaneName.setBounds(0, 67, 197, 30);
		panel.add(textfieldPlaneName);
		
		JLabel lblNewLabel_2 = new JLabel("Tên máy bay");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(0, 49, 90, 19);
		panel.add(lblNewLabel_2);
		
		textFieldChairCount = new JTextField();
		textFieldChairCount.setToolTipText("Là một số chia hết cho 6 ( Tối đa 60 )");
		textFieldChairCount.setColumns(10);
		textFieldChairCount.setBounds(0, 126, 197, 30);
		panel.add(textFieldChairCount);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số lượng ghế");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(0, 107, 90, 19);
		panel.add(lblNewLabel_2_1);
		
		JButton btnLoadSeat = new JButton("Tải danh sách ghế");
		btnLoadSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoadSeat.setBounds(36, 166, 161, 21);
		panel.add(btnLoadSeat);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Chi tiết hạng vé");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(0, 197, 114, 19);
		panel.add(lblNewLabel_2_1_1);
		
		JPanel panelChitietve = new JPanel();
		panelChitietve.setBorder(new LineBorder(Color.BLACK));
		panelChitietve.setBounds(0, 226, 197, 243);
		panel.add(panelChitietve);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 479, 197, 41);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 40, 0));
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnLuu);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(btnHuy);
		
		JPanel panel_1 = new JPanel();
		panelLeft.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Hạng vé");
		lblNewLabel_1.setBounds(88, 18, 81, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setLabelFor(panel_1);
		panel_1.add(lblNewLabel_1);
		
		JPanel panelHangve = new JPanel();
		panelHangve.setBorder(new LineBorder(Color.BLACK));
		panelHangve.setBounds(30, 56, 197, 413);
		panel_1.add(panelHangve);
		
		JButton btnNewButton_1 = new JButton("Chưa có hạng vé");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(30, 479, 197, 41);
		panel_1.add(btnNewButton_1);
		
		seatPanel = new JPanel();
		seatPanel.setBorder(new LineBorder(Color.BLACK));
		seatPanel.setBounds(608, 51, 756, 469);
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
		FlowLayout flowLayout_1 = (FlowLayout) panelSeatMap.getLayout();
		flowLayout_1.setVgap(6);
		flowLayout_1.setHgap(16);
		flowLayout_1.setAlignment(FlowLayout.CENTER);
		panelSeatMap.setBorder(new LineBorder(SystemColor.desktop));
		panelSeatMap.setPreferredSize(new Dimension(647, 454));
		panelSeatMap.setBounds(109, 0, 647, 469);
		seatPanel.add(panelSeatMap);
		
//		JScrollPane scrollPane = new JScrollPane(panelSeatMap);
//		scrollPane.setBounds(109, 0, 647, 454);
//		seatPanel.add(scrollPane);

		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(717, 26, 647, 26);
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 0));
		
		JLabel lblNewLabel_9 = new JLabel("A", SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_9.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("B", SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_8.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("C", SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_7.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("D", SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_6.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("E", SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_4.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("F", SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_3.setPreferredSize(new Dimension(90, 26));
		panel_3.add(lblNewLabel_3);
		
		btnLoadSeat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numButtons = Integer.parseInt(textFieldChairCount.getText());
				if(numButtons%6 !=0 || numButtons>60 ) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập một số chia hết cho 6 và không lớn hơn 60!", "Thông báo", JOptionPane.ERROR_MESSAGE);
					return;
				}
				CreateSeat();
				// create seat number column
				JButton[] buttonArray = new JButton[numButtons/6];
				for (int i = 0;i< (numButtons/6);i++) {
					 buttonArray[i]= new JButton(""+(i+1));
					 buttonArray[i].setPreferredSize(new Dimension(90, 40)); // Kích thước cố định
		             try {
		            	 panelSeatNumer.add(buttonArray[i]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		             panelSeatNumer.revalidate();
		             panelSeatNumer.repaint();
		             
				}
				
			}
		});

	}
	private static void CreateSeat() {
		int numButtons = Integer.parseInt(textFieldChairCount.getText());
		JButton[] buttonArray = new JButton[numButtons];
		for (int i = 0; i < numButtons; i++) {
			 buttonArray[i]= new JButton();
			 buttonArray[i].setPreferredSize(new Dimension(90, 40)); // Kích thước cố định
             try {
				panelSeatMap.add(buttonArray[i]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             panelSeatMap.revalidate();
             panelSeatMap.repaint();
             
         }
	}

}
