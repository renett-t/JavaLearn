package ru.kpfu.itis.tyapa.reader;

import ru.kpfu.itis.tyapa.exceptions.NonValidPathException;
import ru.kpfu.itis.tyapa.utils.PathsChecker;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CommandsParameters {

    private String command;
    private Path pathPart;
    private ArrayList<String> flags;

    public CommandsParameters(String input) {

        String[] strings = input.split(" ");

        if (strings.length < 1) {
            throw new IllegalArgumentException(" Incorrect input, command not found");
        }

        command = strings[0];
        flags = new ArrayList<>();

        if (strings.length > 1) {
            for (int i = 1; i < strings.length; i++) {

                if (strings[i].startsWith("-")) {
                    flags.add(strings[i].substring(1));
                }
                else {
                    if (PathsChecker.isPathCorrect(strings[i])) {
                        pathPart = Paths.get(strings[i]);
                    } else {
                        throw new NonValidPathException(" Incorrect path " + strings[i]);
                    }

                }
            }
        }
    }
    public String getCommand() {
        return command;
    }

    public Path getPath() {
        return pathPart;
    }

    public List<String> getFlagsList() {
        return flags;
    }
}
