package com.ford.swc.codesmells.Flongparameterlist;

public class PlayerAfter {
    private final int player1Points;
    private final String player1Name;

    public PlayerAfter(int player1Points, String player1Name) {
        this.player1Points = player1Points;
        this.player1Name = player1Name;
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public String getPlayer1Name() {
        return player1Name;
    }
}
