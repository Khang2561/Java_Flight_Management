package View.Admin.TicketPlane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

public class SearchFlightTicket extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField searchField;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SearchFlightTicket(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(null);

        // Nút tạo vé (ở đầu trang)
        JButton createTopButton = new JButton("Tạo vé");
        createTopButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        createTopButton.setBounds(10, 11, 175, 53);
        add(createTopButton);

        // Nút tìm vé (ở đầu trang)
        JButton searchTopButton = new JButton("Tìm vé");
        searchTopButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchTopButton.setBounds(200, 11, 175, 53);
        add(searchTopButton);

        JLabel searchLabel = new JLabel("Nhập thông tin tìm kiếm:");
        searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchLabel.setBounds(10, 71, 180, 30);
        add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(200, 71, 200, 30);
        add(searchField);
        searchField.setColumns(10);

        JButton searchButton = new JButton("Tìm kiếm");
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchButton.setBounds(420, 71, 120, 30);
        add(searchButton);

        String[] columnNames = {
            "Mã vé", "Mã chuyến bay", "Họ tên", "CMND/CCCD", 
            "Số điện thoại", "Email", "Ghế", "Hạng vé", "Giá tiền"
        };

        Object[][] data = {
            // Data rows
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 112, 1460, 476);
        add(scrollPane);

        // Tự động co giãn cột theo nội dung
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().trim();
                if (!searchText.isEmpty()) {
                    // Logic tìm kiếm ở đây
                    // Ví dụ: lọc dữ liệu dựa trên searchText và cập nhật bảng
                }
            }
        });

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
}
