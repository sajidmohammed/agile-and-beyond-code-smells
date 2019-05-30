package com.ford.swc.codesmells.HdataClumps.after2;

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
        Players players = new Players(player1, player2);
        score = determineTieScore(score, players);
        score = determineRegularScore(score, players);
        score = determineAdvantageScore(score, players);
        score = determineWinScore(score, players);
        return score;
    }

    private String determineWinScore(String score, Players players) {
        if (players.isLeadingPlayerPointsAtLeast(4) && players.isLeaderLeadingByAtLeast2()) {
            score = "Win for " + players.leadersName();
        }
        return score;
    }

    private String determineAdvantageScore(String score, Players players) {
        if (players.isNotATie() && players.laggardPointsAtLeast(3)) {
            score = "Advantage " + players.leadersName();
        }
        return score;
    }

    private String determineRegularScore(String score, Players players) {
        if (players.isNotATie() && players.pointsAtMost(3)) {
            score = players.hyphenateScores();
        }
        return score;
    }

    private String determineTieScore(String score, Players players) {
        if (players.isATie() && players.pointsAtMost(3)) {
            score = players.playerScore() + "-All";
        }

        if (players.isATie() && players.pointsAtLeast(3))
            score = "Deuce";
        return score;
    }

    public void wonPoint(String player) {
        if (player1.isName(player))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

}