package ru.job4j.io;

import java.io.File;
import java.util.List;

public interface Search {
    public List<File> getFiles(String parent, List<String> exts);
}

