package ru.job4j.io;

import java.io.File;
import java.util.*;

class Search  {
    public List<File> getFiles(String parent, Filter filter) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(new File(parent));
        while (!data.isEmpty()) {
            File f = data.poll();
            if (!f.isDirectory()) {
                if (filter != null) {
                    if (filter.checkFile(f)) {
                        result.add(f);
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
