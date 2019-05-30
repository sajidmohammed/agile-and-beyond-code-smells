package com.ford.swc.codesmells.ElongMethod;

import com.ford.swc.codesmells.TennisGame;

public class TennisGameLongMethodAfter implements TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;
    private static final String PLAYER_1_NAME = "player1";
    private static final String PLAYER_2_NAME = "player2";
    private PointsToScoreMapper pointsToScoreMapper = new PointsToScoreMapper();

    public TennisGameLongMethodAfter(String player1Name, String player2Name) {
    }

    @Override
    public String getScore() {
        String score = "";
        score = determineTieScore(score, this.player1Points, this.player2Points);
        score = determineRegularScore(score, this.player1Points, this.player2Points);
        score = determineAdvantageScore(score, this.player1Points, this.player2Points, PLAYER_1_NAME, PLAYER_2_NAME);
        score = determineWinScore(score, this.player1Points, this.player2Points, PLAYER_1_NAME, PLAYER_2_NAME);
        return score;
    }

    private String determineWinScore(String score, int player1Points, int player2Points, String player1Name, String player2Name) {
        if (pointsAreAtLeast4(player1Points) && pointsAreAtLeast0(player2Points) && pointsDifferenceAtLeast2(player1Points, player2Points)) {
            score = buildWin(player1Name);
        }
        if (pointsAreAtLeast4(player2Points) && pointsAreAtLeast0(player1Points) && pointsDifferenceAtLeast2(player2Points, player1Points)) {
            score = buildWin(player2Name);
        }
        return score;
    }

    private String determineAdvantageScore(String score, int player1Points, int player2Points, String player1Name, String player2Name) {
        if (player1Points > player2Points && pointsAreAtLeast3(player2Points)) {
            score = buildAdvantage(player1Name);
        }

        if (player2Points > player1Points && pointsAreAtLeast3(player1Points)) {
            score = buildAdvantage(player2Name);
        }
        return score;
    }

    private String determineRegularScore(String score, int player1Points, int player2Points) {
        if (pointsAreGreaterThan0(player1Points) && pointsAreZero(player2Points)) {
            score = buildRegularScore(player1Points, player2Points);
        }

        if (pointsAreGreaterThan0(player2Points) && pointsAreZero(player1Points)) {
            score = buildRegularScore(player1Points, player2Points);
        }

        if (player1Points > player2Points && pointsAreAtMost3(player1Points)) {
            score = buildRegularScore(player1Points, player2Points);
        }

        if (player2Points > player1Points && pointsAreAtMost3(player2Points)) {
            score = buildRegularScore(player1Points, player2Points);
        }
        return score;
    }

    private String determineTieScore(String score, int points, int player2Points) {
        if (pointsAreTied(points, player2Points) && pointsAreAtMost3(points)) {
            score = pointsToScoreMapper.mapPointsToScore(points) + "-All";
        }

        if (pointsAreTied(points, player2Points) && pointsAreAtLeast3(points))
            score = "Deuce";
        return score;
    }

    private boolean pointsDifferenceAtLeast2(int points1, int points2) {
        return (points1 - points2) >= 2;
    }

    private boolean pointsAreAtLeast0(int points) {
        return points >= 0;
    }

    private boolean pointsAreAtLeast4(int points) {
        return points >= 4;
    }

    private boolean pointsAreAtLeast3(int points) {
        return points >= 3;
    }

    private boolean pointsAreZero(int points) {
        return points == 0;
    }

    private boolean pointsAreGreaterThan0(int points) {
        return points > 0;
    }

    private boolean pointsAreTied(int points, int player2Points) {
        return points == player2Points;
    }

    private boolean pointsAreAtMost3(int points) {
        return points < 4;
    }

    private String buildWin(String playerName) {
        return "Win for " + playerName;
    }

    private String buildAdvantage(String playerName) {
        return "Advantage " + playerName;
    }

    private String buildRegularScore(int player1Points, int player2Points) {
        String player1Score = pointsToScoreMapper.mapPointsToScore(player1Points);
        String player2Score = pointsToScoreMapper.mapPointsToScore(player2Points);
        return player1Score + "-" + player2Score;
    }

    private void incrementPlayer1Score() {
        player1Points++;
    }

    private void incrementPlayer2Score() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (PLAYER_1_NAME.equals(player))
            incrementPlayer1Score();
        else
            incrementPlayer2Score();
    }
}