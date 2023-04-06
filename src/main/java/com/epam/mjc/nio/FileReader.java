package com.epam.mjc.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(String.valueOf(file)))) {
            String line;
            String[][] subStr = new String[reader.read()][];
            int i = 0;
            while ((line = reader.readLine()) != null) {
                subStr[i] = line.split(": ");
                i++;
            }
            return new Profile(subStr[0][1], Integer.parseInt(subStr[1][1]),
                    subStr[2][1], Long.valueOf(subStr[3][1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile();
    }

    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\Profile.txt");
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(file);
    }
}
