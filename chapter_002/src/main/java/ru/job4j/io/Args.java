package ru.job4j.io;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Args {
    public static void main(String[] args) {
        String dir = null;
        String ext = null;
        File dst = null;
        for (int i = 0; i < args.length; i++) {
             if (args[i].toLowerCase().equals("-d")) {
                 dir = args[i + 1];
             } else if (args[i].toLowerCase().equals("-e")) {
                 ext = args[i + 1];
                 Pattern pattern = Pattern.compile("\\.{1}\\w+$");
                 Matcher matcher = pattern.matcher(ext);
                 if (matcher.find()) {
                     ext = matcher.group(0).substring(1);
                 }
             } else if (args[i].toLowerCase().equals("-o")) {
                 dst = new File(args[i + 1]);
             }
        }
        Zip zip = new Zip();
        List<File> files = zip.seekBy(dir, ext);
        if (files.size() == 0 || dst == null) {
            throw new RuntimeException("Параметры не валидны");
        }
        zip.pack(files, dst);
    }
}
