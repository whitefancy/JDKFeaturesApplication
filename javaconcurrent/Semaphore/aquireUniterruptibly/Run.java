package javaconcurrent.Semaphore.aquireUniterruptibly;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        TheadA a = new TheadA(service);
        a.setName("A");
        a.start();
        TheadB b = new TheadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(1000);
        a.interrupt();
        /*
        当a在等待执行、或者正在执行时，会被中断。如果已经被中断，则会报错
         */
        System.out.println("main中断了a");
    }
}
