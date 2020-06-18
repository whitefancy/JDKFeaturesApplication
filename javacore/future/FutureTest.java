package javacore.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 查找文件目录下，满足含有目标字符串的文件数量
 */
public class FutureTest {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src):");
            String directory = in.nextLine();
            System.out.println("Enter keyword (e.g. volatile):");
            String keyword = in.nextLine();

            MatchCounter counter = new MatchCounter(new File(directory), keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            Thread t = new Thread(task);//runnable
            t.start();
            System.out.println(task.get() + " match files.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/*
返回每个子目录的数量
 */
class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;

    MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<>();

        for (File file : files
        ) {
            if (file.isDirectory()) {
                /*
                下面一段十分精妙，results是全局变量，用results引用task，防止task被gc回收
                同时又可以方便地取出结果累加
                 */
                MatchCounter counter = new MatchCounter(file, keyword);
                FutureTask<Integer> task = new FutureTask<>(counter);
                results.add(task);//这里 futureTask当Future用，作为参数放进了Future的list
                Thread t = new Thread(task);
                t.start();
            } else {
                if (search(file)) {
                    count++;
                }
            }
        }
        for (Future<Integer> result : results
        ) {
            count += result.get();//这里get返回子目录的计算结果，是个阻塞的方法，也就是说，最初调用的会最后被解禁
        }
        return count;
    }

    private boolean search(File file) {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}