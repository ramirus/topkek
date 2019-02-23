package sample.clients;

import java.io.*;
import java.net.Socket;

import static java.lang.System.out;

public class ClientPlayer {
    private Socket clientSocket;
    private PrintWriter pW;
    private BufferedReader bR;
    private String name;

    public ClientPlayer(String name){
        this.name=name;
    }

    public void connect(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            pW = new PrintWriter(clientSocket.getOutputStream(), true);
            bR = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            new Thread(receiver).start();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void sendMes(String mes) {
        out.println(mes);
    }

    private Runnable receiver = new Runnable() {
        @Override
        public void run() {
            while (true) {
                String resp;
                try {
                    resp = bR.readLine();
                    if (resp != null) {
                        out.println(resp);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    };

    public void stopCon() {
        try {
            bR.close();
            pW.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public String getName() {
        return name;
    }
}
