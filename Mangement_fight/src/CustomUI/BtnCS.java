package CustomUI;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BtnCS extends JButton {
	public BtnCS() {
        // Init Color
        setColor(Color.white);
        colorOver = new Color(179, 250, 160);
        colorClick = new Color(152, 184, 56);
        borderColor = new Color(30, 136, 56);

        setContentAreaFilled(false);
        setOpaque(false); // Make button non-opaque to fully control painting

        // Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorOver);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
        });
	}
        
      //-------------------------------------------
        private boolean over;
        private Color color;
        private Color colorOver;
        private Color colorClick;
        private Color borderColor;
        private int radius = 15;

        //---------------------------------------------
        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
            setBackground(color);
        }

        public Color getColorOver() {
            return colorOver;
        }

        public void setColorOver(Color colorOver) {
            this.colorOver = colorOver;
        }

        public Color getColorClick() {
            return colorClick;
        }

        public void setColorClick(Color colorClick) {
            this.colorClick = colorClick;
        }

        public Color getBorderColor() {
            return borderColor;
        }

        public void setBorderColor(Color borderColor) {
            this.borderColor = borderColor;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        //-------------------------------------------
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g; // Use the provided Graphics object
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Paint Background
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

            // Paint Border
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

            // Ensure text is rendered correctly
            g2.setClip(new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            // Do nothing to prevent default border painting
        }
        
        @Override
        protected void paintChildren(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setClip(new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
            super.paintChildren(g2);
            g2.dispose();
        }
}
