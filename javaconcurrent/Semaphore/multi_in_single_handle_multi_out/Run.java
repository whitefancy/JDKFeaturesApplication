package javaconcurrent.Semaphore.multi_in_single_handle_multi_out;

public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThead[] a = new MyThead[12];
        for (int i = 0; i < 12; i++) {
            a[i] = new MyThead(service);
            a[i].start();
        }
    }
}
