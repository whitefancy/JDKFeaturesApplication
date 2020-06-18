package javaconcurrent.Semaphore.multi_producers_multi_consumers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现生产者与消费者模式，并且限制生产者和消费者的数量
 */
public class RepastService {
    volatile private Semaphore setSemaphore = new Semaphore(10);//厨师
    volatile private Semaphore getSemaphore = new Semaphore(10);//就餐者
    volatile private ReentrantLock lock = new ReentrantLock();
    volatile private Condition setCondition = lock.newCondition();
    volatile private Condition getCondition = lock.newCondition();
    volatile private Object[] producePosition = new Object[4];//最多只有pp个盒子存放菜品

    /**
     * 如果盒子至少有一个菜品，就餐者就可以取走
     *
     * @return 盒里是否有至少一个菜品
     */
    private boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < producePosition.length; i++) {
            if (producePosition[i] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    private boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < producePosition.length; i++) {
            if (producePosition[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void set() {
        try {
            System.out.println("生产者在制作");
            setSemaphore.acquire();//允许同时最多有10个厨师进行生产
            long prod = System.currentTimeMillis();
            lock.lock();
            while (isFull()) {
                System.out.println("生产者在等待放入");
                setCondition.await();
            }
            for (int i = 0; i < producePosition.length; i++) {
                if (producePosition[i] == null) {
                    producePosition[i] = "数据";
                    System.out.println(Thread.currentThread().getName() + " 放入了" + producePosition[i] +
                            ",等待了 " + (System.currentTimeMillis() - prod) / 1000 + "秒");
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setSemaphore.release();
        }
    }

    public void get() {
        try {
            System.out.println("消费者来了");
            getSemaphore.acquire();//允许同时最多有10个厨师进行生产
            long prod = System.currentTimeMillis();
            lock.lock();
            while (isEmpty()) {
                System.out.println("消费者在等待食物");
                getCondition.await();
            }
            for (int i = 0; i < producePosition.length; i++) {
                if (producePosition[i] != null) {
                    System.out.println(Thread.currentThread().getName() + " 消费了" + producePosition[i] +
                            ",等待了 " + (System.currentTimeMillis() - prod) / 1000 + "秒");
                    producePosition[i] = null;
                    break;
                }
            }
            setCondition.signalAll();
            lock.unlock();//这里同时只能有一个消费者在拿，是不是不合理。
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getSemaphore.release();
        }
    }
}
