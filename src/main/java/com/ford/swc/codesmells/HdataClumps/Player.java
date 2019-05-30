package com.ford.swc.codesmells.HdataClumps;

import com.ford.swc.codesmells.ElongMethod.PointsToScoreMapper;

public class Player {
    private int points;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void wonPoint() {
        points++;
    }

    String determineScore() {
        return new PointsToScoreMapper().mapPointsToScore(points);
    }

    boolean arePointsAtLeast(int minimumPoints) {
        return points >= minimumPoints;
    }

    boolean isLeadingOtherByAtLeast2(Player player2) {
        return (points - player2.points) >= 2;
    }

    boolean isLeadingOther(Player player2) {
        return points > player2.points;
    }

    boolean arePointsAtMost(int maximumPoints) {
        return points <= maximumPoints;
    }

    boolean pointsSameAsThatOf(Player player2) {
        return points == player2.points;
    }

    boolean isName(String playerName) {
        return getName().equals(playerName);
    }
}
