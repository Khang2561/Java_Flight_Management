package View.Admin.ChatBox;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatBox extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtNhp;
    private JTextArea textArea;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ChatBox() {
        setBackground(new Color(240, 240, 240));
        setBounds(0, 71, 1500, 642);
        setLayout(null);

        // LABEL CHAM SOC KHACH HANG
        JLabel lblChatBoxChm = new JLabel("CHATBOX CHĂM SÓC KHÁCH HÀNG ");
        lblChatBoxChm.setHorizontalAlignment(SwingConstants.CENTER);
        lblChatBoxChm.setForeground(new Color(0, 0, 160));
        lblChatBoxChm.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblChatBoxChm.setBounds(0, 10, 1500, 59);
        add(lblChatBoxChm);

        // TEXT AREA CHAT
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        textArea.setBounds(274, 67, 936, 400);
        add(textArea);

        // BUTTON GUI
        Button button_3 = new Button("GỬI");
        button_3.setForeground(Color.WHITE);
        button_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        button_3.setBackground(new Color(3, 4, 94));
        button_3.setBounds(988, 500, 222, 87);
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        add(button_3);
   

        // NHAP TIN NHAN
        txtNhp = new JTextField();
        txtNhp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(txtNhp);
        scrollPane.setBounds(274, 500, 698, 87);
        add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Connect to the server
        
        try {
            socket = new Socket("localhost", 4999);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create a thread to continuously receive messages from the server
            Thread receiveThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String serverResponse;
                        while ((serverResponse = in.readLine()) != null) {
                            appendMessageToTextArea("Server", serverResponse);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receiveThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = txtNhp.getText();
        if (!message.isEmpty()) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String sender = "You"; // Or get the sender's name from wherever it's stored
            String formattedMessage = "[" + timeStamp + "] " + sender + ": " + message + "\n";
            textArea.append(formattedMessage);
            out.println(message);
            txtNhp.setText(""); // Clear the text field after sending the message
        }
    }
    
  

    // Method to append a message to the JTextArea
    private void appendMessageToTextArea(String sender, String message) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String formattedMessage = "[" + timeStamp + "] " + sender + ": " + message + "\n";
        textArea.append(formattedMessage);
    }
    
    
    
    // Override the JPanel's finalize method to close the socket when the ChatBox is destroyed
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (socket != null) {
            socket.close();
        }
    }
}
