package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;
import ru.kpfu.itis.tyapa.utils.PathsChecker;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TreeCommand implements FileExecutable  {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters) {

        if (parameters.getFlagsList().size() > 0) {
            throw new IllegalArgumentException(" Unknown command " + parameters.getCommand() + " -" + parameters.getFlagsList().get(1));
        }

        Path pathToPrint = parameters.getPath();

        if (pathToPrint != null) {
            if (!pathToPrint.isAbsolute()) {
                if (pathToPrint.toString().equals("~")) {
                    pathToPrint = Paths.get(System.getProperty("user.home"));
                } else {
                    pathToPrint = fileManager.getCurrentPath().resolve(pathToPrint);
                }
            }
        } else {
            pathToPrint = fileManager.getCurrentPath();
        }

        PathsChecker.isFileOrDirectoryExist(pathToPrint);

        this.printAllFilesAndDirectories(pathToPrint);
    }

    private File[] getFiles(Path path) {
        File newFile = new File(path.toUri());
        File[] files = newFile.listFiles();

        if (files == null) {
            files = new File[1];
            files[1] = newFile;
        }

        return files;
    }


    public void printAllFilesAndDirectories(Path path) {
        System.out.println(ANSI_BLUE + "." + ANSI_RESET);
        File[] files = getFiles(path);

        for (int i = 0; i < files.length; i++) {
            System.out.print(ANSI_CYAN + "├── " + ANSI_RESET);
            if (files[i].isFile()) {
                System.out.println(files[i].getName());
            }
            if (files[i].isDirectory()) {
                printDirectory(files[i], 2, 4);
            }
        }
    }

    private void printDirectory(File dir, int level, int spacesCount) {
        System.out.println(ANSI_BLUE + dir.getName() + ANSI_RESET);

        File[] items = dir.listFiles();

        if (items == null) {
            printElements(level, spacesCount);
        } else {
        for (int i = 0; i < items.length; i++) {
            // если директория является последней
            if (i == items.length - 1) {
                printElementsCorrected(level, spacesCount);
            } else {
                printElements(level, spacesCount);
            }

            if (items[i].isFile()) {
                System.out.println(items[i].getName());
            } else {
                printDirectory(items[i], level + 1, spacesCount);
            }
        }
        }
    }

    private void printElements(int level, int spacesCount) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print(ANSI_CYAN + "│" + ANSI_RESET);
            printSpaces(spacesCount);
        }
        System.out.print(ANSI_CYAN + "├── " + ANSI_RESET);
    }

    private void printElementsCorrected(int level, int spacesCount) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print(ANSI_CYAN + "│" + ANSI_RESET);
            printSpaces(spacesCount);
        }
        System.out.print(ANSI_CYAN + "└── " + ANSI_RESET);
    }


    private void printSpaces(int spacesCount) {
        for (int i = 0; i < spacesCount; i++) {
            System.out.print(" ");
        }
    }

    private boolean isFile(Path path) {
        return !isDirectory(path);
    }

    private boolean isDirectory(Path path) {
        return Files.isDirectory(path);
    }
}
