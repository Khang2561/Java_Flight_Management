package CustomUI.Table;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class TableActionButton extends JButton {

    private boolean mousePress;

    public TableActionButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                mousePress = true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                mousePress = false;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        // Remove custom painting logic here
        super.paintComponent(grphcs);
    }

    public void setIcon(ImageIcon icon) {
    	 super.setIcon(icon);
         // Ensure the button's size fits the icon with padding
         setPreferredSize(new java.awt.Dimension(icon.getIconWidth() + 10, icon.getIconHeight() + 10));
    }

}