package client;

import server.Server;

public class Client implements ClientModel {

    private UserData userData;

    private boolean isAuthenticated;

    private final ClientGUI clientGUI;

    private Server server;

    public Client(ClientGUI clientGUI) {
        this.clientGUI = clientGUI;
        this.clientGUI.setClientModel(this);
        userData = new UserData();
    }


    @Override
    public void sendMessage(String message) {
        if (isAuthenticated) {
            server.receivingMessage(this.userData.getUsername() + ":" + message);
        } else appendChatText("Вы не подключены к серверу!");
    }

    public String getChatText() {
        return clientGUI.getChatText();
    }

    @Override
    public void setLogin(String login) {
        userData.setUsername(login);
    }

    @Override
    public void setPassword(String password) {
        userData.setPassword(password);
    }

    @Override
    public void sentDate() {
        isAuthenticated = true;
        this.server.addClient(this);
    }

    public void appendChatText(String chatText) {
        clientGUI.updateChatText(chatText);
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
