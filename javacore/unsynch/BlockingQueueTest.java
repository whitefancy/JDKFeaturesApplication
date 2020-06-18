package javacore.unsynch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 使用阻塞队列来控制一组线程，在其所有子目录下搜索所有文件，打印出包含指定关键字的行
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(BlockingQueueTest.FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src):");
            String directory = in.nextLine();
            System.out.println("Enter keyword (e.g. volatile):");
            String keyword = in.nextLine();
            Runnable enumrator = () -> {
                try {
                    BlockingQueueTest.enumarate(new File(directory));
                    BlockingQueueTest.queue.put(BlockingQueueTest.DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(enumrator).start();
            for (int i = 0; i < BlockingQueueTest.SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = BlockingQueueTest.queue.take();
                            if (file == BlockingQueueTest.DUMMY) {
                                /*
                                这里是为了标志，已经不会有真正的文件进来了，
                                但是为了所有的线程都能正常中止，要让所有的线程都看到dummy，
                                所以，每个线程看到dummy中止后，还要再放一个dummy进入queue中，
                                最终，queue中会有一个dummy，所有搜索线程都终止了
                                 */
                                BlockingQueueTest.queue.put(file);
                                done = true;
                            } else {
                                BlockingQueueTest.search(file, keyword);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    /**
     * 对一个文本文件查找字符串
     *
     * @param file
     * @param keyword
     */
    private static void search(File file, String keyword) {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归查找当前文件夹下所有的文件和子目录文件
     *
     * @param directory
     * @throws InterruptedException
     */
    private static void enumarate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                BlockingQueueTest.enumarate(file);
            } else {
                BlockingQueueTest.queue.put(file);
            }
        }
    }
}
