package com.ford.swc.codesmells.Gdataclass;

import com.ford.swc.codesmells.ElongMethod.PointsToScoreMapper;
import com.ford.swc.codesmells.TennisGame;

public class TennisGameDataClass implements TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;
    private static final String PLAYER_1_NAME = "player1";
    private static final String PLAYER_2_NAME = "player2";
    private PointsToScoreMapper pointsToScoreMapper = new PointsToScoreMapper();

    public TennisGameDataClass(String player1Name, String player2Name) {
    }

    @Override
    public String getScore() {
        Player player1 = new Player(this.player1Points, PLAYER_1_NAME);
        Player player2 = new Player(this.player2Points, PLAYER_2_NAME);

        String score = "";
        score = determineTieScore(score, player1, player2);
        score = determineRegularScore(score, player1, player2);
        score = determineAdvantageScore(score, player1, player2);
        score = determineWinScore(score, player1, player2);
        return score;
    }

    private String determineWinScore(String score, Player player1, Player player2) {
        if (pointsAreAtLeast4(player1.getPoints()) && pointsAreAtLeast0(player2.getPoints()) && pointsDifferenceAtLeast2(player1.getPoints(), player2.getPoints())) {
            score = buildWin(player1.getName());
        }
        if (pointsAreAtLeast4(player2.getPoints()) && pointsAreAtLeast0(player1.getPoints()) && pointsDifferenceAtLeast2(player2.getPoints(), player1.getPoints())) {
            score = buildWin(player2.getName());
        }
        return score;
    }

    private String determineAdvantageScore(String score, Player player1, Player player2) {
        if (player1.getPoints() > player2.getPoints() && pointsAreAtLeast3(player2.getPoints())) {
            score = buildAdvantage(player1.getName());
        }

        if (player2.getPoints() > player1.getPoints() && pointsAreAtLeast3(player1.getPoints())) {
            score = buildAdvantage(player2.getName());
        }
        return score;
    }

    private String determineRegularScore(String score, Player player1, Player player2) {
        if (pointsAreGreaterThan0(player1.getPoints()) && pointsAreZero(player2.getPoints())) {
            score = buildRegularScore(player1.getPoints(), player2.getPoints());
        }

        if (pointsAreGreaterThan0(player2.getPoints()) && pointsAreZero(player1.getPoints())) {
            score = buildRegularScore(player1.getPoints(), player2.getPoints());
        }

        if (player1.getPoints() > player2.getPoints() && pointsAreAtMost3(player1.getPoints())) {
            score = buildRegularScore(player1.getPoints(), player2.getPoints());
        }

        if (player2.getPoints() > player1.getPoints() && pointsAreAtMost3(player2.getPoints())) {
            score = buildRegularScore(player1.getPoints(), player2.getPoints());
        }
        return score;
    }

    private String determineTieScore(String score, Player player1, Player player2) {
        if (pointsAreTied(player1.getPoints(), player2.getPoints()) && pointsAreAtMost3(player1.getPoints())) {
            score = pointsToScoreMapper.mapPointsToScore(player1.getPoints()) + "-All";
        }

        if (pointsAreTied(player1.getPoints(), player2.getPoints()) && pointsAreAtLeast3(player1.getPoints()))
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