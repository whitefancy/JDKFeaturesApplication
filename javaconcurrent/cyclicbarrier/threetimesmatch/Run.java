package javaconcurrent.cyclicbarrier.threetimesmatch;

import java.util.concurrent.CyclicBarrier;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cbRef = new CyclicBarrier(2);
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
