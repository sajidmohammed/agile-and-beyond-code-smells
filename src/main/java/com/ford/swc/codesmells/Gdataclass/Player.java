package com.ford.swc.codesmells.Gdataclass;

public class Player {
    private final int points;
    private final String name;

    public Player(int points, String name) {
        this.points = points;
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
