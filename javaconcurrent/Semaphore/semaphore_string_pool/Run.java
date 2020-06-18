package javaconcurrent.Semaphore.semaphore_string_pool;

public class Run {
    public static void main(String[] args) {
        ListPool pool = new ListPool();
        MyThead[] theadArray = new MyThead[12];
        for (int i = 0; i < theadArray.length; i++) {
            theadArray[i] = new MyThead(pool);
        }
        for (int i = 0; i < theadArray.length; i++) {
            theadArray[i].start();
        }
    }
}
