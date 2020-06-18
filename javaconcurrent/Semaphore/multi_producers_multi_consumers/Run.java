package javaconcurrent.Semaphore.multi_producers_multi_consumers;

public class Run {
    public static void main(String[] args) {
        RepastService service = new RepastService();
        ThreadP[] arrayP = new ThreadP[60];
        ThreadC[] arrayC = new ThreadC[60];
        for (int i = 0; i < 60; i++) {
            arrayP[i] = new ThreadP(service);
            arrayC[i] = new ThreadC(service);
        }
        for (int i = 0; i < 60; i++) {
            arrayP[i].start();
            arrayC[i].start();
        }
    }
}
