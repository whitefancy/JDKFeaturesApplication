package javaconcurrent.cyclicbarrier.reset;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        TheadA a = new TheadA(service);
        TheadB b = new TheadB(service);
        a.start();
        b.start();
        Thread.sleep(2000);
        service.cyclicBarrier.reset();//BrokenBarrierException
    }
}
