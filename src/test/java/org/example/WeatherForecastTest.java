package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WeatherForecastTest {

    private static final List<String> weatherData = DataHelper.readLineByLine("src/main/resources/weather.dat");

    private static final WeatherForecast weatherForecast = new WeatherForecast();

    @Test
    void findMinTempTest() {
        //Arrange
        int expectedResult = 32;

        //Act
        int actual = weatherForecast.findMinTemp(weatherData);

        //Assert
        assertEquals(expectedResult, actual);
    }


    @Test
    void findDayWithMinTempTest(){
        //Arrange
        int min = weatherForecast.findMinTemp(weatherData);
        String expected = "The smallest temperature is 32 fahrenheit on the day: 9";

        //Act
        String actual = weatherForecast.findDayWithMinTemp(weatherData, min);

        //Assert
        assertEquals(expected, actual);

    }
}