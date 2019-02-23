package sample.servers;

import sample.clients.ClientPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.System.in;
import static java.lang.System.out;

public class Server {
    private List<PlayerHan> players;

    public Server() {
        players = new CopyOnWriteArrayList<>();
    }

    public void start(int port) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                new PlayerHan(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class PlayerHan extends Thread {
        private Socket clientSocket;
        private BufferedReader bR;

        PlayerHan(Socket socket) {
            players.add(this);
            out.println("new player");
        }

        public void run() {
            try {
                bR = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String input;
                while ((input = bR.readLine()) != null) {
                    if (".".equals(input)) {
                        for (PlayerHan playerHan : players) {
                            PrintWriter pW = new PrintWriter(playerHan.clientSocket.getOutputStream(), true);
                        }
                    } else {
                        for (PlayerHan playerHan : players) {
                            PrintWriter pW = new PrintWriter(playerHan.clientSocket.getOutputStream(), true);
                            out.println(input);
                        }
                    }
                }
                bR.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
