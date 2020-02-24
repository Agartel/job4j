package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Analizy {
    List<String> lst = new LinkedList<>();

    private void flushToDisk(String target) {
        try (PrintWriter out = new PrintWriter(target)) {
            for (String str : lst) {
                out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void unavailable(String source, String target) {

        String line;
        String[] split;
        int code;
        String dtbegin = null;
        String dtend = null;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            while ((line = read.readLine()) != null) {
                split = line.split(" ");
                code = Integer.parseInt(split[0]);
                if (code != 400 && code != 500) {
                    if (dtbegin != null) {
                        dtend = split[1];
                        lst.add(dtbegin + ";" + dtend);
                    }
                    dtbegin = null;
                    dtend = null;
                } else if (dtbegin == null) {
                    dtbegin = split[1];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        flushToDisk(target);
    }


    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}