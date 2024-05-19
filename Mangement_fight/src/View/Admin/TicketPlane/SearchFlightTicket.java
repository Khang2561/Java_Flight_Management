package View.Admin.TicketPlane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchFlightTicket extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField searchField;

    public SearchFlightTicket() {
        setLayout(null);

        JLabel searchLabel = new JLabel("Nhập thông tin tìm kiếm:");
        searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchLabel.setBounds(10, 10, 180, 30);
        add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(200, 10, 200, 30);
        add(searchField);
        searchField.setColumns(10);

        JButton searchButton = new JButton("Tìm kiếm");
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchButton.setBounds(420, 10, 120, 30);
        add(searchButton);

        String[] columnNames = {
            "Mã vé", "Mã chuyến bay", "Họ tên", "CMND/CCCD", 
            "Số điện thoại", "Email", "Ghế", "Hạng vé", "Giá tiền"
        };

        Object[][] data = {
            
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 1500, 500);
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

                // We've exceeded the maximum width, no need to check other rows
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
    }
}
