package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchTest {
    @Test
    public void ttt() throws FileNotFoundException {
        String src = System.getProperty("java.io.tmpdir");
        Search srch = new Search();
        List<String> exts = new ArrayList<>();
        exts.add("docx");
        exts.add("iml");
        List<File> files = srch.files(src, exts);
        assertThat(files.get(0).getName(), is("docA.docx"));
        assertThat(files.get(1).getName(), is("qwe.iml"));
        assertThat(files.get(2).getName(), is("docB.docx"));
    }
}