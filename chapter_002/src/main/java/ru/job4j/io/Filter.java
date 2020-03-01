package ru.job4j.io;

import java.io.File;

public interface Filter {
    public boolean checkFile(File file);
}
