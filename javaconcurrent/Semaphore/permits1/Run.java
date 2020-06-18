package javaconcurrent.Semaphore.permits1;

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
A,B,C 执行的先后是随机的，但是A start之后肯定是A end
 */
    }
}
