package javaconcurrent.Semaphore.tryacquire;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        TheadA a = new TheadA(service);
        a.setName("A");
        a.start();
        TheadB b = new TheadB(service);
        b.setName("B");
        b.start();
    }
}
