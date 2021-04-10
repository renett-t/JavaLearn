package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TouchCommand implements FileExecutable  {

    @Override
    public void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters) {

        if (parameters.getFlagsList().size() > 0) {
            throw new IllegalArgumentException(" Unknown command " + parameters.getCommand() + " -" + parameters.getFlagsList().get(1));
        }

        Path pathToCreateFile = parameters.getPath();

        if (!pathToCreateFile.isAbsolute()) {
            pathToCreateFile = fileManager.getCurrentPath().resolve(pathToCreateFile);
        }

        try {
            if (!Files.exists(pathToCreateFile)) {
                Files.createFile(pathToCreateFile);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("No such file or directory " + pathToCreateFile.toString());
        }

    }

}
