package ru.job4j.io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchByBreadthTest {

    @Test
    public void shouldGet3Files() throws IOException {
        String src = System.getProperty("java.io.tmpdir");
        Search srch = new SearchByBreadth();
        List<String> exts = new ArrayList<>();
        File f1 = new File(src, "docA.docx");
        f1.createNewFile();
        File d = new File(src, "dir1");
        d.mkdir();
        File f2 = new File(d, "qwe.iml");
        f2.createNewFile();
        File f3 = new File(d, "ryy.rt");
        f3.createNewFile();
        File d2 = new File(d, "dir2");
        d2.mkdir();
        File f4 = new File(d2, "docB.docx");
        f4.createNewFile();
        exts.add("docx");
        exts.add("iml");
        List<File> files = srch.getFiles(src, exts);
        assertThat(files.get(0).getName(), is("docA.docx"));
        assertThat(files.get(1).getName(), is("qwe.iml"));
        assertThat(files.get(2).getName(), is("docB.docx"));
    }

}