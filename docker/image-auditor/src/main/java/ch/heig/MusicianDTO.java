package ch.heig;

import java.util.UUID;

public class MusicianDTO {
    private UUID uuid;
    private String sound;

    public UUID getUuid() {
        return uuid;
    }

    public Instrument getInstrument() {
        return switch (sound) {
            case "ti-ta-ti" -> Instrument.PIANO;
            case "pouet" -> Instrument.TRUMPET;
            case "trulu" -> Instrument.FLUTE;
            case "gzi-gzi" -> Instrument.VIOLIN;
            case "boum-boum" -> Instrument.DRUM;
            default -> null;
        };
    }
}
