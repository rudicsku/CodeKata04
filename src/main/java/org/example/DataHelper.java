package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataHelper {

    public static List<String> readLineByLine(String path) {

        if (path == null || path.isBlank()) {
            return new ArrayList<>();
        }

        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException exception) {
            System.out.println("File not found!");
        }
        return stringList;
    }


    public static List<String[]> splitList(List<String> stringList) {
        List<String[]> result = new ArrayList<>();

        for (String s : stringList) {
            result.add(s.split(" "));
        }
        return result;
    }

    public static List<String> removeWhiteSpaceAndSpecChar(List<String> stringList, String specCharToRemove){
        return stringList.stream()
                .map(s -> s.replaceAll(specCharToRemove, ""))
                .map(s -> s.replaceAll("[ ]+", " "))
                .collect(Collectors.toList());
    }
}
