package javaconcurrent.exchanger.transport;

import java.util.concurrent.Exchanger;

public class ThreadB extends Thread {
    private Exchanger<String> exchanger;

    ThreadB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程A中得到线程B的值为" + exchanger.exchange("你好我是B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B end");
    }
}
