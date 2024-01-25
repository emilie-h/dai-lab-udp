package ch.heig;

import java.util.Date;
import java.util.UUID;

public class Musician {

    UUID id;
    Instrument instrument;
    Date lastActivity;

    public Musician(UUID uuid, Instrument instrument) {
        this.id = uuid;
        this.instrument = instrument;
        this.lastActivity = new Date();
    }
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
