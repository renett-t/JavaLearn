package ru.kpfu.itis.tyapa.utils;

import ru.kpfu.itis.tyapa.exceptions.NonValidPathException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathsChecker{
    private static final String pathStringPattern = "^(?:\\.\\/)?(?:(?:[\\w-\\.]*)*(?:\\/)?)*|(?:[~])$";
    private static final Pattern pathPattern = Pattern.compile(pathStringPattern);

    public static boolean isPathCorrect(String path) {
        Matcher pathMatcher = pathPattern.matcher(path);
        return pathMatcher.matches();
    }


    public static boolean isFileOrDirectoryExist(Path path) {

        if (!Files.exists(path)) {
            throw new NonValidPathException("No such file or directory \"" + path.toString() + "\"");
        }

        return true;
    }
}
