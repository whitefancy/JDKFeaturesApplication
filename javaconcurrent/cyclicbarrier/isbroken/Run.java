package javaconcurrent.cyclicbarrier.isbroken;

import java.util.concurrent.CyclicBarrier;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        int parties = 4;
        CyclicBarrier cbRef = new CyclicBarrier(parties, new Runnable() {
            @Override
            public void run() {
                System.out.println("都到了");
            }
        });
        MyService service = new MyService(cbRef);
        MyThread[] tArray = new MyThread[4];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(service);
        }
        for (int i = 0; i < tArray.length; i++) {
            tArray[i].start();
        }
    }
}
