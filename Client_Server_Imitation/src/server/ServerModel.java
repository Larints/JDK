package server;

import client.Client;

public interface ServerModel {

    void start();

    void stop();

    boolean getStatus();

    String getLog();

    void receivingMessage(String message);

    void addClient(Client client);
}
