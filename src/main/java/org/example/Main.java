package org.example;
// 1. Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
/* 2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой, например,
 состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом,
 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
 Записать в файл 9 значений так, чтобы они заняли три байта*/
public class Main {
    public static void main(String[] args) {
        System.out.println("1 Задание");
        String sourceDirPath = "src/main/java/org/example";
        String backupDirPath = "./backup";

        FileBackup.createBackup(sourceDirPath,backupDirPath);
        System.out.println("2 Задание");
        TicTacToeFileWriter.ticTacToeFileWriter();
        String filePath = "gameField.dat";
        ReadGameField.readGameField(filePath);
    }
}