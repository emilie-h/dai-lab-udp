package ch.heig;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    final static String IPADDRESS = "239.255.22.5";
    final static int PORT = 9904;


    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<UUID, Musician> musicians = new ConcurrentHashMap<>();

        Server server = new Server(musicians);
        Receiver receiver = new Receiver(musicians);
        receiver.StartServer(IPADDRESS, PORT);
        server.StartServer(2205);
    }
}
