package JavaBasics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentHashMap1 {
//    HashMap是否是线程安全的，如何在线程安全的前提下使用HashMap
//    HashMap将数据存储到多个单链表（也称为桶）中
//    扩容时，数组的大小调整会创建两倍的桶（即链接列表），并将  所有现有条目重新分配到存储桶（旧的和新创建的）中。
//    多个线程同时对Node数组进行扩容，都在重新计算元素位置以及复制数据，但是最终只有一个线程扩容后的数组会赋给table，
//    也就是说其他线程的都会丢失，并且各自线程put的数据也丢失
//    因为多线程会导致HashMap的Node链表形成环形数据结构，
//    一旦形成环形数据结构，Node的next节点永远不为空，就会在获取Node时产生死循环。
//    线程安全：Hashtable
//              ConcurrentHashMap
//              Synchronized Map
    public void performanceTest() {
        Map<Integer ,Integer> hashtable = new Hashtable<>();
        concurrentTest(hashtable);
        Map<Integer,Integer> synchronizedHashMap = Collections.synchronizedMap(new HashMap<Integer,Integer>());
        concurrentTest(synchronizedHashMap);
        Map<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentTest(concurrentHashMap);
    }

    private void concurrentTest(Map<Integer, Integer> map) {
//      使用ExecutorService来并发运行5个线程，每个线程添加/获取500K个元素
        System.out.println("Test started for:"+map.getClass());
        long avgTime = 0;// 每组数据跑5次取平均时间
        for(int i =0;i<5;i++){
            long start = System.nanoTime();
            ExecutorService es = Executors.newFixedThreadPool(5);
            for(int j =0;j<5;j++){
                es.execute(new Runnable() {
                    @Override
                    public void run() {
                        for(int i =0;i<500000;i++){
                            Integer key =(int)Math.ceil(Math.random()*500000);
                            Integer value = key;
                            map.put(key,value);
                        }
                    }
                });
            }
            es.shutdown();
            // Blocks until all tasks have completed execution after a shutdown request
            try {
                es.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.nanoTime();
            long total = (end-start)/1000000L;
            avgTime +=total;
            System.out.println("2500K entried added/retrieved in " + total + " ms");
        }
        System.out.println("For " + map.getClass() + " the average time is " + avgTime / 5 + " ms\n");
    }


}
