package ch.heig;

import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

public class Musician {
    UUID id;
    Instrument instrument;
    Date lastActivity;
}

enum Instrument {
    PIANO("ti-ta-ti"),
    TRUMPET("pouet"),
    FLUTE("trulu"),
    VIOLIN("gzi-gzi"),
    DRUM("boum-boum");

    private final String sound;

    Instrument(String sound) {
        this.sound = sound;
    }
}
