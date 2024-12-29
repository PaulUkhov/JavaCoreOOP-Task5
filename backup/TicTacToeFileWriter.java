package org.example;

import java.io.FileOutputStream;
import java.io.IOException;

public class TicTacToeFileWriter {
    public static void ticTacToeFileWriter() {
        // Исходный массив
        int[] field = {0, 1, 2, 3, 0, 1, 2, 3, 0};

        // Сжимаем 9 элементов в одном числе (24 бита)
        int packedData = 0;
        for (int i = 0; i < field.length; i++) {
            // Сдвигаем значение на нужное место и добавляем к packedData
            packedData |= (field[i] << (2 * i));
        }

        // Записываем результат в файл
        try (FileOutputStream fos = new FileOutputStream("gameField.dat")) {
            // Записываем 3 байта
            fos.write((packedData >> 16) & 0xFF); // старший байт
            fos.write((packedData >> 8) & 0xFF);  // средний байт
            fos.write(packedData & 0xFF);         // младший байт
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
