import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class Server extends JFrame {

    private static final int WINDOWS_HEIGHT = 400;
    private static final int WINDOWS_WIDTH = 507;
    private static final int WINDOWS_POSX = 800;
    private static final int WINDOWS_POSY = 300;


    private JTextArea chatArea;

    private JScrollPane scrollPane;

    private JPanel bottomPanel;

    private JButton startButton;

    private JButton stopButton;

    private boolean isRunning;

    private Client firstClient;

    private Client secondClient;


    Server() {
        firstClient = new Client(this);
        secondClient = new Client(this);
        setLocation(WINDOWS_POSX, WINDOWS_POSY);
        setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Server");
        setMainPanel();
        setBottomPanel();
        setVisible(true);
    }


    private void setMainPanel() {
        chatArea = new JTextArea();
        scrollPane = new JScrollPane();
        add(chatArea, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.WEST);
    }

    private void setBottomPanel() {
        bottomPanel = new JPanel(new GridLayout(1, 2));
        startButton = new JButton("Start");
        startButtonClick(startButton);
        stopButton = new JButton("Stop");
        stopButtonClick(stopButton);
        bottomPanel.add(startButton);
        bottomPanel.add(stopButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }


    private void startButtonClick(JButton button) {
        button.addActionListener(e -> {
            chatArea.append("Добро пожалвать. Сервер запущен " +
                    LocalDate.now());
            isRunning = true;
            firstClient.appendChatText(getPreviousChatArea());
            secondClient.appendChatText(getPreviousChatArea());
        });
    }

    private void stopButtonClick(JButton button) {
        button.addActionListener(e -> {
            chatArea.setText("Сервер выключен. Всего хорошего!");
            isRunning = false;
            saveCurrentChatArea();
        });
    }

    private String getPreviousChatArea() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void saveCurrentChatArea() {
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(this.firstClient.getChatText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean isRunning() {
        return isRunning;
    }

    public Client getFirstClient() {
        return firstClient;
    }

    public Client getSecondClient() {
        return secondClient;
    }
}
