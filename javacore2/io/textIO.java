package javacore2.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Java 内部使用的是UTF-16编码，
 * 互联网最常用的是UTF-8编码
 * OutputStreamWriter类，使用选定的字符编码方式，
 * 把Unicode码元的输出流 转换成字节流
 * InputStreamReader类则反过来。
 */
public class textIO {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Reader in = new InputStreamReader(
                new FileInputStream("test/test.txt"), StandardCharsets.UTF_8);
        PrintWriter out = new PrintWriter("test/test.txt", "UTF-8");
    }
}
