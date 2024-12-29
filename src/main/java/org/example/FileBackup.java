package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.File;

public class FileBackup {
    public static void createBackup(String sourceDirPath, String backupDirPath) {
        File sourceDir = new File(sourceDirPath); //todo Экземпляр Исходная директория
        File backupDir = new File(backupDirPath); // Экземпляр Новая директория куда будет произведено резервное копирование

        //todo Проверка, существует ли исходная директория и является ли путь директорией
        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Исходная директория не существует или не является директорией.");
            return;
        }

        //todo Создание директории для резервных копий, если она не существует
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        //todo Получаем список всех файлов в исходной директории (без поддиректорий)
        File[] files = sourceDir.listFiles((dir, name) -> new File(dir, name).isFile());//todo проверяем является ли файлом

        if (files != null) { //todo если массив не пуст,начинаем перебирать файлы
            for (File file : files) {
                // Создаём путь для файла в директории резервной копии
                Path backupFilePath = Path.of(backupDirPath , file.getName()); //todo новый путь выглядит например вот так ./backup/Main.java

                try {
                    //todo Копирование файла в резервную директорию
                    //todo Копируем с помощью класса Files файл который преобразовываем в патч и посылаем по пути в новую директорию->./backup/Main.java
                    //todo если там уже есть файлы мы их перезаписываем с помщью StandardCopyOption.REPLACE_EXISTING
                    Files.copy(file.toPath(), backupFilePath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Файл " + file.getName() + " успешно скопирован.");
                } catch (IOException e) {
                    System.out.println("Ошибка при копировании файла " + file.getName() + ": " + e.getMessage());
                }
            }
        } else {
            System.out.println("Не удалось получить список файлов.");
        }
    }
}


