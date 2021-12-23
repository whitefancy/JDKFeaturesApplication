package JDKFeaturesApplication.JavaBasics;

public class StringBuilder1 {
//    为什么会出现那么多比较String和StringBuffer的文章？
//    原因在于当改变字符串内容时，采用StringBuffer能获得更好的性能。
//    StringBuffer和StringBuilder类的区别也在于此，新引入的StringBuilder类不是线程安全的，但其在单线程中的性能比StringBuffer高。
//    1765 millis has elapsed when used String.
//    149 millis has elapsed when used StringBuffer.
//    77 millis has elapsed when used StringBuilder.
    // 源码分析：StringBuffer和StringBuilder的底层实现基本一直，唯一的区别是StringBuffer的下面的方法加了关键字synchronized
    // synchronized StringBuffer append(String str)
    // 两者的底层都是使用数组实现的，关键方法：
    //数组扩容 Arrays.copyOf(value,newCapacity(minimumCapacity));
    //数组赋值 System.arraycopy(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);

    public void performanceTest() {
        String base ="base string.";
        int count = 2000000;
        long begin, end;
        //String
        begin = System.currentTimeMillis();
        String test = new String(base);
        for (int i = 0; i < count/100; i++) {
            test = test + " add ";
        }
        end = System.currentTimeMillis();
        System.out.println((end - begin)
                + " millis has elapsed when used String. ");

        // StringBuffer
        begin = System.currentTimeMillis();
        StringBuffer test1 = new StringBuffer(base);
        for (int i = 0; i < count; i++) {
            test1 = test1.append(" add ");
        }
        end = System.currentTimeMillis();
        System.out.println((end - begin)
                + " millis has elapsed when used StringBuffer. ");

        //StringBuilder
        begin = System.currentTimeMillis();
        StringBuilder test2 = new StringBuilder(base);
        for (int i = 0; i < count; i++) {
            test2 = test2.append(" add ");
        }
        end = System.currentTimeMillis();
        System.out.println((end - begin)
                + " millis has elapsed when used StringBuilder. ");
    }
}
