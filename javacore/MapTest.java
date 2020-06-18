package javacore;

import java.util.IdentityHashMap;

/**
 * 映射
 * hashMap TreeMap SortedMap
 * 映射视图，映射不是集合，但可以实现Collection接口，得到映射的view，从而进行迭代器操作，比如keySet forEach
 * <p>
 * 弱散列映射 WeakHashMap
 * 长期存活的系统映射表，有些value再也不用了，但是没人通知删除key，不能被gc回收
 * 实现：使用弱引用保存键，如果对象只被WeakRefrence引用，虽然引用，GC也回收它
 * <p>
 * LinkedHashMap LinkedHashSet
 * 插入散列表时，也会并入双向链表中
 * 删除时，两边都删
 * 调用时，散列表不动，位置移动到链表的尾部
 * 好处：用于实现 高速缓存的 最近最少使用 原则
 * <p>
 * 枚举集EnumSet  内部用位序列实现
 * 没有公告构造器 用静态工厂方法构造
 * 用Set接口的方法来修改枚举集
 * EnumMap<T,U> T是不同的枚举值，U对应枚举的详细信息
 * <p>
 * 标识散列映射IdentityHashMap
 * 即使两个对象内容一样，也会有不同的散列码（标识）
 * 比较对象时，使用==
 * 实现对象遍历算法 如对象串行化 是，有用
 */
public class MapTest {
    {
        IdentityHashMap map = new IdentityHashMap();
        map.put(String.class, "ad");
    }
}
