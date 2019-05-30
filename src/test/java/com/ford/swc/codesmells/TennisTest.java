package com.ford.swc.codesmells;

import com.ford.swc.codesmells.Acomments.TennisGameComments;
import com.ford.swc.codesmells.Bnames.TennisGameNamesSmell;
import com.ford.swc.codesmells.Bnames.TennisGameNamesSmellAfter;
import com.ford.swc.codesmells.Cidewarnings.TennisGameIdeWarnings;
import com.ford.swc.codesmells.Cidewarnings.TennisGameIdeWarningsAfter;
import com.ford.swc.codesmells.D1duplicate.TennisGameDuplicate;
import com.ford.swc.codesmells.D1duplicate.TennisGameDuplicateAfter;
import com.ford.swc.codesmells.D2longclass.TennisGameLongClass;
import com.ford.swc.codesmells.D2longclass.TennisGameLongClassAfter;
import com.ford.swc.codesmells.ElongMethod.TennisGameLongMethod;
import com.ford.swc.codesmells.ElongMethod.TennisGameLongMethodAfter;
import com.ford.swc.codesmells.Flongparameterlist.TennisGameLongParameterList;
import com.ford.swc.codesmells.Flongparameterlist.TennisGameLongParameterListAfter;
import com.ford.swc.codesmells.Gdataclass.after1.TennisGameDataClass;
import com.ford.swc.codesmells.HdataClumps.after1.TennisGameDataClumps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TennisTest {

    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public void checkAllScores(TennisGame game) {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.wonPoint("player1");
            if (i < this.player2Score)
                game.wonPoint("player2");
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @MethodSource("provideStringsForIsBlank")
    @ParameterizedTest
    public void checkAllScoresTennisGame1(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
        checkAllScores(new TennisGameComments("player1", "player2"));
        checkAllScores(new TennisGameNamesSmell("player1", "player2"));
        checkAllScores(new TennisGameNamesSmellAfter("player1", "player2"));
        checkAllScores(new TennisGameIdeWarnings("player1", "player2"));
        checkAllScores(new TennisGameIdeWarningsAfter("player1", "player2"));
        checkAllScores(new TennisGameDuplicate("player1", "player2"));
        checkAllScores(new TennisGameDuplicateAfter("player1", "player2"));
        checkAllScores(new TennisGameLongClass("player1", "player2"));
        checkAllScores(new TennisGameLongClassAfter("player1", "player2"));
        checkAllScores(new TennisGameLongMethod("player1", "player2"));
        checkAllScores(new TennisGameLongMethodAfter("player1", "player2"));
        checkAllScores(new TennisGameLongParameterList("player1", "player2"));
        checkAllScores(new TennisGameLongParameterListAfter("player1", "player2"));
        checkAllScores(new com.ford.swc.codesmells.Gdataclass.TennisGameDataClass("player1", "player2"));
        checkAllScores(new TennisGameDataClass("player1", "player2"));
        checkAllScores(new com.ford.swc.codesmells.Gdataclass.after1.TennisGameDataClass("player1", "player2"));
        checkAllScores(new com.ford.swc.codesmells.Gdataclass.afterWonPoint.afterwonpoint.TennisGameDataClass("player1", "player2"));
        checkAllScores(new TennisGameDataClumps("player1", "player2"));
        checkAllScores(new com.ford.swc.codesmells.HdataClumps.after1.TennisGameDataClumps("player1", "player2"));
        checkAllScores(new com.ford.swc.codesmells.HdataClumps.after2.TennisGameDataClumps("player1", "player2"));
        checkAllScores(new com.ford.swc.codesmells.HdataClumps.after3.TennisGameDataClumps("player1", "player2"));
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(0, 0, "Love-All"),
                Arguments.of(1, 1, "Fifteen-All"),
                Arguments.of(0, 0, "Love-All")   ,

                Arguments.of( 0, 0, "Love-All" ),
                Arguments.of( 1, 1, "Fifteen-All" ),
                Arguments.of( 2, 2, "Thirty-All"),
                Arguments.of( 3, 3, "Deuce"),
                Arguments.of( 4, 4, "Deuce"),

                Arguments.of( 1, 0, "Fifteen-Love"),
                Arguments.of( 0, 1, "Love-Fifteen"),
                Arguments.of( 2, 0, "Thirty-Love"),
                Arguments.of( 0, 2, "Love-Thirty"),
                Arguments.of( 3, 0, "Forty-Love"),
                Arguments.of( 0, 3, "Love-Forty"),
                Arguments.of( 4, 0, "Win for player1"),
                Arguments.of( 0, 4, "Win for player2"),

                Arguments.of( 2, 1, "Thirty-Fifteen"),
                Arguments.of( 1, 2, "Fifteen-Thirty"),
                Arguments.of( 3, 1, "Forty-Fifteen"),
                Arguments.of( 1, 3, "Fifteen-Forty"),
                Arguments.of( 4, 1, "Win for player1"),
                Arguments.of( 1, 4, "Win for player2"),

                Arguments.of( 3, 2, "Forty-Thirty"),
                Arguments.of( 2, 3, "Thirty-Forty"),
                Arguments.of( 4, 2, "Win for player1"),
                Arguments.of( 2, 4, "Win for player2"),

                Arguments.of( 4, 3, "Advantage player1"),
                Arguments.of( 3, 4, "Advantage player2"),
                Arguments.of( 5, 4, "Advantage player1"),
                Arguments.of( 4, 5, "Advantage player2"),
                Arguments.of( 15, 14, "Advantage player1"),
                Arguments.of( 14, 15, "Advantage player2"),

                Arguments.of( 6, 4, "Win for player1"),
                Arguments.of( 4, 6, "Win for player2"),
                Arguments.of( 16, 14, "Win for player1"),
                Arguments.of( 14, 16, "Win for player2")
        );
    }
}
