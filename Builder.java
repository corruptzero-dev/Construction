package ru.corruptzero;

public class Builder extends Thread {
    private final House house = House.getInstance();
    private final BrickFactory brickFactory = BrickFactory.getInstance();
    private boolean isActive = true;
    private int bricks = 0;

    public Builder() {
        this.setName("Строитель");
    }

    @Override
    public void run() {
        build();
    }

    public void build() {
        while (isActive) {
            try {
                if (Weather.isSunny) {
                    if (this.bricks == 0) {
                        if (brickFactory.getBricks() != 0) {
                            System.out.println(this.getName() + " забрал " + brickFactory.getBricks() + " кирпичей.");
                            bricks = brickFactory.getBricks();
                            brickFactory.setBricks(0);
                        } else {
                            System.out.println(this.getName() + " ждет кирпичи");
                        }
                    } else {
                        if (bricks < 2) {
                            house.setBricks(house.getBricks() + bricks);
                            bricks = 0;
                        } else {
                            house.setBricks(house.getBricks() + 2);
                            bricks -= 2;
                        }
                        System.out.println(this.getName() + " кладет кирпичи");
                    }
                } else {
                    System.out.println(this.getName() + " ждет хорошей погоды");
                }
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
}
