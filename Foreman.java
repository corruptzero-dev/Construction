package ru.corruptzero;

public class Foreman extends Thread {
    private final Builder builder = new Builder();
    private final BrickFactory brickFactory = BrickFactory.getInstance();

    private final House house = House.getInstance();

    public Foreman() {
        this.setName("Прораб");
    }

    @Override
    public void run() {
        house.setObjective(100);
        brickFactory.start();
        builder.start();
        while (true) {
            if (house.getBricks() >= house.getObjective()) {
                System.out.println(this.getName() + ": Работа окончена!");
                builder.setActive(false);
                brickFactory.setActive(false);
                Weather.setActive(false);
                break;
            }
            System.out.println(this.getName() + ": Еще нужно " + (house.getObjective() - house.getBricks()) + " кирпичей");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
