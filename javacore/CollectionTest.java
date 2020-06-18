package javacore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合有两个基本接口 Collection 和 Map
 * <p>
 * Java中，所有的链表实际上都是双向链表， 链表不支持快速的随机访问 会根据index从头或从尾找
 * <p>
 * ArrayList不是线程安全的，很快，而Vector的所有方法都是同步的，所以经验丰富的程序员可能会使用Vector
 * <p>
 * 散列表没有顺序，但是想要找它在不在，很快，散列码保存在链表数组中，如果桶满了，会由链表变为平衡二叉树，以提高性能。
 * 可以指定初始桶蜀，标准桶数是2的幂 默认装填因子是0.75
 * set类型可以用散列表来实现 HashSet就是通过散列表实现的
 * 散列表太满了，就会自动再散列
 * <p>
 * 树集 有序集合 红黑树 例如TreeSet
 * 特点 添加比散列表慢  必须能够比较元素才能使用树集 即 如果相等，肯定是同一个
 * 对于某些数据来说，排序函数比散列函数要困难，所以没有被取代 例如 矩形类Rectangle 很难排序，但可以根据坐标散列
 * <p>
 * 双端队列 两头都可以增删，但中间不行 Deque 必要时可以增加队列的长度
 * <p>
 * 优先级队列 PriorityQueue()  可以按任意顺序插入 但是remove方法总是获得优先级最低的元素
 * 使用堆heap实现的 可以自我调整的二叉树
 * 必须实现Comparable接口 或在构造器中提供Comparator对象
 * 典型事例 任务调度
 */
public class CollectionTest {
    /*
    将集合的接口和实现分离

    队列接口：增 删 size
    队列实现：循环数组 链表
    只在构建时，具体的类才有意义，使用时都一样 需要另一种实现，只需要在构造器调用的地方修改即可
    循环数组更高效，但是容量有限
    如果想自己实现队列，继承AbstractQueue 比实现Queue接口的所有方法轻松得多

    Collection接口： 增 迭代器iterator 所以任何集合都能用foreach循环

    迭代器iterator接口： next hasNext remove 带有迭代器的循环foreach 这里没有add方法，因为有些集合是无序的
    应该讲Java迭代器认为是位于两个元素之间，调用next时，越过下一个元素，返回刚刚越过的元素的引用 可以类比于 read方法
    如果在调用remove之间，没有调用next 是不合法的 即两个remove之间，必须隔着next
     */
    /*

     */
    private List list;

    {
        list = new ArrayList<String>();
        Iterator iterator = list.iterator();
        //Java8 lambda的foreach循环
        iterator.forEachRemaining(e -> {
            System.out.println(e);
        });
    }
}
