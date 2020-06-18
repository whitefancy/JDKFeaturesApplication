package oddtips;

/**
 *
 */
public class returnfinally {

    public static void main(String[] args) throws Exception {
        int a = new returnfinally().test();
        System.out.println(a);
    }

    public int test() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}