package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.exceptions.NonValidPathException;
import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MkdirCommand implements FileExecutable  {

    @Override
    public void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters) {

        if (parameters.getFlagsList().size() > 0) {

            if (parameters.getFlagsList().get(0).equals("p")) {
                Path pathToCreate = parameters.getPath().normalize();
                Path currentPath = fileManager.getCurrentPath();

                if (pathToCreate.isAbsolute()) {
                    currentPath = pathToCreate.getRoot();
                }
                createDirectories(pathToCreate, currentPath);
            } else {
                throw new NonValidPathException(" Non valid command " + parameters.getCommand() + " " + parameters.getFlagsList().get(0));
            }

        }
        else {
            createDirectory(parameters.getPath().normalize(), fileManager.getCurrentPath());
        }

    }

    private void createDirectories(Path path, Path currentPath) {
        try {
            int count = path.getNameCount();
            Path checkingPath = currentPath;

            for (int i = 0; i < count; i++) {
                checkingPath = checkingPath.resolve(path.getName(i));

                if (!Files.exists(currentPath.resolve(checkingPath))) {
                    Files.createDirectory(checkingPath);
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(" Something wrong.");
        }
    }

    private void createDirectory(Path path, Path currentPath) {

        try {
            if (path.isAbsolute()) {
                Files.createDirectory(path);
            }
            else {
                if (path.getParent() == null || Files.exists(path.getParent())) {
                    Files.createDirectory(currentPath.resolve(path));
                } else {
                    throw new NonValidPathException(" Directory " + path.toString() + " do not exists");
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(" Something wrong.");
        }

    }
}
