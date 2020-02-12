package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Test
    public void WhenSrcLogThenDstLogIsCorrect() throws FileNotFoundException {
        String src = "../chapter_002/src.log";
        String dst = "../chapter_002/dst.log";
        Analizy an = new Analizy();
        an.unavailable(src, dst);
        List<String> lst = new LinkedList<>();
        BufferedReader read = new BufferedReader(new FileReader(dst));
        read.lines().forEach(str -> {
               lst.add(str);
        });
        assertThat(lst.get(0), is("10:57:01;10:59:01"));
        assertThat(lst.get(1), is("11:01:02;11:02:02"));
    }

}