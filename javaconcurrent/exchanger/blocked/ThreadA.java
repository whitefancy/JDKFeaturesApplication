package javaconcurrent.exchanger.blocked;

import java.util.concurrent.Exchanger;

public class ThreadA extends Thread {
    private Exchanger<String> exchanger;

    ThreadA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程A中得到线程B的值为" + exchanger.exchange("你好我是A"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A end");
    }
}
