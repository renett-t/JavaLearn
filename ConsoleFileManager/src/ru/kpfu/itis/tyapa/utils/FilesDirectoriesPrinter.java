package ru.kpfu.itis.tyapa.utils;

import ru.kpfu.itis.tyapa.exceptions.NonValidPathException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.text.SimpleDateFormat;

public class FilesDirectoriesPrinter {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void printFiles(Path path) {

        PathsChecker.isFileOrDirectoryExist(path);

        if (!Files.exists(path)) {
            System.out.println("No such file or directory \"" + path.toString() + "\"");
            return;
        }

        File tryFile = path.toFile();
        File[] files = tryFile.listFiles();

        if (files == null) {
            files = new File[1];
            files[0] = tryFile;
        }

        for (File file: files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else{
                System.out.println(ANSI_BLUE + file.getName() + ANSI_RESET);
            }
        }

    }

    public static void printFilesWithInfo(Path path) {

        PathsChecker.isFileOrDirectoryExist(path);

        File tryFile = path.toFile();
        File[] files = tryFile.listFiles();

        if (files == null) {
            files = new File[1];
            files[0] = tryFile;
        }

        try {

            System.out.println("Total: " + files.length);

            for (File file: files) {

                SimpleDateFormat timeFormat = new SimpleDateFormat("MMM dd HH:mm");
                PosixFileAttributes attrs = Files.getFileAttributeView(file.toPath(), PosixFileAttributeView.class).readAttributes();

                //getPosixFilePermissions
                String result = String.format("%s %s %d %s %s", PosixFilePermissions.toString(attrs.permissions()),
                        Files.getOwner(file.toPath()),
                        Files.size(file.toPath()),
                        timeFormat.format(file.lastModified()), (file.isFile() ?
                        file.getName() : ANSI_BLUE + file.getName() + ANSI_RESET));
                System.out.println(result);
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException(" Unable to gat all files and directories");
        }

    }

}