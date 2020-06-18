package javaconcurrent.Semaphore.semaphorefair;


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
        System.out.println("Thread name = " + getName() + " 启动了！");
        service.testMethod();
    }
}
