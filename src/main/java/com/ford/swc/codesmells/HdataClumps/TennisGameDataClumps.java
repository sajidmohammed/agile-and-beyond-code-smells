package com.ford.swc.codesmells.HdataClumps;

import com.ford.swc.codesmells.TennisGame;

public class TennisGameDataClumps implements TennisGame {
    private Player player1;
    private Player player2;

    public TennisGameDataClumps(String player1Name, String player2Name) {
        player1 = new Player("player1");
        player2 = new Player("player2");
    }

    @Override
    public String getScore() {

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
        if (player1.isLeadingOther(player2) && player1.arePointsAtMost(3)) {
            score = hyphenateScores(player1, player2);
        }

        if (player2.isLeadingOther(player1) && player2.arePointsAtMost(3)) {
            score = hyphenateScores(player1, player2);
        }
        return score;
    }

    private String hyphenateScores(Player player1, Player player2) {
        return player1.determineScore() + "-" + player2.determineScore();
    }

    private String determineTieScore(String score, Player player1, Player player2) {
        if (player1.pointsSameAsThatOf(player2) && player1.arePointsAtMost(3)) {
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

    public void wonPoint(String player) {
        if (player1.isName(player))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

}