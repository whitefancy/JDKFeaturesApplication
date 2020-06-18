package javacore;

import java.util.BitSet;

/*
生成素数的经典程序
被用于测试编译程序性能
称为“Eratorthenes筛子”算法
查找出200万以内的素数
首先将所有的位置设为开
然后将已知素数的倍数对应位置设置成关，之后保留下来的位就是对应的素数
 */
public class Sieve {
    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++) {
            b.set(i);
        }
        i = 2;
        while (i * i <= n) {
            if (b.get(i)) {
                count++;
                int k = 2 * i;
                while (k <= n) {
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i < n) {
            if (b.get(i)) {
                count++;
            }
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");

    }
}
