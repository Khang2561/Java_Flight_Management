package View.Admin.TicketPlane;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

public class FlightTicket extends JPanel {

    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(100, 100, 800, 600);
                    FlightTicket flightTicketPanel = new FlightTicket();
                    frame.setContentPane(flightTicketPanel);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the panel.
     */
    public FlightTicket() {
        setBounds(100, 100, 1365, 520);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(0, 0, 1500, 520);
        add(mainPanel);

        JPanel flightTicketPanel = new JPanel();
        flightTicketPanel.setLayout(null);
        JButton creaButton = new JButton("Tạo vé \r\nmáy bay");
        creaButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        creaButton.setBounds(10, 11, 175, 53);
        flightTicketPanel.add(creaButton);

        JButton searchButton = new JButton("Tìm kiếm vé");
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchButton.setBounds(10, 75, 175, 53);
        flightTicketPanel.add(searchButton);

        mainPanel.add(flightTicketPanel, "FlightTicket");
        mainPanel.add(new CreateFlightTicket(), "CreateFlightTicket");
        mainPanel.add(new SearchFlightTicket(), "SearchFlightTicket");

        creaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "CreateFlightTicket");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "SearchFlightTicket");
            }
        });

        cardLayout.show(mainPanel, "FlightTicket");
    }
}
