package ch.heig;

import com.google.gson.annotations.SerializedName;

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
    @SerializedName("piano")
    PIANO("ti-ta-ti"),
    @SerializedName("trumpet")
    TRUMPET("pouet"),
    @SerializedName("flute")
    FLUTE("trulu"),
    @SerializedName("violin")
    VIOLIN("gzi-gzi"),
    @SerializedName("drum")
    DRUM("boum-boum");

    private final String sound;

    Instrument(String sound) {
        this.sound = sound;
    }
}
