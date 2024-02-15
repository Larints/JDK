package server;

import client.Client;
import database.DataBaseModel;
import database.Database;

import java.util.ArrayList;
import java.util.List;


public class Server implements ServerModel {

    private List<Client> clients;

    private boolean status;

    private DataBaseModel dataBase;

    private ServerGUI serverGUI;


    public Server(ServerGUI serverGUI) {
        clients = new ArrayList<>();
        dataBase = new Database("log.txt", this);
        this.serverGUI = serverGUI;
        this.serverGUI.setServerModel(this);
    }


    @Override
    public void start() {
        appendText(dataBase.load());
        status = true;
    }

    @Override
    public void stop() {
        dataBase.save();
        status = false;
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public String getLog() {
        return this.clients.get(0).getChatText();
    }

    @Override
    public void receivingMessage(String message) {
        if (status) {
            appendText(message);
        } else appendText("Сервер сейчас выключен\n");
    }


    @Override
    public void addClient(Client client) {
        this.clients.add(client);
    }

    private void appendText(String message) {
        for (Client client : clients) {
            client.appendChatText(message + "\n");
        }
    }

}
