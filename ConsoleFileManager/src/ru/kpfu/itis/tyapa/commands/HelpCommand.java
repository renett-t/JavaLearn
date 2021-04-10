package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;

public class HelpCommand implements FileExecutable {

    @Override
    public void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters) {

        if (parameters.getFlagsList().size() > 0) {
            throw new IllegalArgumentException(" Unknown command " + parameters.getCommand() + " -" + parameters.getFlagsList().get(1));
        }
        if (parameters.getPath() != null) {
            throw new IllegalArgumentException(" Unknown command " + parameters.getCommand() + " " + parameters.getPath());
        }

        System.out.println(" Here the list of commands: ");
        for (String elem : fileManager.getCommandsSet()) {
            System.out.println(elem);
        }
    }
}
