package database;

import server.ServerModel;
import java.io.*;

public class Database implements DataBaseModel {

    private String logFile;

    private ServerModel server;

    public Database(String logFile, ServerModel server) {
        this.logFile = logFile;
        this.server = server;
    }

    @Override
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(server.getLog());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String load() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
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

}
