package javaconcurrent.cyclicbarrier.getparties_numberwaiting;

public class Run {
    public static void main(String[] args) throws InterruptedException {
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
        Thread.sleep(2000);
        System.out.println("屏障对象的parties个数为：" + service.getCyclicBarrier().getParties());
        System.out.println("在屏障处等待的线程个数为：" + service.getCyclicBarrier().getNumberWaiting());
    }
}
