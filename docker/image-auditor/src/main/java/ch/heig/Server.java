package ch.heig;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.UTF_8;

class Server {

    private volatile boolean isRunning = true;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Server() {

    }

    public void StartServer(int port) {
        executor.submit(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {

                try (Socket client = serverSocket.accept()) {
                    client.getOutputStream().write("Hello World!".getBytes(UTF_8));
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
