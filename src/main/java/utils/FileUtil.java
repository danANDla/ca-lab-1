package utils;

import calculator.Matrix;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtil {
    private static final String path = "/home/danandla/BOTAY/computational_algebra/labs/ca-1/ca-lab-1/matrices/";
    private IOutil io;

    public FileUtil(IOutil io) {
        this.io = io;
    }

    public ArrayList<String> readMatrix(String filename) {
        ArrayList<String> strings = null;
        try (FileReader reader = new FileReader(path + filename)) {
            char[] buf = new char[2048];
            strings = new ArrayList<>();
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 2048) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
                String[] bigStr = (new String(buf)).split("\n");
                strings.addAll(Arrays.asList(bigStr));
            }
        } catch (IOException ex) {
            io.printError("exception while reading file \"" + path + filename + "\"");
        }

        return strings;
    }
}