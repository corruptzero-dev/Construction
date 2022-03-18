package ru.corruptzero;

public class BrickFactory extends Thread {

    private static BrickFactory INSTANCE = null;
    private int bricks = 0;
    private boolean isActive = true;

    private BrickFactory() {
    }

    public static BrickFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BrickFactory();
            INSTANCE.setName("Фабрика");
        }
        return INSTANCE;
    }

    @Override
    public void run() {
        makeABrick();
    }

    public void makeABrick() {
        while (isActive) {
            try {
                this.bricks++;
                System.out.println(this.getName() + " производит кирпич. На складе: " + bricks);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " прекращает работу.");
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getBricks() {
        return bricks;
    }

    public void setBricks(int bricks) {
        this.bricks = bricks;
    }
}
