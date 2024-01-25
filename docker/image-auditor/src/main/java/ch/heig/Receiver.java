package ch.heig;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Receiver {


    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private volatile boolean isRunning = true;
    private Map<UUID, Musician> musicians;

    public Receiver(Map<UUID, Musician> musicians) {
        this.musicians = musicians;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void StartServer(String ipaddress, int port) {
        executor.submit(() -> {
            try (MulticastSocket socket = new MulticastSocket(port)) {
                InetSocketAddress group_address = new InetSocketAddress(ipaddress, port);
                NetworkInterface netif = NetworkInterface.getByName("eth0");
                socket.joinGroup(group_address, netif);

                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                Gson gson = new Gson();
                System.out.println("Lisening");
                while (isRunning) {
                    socket.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength(), UTF_8);
                    MusicianDTO musician = gson.fromJson(message, MusicianDTO.class);
                    musicians.put(musician.getUuid(), new Musician(musician.getUuid(), musician.getInstrument()));
                    System.out.println("Received message: " + message + " from " + packet.getAddress() + ", port " + packet.getPort());
                }

                socket.leaveGroup(group_address, netif);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
}
