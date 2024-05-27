package View.Admin.ChatBox;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item_left extends JPanel {

    private static final long serialVersionUID = 1L;
    private ChatText txt;
    private JLabel jLabel1;
    private JLabel lblTimestamp;

    public Item_left(String text) {
        initComponents();
        txt.setText(text);
        lblTimestamp.setText(getCurrentTimestamp());
    }

    private void initComponents() {
        txt = new ChatText();
        jLabel1 = new JLabel();
        lblTimestamp = new JLabel();
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Resource/chatrobotavatar.png")));

        txt.setEditable(false);
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        txt.setBgColor(new Color(221, 246, 255));
        txt.setBorderColor(new Color(6, 126, 183));
        lblTimestamp.setFont(new Font("Tahoma", Font.ITALIC, 10));
        lblTimestamp.setForeground(Color.GRAY);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(46)
                    .addComponent(lblTimestamp))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblTimestamp)
                    .addGap(0, 0, 0))
        );
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
