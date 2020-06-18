package JavaBasics;

public class JoinThread extends Thread {
    // 有参数的构造器，设置线程名字
    public JoinThread(String name){
        super(name);
    }
    //重写run方法
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+" "+i);
        }
    }
    public void test(){
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if(i == 20)
            {
                JoinThread jt = new JoinThread("阻塞线程");
                jt.start();
                try {
                    jt.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
