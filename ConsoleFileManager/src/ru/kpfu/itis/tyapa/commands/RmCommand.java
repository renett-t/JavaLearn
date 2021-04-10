package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;
import ru.kpfu.itis.tyapa.utils.PathsChecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RmCommand implements FileExecutable  {

    @Override
    public void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters) {
        Path pathToDelete = parameters.getPath();

        if (parameters.getFlagsList().size() > 0) {
            throw new IllegalArgumentException(" Unknown command " + parameters.getCommand() + " -" + parameters.getFlagsList().get(1));
        }

        if (!pathToDelete.isAbsolute()) {
            pathToDelete = fileManager.getCurrentPath().resolve(pathToDelete);
        }

        PathsChecker.isFileOrDirectoryExist(pathToDelete);

        try {
            Files.delete(pathToDelete);
        } catch (IOException e) {
            throw new IllegalArgumentException(" Something went wrong");
        }
    }

}
