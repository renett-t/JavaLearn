package ru.kpfu.itis.tyapa.commands;

import ru.kpfu.itis.tyapa.filemanager.ConsoleFileManagerInterface;
import ru.kpfu.itis.tyapa.reader.CommandsParameters;


public interface FileExecutable {
    void execute(ConsoleFileManagerInterface fileManager, CommandsParameters parameters);
}


