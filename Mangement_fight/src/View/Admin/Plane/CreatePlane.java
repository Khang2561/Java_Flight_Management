package View.Admin.Plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CreatePlane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxPlaneName;
	private JTextField textFieldChairCount;

	/**
	 * Create the panel.
	 */
	public CreatePlane() {
		setLayout(null);
		setBounds(62, 73, 1365, 520);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 500, 520);
		add(panelLeft);
		panelLeft.setLayout(new GridLayout(0, 2, 40, 0));
		
		JPanel panel = new JPanel();
		panelLeft.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tạo máy bay");
		lblNewLabel.setBounds(41, 20, 131, 19);
		lblNewLabel.setLabelFor(panel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblNewLabel);
		
		comboBoxPlaneName = new JComboBox();
		comboBoxPlaneName.setBounds(0, 67, 197, 30);
		panel.add(comboBoxPlaneName);
		
		JLabel lblNewLabel_2 = new JLabel("Tên máy bay");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(0, 49, 90, 19);
		panel.add(lblNewLabel_2);
		
		textFieldChairCount = new JTextField();
		textFieldChairCount.setEditable(false);
		textFieldChairCount.setColumns(10);
		textFieldChairCount.setBounds(0, 126, 197, 30);
		panel.add(textFieldChairCount);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số lượng ghế");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(0, 107, 90, 19);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Tải lại danh sách ghế");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(36, 166, 161, 21);
		panel.add(btnNewButton);
		
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
		
		JPanel panelRight = new JPanel();
		panelRight.setBorder(new LineBorder(Color.BLACK));
		panelRight.setBounds(608, 65, 756, 455);
		add(panelRight);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(608, 39, 757, 26);
		add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 80, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 20, 0));
		
		JButton btnNewButton_2 = new JButton("1");
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("2");
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("3");
		panel_4.add(btnNewButton_4);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 20, 0));
		
		JButton btnNewButton_7 = new JButton("4");
		panel_5.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("5");
		panel_5.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("6");
		panel_5.add(btnNewButton_5);

	}

}
