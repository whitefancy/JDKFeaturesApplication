package javaconcurrent.Semaphore.permitsdynamic;

public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        TheadA[] a = new TheadA[10];
        for (int i = 0; i < 10; i++) {
            a[i] = new TheadA(service);
            a[i].start();
        }
    }
}
