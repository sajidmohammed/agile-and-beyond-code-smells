package com.ford.swc.codesmells.Cidewarnings;

import com.ford.swc.codesmells.TennisGame;

public class TennisGameIdeWarningsAfter implements TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;

    private String player1Score = "";
    private String player2Score = "";

    public TennisGameIdeWarningsAfter(String player1Name, String player2Name) {
    }

    @Override
    public String getScore() {
        String score = "";

        if (player1Points == player2Points && player1Points < 4) {
            if (player1Points == 0)
                score = "Love";
            if (player1Points == 1)
                score = "Fifteen";
            if (player1Points == 2)
                score = "Thirty";
            score += "-All";
        }

        if (player1Points == player2Points && player1Points >= 3)
            score = "Deuce";


        if (player1Points > 0 && player2Points == 0) {
            if (player1Points == 1)
                player1Score = "Fifteen";
            if (player1Points == 2)
                player1Score = "Thirty";
            if (player1Points == 3)
                player1Score = "Forty";

            player2Score = "Love";
            score = player1Score + "-" + player2Score;
        }


        if (player2Points > 0 && player1Points == 0) {
            if (player2Points == 1)
                player2Score = "Fifteen";
            if (player2Points == 2)
                player2Score = "Thirty";
            if (player2Points == 3)
                player2Score = "Forty";

            player1Score = "Love";
            score = player1Score + "-" + player2Score;
        }

        if (player1Points > player2Points && player1Points < 4) {
            if (player1Points == 2)
                player1Score = "Thirty";
            if (player1Points == 3)
                player1Score = "Forty";
            if (player2Points == 1)
                player2Score = "Fifteen";
            if (player2Points == 2)
                player2Score = "Thirty";
            score = player1Score + "-" + player2Score;
        }
        if (player2Points > player1Points && player2Points < 4) {
            if (player2Points == 2)
                player2Score = "Thirty";
            if (player2Points == 3)
                player2Score = "Forty";
            if (player1Points == 1)
                player1Score = "Fifteen";
            if (player1Points == 2)
                player1Score = "Thirty";
            score = player1Score + "-" + player2Score;
        }

        if (player1Points > player2Points && player2Points >= 3) {
            score = "Advantage player1";
        }

        if (player2Points > player1Points && player1Points >= 3) {
            score = "Advantage player2";
        }

        if (player1Points >= 4 && player2Points >= 0 && (player1Points - player2Points) >= 2) {
            score = "Win for player1";
        }
        if (player2Points >= 4 && player1Points >= 0 && (player2Points - player1Points) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private void incrementPlayer1Score() {
        player1Points++;
    }

    private void incrementPlayer2Score() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            incrementPlayer1Score();
        else
            incrementPlayer2Score();
    }
}