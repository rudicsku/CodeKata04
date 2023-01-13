package org.example;

import java.util.ArrayList;
import java.util.List;

public class SoccerLeague {

    public String findWinnerTeam(List<String> results, int minDiff) {
        String result = "";
        List<String> correctedList = DataHelper.removeWhiteSpaceAndSpecChar(results, "\\-");
        List<String[]> splitList = SoccerLeague.splitList(correctedList);

        try {
            for (int i = 0; i < splitList.size(); i++) {
                int temp = Math.abs(Integer.parseInt(splitList.get(i)[7]) - Integer.parseInt(splitList.get(i)[8]));
                if (minDiff == temp) {
                    result = "The winner team is " + splitList.get(i)[2] + " with goal difference " + minDiff + ".";
                }
            }
        } catch (NumberFormatException e) {
            return "Error";
        }
        return result;
    }


    public int findSmallestDiff(List<String> results) {

        List<String> correctedList = DataHelper.removeWhiteSpaceAndSpecChar(results, "\\-");
        List<String[]> splitList = SoccerLeague.splitList(correctedList);

        int minDiff = Integer.MAX_VALUE;

        try {
            for (String[] strings : splitList) {
                int temp = Math.abs(Integer.parseInt(strings[7]) - Integer.parseInt(strings[9]));
                if (minDiff > temp) {
                    minDiff = temp;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error");
        }

        return minDiff;
    }

    private static List<String[]> splitList(List<String> stringList) {
        List<String[]> result = new ArrayList<>();

        //Splitting the lines
        //TODO use Datahelper.splitList
        for (String s : stringList) {
            result.add(s.split(" "));
        }

        //Removing not informative lines
        //TODO Extract method
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).length != 10) {
                result.remove(i);
            }
        }
        return result;
    }

}
