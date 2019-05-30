package com.ford.swc.codesmells.Gdataclass.after1;

import com.ford.swc.codesmells.TennisGame;

public class TennisGameDataClass implements TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;
    private static final String PLAYER_1_NAME = "player1";
    private static final String PLAYER_2_NAME = "player2";

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
        if (player1.arePointsAtLeast(4) && player1.isLeadingOtherByAtLeast2(player2)) {
            score = buildWin(player1.getName());
        }
        if (player2.arePointsAtLeast(4) && player2.isLeadingOtherByAtLeast2(player1)) {
            score = buildWin(player2.getName());
        }
        return score;
    }

    private String determineAdvantageScore(String score, Player player1, Player player2) {
        if (player1.isLeadingOther(player2) && player2.arePointsAtLeast(3)) {
            score = buildAdvantage(player1.getName());
        }

        if (player2.isLeadingOther(player1) && player1.arePointsAtLeast(3)) {
            score = buildAdvantage(player2.getName());
        }
        return score;
    }

    private String determineRegularScore(String score, Player player1, Player player2) {

        if (player1.isLeadingOther(player2) && player1.isAtMost()) {
            score = hyphenateScores(player1, player2);
        }

        if (player2.isLeadingOther(player1) && player2.isAtMost()) {
            score = hyphenateScores(player1, player2);
        }
        return score;
    }

    private String hyphenateScores(Player player1, Player player2) {
        String score;
        String player1Score = player1.determineScore();
        String player2Score = player2.determineScore();
        score = player1Score + "-" + player2Score;
        return score;
    }

    private String determineTieScore(String score, Player player1, Player player2) {
        if (player1.pointsSameAsThatOf(player2) && player1.isAtMost()) {
            score = player1.determineScore() + "-All";
        }

        if (player1.pointsSameAsThatOf(player2) && player1.arePointsAtLeast(3))
            score = "Deuce";
        return score;
    }

    private String buildWin(String playerName) {
        return "Win for " + playerName;
    }

    private String buildAdvantage(String playerName) {
        return "Advantage " + playerName;
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