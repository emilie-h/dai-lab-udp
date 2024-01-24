package ch.heig;

import java.util.*;

public class Main {

    final static String IPADDRESS = "239.255.22.5";
    final static int PORT = 9904;


    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Musician> l = Collections.synchronizedList(new ArrayList<Musician>());

        Server server = new Server();
        Receiver receiver = new Receiver();
        receiver.StartServer(IPADDRESS, PORT);
        server.StartServer(1234);


        //Timer timer = new Timer();
        //timer.schedule(new SayHello(), 0, 5000);

    }
}

class SayHello extends TimerTask {
    public void run() {
        System.out.println("Hello World!");
    }
}
