package javacore.unsynch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 */
public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> queue = new PriorityQueue<>();//返回最小值 多存一个元素
    PriorityQueue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return 1;
            } else if (o1 == o2) {
                return 0;
            } else {
                return -1;
            }
        }
    });//返回最大值
    double median = Integer.MIN_VALUE;

    public MedianFinder() {

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    public void addNum(int num) {
        if (queue.size() == queue1.size()) {
            if (num > median) {
                queue.offer(num);
                median = queue.peek();
            } else {
                queue1.offer(num);
                int move = queue1.poll();
                queue.offer(move);
                median = queue.peek();
            }
        } else if (queue.size() > queue1.size()) {
            if (num <= median) {
                queue1.offer(num);
                median = (queue.peek() + queue1.peek()) / 2.0;
            } else {
                queue.offer(num);
                int move = queue.poll();
                queue1.offer(move);
                median = (queue.peek() + queue1.peek()) / 2.0;
            }
        }
    }

    public double findMedian() {
        return median;
    }
}