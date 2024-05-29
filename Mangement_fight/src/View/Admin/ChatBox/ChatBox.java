package View.Admin.ChatBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import CustomUI.BtnCS;
import CustomUI.JtfCS;

public class ChatBox extends JPanel {

    private static final long serialVersionUID = 1L;
    private JtfCS txtNhp;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private JPanel chatShow;
    private BtnCS button_3;

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

        // BUTTON GUI
        button_3 = new BtnCS();
        button_3.setText("GỬI");
        button_3.setRadius(35);
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessageFromInput();
            }
        });
        button_3.setForeground(Color.WHITE);
        button_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        button_3.setBackground(new Color(3, 4, 94));
        button_3.setBounds(988, 500, 222, 87);
        add(button_3);

        // NHAP TIN NHAN
        txtNhp = new JtfCS();
        txtNhp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtNhp.setBounds(274, 500, 698, 87);
        txtNhp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessageFromInput();
            }
        });
        add(txtNhp);

        // PANEL CHỨA TIN NHẮN
        chatShow = new JPanel();
        chatShow.setLayout(new BoxLayout(chatShow, BoxLayout.Y_AXIS));
        chatShow.setBackground(Color.WHITE);

        // SCROLL PANE CHỨA PANEL TIN NHẮN
        JScrollPane scrollChatShow = new JScrollPane(chatShow);
        scrollChatShow.setBounds(274, 79, 936, 411);
        scrollChatShow.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollChatShow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollChatShow);

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

    private void sendMessageFromInput() {
        String text = txtNhp.getText();
        if (!text.trim().isEmpty()) {
            Item_right item = new Item_right(text);
            chatShow.add(item);
            chatShow.revalidate(); // Cập nhật giao diện
            chatShow.repaint();    // Vẽ lại giao diện
            sendMessage(text); // Gửi tin nhắn tới server
            txtNhp.setText(""); // Xóa nội dung sau khi gửi
        }
    }

    private void sendMessage(String message) {
        if (out != null && !message.trim().isEmpty()) {
            out.println(message);
        }
    }

    private void appendMessageToTextArea(String sender, String message) {
        Item_left item = new Item_left(message);
        chatShow.add(item);
        chatShow.revalidate();
        chatShow.repaint();
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
