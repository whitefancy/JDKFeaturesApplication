package JDKFeaturesApplication.javaconcurrent.Semaphore.queuedthread;

public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThead firstThread = new MyThead(service);
        firstThread.start();
        MyThead[] a = new MyThead[4];
        for (int i = 0; i < 4; i++) {
            a[i] = new MyThead(service);
            a[i].start();
            /*
            线程的个数呈递减的状态
             */
        }
    }
}
