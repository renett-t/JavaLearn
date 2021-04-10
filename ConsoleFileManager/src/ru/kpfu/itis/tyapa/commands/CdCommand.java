package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;
import ru.kpfu.itis.tyapa.utils.PathsChecker;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommand implements FileExecutable {

    @Override
    public void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters) {

        if (parameters.getFlagsList().size() > 0) {
            throw new IllegalArgumentException(" Unknown command " + parameters.getCommand() + " -" + parameters.getFlagsList().get(1));
        }

        Path newPath = parameters.getPath();
        Path currentPath = fileManager.getCurrentPath();

        if (newPath.isAbsolute()) {
            fileManager.setCurrentPath(newPath);
        }
        else {

            if (newPath.toString().equals("~")) {
                newPath = Paths.get(System.getProperty("user.home"));
            } else {
                newPath = currentPath.resolve(newPath);
            }

            if (PathsChecker.isFileOrDirectoryExist(newPath)) {
                fileManager.setCurrentPath(currentPath.resolve(newPath).normalize());
            } else {
                throw new IllegalArgumentException(" No such file or directory " + newPath.toString());
            }
        }
    }
}
