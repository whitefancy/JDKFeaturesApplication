package javacore;

import java.util.Arrays;

public class ArrayDemo {
    private ArrayDemo() {
        //数组copy，两个变量引用同一个数组
        int[] smallPrimes = new int[]{2, 3, 5, 7, 11};
        int[] luckyNumbers = smallPrimes;
        //修改一个引用的值，即该数组的值被修改
        luckyNumbers[2] = 13;
        //使用Arrays.toString 打印数组中所有值
        System.out.println(Arrays.toString(smallPrimes));
        // 所有值copy到新的数组
        int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);
        // 第二个参数是新数组的长度，通常用于增加数组的大小，
        // 扩容，多余的元素会赋值为0，false
        // 如果长度小于原始数组，则只copy最前面的数据元素

        //Java数组基本上与分配在堆上的数组指针一样
        // 运算符被预定义为检查数组边界，并且没有指针运算，不能通过a+1得到下一个元素
        Arrays.sort(luckyNumbers);//Arrays默认的排序使用了优化的快速排序算法

        Arrays.binarySearch(luckyNumbers, 3);//二分搜索
        Arrays.fill(copiedLuckyNumbers, 17);//统一赋值
        Arrays.equals(luckyNumbers, smallPrimes);//判断是否元素个数相等，对应位置元素相等

        //快速打印二维数组
        Arrays.deepToString(new int[3][4]);

        //不规则数组 因为java没有二维数组，只有数组的数组，所以可以方便地构造不规则数组
        int[][] odds = new int[5][];
        for (int i = 0; i < odds.length; i++) {
            odds[i] = new int[odds.length + i];
        }
        //不规则数组赋值
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                odds[i][j] = i + j;
            }
        }
    }

    //main方法的第一个参数不是函数名，而是真正传入的第一个参数，与c语言不同
    public static void main(String[] args) {
        new ArrayDemo();
    }
}
