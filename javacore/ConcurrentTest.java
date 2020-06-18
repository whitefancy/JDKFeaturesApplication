package javacore;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 同时可以运行多个线程的程序 称为多线程程序 multithreaded
 * 多线程与多进程的区别 多线程共享数据，使得线程之间通信更加有效，创建、撤销一个线程比启动新进程开销小很多
 */
public class ConcurrentTest {

    /*
    stop 和suspend方法被弃用了，分别是中止线程程和阻塞线程
    因为前者会造成数据不一致，立即释放锁，后者会导致死锁，会导致对象被破坏，现在都是请求方法。
     */ {
    }
}
