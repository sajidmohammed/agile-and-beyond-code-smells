package com.ford.swc.codesmells.HdataClumps.after1;

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
        if (players.getPlayer1().arePointsAtLeast(4) && players.getPlayer1().isLeadingOtherByAtLeast2(players.getPlayer2())) {
            score = buildWin(players.getPlayer1().getName());
        }
        if (players.getPlayer2().arePointsAtLeast(4) && players.getPlayer2().isLeadingOtherByAtLeast2(players.getPlayer1())) {
            score = buildWin(players.getPlayer2().getName());
        }
        return score;
    }

    private String determineAdvantageScore(String score, Players players) {
        if (players.getPlayer1().isLeadingOther(players.getPlayer2()) && players.getPlayer2().arePointsAtLeast(3)) {
            score = buildAdvantage(players.getPlayer1().getName());
        }

        if (players.getPlayer2().isLeadingOther(players.getPlayer1()) && players.getPlayer1().arePointsAtLeast(3)) {
            score = buildAdvantage(players.getPlayer2().getName());
        }
        return score;
    }

    private String determineRegularScore(String score, Players players) {
        if (players.getPlayer1().isLeadingOther(players.getPlayer2()) && players.getPlayer1().arePointsAtMost(3)) {
            score = hyphenateScores(players.getPlayer1(), players.getPlayer2());
        }

        if (players.getPlayer2().isLeadingOther(players.getPlayer1()) && players.getPlayer2().arePointsAtMost(3)) {
            score = hyphenateScores(players.getPlayer1(), players.getPlayer2());
        }
        return score;
    }

    private String hyphenateScores(Player player1, Player player2) {
        return player1.determineScore() + "-" + player2.determineScore();
    }

    private String determineTieScore(String score, Players players) {
        if (players.getPlayer1().pointsSameAsThatOf(players.getPlayer2()) && players.getPlayer1().arePointsAtMost(3)) {
            score = players.getPlayer1().determineScore() + "-All";
        }

        if (players.getPlayer1().pointsSameAsThatOf(players.getPlayer2()) && players.getPlayer1().arePointsAtLeast(3))
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