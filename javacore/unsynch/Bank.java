package javacore.unsynch;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bank {
    private final double[] accounts;
    private Lock transferLock = new ReentrantLock();
    private Condition sufficientFunds;// 条件对象
    private Lock intrinsicLock = new ReentrantLock();
    private Object lock1 = new Object();
    /*
    读写锁 很多线程读，很少线程写，读写锁就很有用
     */
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    //抽取读锁和写锁
    private Lock readLock = rwl.readLock();
    private Lock writeLock = rwl.writeLock();

    public Bank(int naccounts, double initialBalance) {
        sufficientFunds = transferLock.newCondition();//为同步锁增加条件对象
        accounts = new double[naccounts];
        Arrays.fill(accounts, initialBalance);
    }

    public int size() {
        return accounts.length;
    }

    public void transfer(int from, int to, double amount) {
        /*
        锁和条件的关键之处
        任何时刻只有一个线程执行被保护的代码
        锁管理试图进入被保护代码段的线程
        锁可以拥有一个或多个相关对象
        条件对象 管理 的是进入被保护代码段 但是还不能运行的线程
         */
        transferLock.lock();
        try {
            while (accounts[from] < amount) {
                System.out.println(from + " waiting...");
                sufficientFunds.await();//当账户余额不足，用户并不想取消交易，而是想等有钱了再交易 阻塞自己
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d\n", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance:%10.2f\n", getTotalBalance());
            sufficientFunds.signalAll();//解除阻塞 signal()是随机选择一个线程，解除其阻塞状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            transferLock.unlock();
        }
    }

    private synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    private double getTotalBalance11() {
        //对所有的获取方法加读锁
        readLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            readLock.unlock();
        }
    }

    public void transfer11(int from, int to, double amount) {
        /*对所有的修改方法加写锁
         */
        writeLock.lock();
        try {
            if (accounts[from] < amount) {
                return;
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d\n", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance:%10.2f\n", getTotalBalance());
        } finally {
            writeLock.unlock();
        }
    }

    public synchronized void method1() {
        //method body
    }

    //等价于下面，所以也可以简单地将transfer方法声明为synchronized 而不是使用一个显式地锁
    /*
    如果只有一个条件对象，比如object， 那么object.wait() 和 notifyAll 就等价于
    intrinsicCondition.await()  和  signalAll
     */
    public void method() {
        intrinsicLock.lock();
        try {
            //method body
        } finally {
            intrinsicLock.unlock();
        }
    }

    /**
     * 最好既不使用Lock condition 也不使用 synchronized关键字
     * 而是使用concurrent包提供的机制
     * 比如阻塞队列
     * 如果synchronized时候，尽量使用，除非特别需要，才使用Lock/condition
     *
     * @param from
     * @param to
     * @param amount
     */
    public synchronized void transfer1(int from, int to, double amount) {
//使用synchronized关键字来编写，要简洁得多
        while (accounts[from] < amount) {
            System.out.println(from + " waiting...");
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d\n", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total Balance:%10.2f\n", getTotalBalance());
        notifyAll();
    }

    /**
     * 同步阻塞
     * lock1对象被创建仅仅用来使用对象持有的锁
     *
     * @param from
     * @param to
     * @param amount
     */
    public void transfer2(int from, int to, double amount) {
        //因为JAVA的每个对象都有一个锁，所以可以用一个object 进入同步阻塞
        synchronized (lock1) {
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d\n", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance:%10.2f\n", getTotalBalance());
        }
    }

    /**
     * 客户端锁定
     * 使用一个对象的锁来实现对 该对象 额外的 原子操作
     * 客户端锁定是非常脆弱的，通常不推荐使用
     *
     * @param accounts
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(Vector<Double> accounts, int from, int to, double amount) {
        synchronized (accounts) {
            System.out.println(Thread.currentThread());
            accounts.set(from, accounts.get(from) - amount);
            System.out.printf("%10.2f from %d to %d\n", amount, from, to);
            accounts.set(to, accounts.get(to) + amount);
            System.out.printf("Total Balance:%10.2f\n", getTotalBalance());
        }
    }
}
