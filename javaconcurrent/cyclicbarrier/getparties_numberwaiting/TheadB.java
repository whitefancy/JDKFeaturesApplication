package JDKFeaturesApplication.javaconcurrent.cyclicbarrier.getparties_numberwaiting;

public class TheadB extends Thread {
    private Service service;

    TheadB(Service service) {
        /*
        因为Thread没有参数为Service的构造方法，
        所以这里的super()是调用的无参构造方法。
         */
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
