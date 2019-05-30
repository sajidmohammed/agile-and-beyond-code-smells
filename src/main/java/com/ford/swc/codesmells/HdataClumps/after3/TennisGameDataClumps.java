package com.ford.swc.codesmells.HdataClumps.after3;

import com.ford.swc.codesmells.TennisGame;

public class TennisGameDataClumps implements TennisGame {
    private Players players;

    public TennisGameDataClumps(String player1Name, String player2Name) {
        players = new Players("player1", "player2");
    }

    @Override
    public String getScore() {

        String score = "";
        score = determineTieScore(score, players);
        score = determineRegularScore(score, players);
        score = determineAdvantageScore(score, players);
        score = determineWinScore(score, players);
        return score;
    }

    private String determineWinScore(String score, Players players) {
        if (players.isLeaderPoints4AndLeadingByAtLeast2()) {
            score = "Win for " + players.leadersName();
        }
        return score;
    }

    private String determineAdvantageScore(String score, Players players) {
        if (players.isLaggardPointsAtLeast3()) {
            score = "Advantage " + players.leadersName();
        }
        return score;
    }

    private String determineRegularScore(String score, Players players) {
        if (players.isAtMost3AndNotATie()) {
            score = players.hyphenateScores();
        }
        return score;
    }

    private String determineTieScore(String score, Players players) {
        if (players.isTieAndAtMost3()) {
            score = players.tiedScore() + "-All";
        }

        if (players.isTieAndAtLeast3())
            score = "Deuce";
        return score;
    }

    public void wonPoint(String player) {
        players.pointWonByPlayerNamed(player);
    }

}