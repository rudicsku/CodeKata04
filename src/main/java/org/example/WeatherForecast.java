package org.example;

import java.util.List;

public class WeatherForecast {

    public String findDayWithMinTemp(List<String> weatherData, int min) {

        if (weatherData == null || weatherData.isEmpty()) {
            System.out.println("Invalid input.");
        }

        String result = "";
        List<String> correctedList = DataHelper.removeWhiteSpaceAndSpecChar(weatherData, "\\*");
        List<String[]> splitList = DataHelper.splitList(correctedList);

        try {
            for (int i = 2; i < splitList.size() - 1; i++) {
                int temp = Integer.parseInt(splitList.get(i)[3]);
                if (temp == min) {
                    result = "The smallest temperature is " + min + " fahrenheit on the day: " + splitList.get(i)[1];
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error");
        }
        return result;
    }


    public int findMinTemp(List<String> weatherData) {

        if (weatherData == null || weatherData.isEmpty()) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        List<String> correctedList = DataHelper.removeWhiteSpaceAndSpecChar(weatherData, "\\*");
        List<String[]> splitList = DataHelper.splitList(correctedList);

        try {
            for (int i = 2; i < splitList.size() - 1; i++) {
                int temp = Integer.parseInt(splitList.get(i)[3]);
                if (min > temp) {
                    min = temp;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error");
        }
        return min;
    }
}
