package com.ford.swc.codesmells.HdataClumps.after2;

public class Players {
    private final Player player1;
    private final Player player2;

    public Players(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    boolean isLeadingPlayerPointsAtLeast(int minimumPoints) {
        return leader().arePointsAtLeast(minimumPoints);
    }

    private Player leader() {
        return player1.isLeadingOther(player2) ? player1 : player2;
    }

    boolean isLeaderLeadingByAtLeast2() {
        return leader().isLeadingOtherByAtLeast2(laggard());
    }

    private Player laggard() {
        return player2.isLeadingOther(player1) ? player1 : player2;
    }

    String leadersName() {
        return leader().getName();
    }

    boolean laggardPointsAtLeast(int minimumPoints) {
        return laggard().arePointsAtLeast(minimumPoints);
    }

    boolean isNotATie() {
        return !player1.pointsSameAsThatOf(player2);
    }

    boolean isATie() {
        return player1.pointsSameAsThatOf(player2);
    }

    boolean pointsAtMost(int maximumPoints) {
        return player1.arePointsAtMost(maximumPoints);
    }

    boolean pointsAtLeast(int minimumPoints) {
        return player1.arePointsAtLeast(minimumPoints);
    }

    String hyphenateScores() {
        return player1.determineScore() + "-" + player2.determineScore();
    }

    String playerScore() {
        return player1.determineScore();
    }
}
