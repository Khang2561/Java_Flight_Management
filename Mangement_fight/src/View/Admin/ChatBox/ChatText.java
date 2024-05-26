package View.Admin.ChatBox;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ChatText extends JTextPane {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	 public Color getBorderColor() {
	        return borderColor;
	    }

	    public void setBorderColor(Color borderColor) {
	        this.borderColor = borderColor;
	    }

	    public Color getBgColor() {
	        return bgColor;
	    }

	    public void setBgColor(Color bgColor) {
	        this.bgColor = bgColor;
	    }

	    public ChatText() {
	        setBackground(new Color(0, 0, 0, 0));
	    }

	  

	
	    Color borderColor = Color.BLUE;
	    Color bgColor = Color.green;
	    protected void painComponent(Graphics grphcs) {
	    	Graphics2D g2 = (Graphics2D) grphcs;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(bgColor);
	        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
	        g2.setColor(borderColor);
	        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 5, 5);
	        super.paintComponent(grphcs);
	    }

}
