package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SoccerLeagueTest {

    private static final List<String> results = DataHelper.readLineByLine("/Users/HU900849/Desktop/CodeKata/CodeKata-04/src/main/resources/football.dat");

    private static final SoccerLeague soccerLeague = new SoccerLeague();

    @Test
    void findSmallestDiff2Test() {
        //Arrange
        int expectedDiff = 1;

        //Act
        int actualDiff = soccerLeague.findSmallestDiff(results);

        //Assert
        assertEquals(expectedDiff, actualDiff);
    }

    @Test
    void findWinnerTeamTest(){
        //Arrange
        int mindDiff = 1;
        String expectedStr = "The winner team is Aston_Villa with goal difference 1.";

        //Act
        String actual = soccerLeague.findWinnerTeam(results, mindDiff);

        //Assert
        Assertions.assertEquals(expectedStr, actual);
    }

}