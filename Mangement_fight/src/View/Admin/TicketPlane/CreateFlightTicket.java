package View.Admin.TicketPlane;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class CreateFlightTicket extends JPanel {

    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public CreateFlightTicket(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(null);
        setBounds(62, 73, 1500, 520);

        JButton createTopButton = new JButton("Tạo vé");
        createTopButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        createTopButton.setBounds(10, 11, 175, 53);
        add(createTopButton);

        // Nút tìm vé (ở đầu trang)
        JButton searchTopButton = new JButton("Tìm vé");
        searchTopButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchTopButton.setBounds(200, 11, 175, 53);
        add(searchTopButton);

        JTextField maChbay = new HintTextField("Mã chuyến bay");
        maChbay.setBounds(41, 100, 200, 30);
        add(maChbay);

        JTextField giaTien = new HintTextField("Giá tiền");
        giaTien.setBounds(41, 140, 200, 30);
        add(giaTien);

        JTextField hoTen = new HintTextField("Họ tên");
        hoTen.setBounds(41, 190, 200, 30);
        add(hoTen);

        JTextField cccd = new HintTextField("CMND/CCCD");
        cccd.setBounds(41, 240, 200, 30);
        add(cccd);

        JTextField sdt = new HintTextField("Số điện thoại");
        sdt.setBounds(41, 290, 200, 30);
        add(sdt);

        JTextField email = new HintTextField("Email");
        email.setBounds(41, 340, 200, 30);
        add(email);

        JPanel dashedPanel = new JPanel();
        dashedPanel.setBorder(new DashedBorder(2, 5)); // Thiết lập viền nét đứt cho JPanel
        dashedPanel.setBounds(800, 50, 800, 400);
        add(dashedPanel);
        dashedPanel.setLayout(null);

        JLabel empty = new JLabel("");
        JLabel no1 = new JLabel("1");
        no1.setBounds(800, 20, 100, 30);
        no1.setBorder(getBorder());
        add(no1);
        empty.setBounds(900, 20, 20, 30);
        JLabel no2 = new JLabel("2");
        no2.setBounds(920, 20, 100, 30);
        add(no2);
        empty.setBounds(940, 20, 20, 30);
        JLabel no3 = new JLabel("3");
        no3.setBounds(1040, 20, 100, 30);
        add(no3);
        empty.setBounds(1140, 20, 100, 30);
        JLabel no4 = new JLabel("4");
        no4.setBounds(1240, 20, 100, 30);
        add(no4);
        empty.setBounds(1340, 20, 20, 30);
        JLabel no5 = new JLabel("5");
        no5.setBounds(1360, 20, 100, 30);
        add(no5);
        empty.setBounds(1460, 20, 20, 30);
        JLabel no6 = new JLabel("6");
        no6.setBounds(1480, 20, 100, 30);
        add(no6);
        empty.setBounds(1580, 20, 20, 30);

        JButton createButton = new JButton("Tạo vé");
        createButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        createButton.setBounds(41, 400, 100, 50);
        add(createButton);

        createTopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "CreateFlightTicket");
            }
        });

        searchTopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "SearchFlightTicket");
            }
        });
    }

    // Tạo viền bo tròn cho các nút
    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public class HintTextField extends JTextField implements FocusListener {
        private final String hint;
        private boolean showingHint;

        public HintTextField(final String hint) {
            super(hint);
            this.hint = hint;
            this.showingHint = true;
            super.addFocusListener(this);
            setForeground(Color.GRAY); // Màu văn bản gợi ý
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText("");
                showingHint = false;
                setForeground(Color.BLACK); // Màu văn bản thực
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(hint);
                showingHint = true;
                setForeground(Color.GRAY); // Màu văn bản gợi ý
            }
        }

        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
        }
    }

    public class DashedBorder implements Border {

        private int thickness;
        private int dashLength;

        public DashedBorder(int thickness, int dashLength) {
            this.thickness = thickness;
            this.dashLength = dashLength;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            float[] dash = {dashLength};
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
            g2d.drawRect(x, y, width - 1, height - 1);
            g2d.dispose();
        }
    }
}
