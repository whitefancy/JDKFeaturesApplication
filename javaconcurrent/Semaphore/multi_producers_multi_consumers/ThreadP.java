package javaconcurrent.Semaphore.multi_producers_multi_consumers;

/*
生产者线程
 */
public class ThreadP extends Thread {
    private RepastService service;

    public ThreadP(RepastService service) {
        /*
        因为Thread没有参数为Service的构造方法，
        所以这里的super()是调用的无参构造方法。
         */
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.set();
    }
}
