package ch.heig;

import java.util.UUID;

public class MusicianDatagram {

    private final UUID uuid = UUID.randomUUID();
    private final String sound;

    public MusicianDatagram(String sound) {
        this.sound = sound;
    }
}
