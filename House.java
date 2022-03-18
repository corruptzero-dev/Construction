package ru.corruptzero;

public class House {
    private static House INSTANCE = null;
    private int bricks = 0;
    private int objective = 0;

    private House() {
    }

    public static House getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new House();
        }
        return INSTANCE;
    }

    public int getBricks() {
        return bricks;
    }

    public void setBricks(int bricks) {
        this.bricks = bricks;
    }

    public int getObjective() {
        return objective;
    }

    public void setObjective(int objective) {
        this.objective = objective;
    }
}
