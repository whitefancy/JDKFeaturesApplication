package javaconcurrent.Semaphore.permits2;

public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        TheadA a = new TheadA(service);
        a.setName("A");
        TheadB b = new TheadB(service);
        b.setName("B");
        TheadC c = new TheadC(service);
        c.setName("C");
        a.start();
        c.start();
        b.start();
/*
A,B,C 执行的先后是随机的，但最多只有两个线程执行Semaphore aquire和release之间的代码
 */
    }
}
