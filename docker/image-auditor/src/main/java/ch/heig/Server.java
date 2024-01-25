package ch.heig;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Server {

    private volatile boolean isRunning = true;
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Map<UUID, Musician> musicians;

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Server(Map<UUID, Musician> musicians) {
        this.musicians = musicians;
    }

    public void StartServer(int port) {
        executor.submit(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (isRunning) {
                    try (Socket client = serverSocket.accept()) {
                        System.out.println(musicians.size());
                        Date now = new Date();
                        now.setTime(now.getTime() - 5000);
                        for (UUID uuid : musicians.keySet()) {
                            if (now.compareTo(musicians.get(uuid).lastActivity) > 0) {
                                musicians.remove(uuid);
                            }
                        }
                        client.getOutputStream().write(new Gson().toJson(musicians.values()).getBytes());
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
