package javacore2.io;

import java.io.*;
import java.util.zip.ZipInputStream;

public class IoStreamFilter {
    public static void main(String[] args) throws IOException {
        /*
        因为想要回推，我们使用PushbackInputStream装饰器，
        同时想要读入和浏览数字，所以也使用了BufferedInputStream数据流装饰器
         */
        PushbackInputStream pbin = new PushbackInputStream(
                new BufferedInputStream(
                        new FileInputStream("test/test.txt")));
        /*
        当把多个输入流连接在一起时，需要跟踪各个中介输入流
        当读入输入时，经常需要浏览下一个字节，以了解是否是想要的。
        此时可以使用PushbackInputStream
         */
        int b = pbin.read();
        if (b != '<') {
            pbin.unread(b);//如果它并非想要的，可以推回流中。
        }
        /*
        从ZIP压缩文件中读入数字
         */
        ZipInputStream zin = new ZipInputStream(new FileInputStream("test/ts.zip"));
        DataInputStream din = new DataInputStream(zin);
    }
}
