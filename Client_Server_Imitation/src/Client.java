import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {

    private static final int WINDOWS_HEIGHT = 400;
    private static final int WINDOWS_WIDTH = 507;
    private static final int WINDOWS_POSX = 800;
    private static final int WINDOWS_POSY = 300;

    private JPanel topPanel;

    private JPanel addressPanel;

    private JTextField addressField;

    private JTextField portField;

    private JPanel authenticationPanel;

    private JTextField loginField;

    private JPasswordField passwordField;

    private JButton loginButton;

    private JScrollPane scrollPanel;


    private JTextArea chat;


    private JPanel bottomPanel;

    private JTextField sendField;

    private JButton sendButton;

    private Server server;

    private Client client;

    Client(Server server) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(WINDOWS_POSX, WINDOWS_POSY);
        setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
        setTitle("Client");
        setTopPanel();
        setChat();
        setScrollArea();
        setBottomPanel();
        setVisible(true);
        this.server = server;
    }


    private void setTopPanel() {
        topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(setAddressPanel());
        topPanel.add(setAuthenticationPanel());
        add(topPanel, BorderLayout.NORTH);
    }

    private JPanel setAddressPanel() {
        addressPanel = new JPanel(new GridLayout(1, 2));
        addressPanel.add(addressField = new JTextField("127.0.0.1"));
        addressPanel.add(portField = new JTextField("8181"));
        addressPanel.add(new JPanel());
        add(addressPanel, BorderLayout.NORTH);
        return addressPanel;
    }

    private JPanel setAuthenticationPanel() {
        authenticationPanel = new JPanel(new GridLayout(1, 3));
        loginField = new JTextField("Login");
        passwordField = new JPasswordField("Password");
        passwordField.setEchoChar('*');
        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            loginField.setText(loginField.getText());
            passwordField.setText(passwordField.getText());
        });
        authenticationPanel.add(loginField);
        authenticationPanel.add(passwordField);
        authenticationPanel.add(loginButton);
        add(authenticationPanel, BorderLayout.NORTH);
        return authenticationPanel;
    }

    private void setChat() {
        chat = new JTextArea();
        chat.setLineWrap(true);
        chat.setEditable(false);
        add(chat, BorderLayout.CENTER);
    }

    private void setScrollArea() {
        scrollPanel = new JScrollPane();
        add(scrollPanel, BorderLayout.EAST);
    }

    private void setBottomPanel() {
        bottomPanel = new JPanel(new GridLayout(1, 2));
        sendField = new JTextField(" ");
        sendField.setSize(50, 50);
        sendButton = new JButton("Send");
        sendMessage(sendButton, sendField, chat);
        bottomPanel.add(sendField);
        bottomPanel.add(sendButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }


    private void sendMessage(JButton button, JTextField field, JTextArea textArea) {
        button.addActionListener(e -> {
            if (server.isRunning()) {
                String text = field.getText();
                field.setText("");
                textArea.append(this.loginField.getText() + ": " + text + "\n");
                this.client = server.getFirstClient();
                if (client == this) client = server.getSecondClient();
                client.appendChatText(this.loginField.getText() + ": " + text + "\n");

            } else textArea.setText("Извините сервер выключен!");
        });
    }


    public String getChatText() {
        return this.chat.getText();
    }

    public void appendChatText(String chatText) {
        chat.append(chatText);
    }


}
