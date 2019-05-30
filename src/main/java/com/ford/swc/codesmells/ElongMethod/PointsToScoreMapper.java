package com.ford.swc.codesmells.ElongMethod;

import java.util.Map;

public class PointsToScoreMapper {
    public String mapPointsToScore(int points) {
        Map<Integer, String> pointsToScoreMap = Map.of(
                0, "Love",
                1, "Fifteen",
                2, "Thirty",
                3, "Forty"
        );

        return pointsToScoreMap.getOrDefault(points, "");
    }
}
