import client.Client;
import client.ClientGUI;
import server.Server;
import server.ServerGUI;

public class Main {

    public static void main(String[] args) {

        Server server = new Server(new ServerGUI());
        Client firstClient = new Client(new ClientGUI());
        Client secondClient = new Client(new ClientGUI());
        firstClient.setServer(server);
        secondClient.setServer(server);

    }

}
