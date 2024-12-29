package org.example;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadGameField {
    public static void readGameField(String filePath) {

        try (FileInputStream fis = new FileInputStream(filePath)) {
            int byteRead;
            System.out.println("Содержимое файла (в байтах):");
            while ((byteRead = fis.read()) != -1) {
                System.out.printf("0x%02X ", byteRead); // Вывод каждого байта в HEX
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
