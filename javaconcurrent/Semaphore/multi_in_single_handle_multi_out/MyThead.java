package javaconcurrent.Semaphore.multi_in_single_handle_multi_out;


public class MyThead extends Thread {
    private MyService service;

    MyThead(MyService service) {
        /*
        因为Thread没有参数为Service的构造方法，
        所以这里的super()是调用的无参构造方法。
         */
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.sayHello();
    }
}
