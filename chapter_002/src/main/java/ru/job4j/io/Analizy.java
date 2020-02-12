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
    public void unavailable(String source, String target) {
        List<String> lst = new LinkedList<>();
        String Line;
        String[] split;
        int code;
        String dtbegin = null;
        String dtend = null;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            while ((Line = read.readLine()) != null) {
                split = Line.split(" ");
                code = Integer.parseInt(split[0]);;
                if (code != 400 && code != 500) {
                    if (dtbegin != null) {
                        dtend = split[1];
                        lst.add(dtbegin + ";" + dtend);
                    }
                    dtbegin = null;
                    dtend = null;
                    continue;
                }
                if (dtbegin == null) {
                    dtbegin = split[1];
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String str : lst) {
                out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        };
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