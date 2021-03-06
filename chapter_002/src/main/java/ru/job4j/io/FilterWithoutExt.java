package ru.job4j.io;

import java.io.File;
import java.util.List;

public class FilterWithoutExt implements Filter {

    private List<String> conditions;

    public FilterWithoutExt(List<String> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean checkFile(File file) {
        for (String ext : conditions) {
            if (!file.getName().endsWith("." + ext)) {
                return true;
            }
        }
        return false;
    }
}

