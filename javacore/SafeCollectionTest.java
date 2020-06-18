package javacore;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 多线程并发修改数据结构，就会很容易破坏这个数据结构，比如散列表
 * 会使用无效的链接，抛出异常或陷入死循环
 */
public class SafeCollectionTest {
    /*
    Java的concurrent包提供了映射、有序集、队列的高效实现
    这些集合使用复杂的算法，允许并发访问数据结构的不同部分，来使竞争极小化
    size方法往往需要遍历
    当散列映射非常庞大，比如超过20亿条目，size方法的int类型已经不足够，Java8提供了mappingCount返回long型的size
     */
    ConcurrentHashMap<String, LongAdder> map;//初始容量16个桶，树状冲突，每个桶的负载因子默认为0.75
    ConcurrentSkipListMap map1;
    ConcurrentSkipListSet set;//可被多线程安全访问的有序集
    ConcurrentLinkedQueue queue;

    {
        /*
        集合返回弱一致性的迭代器，即，不保证插入的一定能立刻看到。
        默认支持16路并发写者和大量的读者，否则会被阻塞
        并发散列映射，Java8是树，而不是列表，保证了性能log n
         */
        Long size = map.mappingCount();
        /*
这种多线程安全，指的是不会破坏内部结构，如果操作序列不是原子的，还是会结果不可知
 想要进行原子更新操作，需要是用Java8的带AtomicLong的构造器*/
        map = new ConcurrentHashMap<>();
        map.putIfAbsent("aword", new LongAdder()).increment();
    }
}
