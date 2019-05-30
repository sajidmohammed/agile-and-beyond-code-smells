package com.ford.swc.codesmells.Acomments;

import com.ford.swc.codesmells.TennisGame;

public class TennisGameComments implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGameComments(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /**
     * A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
     * The running mapPointsToScore of each game is described in a manner peculiar to tennis: scores from zero to three points are described as "Love", "Fifteen", "Thirty", and "Forty" respectively.
     * If at least three points have been scored by each player, and the scores are equal, the mapPointsToScore is "Deuce".
     * If at least three points have been scored by each side and a player has one more point than his opponent, the mapPointsToScore of the game is "Advantage" for the player in the lead.
     *
     * @return display mapPointsToScore
     */
    @Override
    public String getScore(){
        String score = "";

        //Both player's points match and are at most 3
        if (P1point == P2point && P1point < 4)
        {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";
            score += "-All";
        }

        //Both payer's points match but points are at least 3
        if (P1point==P2point && P1point>=3)
            score = "Deuce";


        if (P1point > 0 && P2point==0)
        {
            if (P1point==1)
                P1res = "Fifteen";
            if (P1point==2)
                P1res = "Thirty";
            if (P1point==3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }


        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                P1res="Thirty";
            if (P1point==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (P1point==1)
                P1res="Fifteen";
            if (P1point==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }

        //Advantage Score
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }

        //Win Score
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1") //Do not generalize
            P1Score();
        else
            P2Score();
    }
}