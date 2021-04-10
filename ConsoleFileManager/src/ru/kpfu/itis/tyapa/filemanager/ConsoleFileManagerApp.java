package ru.kpfu.itis.tyapa.filemanager;

import ru.kpfu.itis.tyapa.commands.*;
import ru.kpfu.itis.tyapa.exceptions.NonValidPathException;
import ru.kpfu.itis.tyapa.reader.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ConsoleFileManagerApp extends AbstractApp implements ConsoleFileManagerInterface {
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String ANSI_RESET = "\u001B[0m";

    private String INITIAL_PATH;
    private Path currentPath;
    private ReaderInterface reader;
    private Map<String, FileExecutable> commandsMap;

    public ConsoleFileManagerApp() {
        super();
    }

    @Override
    protected void init() {
        INITIAL_PATH = System.getProperty("user.home");
        currentPath = Paths.get(INITIAL_PATH);
        reader = new ConsoleReader();
        commandsMap = new HashMap<String, FileExecutable>();
        commandsMap.put("ls", new LsCommand());
        commandsMap.put("ls -l", new LsCommand());
        commandsMap.put("cd", new CdCommand());
        commandsMap.put("touch", new TouchCommand());
        commandsMap.put("mkdir", new MkdirCommand());
        commandsMap.put("mkdir -p", new MkdirCommand());
        commandsMap.put("tree", new TreeCommand());
        commandsMap.put("rm", new RmCommand());
        commandsMap.put("exit", new ExitCommand());
        commandsMap.put("help", new HelpCommand());
    }

    @Override
    protected void start() {
        Path pathPart = null;

        while (true) {
            System.out.print(GREEN_BOLD_BRIGHT + currentPath.toString() + "$ " + ANSI_RESET);

            try {
                CommandsParameters newInput = new CommandsParameters(reader.readOneLine());

                if (pathPart == null) {
                    pathPart = currentPath;
                }

                if (commandsMap.containsKey(newInput.getCommand())) {
                    commandsMap.get(newInput.getCommand()).execute(this, newInput);
                } else {
                    System.out.println("Non valid command! Press help to get more information");
                }
            } catch (IllegalArgumentException | NonValidPathException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @Override
    public Path getCurrentPath() {
        return currentPath;
    }

    @Override
    public void setCurrentPath(Path newPath) {
        currentPath = newPath;
    }

    @Override
    public Set<String> getCommandsSet() {
        return commandsMap.keySet();
    }


    public static void main(String[] args) {
        new ConsoleFileManagerApp();
    }
}
