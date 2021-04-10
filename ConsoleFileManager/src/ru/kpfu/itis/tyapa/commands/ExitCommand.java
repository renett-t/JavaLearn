package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;

public class ExitCommand implements FileExecutable {

    @Override
    public void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters) {
        System.exit(0);
    }

}
