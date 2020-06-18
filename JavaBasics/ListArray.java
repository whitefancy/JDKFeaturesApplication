package JavaBasics;

import java.util.*;
import java.util.stream.Collectors;

public class ListArray {

    public List test(){
        // Arrays
        Integer[] primes= new Integer[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,
                131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,
                281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,
                457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,563,569,571,577,587,593,599,601,607,613,617,619,631,
                641,643,647,653,659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,769,773,787,797,809,811,821,823};

        int ele = Arrays.binarySearch(primes,503);// 仅对有序数组可以用二分查找

        Integer[] subprimes = Arrays.copyOfRange(primes,4,23);// 数组复制

        boolean eq = Arrays.deepEquals(subprimes,primes);// 深相等，每一个元素都相等。这里不能用基本类型

        String s =Arrays.deepToString(subprimes);// 深打印 [[0, 2], [1, 2], [2, 0]]
        System.out.println(s);

        // List
        List<Integer> list = Arrays.asList(primes);// array to list 这里也只能用object 不能用基本类型
        List b = Collections.EMPTY_LIST;//b 初始化为空List
        Collections.shuffle(list);//洗牌 打乱顺序
        int max = Collections.max(list);// 找出最大值
        System.out.println(max);
        Collections.rotate(list,3);//将list后3个元素整体移到前面
        Collections.rotate(list,-3);//将list前3个元素整体移到后面
        Collections.indexOfSubList(list,b);// 返回子列表在父列表中第一次出现的位置索引
        Collections.lastIndexOfSubList(list,b);// 返回最后一次位置索引
        Collections.replaceAll(list,2,8);//整体替换值

// Set List, Deque,Map 都是线程不安全的。如果多线程，需要用Collenctions包装成线程同步
        List list2 =Collections.synchronizedList(new LinkedList());
        int a[]={1,2,3,2};
        List<Integer> l1 = Arrays.stream(a).boxed().collect(Collectors.toList());
        int b1[]={4,2,90,8,98};
        int[] d3 = new int[a.length + b1.length];
        System.arraycopy(a, 0, d3, 0, a.length);
        System.arraycopy(b, 0, d3, a.length, b1.length);//拼接两个数组
        // 返回不可变的集合
        List list3 = Collections.singletonList(new ArrayList());

        for (int i = 0; i < b.size(); i++) {
            // b.fori
        }
        for (int i = b.size() - 1; i >= 0; i--) {
            //b.forr
        }
        for (Object o : b) {
            //b.for
        }
        ((ArrayList) b).get(0);//b.cast 强制类型转换
        b.addAll(0,list);// 在index的位置插入集合
        System.out.println(b);// b.sout
        System.out.println("b = " + b);//b.soutv
        if (b == null) {
            // b.null
            // b,notnull
        }
        //b.arg 把b作为参数
        ((ArrayList) b).trimToSize();// 缩小b的存储到最小的b
        ((ArrayList) b).ensureCapacity(100);// 让b的Array长度至少是100，从100起步
        int[] ints =list.stream().mapToInt((Integer in)-> in).toArray();
        int[]  newData = Arrays.copyOfRange(ints, 2, 7);
        return b;//b.return
    }

}
