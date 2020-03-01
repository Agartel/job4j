package ru.job4j.io;

import org.hamcrest.core.Is;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.Assert.*;

public class ArgsTest {

    @Test
    public void main() throws IOException {
        String src = "E:/JavaProjects/job4j/chapter_002";
        String dst = "E:/JavaProjects/job4j/chapter_002/qw.zip";
        File d = new File(src, "dir1");
        d.mkdir();
        File f2 = new File(d, "qwe.iml");
        f2.createNewFile();
        File f3 = new File(d, "ryy.xml");
        f3.createNewFile();
        File d2 = new File(d, "dir2");
        d2.mkdir();
        File f4 = new File(d2, "docB.docx");
        f4.createNewFile();
        File f5 = new File(d2, "jjj.xml");
        f5.createNewFile();
        String[] args = {"-d", d.getName(), "-e", "*.xml", "-o", dst};
        Args.main(args);
        ZipInputStream zipIs = new ZipInputStream(new FileInputStream(dst));
        ZipEntry entry = null;
        List<String> res = new ArrayList<>();
        while ((entry = zipIs.getNextEntry()) != null) {
            if (!entry.isDirectory()) {
                res.add(entry.getName());
                System.out.println(entry.getName());
            }
        }
        assertThat(res.get(0), is("dir1\\qwe.iml"));
        assertThat(res.get(1), is("dir1\\dir2\\docB.docx"));
    }
}