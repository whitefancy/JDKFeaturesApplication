package javacore;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest {
    Callable<Integer> callable;
    /*
    Integer 表示最终返回Integer对象的异步计算
     */
    private Future<String> future;

    /*
    Future保存异步计算的结果， 启动一个计算，把Future对象交给其中一个线程，
    计算好之后，Future就回到所有者了。
     */ {
        try {
            /*
            get方法的调用 会被阻塞，直到计算完成，可以使用超时参数，但两者是一样的，超时或线程被中断，都抛出异常
             */
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        /*
        查询计算状态
         */
        future.isCancelled();
        future.isDone();
        /*
        取消该计算
         */
        future.cancel(false);//如果传入false，只在没开始的时候取消，运行了就不取消了。
        /*
        FutureTask包装器
        既是一个Future<V> 又是一个Runnable的对象
        能自适应地将Callable 转换成Future 和Runnable
         */
        Callable<Integer> myComputation = null;
        FutureTask<Integer> task = new FutureTask<>(myComputation);
        Thread t = new Thread(task);//行使Runnable的身份
        t.start();
        try {
            Integer result = task.get();//行使Future的身份
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
