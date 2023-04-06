package com.epam.mjc.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    public Profile getDataFromFile(File file) {
        try {
            Path writeFilePath = Paths.get(String.valueOf(file));
            String content = Files.readString(writeFilePath);

            String[] subStr = content.split("\r\n");
            String[][] subStrTwo = new String[subStr.length][2];
            for (int i = 0; i < subStr.length; i++) {
                subStrTwo[i] = subStr[i].split(": ");
            }

            return new Profile(subStrTwo[0][1], Integer.parseInt(subStrTwo[1][1]),
                    subStrTwo[2][1], Long.valueOf(subStrTwo[3][1]));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\resources\\Profile.txt");
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(file);
    }
}
