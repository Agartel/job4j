package ru.job4j.io;

import java.io.File;
import java.util.*;

class SearchByBreadth implements Search {
    public List<File> getFiles(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(new File(parent));
        while (!data.isEmpty()) {
            File f = data.poll();
            if (!f.isDirectory()) {
                for (String ext : exts) {
                    if (f.getName().endsWith("." + ext)) {
                        result.add(f);
                        break;
                    }
                }
            } else {
                for (File child : f.listFiles()) {
                    data.offer(child);
                }
            }
        }
        return result;
    }

}
