package javaconcurrent.cyclicbarrier.isbroken;

public class MyThread extends Thread {
    private MyService service;

    MyThread(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testA();
    }
}
