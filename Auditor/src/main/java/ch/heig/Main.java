package ch.heig;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Timer timer = new Timer();
        timer.schedule(new SayHello(), 0, 5000);

    }
}
class SayHello extends TimerTask {
    public void run() {
        System.out.println("Hello World!");
    }
}
