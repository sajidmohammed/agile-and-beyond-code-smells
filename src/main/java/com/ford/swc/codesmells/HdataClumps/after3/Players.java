package com.ford.swc.codesmells.HdataClumps.after3;

public class Players {
    private final Player player1;
    private final Player player2;

    public Players(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    String hyphenateScores() {
        return player1.determineScore() + "-" + player2.determineScore();
    }

    public void pointWonByPlayerNamed(String playerName) {
        Player pointWinner = player1.isName(playerName) ? player1 : player2;
        pointWinner.wonPoint();
    }


    String leadersName() {
        return leader().getName();
    }

    String tiedScore() {
        return player1.determineScore();
    }

    boolean isLaggardPointsAtLeast3() {
        return !isATie() && laggard().arePointsAtLeast(3);
    }

    boolean isAtMost3AndNotATie() {
        return !isATie() && pointsAtMost(3);
    }

    boolean isTieAndAtMost3() {
        return isATie() && pointsAtMost(3);
    }

    boolean isTieAndAtLeast3() {
        return isATie() && pointsAtLeast(3);
    }


    boolean isLeaderPoints4AndLeadingByAtLeast2() {
        return isLeadingPlayerPointsAtLeast4() && isLeaderLeadingByAtLeast2();
    }

    private Player leader() {
        return player1.isLeadingOther(player2) ? player1 : player2;
    }

    private Player laggard() {
        return player2.isLeadingOther(player1) ? player1 : player2;
    }

    private boolean isATie() {
        return player1.pointsSameAsThatOf(player2);
    }

    private boolean pointsAtMost(int maximumPoints) {
        return player1.arePointsAtMost(maximumPoints);
    }

    private boolean pointsAtLeast(int minimumPoints) {
        return player1.arePointsAtLeast(minimumPoints);
    }

    private boolean isLeadingPlayerPointsAtLeast4() {
        return leader().arePointsAtLeast(4);
    }

    private boolean isLeaderLeadingByAtLeast2() {
        return leader().isLeadingOtherByAtLeast2(laggard());
    }
}
