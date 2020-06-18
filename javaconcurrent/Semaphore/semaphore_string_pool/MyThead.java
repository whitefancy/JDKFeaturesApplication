package javaconcurrent.Semaphore.semaphore_string_pool;


public class MyThead extends Thread {
    private ListPool listPool;

    MyThead(ListPool listPool) {
        /*
        因为Thread没有参数为Service的构造方法，
        所以这里的super()是调用的无参构造方法。
         */
        super();
        this.listPool = listPool;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String getString = listPool.get();
            System.out.println(Thread.currentThread().getName() + " 取得值 " + getString);
            listPool.put(getString);
        }
    }
}
