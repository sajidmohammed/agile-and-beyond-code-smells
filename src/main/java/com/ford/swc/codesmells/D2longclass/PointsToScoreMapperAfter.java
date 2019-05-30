package com.ford.swc.codesmells.D2longclass;

public class PointsToScoreMapperAfter {
    public String mapPointsToScore(int points) {
        String score ="";

        if (points == 0)
            score = "Love";
        if (points == 1)
            score = "Fifteen";
        if (points == 2)
            score = "Thirty";
        if (points == 3) {
            score = "Forty";
        }
        return score;
    }
}
