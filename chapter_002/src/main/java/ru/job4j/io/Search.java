package ru.job4j.io;

import java.io.File;
import java.util.*;

class Search {
    /*public List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(file);
        while (!data.isEmpty()) {
            File f = data.poll();
            if (!f.isDirectory()) {
                for (String ext : exts) {
                    if (f.getName().endsWith("." + ext)) {
                        result.add(f);
                        break;
                    }
                }
            }
            for (File child : f.listFiles()) {
                data.offer(child);
            }
        }
        //List<File> files = Arrays.asList(file.listFiles());
        return result;
    }*/

}
