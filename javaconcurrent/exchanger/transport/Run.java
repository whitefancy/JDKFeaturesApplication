package javaconcurrent.exchanger.transport;

import java.util.concurrent.Exchanger;

public class Run {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a = new ThreadA(exchanger);
        ThreadB b = new ThreadB(exchanger);
        b.start();
        a.start();
        System.out.println("main end!");
    }
}
