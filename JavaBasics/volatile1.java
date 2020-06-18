package JavaBasics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class volatile1 {
/*     内存模型：
    程序在运行过程中，会将运算需要的数据从主存复制一份到CPU的高速缓存当中，
     那么CPU进行计算时就可以直接从它的高速缓存读取数据和向其中写入数据，
     当运算结束之后，再将高速缓存中的数据刷新到主存当中
    当线程执行i=i+1时，会先从主存当中读取i的值，然后复制一份到高速缓存当中，
     然后CPU执行指令对i进行加1操作，然后将数据写入高速缓存，
     最后将高速缓存中i最新的值刷新到主存当中
    在多核CPU中，每条线程可能运行于不同的CPU中，因此每个线程运行时有自己的高速缓存
    这就是著名的缓存一致性问题。通常称这种被多个线程访问的变量为共享变量。
    2种解决方法：
    　　1）通过在总线加LOCK#锁的方式
    　　2）通过缓存一致性协议
    CPU和其他部件进行通信都是通过总线来进行的，如果对总线加LOCK#锁的话，也就是说阻塞了其他CPU对其他部件访问（如内存）
    Intel 的MESI协议:
     当CPU写数据时，如果发现操作的变量是共享变量，即在其他CPU中也存在该变量的副本，会发出信号通知其他CPU将该变量的缓存行置为无效状态，
     因此当其他CPU需要读取这个变量时，发现自己缓存中缓存该变量的缓存行是无效的，那么它就会从内存重新读取

     并发中的 原子性 可见性 有序性
    要想并发程序正确地执行，必须要保证原子性、可见性以及有序性。只要有一个没有被保证，就有可能会导致程序运行不正确
    原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行
    可见性：当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
    有序性：处理器为了提高程序运行效率，可能会对输入代码进行优化，指令重排序时是会考虑指令之间的数据依赖性，即程序执行的顺序按照代码的先后顺序执行
    只有简单的读取、赋值（而且必须是将数字赋值给某个变量，变量之间的相互赋值不是原子操作）才是原子操作

    Java内存模型只保证了基本读取和赋值是原子性操作，如果要实现更大范围操作的原子性，可以通过synchronized和Lock来实现。
     由于synchronized和Lock能够保证任一时刻只有一个线程执行该代码块，那么自然就不存在原子性问题了，从而保证了原子性。

    Java提供了volatile关键字来保证可见性。
    当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
    synchronized和Lock也能够保证可见性

    可以通过volatile关键字来保证一定的“有序性”。另外可以通过synchronized和Lock来保证有序性
    如果两个操作的执行次序无法从happens-before原则推导出来，那么它们就不能保证它们的有序性，虚拟机可以随意地对它们进行重排序
    共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
    　　1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
    　　2）禁止进行指令重排序。
 */
    volatile int inc =0;
    public void increase(){
        inc++;
    }
    public void atomicTest(){
        // volatile 不能保证原子性，而synchronized,Lock,AtomicInteger都可以
        for(int i =0;i<10;i++){
            new Thread(){
                public void run(){
                    for(int i =0;i<1000;i++){
                        increase3();
                    }
                }
            }.start();
        }
        while (Thread.activeCount()>1) //保证前面的线程都执行完
            Thread.yield();
        System.out.println("synchronized usage: increase count = "+inc3);// inc3=10000

        for(int i =0;i<10;i++){
            new Thread(){
                public void run(){
                    for(int i =0;i<1000;i++){
                        increase2();
                    }
                }
            }.start();
        }
        while (Thread.activeCount()>1) //保证前面的线程都执行完
            Thread.yield();
        System.out.println("synchronized usage: increase count = "+inc2);// inc2=10000

        for(int i =0;i<10;i++){
            new Thread(){
                public void run(){
                    for(int i =0;i<1000;i++){
                        increase1();
                    }
                }
            }.start();
        }
        while (Thread.activeCount()>1) //保证前面的线程都执行完
            Thread.yield();
        System.out.println("synchronized usage: increase count = "+inc1);// inc1=10000

        for(int i =0;i<10;i++){
            new Thread(){
                public void run(){
                    for(int i =0;i<1000;i++){
                        increase();
                    }
                }
            }.start();
        }
        //debug模式下可以跑完，run模式下会进入死循环
        while (Thread.activeCount()>1) //保证前面的线程都执行完
            Thread.yield();
        System.out.println("volatile usage: increase count = "+inc);// inc<10000

    }

    int inc1 =0;
    public synchronized void increase1()
    {
        inc1++;
    }

    int inc2 =0;
    Lock lock = new ReentrantLock();

    public void increase2(){
        lock.lock();
        try {
            inc2++;
        } finally {
            lock.unlock();
        }
    }

    AtomicInteger inc3 =new AtomicInteger();
    void increase3(){
        inc3.getAndIncrement();
    }
}
