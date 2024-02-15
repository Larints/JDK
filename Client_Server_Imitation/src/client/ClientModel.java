package client;

public interface ClientModel {

    void sendMessage(String message);

    String getChatText();

    void setLogin(String login);

    void setPassword(String password);

    void sentDate();
}
