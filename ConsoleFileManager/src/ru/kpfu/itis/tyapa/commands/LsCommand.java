package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;
import ru.kpfu.itis.tyapa.utils.FilesDirectoriesPrinter;
import ru.kpfu.itis.tyapa.utils.PathsChecker;

import java.nio.file.Path;
import java.nio.file.Paths;

public class LsCommand implements FileExecutable {

    @Override
    public void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters) {

        Path pathToPrint = parameters.getPath();

        if (pathToPrint == null) {
            pathToPrint = fileManager.getCurrentPath();
        } else {
            if (pathToPrint.toString().equals("~")) {
                pathToPrint = Paths.get(System.getProperty("user.home"));
            } else {
                pathToPrint = fileManager.getCurrentPath().resolve(pathToPrint).normalize().toAbsolutePath();
            }
        }

        PathsChecker.isFileOrDirectoryExist(pathToPrint);

        if (parameters.getFlagsList().size() > 0 ) {
            if (parameters.getFlagsList().get(0).equals("l")) {
                printAllFilesFlagL(pathToPrint);
            } else {
                System.out.println(" Command not found " + parameters.getCommand() + " -" + parameters.getFlagsList().get(0));
            }
        } else {
            printAllFiles(pathToPrint);
        }
    }

    private void printAllFiles(Path path) {
        FilesDirectoriesPrinter.printFiles(path);
    }

    private void printAllFilesFlagL(Path path) {
        FilesDirectoriesPrinter.printFilesWithInfo(path);
    }

}
