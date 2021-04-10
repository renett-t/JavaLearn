package ru.kpfu.itis.tyapa.filemanager;

import java.nio.file.Path;
import java.util.Set;

public interface ConsoleFileManagerInterface {

    Path getCurrentPath();
    void setCurrentPath(Path newPath);
    Set<String> getCommandsSet();




}
