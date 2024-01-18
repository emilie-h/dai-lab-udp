package ch.heig;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.HashMap;

import static java.nio.charset.StandardCharsets.*;

class Musician {
    final static String IPADDRESS = "239.255.22.5";
    final static int PORT = 9904;


    public static void main(String[] args) {
        HashMap<String, String> instruments = new HashMap<>();
        instruments.put("piano", "ti-ta-ti");
        instruments.put("trumpet", "pouet");
        instruments.put("flute", "trulu");
        instruments.put("violin", "gzi-gzi");
        instruments.put("drum", "boum-boum");

        // get instrument from command line arguments
        String instrument = args[0];
        if (instrument == null) {
            System.out.println("Please specify an instrument");
            System.exit(1);
        } else if (!instruments.containsKey(instrument)) {
            System.out.println("Please specify a valid instrument");
            System.exit(1);
        }
        play(instrument, instruments);

    }

    static void play(String instrument, HashMap<String, String> instruments) {
        try (DatagramSocket socket = new DatagramSocket()) {
            while (true) {
                String sound = instruments.get(instrument);
                byte[] payload = sound.getBytes(UTF_8);
                InetSocketAddress dest_address = new InetSocketAddress(IPADDRESS, PORT);
                var packet = new DatagramPacket(payload, payload.length, dest_address);
                socket.send(packet);
                Thread.sleep(1000);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
