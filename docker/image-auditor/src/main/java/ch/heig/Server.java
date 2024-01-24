package ch.heig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.UTF_8;

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
                        client.getOutputStream().write("Hello World!".getBytes(UTF_8));
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
