package com.ford.swc.codesmells.Gdataclass.after1;

import com.ford.swc.codesmells.ElongMethod.PointsToScoreMapper;

public class Player {
    private final int points;
    private final String name;

    public Player(int points, String name) {
        this.points = points;
        this.name = name;
    }

    public String getName() {
        return name;
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

    boolean isAtMost() {
        return points <= 3;
    }

    boolean pointsSameAsThatOf(Player player2) {
        return points == player2.points;
    }
}
