package ru.corruptzero;

import java.util.Random;

public class Weather extends Thread {
    public static boolean isSunny;
    private static boolean isActive = true;
    private final Random random = new Random();

    public static void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void run() {
        while (isActive) {
            isSunny = random.nextBoolean();
            System.out.println("Погода: " + (isSunny ? "солнечно" : "пасмурно"));
            try {
                Thread.sleep(random.nextLong(1000, 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
